package com.jspider.mvcrv.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="pet_details")

public class PetDto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
private int p_id;
	
	private String pet_name;
	
	private float pet_weight;
	
	private String pet_color;
	
	private String userName;
	
	private String password;


}
