package br.com.eumesmo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.eumesmo.model.Conta;
import br.com.eumesmo.model.Movimentacao;
import br.com.eumesmo.util.JpaUtil;

public class TesteMovimentacoesDasContas {
	public static void main(String[] args) {
		
		String jpql = "Select distinct c from Conta c left join fetch c.movimentacoes";
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		Query query = em.createQuery(jpql);
		
		List<Conta> contas = query.getResultList();
		for (Conta c : contas) {
			System.out.println(c);
			c.getMovimentacoes().forEach(m -> System.out.println("   "+m));
			System.out.println();
		}
		em.close();
	}
}
