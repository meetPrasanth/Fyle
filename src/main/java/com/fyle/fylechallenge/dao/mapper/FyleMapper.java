package com.fyle.fylechallenge.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fyle.fylechallenge.constants.ServiceConstants;
import com.fyle.fylechallenge.models.Bank;

/**
 * Interface to interact with database using mybatis
 * @author prasanthvenkatesan
 */
@Mapper
public interface FyleMapper {
	
	/**
	 * Method to get bank info by ifsc
	 * @param ifsc
	 * @return {@link Bank}
	 */
	@Select("SELECT * FROM `bank` WHERE ifsc=#{ifsc}")
	Bank getBankByIfsc(String ifsc);
	
	/**
	 * Method to get bank branches by name and city
	 * @param name
	 * @param city
	 * @return {@link List}
	 */
	@Select("SELECT * FROM `bank` WHERE name=#{name} and city=#{city}")
	List<Bank> getBankByNameAndCity(@Param(ServiceConstants.NAME) String name, @Param(ServiceConstants.CITY) String city);

}
