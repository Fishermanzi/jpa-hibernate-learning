package br.com.eumesmo;

import javax.persistence.EntityManager;

import br.com.eumesmo.model.Conta;
import br.com.eumesmo.util.JpaUtil;

public class TesteBusca {
	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class,1);
		
		conta.setTitular("SADADAS");
		System.out.println(conta);
		
		em.getTransaction().commit();
		
	}
}
