package com.study.demo;

import java.io.IOException;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		CSVParser parser  = new BankStatementCSVParser();
		bankStatementAnalyzer.analyze(parser);
	}

}
