package lesson11.repositories;

import lesson11.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {
	List<Account> getAccounts();

	Account getAccount(Long id);

	int getNumberOfAccount();

	Long createAccount(BigDecimal initialBalance);

	int deleteAccount(Long id);

	void updateAccount(Account account);
}
