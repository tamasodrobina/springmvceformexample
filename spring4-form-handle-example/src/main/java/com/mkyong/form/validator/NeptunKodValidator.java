package com.mkyong.form.validator;

import org.springframework.stereotype.Component;

@Component("neptunKodValidator")
public class NeptunKodValidator {


	public boolean valid(final String neptunKod) {
		return neptunKod.length() >= 6;
	}
}