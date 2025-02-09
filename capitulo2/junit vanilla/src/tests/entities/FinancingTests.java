package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {

	@Test
	public void shouldThrowExceptionWhenIllegalArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			creatingObjectForTestsClass(false);
		});
	}
	@Test
	public void shouldCreateObjectWhenForApproved() {
		
		Assertions.assertDoesNotThrow(() -> {
			creatingObjectForTestsClass(true);
		});
	}

	@Test
	public void shouldThrowExceptionWhenSetAmountInvalidValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = creatingObjectForTestsClass(true);
			fin.setTotalAmount(200000.0);
		});
	}
	
	@Test
	public void shouldDoNothingWhenSetAmountValidValue() {
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = creatingObjectForTestsClass(true);
			fin.setTotalAmount(50000.0);
		});
	}

	@Test
	public void shouldThrowExceptionWhenSetIncomeInvalidValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = creatingObjectForTestsClass(true);
			fin.setIncome(500.0);
		});
	}
	
	@Test
	public void shouldDoNothingWhenSetIncomeValidValue() {
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = creatingObjectForTestsClass(true);
			fin.setIncome(3000.0);
		});
	}

	@Test
	public void shouldThrowExceptionWhenSetMonthValid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = creatingObjectForTestsClass(true);
			fin.setMonths(10);
		});
	}

	@Test
	public void shouldDoNothingWhenSetMonthValid() {
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = creatingObjectForTestsClass(true);
			fin.setMonths(100);
		});
	}
	
	@Test
	public void shouldCorrectlyCalculateWhenEntryCalled() {
		Financing fTrue = creatingObjectForTestsClass(true);
		Assertions.assertEquals(20000.0, fTrue.entry());
	}
	
	@Test
	public void shouldCorrectlyCalculateWhenQuotaCalled() {
		Financing fTrue = creatingObjectForTestsClass(true);
		Assertions.assertEquals(1000.0, fTrue.quota());
	}
	
	private Financing creatingObjectForTestsClass(boolean valid) {
		if(valid) {
			double totalAmount = 100000.0;
			double income = 2000.0; 
			int months = 80;
			return new Financing(totalAmount,income, months);
		}
		else {
			double totalAmount = 100000.0;
			double income = 2000.0; 
			int months = 20;
			return new Financing(totalAmount,income, months);
		}
	}

}
