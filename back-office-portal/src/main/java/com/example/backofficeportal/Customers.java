package com.example.backofficeportal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Customers {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

}