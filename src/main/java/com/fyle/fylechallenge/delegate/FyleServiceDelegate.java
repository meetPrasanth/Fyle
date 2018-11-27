package com.fyle.fylechallenge.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fyle.fylechallenge.dao.FyleDAO;
import com.fyle.fylechallenge.models.Bank;

@Component
public class FyleServiceDelegate {
	
	@Autowired
	private FyleDAO fyleDAO;

	public Bank getBankByIfsc(String ifsc) {
		Bank bank = new Bank();
		if(!ifsc.isEmpty()) {
			bank = fyleDAO.getBankByIfsc(ifsc);
		}
		return bank;	
	}
	
	public List<Bank> getBankByNameAndCity(String name, String city) {
		return fyleDAO.getBankByNameAndCity(name, city);
	}
}
