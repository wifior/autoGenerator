package com.test.modular.common.controller;

import com.test.modular.common.tips.SuccessTip;

public abstract class BaseController {
    protected static SuccessTip SUCCESS_TIP = new SuccessTip();

    public static String WEB = "web";
    public static String MEMBER = "member";

    /**
     * 主页的页面主题
     * @param viewName
     * @return
     */
    public String render(String viewName) {
        return WEB + "/" + viewName;
    }

    public String memRender(String viewName){
        return MEMBER+"/"+viewName;

    }
}
