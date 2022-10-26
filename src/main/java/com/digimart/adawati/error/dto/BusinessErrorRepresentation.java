package com.digimart.adawati.error.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessErrorRepresentation {

	private String errorCode;
	private String errorMessage;
	private String errorTime;
}
