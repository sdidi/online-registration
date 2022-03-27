package com.registrationonline.customerregistration.domain;

import io.swagger.annotations.*;
import javax.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "applicant model with all details")
public class Applicant
{
	@Id
	@ApiModelProperty(notes ="The unique id of the address")
	private long id;
	@ApiModelProperty(notes ="The applicant first name")
	private String firstName;
	@ApiModelProperty(notes ="The applicant last name")
	private String lastName;
	@Override
	public String toString()
	{
		return "{ Id: "+id+" firname name: "+firstName+ " last name: "+lastName+" }";
	}
}
