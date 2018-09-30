package com.aikefu.web.controller.core;

/**
 * <pre>
 *     Controller抽象类
 * </pre>
 *
 * @author : coldxiangyu
 * @date : 2018/9/17
 */
public abstract class BaseController {

    /**
     * 渲染404页面
     *
     * @return redirect:/404
     */
    public String renderNotFound() {
        return "redirect:/404";
    }
}
