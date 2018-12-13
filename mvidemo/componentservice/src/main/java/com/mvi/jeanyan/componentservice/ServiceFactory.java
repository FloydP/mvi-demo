package com.mvi.jeanyan.componentservice;

import com.mvi.jeanyan.componentservice.home.HomeService;
import com.mvi.jeanyan.componentservice.login.LoginService;

public class ServiceFactory {

    private HomeService homeService;
    private LoginService loginService;

    public HomeService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    private static ServiceFactory getInstance(){
        if (serviceFactory == null) {
           synchronized (ServiceFactory.class) {
               serviceFactory = new ServiceFactory();
           }
        }
        return serviceFactory;
    }
}
