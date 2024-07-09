package com.dai.mapper.impl;

import org.springframework.stereotype.Repository;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName AccountMapperImpl
 * @Description: TODO
 * @Date 2024-07-03 22:09
 */
@Repository("accountMapper")
public class AccountMapperImpl {
    public void incrMoney(String accountName, Integer money) {
        System.out.println("incrMoney " + accountName + " == " + money);
    }


    public void decrMoney(String accountName, Integer money) {
        System.out.println("decrMoney " + accountName + " == " + money);
    }
}
