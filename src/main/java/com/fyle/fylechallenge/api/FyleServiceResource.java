package com.fyle.fylechallenge.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-info")
public class FyleServiceResource {

	@GetMapping("/health-check")
	public String healthCheck() {
		return "Health Check";
	}
	
}
