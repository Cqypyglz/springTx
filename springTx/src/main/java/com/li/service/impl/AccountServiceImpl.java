package com.li.service.impl;

import com.li.dao.IAccountDao;
import com.li.domain.Account;
import com.li.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("accountService")
@Transactional
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    /**
     * 根据id查询账户信息
     *
     * @param accountId
     */
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 转账
     *
     * @param sourceName 转出账户的名称
     * @param targetName 转入账户的名称
     * @param money      转账金额
     */
    public void transfer(String sourceName, String targetName, Float money) {
        //2.1根据名称查询转出账户
        Account source=accountDao.findAccountByName(sourceName);
        //2.2 根据名称查询转入账户
        Account target=accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        int i=2/0;
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
