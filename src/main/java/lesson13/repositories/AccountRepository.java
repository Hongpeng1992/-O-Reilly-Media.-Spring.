package lesson13.repositories;

import lesson13.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
	List<Account> findAccountByBalanceGreaterThanEqual(BigDecimal amount);
}
