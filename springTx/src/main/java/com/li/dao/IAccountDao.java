package com.li.dao;

import com.li.domain.Account;

public interface IAccountDao {
    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询
     * @param Name
     * @return
     */
    Account findAccountByName(String Name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
