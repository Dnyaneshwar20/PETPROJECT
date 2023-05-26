package com.jspider.mvcrv.dao;

import java.util.List;

import com.jspider.mvcrv.dto.PetDto;

public interface petDaoInterface {
	
	PetDto insert(String pet_name, float pet_weight, String pet_color, String userName, String password);

	void remove(int p_id);

	List<PetDto> findAllpets();

	PetDto search(int p_id);

	PetDto login(String userName, String password);

	void update(int p_id, String pet_name, float pet_weight, String pet_color, String userName, String password);

}
