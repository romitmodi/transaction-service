package org.recruitment.problem.transfer.api.dao;

import org.recruitment.problem.transfer.api.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
