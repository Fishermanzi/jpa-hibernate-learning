package br.com.eumesmo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.eumesmo.model.Categoria;
import br.com.eumesmo.model.Movimentacao;
import br.com.eumesmo.util.JpaUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {

		Categoria categoria = new Categoria();
		categoria.setId(1);

		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movs = query.getResultList();

		movs.forEach(m ->
			System.out.println(String.format("{'descrição': '%s', 'conta_id': '%s'}",
					m.getDescricao(), m.getConta().getId())));

		em.getTransaction().commit();
		em.close();
	}

}
