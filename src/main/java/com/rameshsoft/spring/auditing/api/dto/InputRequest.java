package com.rameshsoft.spring.auditing.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

//here we passed logged in user
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class InputRequest<T> { //Generic
	@JsonProperty(value = "userId", required=true) //mandatory field
	private String loggedInUser;
	private String timeZone; //trace time user's used my application
	private T employee;

}
