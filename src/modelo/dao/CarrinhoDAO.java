package modelo.dao;

import javax.persistence.EntityManager;

import modelo.dominio.Carrinho;

public class CarrinhoDAO {
	private EntityManager manager;

	public CarrinhoDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(Carrinho obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(Carrinho obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(Carrinho obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

}
