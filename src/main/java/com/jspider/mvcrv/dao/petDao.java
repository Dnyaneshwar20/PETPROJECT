package com.jspider.mvcrv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.mvcrv.dto.PetDto;

@Repository
public class petDao implements petDaoInterface {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;

	public static void oc() {
		emf = Persistence.createEntityManagerFactory("wejm3");
		em = emf.createEntityManager();
		et = em.getTransaction();

	}

	public static void cc() {
		if (emf != null) {
			emf.close();
		}
		if (em != null) {
			em.close();
		}

	}

	@Override
	public PetDto insert(String pet_name, float pet_weight, String pet_color, String userName, String password) 
	{
		oc();
		et.begin();
		PetDto pd = new PetDto();
		pd.setPet_name(pet_name);
		pd.setPet_weight(pet_weight);
		pd.setPassword(password);
		pd.setPet_color(pet_color);
		pd.setUserName(userName);
		em.persist(pd);
		et.commit();
		cc();
		return pd;
	}

	@Override
	public void remove(int p_id) {
		oc();
		et.begin();
		PetDto pd = em.find(PetDto.class, p_id);
		em.remove(pd);
		et.commit();
		cc();

	}

	@Override
	public List<PetDto> findAllpets() {
		oc();
		et.begin();
		String jpql = "from PetDto";
		Query q = em.createQuery(jpql);
		List<PetDto> l = q.getResultList();
		et.commit();
		cc();

		return l;
	}

	@Override
	public PetDto search(int p_id) {
		oc();
		et.begin();
		PetDto pd = em.find(PetDto.class, p_id);
		et.commit();
		cc();
		return pd;
	}

	@Override
	public PetDto login(String userName, String password) {
		oc();
		et.begin();
		String jpql = "from PetDto where username='" + userName + "'and password='" + password + "'";
		Query createQuery = em.createQuery(jpql);
		try {
			PetDto pd = (PetDto) createQuery.getSingleResult();
			if (pd != null) {
				et.commit();
				cc();
				return pd;
			}
		} catch (

		Exception e) {
			cc();
			return null;
		}
		return null;
	}

	@Override
	public void update(int p_id, String pet_name, float pet_weight, String pet_color, String userName,
			String password) {
		oc();
		et.begin();
		PetDto pd = em.find(PetDto.class, p_id);
		pd.setPassword(password);
		pd.setPet_color(pet_color);
		pd.setPet_name(pet_name);
		pd.setPet_weight(pet_weight);
		pd.setUserName(userName);
		em.persist(pd);
		et.commit();
	}

	

}
