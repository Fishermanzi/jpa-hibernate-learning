package br.com.eumesmo;

import javax.persistence.EntityManager;

import br.com.eumesmo.model.Conta;
import br.com.eumesmo.model.Movimentacao;
import br.com.eumesmo.util.JpaUtil;

public class TesteMovimentacaoPorConta {
	public static void main(String[] args) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao mov = em.find(Movimentacao.class, 3);
		Conta conta = mov.getConta();
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();

	}
}
