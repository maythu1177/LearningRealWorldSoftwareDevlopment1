package com.study.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzer {

	public static final String RESOURCES = "src/Bank.csv";

	public void analyze(CSVParser parser) throws IOException {
		final Path path = Paths.get(RESOURCES);
		final List<String> lines = Files.readAllLines(path);
		final List<BankTransaction> transactionList = parser.parseLineFromCsv(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(transactionList);
		collectSummary(bankStatementProcessor);
	}

	private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println(
				"The total transaction for january  is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total transaction for feburary is "
				+ bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("The salary received is " + bankStatementProcessor.calculateTotalForCateory("Salary"));
	}
}
