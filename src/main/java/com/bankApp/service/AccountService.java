package com.bankApp.service;

import java.util.List;

import com.bankApp.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountByid(Long id);
	AccountDto deposit(Long id, double amount);
	AccountDto withdraw(Long id, double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(Long id);
}
