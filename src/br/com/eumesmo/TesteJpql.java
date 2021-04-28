package br.com.eumesmo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.eumesmo.model.Conta;
import br.com.eumesmo.model.Movimentacao;
import br.com.eumesmo.model.TipoMovimentacao;
import br.com.eumesmo.util.JpaUtil;

public class TesteJpql {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(5);
		
//		String jpql = "select m from Movimentacao m where m.conta = :pConta "+
//		"and m.tipo = :pTipo "+
//		"order by m.valor desc";
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta "+
		"and m.tipo = :pTipo "+
		"order by m.valor desc";
		
		String jpql2 = "select avg(m.valor) from Movimentacao m where m.conta = :pConta "+
				"and m.tipo = :pTipo "+
				"order by m.valor desc";

		String jpql3 = "select avg(m.valor) from Movimentacao m where "+
				"m.tipo = :pTipo "+
				"group by day(m.data),month(m.data), year(m.data)";
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
//		List<Movimentacao> movs = query.getResultList();
		
//		movs.forEach(m -> System.out.println(
//				String.format("{'descrição': '%s', 'conta_id': '%s' }",
//						m.getDescricao(), m.getConta().getId())));
		
		BigDecimal soma = query.getSingleResult();
		System.out.println(soma);
		
		em.close();
		
		em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Double> query2 = em.createQuery(jpql2,Double.class);
		query2.setParameter("pConta", conta);
		query2.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		Double media = query2.getSingleResult();
		System.out.println(media);
		
		em.close();
		
		em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Double> query3 = em.createQuery(jpql3,Double.class);
		query3.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = query3.getResultList();
		
		medias.forEach(System.out::println);
		
		em.close();
	}
}
