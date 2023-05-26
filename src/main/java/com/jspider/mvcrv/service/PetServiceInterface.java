package com.jspider.mvcrv.service;

import java.util.List;

import com.jspider.mvcrv.dto.PetDto;

public interface PetServiceInterface {

	PetDto insert(String pet_name, float pet_weight, String pet_color, String userName, String password);

	PetDto remove(int p_id);

	List<PetDto>findAllpets();

	PetDto search(int p_id);

	PetDto login(String userName, String password);

	void update(int p_id, String pet_name, float pet_weight, String pet_color, String userName, String password);
}
