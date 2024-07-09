package com.dai.service.impl;

import com.dai.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Date 2024-07-08 21:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void show() {
        System.out.println("UserServiceImpl......");
    }
}
