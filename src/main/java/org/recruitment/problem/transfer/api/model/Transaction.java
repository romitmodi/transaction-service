package org.recruitment.problem.transfer.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.recruitment.problem.transfer.api.model.enums.TransactionStatus;

@Entity
@Table(name = "transaction_details")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", nullable = false)
	private Long transactionId;

	@NotNull(message = "Source account number can't be null. Please provide Source account number in request")
	@Column(name = "src_account_number")
	private Long sourceAccountNumber;

	@NotNull(message = "Destination account number can't be null. Please provide Destination account number in request")
	@Column(name = "des_account_number")
	private Long destinationAccountNumber;

	@Min(value = 0, message = "Transaction amount must be greater than 0")
	@NotNull(message = "Transaction ammount can't be null")
	@Column(name = "transaction_amount")
	private Double amount;

	@Column(name = "status")
	private TransactionStatus status;

	@Column(name = "description")
	private String description;

	@Column(name = "transaction_timestamp")
	private LocalDateTime localDateTime = LocalDateTime.now();

	public Transaction() {
		super();
	}

	public Transaction(Long sourceAccountNumber, Long destinationAccountNumber, Double amount) {
		super();
		this.sourceAccountNumber = sourceAccountNumber;
		this.destinationAccountNumber = destinationAccountNumber;
		this.amount = amount;
	}

	public Transaction(Long sourceAccountNumber, Long destinationAccountNumber, Double amount, String description) {
		super();
		this.sourceAccountNumber = sourceAccountNumber;
		this.destinationAccountNumber = destinationAccountNumber;
		this.amount = amount;
		this.description = description;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(Long sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public Long getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(Long destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

}
