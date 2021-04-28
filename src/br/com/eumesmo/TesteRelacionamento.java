package br.com.eumesmo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.eumesmo.model.Conta;
import br.com.eumesmo.model.Movimentacao;
import br.com.eumesmo.model.TipoMovimentacao;
import br.com.eumesmo.util.JpaUtil;

public class TesteRelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta("Carlos","6969","Xbox 360","2424");

		Movimentacao mov = new Movimentacao(new BigDecimal(200),TipoMovimentacao.ENTRADA, Calendar.getInstance(), "alou", conta);
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		em.close();
	}

}
