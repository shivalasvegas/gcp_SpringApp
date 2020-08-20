package com.qa.hobbyproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "That id does not exist")
public class IdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 42L;

}
