package org.recruitment.problem.transfer.api.service;

import javax.transaction.Transactional;

import org.recruitment.problem.transfer.api.dao.TransactionRepository;
import org.recruitment.problem.transfer.api.exception.AccountNotActiveException;
import org.recruitment.problem.transfer.api.exception.InsufficentFundException;
import org.recruitment.problem.transfer.api.model.Account;
import org.recruitment.problem.transfer.api.model.Transaction;
import org.recruitment.problem.transfer.api.model.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountService accountService;

	@Override
	public void preTransferValidation(Transaction transaction) {
		Account sourceAccount = accountService.getAccountDetailsById(transaction.getSourceAccountNumber());
		if (sourceAccount.getAccountBalance() < transaction.getAmount()) {
			throw new InsufficentFundException(
			        "Insufficent balance in Source Account: " + transaction.getSourceAccountNumber());
		} else if (!sourceAccount.getAccountStatus().equals(AccountStatus.ACTIVE)) {
			throw new AccountNotActiveException("Source Account is not Active: " + transaction.getSourceAccountNumber());
		}
		Account destinationAccount = accountService.getAccountDetailsById(transaction.getDestinationAccountNumber());
		if (!destinationAccount.getAccountStatus().equals(AccountStatus.ACTIVE)) {
			throw new AccountNotActiveException(
			        "Destination Account is not Active: " + transaction.getDestinationAccountNumber());
		}
	}

	@Override
	public Transaction transferFund(Transaction transaction) {
		Account sourceAccount = accountService.getAccountDetailsById(transaction.getSourceAccountNumber());
		sourceAccount.setAccountBalance(sourceAccount.getAccountBalance() - transaction.getAmount());
		
		Account destinationAccount = accountService.getAccountDetailsById(transaction.getDestinationAccountNumber());
		destinationAccount.setAccountBalance(destinationAccount.getAccountBalance() + transaction.getAmount());
		
		accountService.createAndUpdateAccount(sourceAccount);
		accountService.createAndUpdateAccount(destinationAccount);
		
		return transactionRepository.save(transaction);
	}
}
