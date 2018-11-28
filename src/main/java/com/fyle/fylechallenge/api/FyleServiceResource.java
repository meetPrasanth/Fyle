package com.fyle.fylechallenge.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyle.fylechallenge.constants.ServiceConstants;
import com.fyle.fylechallenge.delegate.FyleServiceDelegate;
import com.fyle.fylechallenge.models.Bank;

import lombok.extern.log4j.Log4j2;

/**
 * API endpoints for bank information
 * @author prasanthvenkatesan
 */
@RestController
@RequestMapping("/bank-info")
@Log4j2
public class FyleServiceResource {
	
	@Autowired
	private FyleServiceDelegate fyleServiceDelegate;

	/**
	 * Method to do health check
	 * @return {@link String}
	 */
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Health Check";
	}
	
	/**
	 * Method to get bank info by ifsc
	 * @param ifsc
	 * @return {@link Bank}
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Bank getBankByIfsc(@RequestParam(ServiceConstants.IFSC) String ifsc) {
		log.traceEntry(ifsc);
		Bank bank = fyleServiceDelegate.getBankByIfsc(ifsc);
		log.traceExit(ifsc);
		return bank;
	}
	
	/**
	 * Method to get bank branches by name and city
	 * @param name
	 * @param city
	 * @return {@link List}
	 */
	@GetMapping(path = "/branches", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bank> getBankByNameAndCity(@RequestParam(name = ServiceConstants.NAME, required = true) String name,
			@RequestParam(name = ServiceConstants.CITY, required = true) String city) {
		log.traceEntry(name, city);
		List<Bank> banks = fyleServiceDelegate.getBankByNameAndCity(name, city);
		log.traceExit(banks);
		return banks;
	}
	
}
