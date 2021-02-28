package org.recruitment.problem.transfer.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.recruitment.problem.transfer.api.dao.AccountRepository;
import org.recruitment.problem.transfer.api.exception.AccountNotFoundException;
import org.recruitment.problem.transfer.api.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAndUpdateAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account getAccountDetailsById(Long accountNumber) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		if (!accountOptional.isPresent()) {
			throw new AccountNotFoundException("Account not found against Account-Number: " + accountNumber);
		}
		return accountOptional.get();
	}
}
