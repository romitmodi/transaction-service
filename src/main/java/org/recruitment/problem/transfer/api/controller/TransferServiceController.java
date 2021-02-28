package org.recruitment.problem.transfer.api.controller;

import org.recruitment.problem.transfer.api.model.Transaction;
import org.recruitment.problem.transfer.api.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferServiceController {

	private TransactionService transactionService;

	@PostMapping(value = "/transfer")
	public ResponseEntity<Transaction> performTransfer(@RequestBody Transaction transaction) {
		transactionService.preTransferValidation(transaction);
		transactionService.transferFund(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
