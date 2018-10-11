package com.aikefu.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     用户信息
 * </pre>
 *
 * @author : coldxiangyu
 * @date : 2018/9/17
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = -5144055068797033748L;

    /**
     * 编号
     */
    @TableId(value="user_id", type= IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    @NotBlank(message = "用户名不能为空")
    @JsonIgnore
    private String userName;

    /**
     * 显示名称
     */
    @TableField("user_display_name")
    private String userDisplayName;

    /**
     * 密码
     */
    @TableField("user_pass")
    @JsonIgnore
    private String userPass;

    /**
     * 邮箱
     */
    @TableField("user_email")
    @Email(message = "邮箱格式不正确")
    private String userEmail;

    /**
     * 头像
     */
    @TableField("user_avatar")
    private String userAvatar;

    /**
     * 说明
     */
    @TableField("user_desc")
    private String userDesc;

    /**
     * 是否禁用登录
     */
    @TableField("login_enable")
    @JsonIgnore
    private String loginEnable = "true";

    /**
     * 最后一次登录时间
     */
    @TableField("login_last")
    @JsonIgnore
    private Date loginLast;

    /**
     * 登录错误次数记录
     */
    @TableField("login_error")
    @JsonIgnore
    private Integer loginError = 0;
}
