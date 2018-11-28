package com.fyle.fylechallenge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fyle.fylechallenge.dao.mapper.FyleMapper;
import com.fyle.fylechallenge.models.Bank;

import lombok.extern.log4j.Log4j2;

/**
 * DAO
 * @author prasanthvenkatesan
 *
 */
@Component
@Log4j2
public class FyleDAO {
	
	@Autowired
	private FyleMapper fyleMapper;

	/**
	 * Method to get bank by ifsc
	 * @param ifsc
	 * @return {@link Bank}
	 */
	public Bank getBankByIfsc(String ifsc) {
		log.traceEntry(ifsc);
		return fyleMapper.getBankByIfsc(ifsc);
	}
	
	/**
	 * Method to get bank branches by name and city
	 * @param name
	 * @param city
	 * @return {@link List}
	 */
	public List<Bank> getBankByNameAndCity(String name, String city) {
		log.traceEntry(name, city);
		return fyleMapper.getBankByNameAndCity(name, city);
	}
	
}
