package org.recruitment.problem.transfer.api.service;

import org.recruitment.problem.transfer.api.model.Account;

public interface AccountService {

	Account createAndUpdateAccount(Account account);

	Account getAccountDetailsById(Long accountNumber);

}
