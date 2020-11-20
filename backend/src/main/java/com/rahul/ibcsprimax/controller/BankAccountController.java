package com.rahul.ibcsprimax.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.ibcsprimax.enums.AccountTypeEnum;

@CrossOrigin("*")
@RestController
@RequestMapping("/bankacc")
public class BankAccountController {

	@GetMapping("/accountTypes")
	public List<AccountTypeEnum> getAllAccountTypes(){
		return Arrays.asList(AccountTypeEnum.values());
	}
	
	//@GetMapping()
}
