package com.fyle.fylechallenge.models;

import lombok.Data;

@Data
public class Bank {
	private int id;
	private String name;
	private String ifsc;
	private String branch;
	private String address;
	private String city;
	private String district;
	private String state;
}
