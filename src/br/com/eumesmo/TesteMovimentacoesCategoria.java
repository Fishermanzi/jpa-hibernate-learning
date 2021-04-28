package br.com.eumesmo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.eumesmo.model.Categoria;
import br.com.eumesmo.model.Conta;
import br.com.eumesmo.model.Movimentacao;
import br.com.eumesmo.model.TipoMovimentacao;
import br.com.eumesmo.util.JpaUtil;

public class TesteMovimentacoesCategoria {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Categoria c1 = new Categoria();
		Categoria c2 = new Categoria();
		
		c1.setId(1);
		c2.setId(2);
		
		Movimentacao mov1 = new Movimentacao(new BigDecimal(233), TipoMovimentacao.SAIDA, Calendar.getInstance(), "fui voar", conta,Arrays.asList(c1,c2));
		Movimentacao mov2 = new Movimentacao(new BigDecimal(1231), TipoMovimentacao.SAIDA, Calendar.getInstance(), "fui voar longe",conta,Arrays.asList(c1,c2));
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(mov1);
		em.persist(mov2);
		
		em.getTransaction().commit();
		em.close();
	}

}
