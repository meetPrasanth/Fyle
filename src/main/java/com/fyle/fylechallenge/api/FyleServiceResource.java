package com.fyle.fylechallenge.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyle.fylechallenge.constants.ServiceConstants;
import com.fyle.fylechallenge.delegate.FyleServiceDelegate;
import com.fyle.fylechallenge.models.Bank;

@RestController
@RequestMapping("/bank-info")
public class FyleServiceResource {
	
	@Autowired
	private FyleServiceDelegate fyleServiceDelegate;

	@GetMapping("/health-check")
	public String healthCheck() {
		return "Health Check";
	}
	
	@GetMapping(path = "/{" + ServiceConstants.IFSC +"}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Bank getBankByIfsc(@PathVariable(ServiceConstants.IFSC) String ifsc) {
		Bank bank = fyleServiceDelegate.getBankByIfsc(ifsc);
		return bank;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bank> getBankByNameAndCity(@RequestParam(name = ServiceConstants.NAME, required = true) String name,
			@RequestParam(name = ServiceConstants.CITY, required = true) String city) {
		List<Bank> banks = fyleServiceDelegate.getBankByNameAndCity(name, city);
		return banks;
	}
	
}
