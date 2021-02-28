package org.recruitment.problem.transfer.api.service;

import org.recruitment.problem.transfer.api.dao.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
}
