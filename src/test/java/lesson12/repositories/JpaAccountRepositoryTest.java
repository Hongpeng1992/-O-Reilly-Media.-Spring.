package lesson12.repositories;

import lesson12.config.AppConfig;
import lesson12.entities.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class JpaAccountRepositoryTest {

	public static final long ID = 1L;

	@Autowired
	private AccountRepository repository;

	@Test
	public void testGetAccounts() throws Exception {
		List<Account> accounts = repository.getAccounts();
		assertEquals(3, accounts.size());
	}

	@Test
	public void testGetAccount() throws Exception {
		Account account = repository.getAccount(ID);
		assertEquals(true, Optional.ofNullable(account.getId()).isPresent());
	}

	@Test
	public void testGetNumberOfAccount() throws Exception {
		assertEquals(3, repository.getNumberOfAccount());
	}

	@Test
	public void createAccount() throws Exception {
		Long id = repository.createAccount(new BigDecimal("250.00"));
		assertNotNull(id);

		Account account = repository.getAccount(id);
		assertEquals(id, account.getId());
	}

	@Test
	public void deleteAccount() throws Exception {
		for (Account account : repository.getAccounts()) {
			repository.deleteAccount(account.getId());
		}

		assertEquals(0, repository.getAccounts().size());
	}

	@Test
	public void updateAccount() throws Exception {
		Account account = repository.getAccount(ID);
		BigDecimal current = account.getBalance();
		BigDecimal amount = new BigDecimal("50.0");
		account.setBalance(current.add(amount));
		repository.updateAccount(account);

		assertEquals(account.getBalance(), repository.getAccount(ID).getBalance());
	}

}