package com.study.demo;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

	private final List<BankTransaction> transactions;

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.transactions = bankTransactions;
	}

	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction transaction : transactions) {
			total += transaction.getAmount();
		}
		return total;
	}

	public List<BankTransaction> selectTransactionInMonth( Month month) {
		List<BankTransaction> bankTransactionInMonth = new ArrayList<>();
		for (BankTransaction transaction : transactions) {
			if (transaction.getDate().getMonth() == month)
				bankTransactionInMonth.add(transaction);
		}
		return bankTransactionInMonth;
	}

	public double calculateTotalInMonth(Month month) {
		double total = 0d;
		for (BankTransaction transaction : transactions) {
			if (transaction.getDate().getMonth() == month)
				total += transaction.getAmount();
		}
		return total;
	}
	
	public double calculateTotalForCateory(final String category) {
		double total = 0d;
		for (BankTransaction transaction : transactions) {
			if (transaction.getDescription().equals(category))
				total += transaction.getAmount();
		}
		return total;
	}

}
