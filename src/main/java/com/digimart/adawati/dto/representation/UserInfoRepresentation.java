package com.digimart.adawati.dto.representation;

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
public class UserInfoRepresentation {

	private String userName;
    private String firstName;
    private String lastName;
    private String state;
}
