package com.bankApp.service.impl;

import org.springframework.stereotype.Service;

import com.bankApp.dto.AccountDto;
import com.bankApp.entity.Account;
import com.bankApp.mapper.AccountMapper;
import com.bankApp.repository.AccountRepository;
import com.bankApp.service.AccountService;

@Service
public class AccountserviceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountserviceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountByid(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		double totalBalance = account.getBalance()+amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		if(account.getBalance() < amount) {
			throw new RuntimeException("Incufficient Balance");
		}
		double totalBalance = account.getBalance()-amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

}
