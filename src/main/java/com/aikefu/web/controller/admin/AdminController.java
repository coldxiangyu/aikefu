package com.aikefu.web.controller.admin;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.aikefu.entity.domain.User;
import com.aikefu.entity.dto.AikefuConst;
import com.aikefu.entity.dto.JsonResult;
import com.aikefu.entity.enums.CommonParamsEnum;
import com.aikefu.entity.enums.ResultCodeEnum;
import com.aikefu.entity.enums.TrueFalseEnum;
import com.aikefu.service.UserService;
import com.aikefu.web.controller.core.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <pre>
 *     后台首页控制器
 * </pre>
 *
 * @author : coldxiangyu
 * @date : 2018/9/17
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 请求后台页面
     *
     * @return 模板路径admin/index
     */
    @GetMapping(value = {"", "/index"})
    public String index() {
        return "admin/index";
    }
    /**
     * 处理跳转到登录页的请求
     *
     * @param session session
     * @return 模板路径admin/admin_login
     */
    @GetMapping(value = "/login")
    public String login(HttpSession session) {
        User user = (User) session.getAttribute(AikefuConst.USER_SESSION_KEY);
        //如果session存在，跳转到后台首页
        if (null != user) {
            return "redirect:/admin";
        }
        return "admin/page-login";
    }

    /**
     * 验证登录信息
     *
     * @param loginName 登录名：邮箱／用户名
     * @param loginPwd  loginPwd 密码
     * @param session   session session
     * @return JsonResult JsonResult
     */
    @PostMapping(value = "/getLogin")
    @ResponseBody
    public JsonResult getLogin(@ModelAttribute("loginName") String loginName,
                               @ModelAttribute("loginPwd") String loginPwd,
                               HttpSession session) {
        //已注册账号，单用户，只有一个
        User aUser = userService.findUser();
        //首先判断是否已经被禁用已经是否已经过了10分钟
        Date loginLast = DateUtil.date();
        if (null != aUser.getLoginLast()) {
            loginLast = aUser.getLoginLast();
        }
        Long between = DateUtil.between(loginLast, DateUtil.date(), DateUnit.MINUTE);
        if (StringUtils.equals(aUser.getLoginEnable(), TrueFalseEnum.FALSE.getDesc()) && (between < CommonParamsEnum.TEN.getValue())) {
            return new JsonResult(ResultCodeEnum.FAIL.getCode(), "已禁止登录，请10分钟后再试");
        }
        //验证用户名和密码
        User user = null;
        if (Validator.isEmail(loginName)) {
            user = userService.getUserByWrapper(
                    new QueryWrapper<User>().eq("user_email",loginName).eq("user_pass",SecureUtil.md5(loginPwd)));
        } else {
            user = userService.getUserByWrapper(new QueryWrapper<User>().eq("user_name",loginName).eq("user_pass",SecureUtil.md5(loginPwd)));
        }
        userService.updateUserLoginLast(DateUtil.date());
        //判断User对象是否相等
        if (ObjectUtil.equal(aUser, user)) {
            session.setAttribute(AikefuConst.USER_SESSION_KEY, aUser);
            //重置用户的登录状态为正常
            userService.updateUserNormal();
            log.info("用户[{}]登录成功。", aUser.getUserDisplayName());
            return new JsonResult(ResultCodeEnum.SUCCESS.getCode(), "登录成功！");
        } else {
            //更新失败次数
            Integer errorCount = userService.updateUserLoginError();
            //超过五次禁用账户
            if (errorCount >= CommonParamsEnum.FIVE.getValue()) {
                userService.updateUserLoginEnable(TrueFalseEnum.FALSE.getDesc());
            }
            return new JsonResult(ResultCodeEnum.FAIL.getCode(), "登录失败，你还有" + (AikefuConst.USER_LOGIN_TIMES - errorCount) + "次机会。");
        }
    }


}
