package com.lms.userservice.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


@Document(collection = "schools")
public class Schools {
	
	@Id
	private BigInteger id;
	private String schoolName;
	private String cityName;
	private String pocEmail;
	private BigInteger phoneNumber;
	private String website;
	private String signatoryName;
	private String signatoryRole;
	private String schoolType;

	
	

}
