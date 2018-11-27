package com.fyle.fylechallenge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fyle.fylechallenge.dao.mapper.FyleMapper;
import com.fyle.fylechallenge.models.Bank;

@Component
public class FyleDAO {
	
	@Autowired
	private FyleMapper fyleMapper;

	public Bank getBankByIfsc(String ifsc) {
		return fyleMapper.getBankByIfsc(ifsc);
	}
	
	public List<Bank> getBankByNameAndCity(String name, String city) {
		return fyleMapper.getBankByNameAndCity(name, city);
	}
	
}
