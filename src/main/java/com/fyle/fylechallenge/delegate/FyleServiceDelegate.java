package com.fyle.fylechallenge.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fyle.fylechallenge.dao.FyleDAO;
import com.fyle.fylechallenge.models.Bank;

import lombok.extern.log4j.Log4j2;

/**
 * Service resource delegate
 * @author prasanthvenkatesan
 *
 */
@Component
@Log4j2
public class FyleServiceDelegate {
	
	@Autowired
	private FyleDAO fyleDAO;

	/**
	 * Method to get a bank info by ifsc
	 * @param ifsc
	 * @return {@link Bank}
	 */
	public Bank getBankByIfsc(String ifsc) {
		log.traceEntry(ifsc);
		Bank bank = new Bank();
		if(!ifsc.isEmpty()) {
			bank = fyleDAO.getBankByIfsc(ifsc);
		}
		log.traceExit(bank);
		return bank;	
	}
	
	/**
	 * Method to get branches by name and city
	 * @param name
	 * @param city
	 * @return {@link List}
	 */
	public List<Bank> getBankByNameAndCity(String name, String city) {
		log.traceEntry(name, city);
		List<Bank> banks = fyleDAO.getBankByNameAndCity(name, city);
		log.traceExit(banks);
		return banks;
	}
}
