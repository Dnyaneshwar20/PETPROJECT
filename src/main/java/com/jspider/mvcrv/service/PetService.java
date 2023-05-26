package com.jspider.mvcrv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.mvcrv.dao.petDao;
import com.jspider.mvcrv.dto.PetDto;

@Service
public class PetService implements PetServiceInterface {
	@Autowired
	private petDao dao;

	@Override
	public PetDto insert(String pet_name, float pet_weight, String pet_color, String userName, String password) {
		PetDto pd = dao.insert(pet_name, pet_weight, pet_color, userName, password);

		// TODO Auto-generated method stub
		return pd;
	}

	@Override
	public PetDto remove(int p_id) {
		PetDto pd = dao.search(p_id);
		if (pd != null) {
			dao.remove(p_id);
			return pd;
		}
		return null;
	}

	@Override
	public List<PetDto> findAllpets() {
		List<PetDto> pd = dao.findAllpets();
		return pd;
	}

	@Override
	public PetDto search(int p_id) {
		// TODO Auto-generated method stub
		PetDto pd = dao.search(p_id);

		return pd;
	}

	@Override
	public PetDto login(String userName, String password) {
		// TODO Auto-generated method stub
		PetDto pd = dao.login(userName, password);
		if (pd != null) {
			return pd;
		}
		return null;
	}

	@Override
	public void update(int p_id, String pet_name, float pet_weight, String pet_color, String userName,
			String password) {
		// TODO Auto-generated method stub
dao.update(p_id, pet_name, pet_weight, pet_color, userName, password);
	}
}
