package com.bankApp.service;

import com.bankApp.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountByid(Long id);
	AccountDto deposit(Long id, double amount);
}
