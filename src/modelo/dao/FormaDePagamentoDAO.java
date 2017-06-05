package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.FormaDePagamento;

public class FormaDePagamentoDAO {
	private EntityManager manager;

	public FormaDePagamentoDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(FormaDePagamento obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(FormaDePagamento obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(FormaDePagamento obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public List<FormaDePagamento> buscarTodos() {
		
		String jpql = "FROM FormaDePagamento ORDER BY id";
		
		TypedQuery<FormaDePagamento> query = manager.createQuery(jpql, FormaDePagamento.class);
		List<FormaDePagamento> lista = query.getResultList();

		return lista;
	}
}
