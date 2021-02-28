package org.recruitment.problem.transfer.api.service;

import org.recruitment.problem.transfer.api.model.Transaction;

public interface TransactionService {

	void preTransferValidation(Transaction transaction);

	Transaction transferFund(Transaction transaction);

}
