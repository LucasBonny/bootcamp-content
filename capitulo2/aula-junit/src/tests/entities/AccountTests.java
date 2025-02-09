package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {

		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 1000.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double res = acc.fullWithdraw();
		
		Assertions.assertEquals(expectedValue,acc.getBalance());
		Assertions.assertEquals(res, initialBalance);
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		double expectedValue = 100.0;
		double initialBalance = 200.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		acc.withdraw(100.0);

		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			double initialBalance = 1000.0;
			Account acc = AccountFactory.createAccount(initialBalance);
			
			acc.withdraw(1001.0);
		});
	}
	
	
}
