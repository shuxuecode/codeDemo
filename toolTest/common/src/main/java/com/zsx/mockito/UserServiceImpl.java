package com.zsx.mockito;

public class UserServiceImpl implements UserService {


    public String getUserName(String userId) {
        System.out.println("getUserName userId:" + userId);
        return "zsx";
    }

}
