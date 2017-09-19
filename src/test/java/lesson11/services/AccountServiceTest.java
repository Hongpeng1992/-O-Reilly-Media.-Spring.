package lesson11.services;

import lesson11.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Transactional
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountServiceTest {

	public static final long ID = 1L;
	@Autowired
	private AccountService service;

	@Test
	public void testGetBalance() throws Exception {
	}

	@Test
	public void testDeposit() throws Exception {
		BigDecimal start = service.getBalance(ID);
		BigDecimal amount = new BigDecimal("50.0");
		service.deposit(ID, amount);
		BigDecimal finish = start.add(amount);

		assertEquals(start.add(amount), finish);
	}

	@Test
	public void testWithdraw() throws Exception {
		BigDecimal start = service.getBalance(ID);
		BigDecimal amount = new BigDecimal("50.0");
		service.withdraw(ID, amount);
		BigDecimal finish = start.subtract(amount);

		assertEquals(start.subtract(amount), finish);
	}

}