package org.recruitment.problem.transfer.api.service;

import org.recruitment.problem.transfer.api.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
}
