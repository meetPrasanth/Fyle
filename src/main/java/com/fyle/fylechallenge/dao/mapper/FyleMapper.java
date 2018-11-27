package com.fyle.fylechallenge.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fyle.fylechallenge.models.Bank;

@Mapper
public interface FyleMapper {
	
	@Select("SELECT * FROM bank WHERE ifsc=#{ifsc}")
	Bank getBankByIfsc(String ifsc);
	
	@Select("SELECT * FROM bank WHERE name=#{name} and city=#{city}")
	List<Bank> getBankByNameAndCity(String name, String city);

}
