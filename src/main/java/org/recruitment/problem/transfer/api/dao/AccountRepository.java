package org.recruitment.problem.transfer.api.dao;

import org.recruitment.problem.transfer.api.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
