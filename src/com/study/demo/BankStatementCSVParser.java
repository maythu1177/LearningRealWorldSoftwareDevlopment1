package com.study.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public BankTransaction parseFromCsv(String lines) {
		final String[] columns = lines.split(",");
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		return new BankTransaction(date,amount,description);
	}
	
	
	public List<BankTransaction> parseLineFromCsv(List<String>lines){
		List<BankTransaction> transactionList = new ArrayList<>();
		for(String line:lines) {
			transactionList.add(parseFromCsv(line));
		}
		return transactionList;
	}

}
