package com.study.demo;

import java.util.List;

public interface CSVParser {
	
	public BankTransaction parseFromCsv(String lines);
	
	public List<BankTransaction> parseLineFromCsv(List<String>lines);

}
