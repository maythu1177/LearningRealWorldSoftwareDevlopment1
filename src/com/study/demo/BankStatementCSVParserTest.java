package com.study.demo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

public class BankStatementCSVParserTest {

	@Test
	public void test() {
	   String lines = "2021-01-01,300,Cisco";
	   
	   BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
	   BankTransaction result = bankStatementCSVParser.parseFromCsv(lines);
	   
	   BankTransaction expected = new BankTransaction(LocalDate.of(2021, Month.JANUARY, 01),300,"Cisco");
	   
	   final double tolerance = 0.0d;
	   Assert.assertEquals(expected.getDate(), result.getDate());
	   Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
	   Assert.assertEquals(expected.getDescription(), result.getDescription());

	}

}
