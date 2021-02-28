package org.recruitment.problem.transaction.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.recruitment.problem.transaction.api.model.enums.AccountStatus;
import org.recruitment.problem.transaction.api.model.enums.AccountType;

@Entity
@Table(name = "account_details")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_number", nullable = false)
	private Long accountNumber;

	@Column(name = "account_balance")
	private Double accountBalance;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "account_type")
	private AccountType accountType;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "account_status")
	private AccountStatus accountStatus;

	public Account() {
		super();
	}

	public Account(Double accountBalance, AccountType accountType, AccountStatus accountStatus) {
		super();
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

}
