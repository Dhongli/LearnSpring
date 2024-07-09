package com.dai.service.impl;


import com.dai.mapper.impl.AccountMapperImpl;
import com.dai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapperImpl accountMapper;

    public void transferMoney(String outAccount, String inAccount, Integer money) {
        accountMapper.decrMoney(outAccount,money);
        //int i = 1/0;
        accountMapper.incrMoney(inAccount,money);
    }

}
