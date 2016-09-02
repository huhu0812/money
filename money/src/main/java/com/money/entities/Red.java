package com.money.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Red implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634106468781742028L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50, nullable = false, unique = true)
	private String number;

	public Red() {

	}

	public Red(List<String> numbers) {
		this.number = numbers.parallelStream().sorted().collect(Collectors.joining(","));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<String> getNumbers() {
		return Arrays.asList(this.number.split(","));
	}

}
