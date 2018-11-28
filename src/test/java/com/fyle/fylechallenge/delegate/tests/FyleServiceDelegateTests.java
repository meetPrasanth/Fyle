package com.fyle.fylechallenge.delegate.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fyle.fylechallenge.delegate.FyleServiceDelegate;
import com.fyle.fylechallenge.models.Bank;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class FyleServiceDelegateTests {

	@Autowired
	FyleServiceDelegate fyleServiceDelegate;
	
	@Test
	public void getBankByIfsc() {
		log.traceEntry();
		String ifsc = "ABHY0065004";
		Bank bank = fyleServiceDelegate.getBankByIfsc(ifsc);
		Assert.assertNotNull(bank);
		log.traceExit(bank);
	}
	
	@Test
	public void getBankByNameAndCity() {
		log.traceEntry();
		String name = "ALLAHABAD BANK";
		String city = "KOLKATA";
		List<Bank> banks = fyleServiceDelegate.getBankByNameAndCity(name, city);
		Assert.assertTrue(banks.size() > 0);
		log.traceExit(banks);
	}
}
