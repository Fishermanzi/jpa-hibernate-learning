package br.com.eumesmo;

import javax.persistence.EntityManager;

import br.com.eumesmo.model.Cliente;
import br.com.eumesmo.model.Conta;
import br.com.eumesmo.util.JpaUtil;

public class TesteClienteConta {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(3);
		Cliente cliente = new Cliente("Carlão", "Padeiro", "Rua Guatemala 6325 - Bairro Santo Delgado - Belo Horizonte",conta);
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
