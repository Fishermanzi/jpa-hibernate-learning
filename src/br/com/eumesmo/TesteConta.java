package br.com.eumesmo;

import javax.persistence.EntityManager;

import br.com.eumesmo.model.Conta;
import br.com.eumesmo.util.JpaUtil;

public class TesteConta {
	public static void main(String[] args) {
		
		Conta conta = new Conta("Leonardo","123","Caixa Economica","456");
        
		JpaUtil jpaUtil = new JpaUtil();
        EntityManager em = jpaUtil.getEntityManager();


        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();
        jpaUtil.close();
	}
}
