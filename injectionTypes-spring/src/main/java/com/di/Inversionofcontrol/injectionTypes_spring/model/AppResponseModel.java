package com.di.Inversionofcontrol.injectionTypes_spring.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AppResponseModel {
	
	private String status;
	private int statusCode;
	private Exception e;
	
	

}
