package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Publicador;

public class PublicadorDAO {
	private EntityManager manager;

	public PublicadorDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(Publicador obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(Publicador obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(Publicador obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public Publicador buscar(Integer publisherID) {

		Publicador retorno = this.manager.find(Publicador.class, publisherID);

		return retorno;

	}

	public List<Publicador> buscarTodos() {
		
		String jpql = "FROM Publicador ORDER BY publisherID";
		
		TypedQuery<Publicador> query = manager.createQuery(jpql, Publicador.class);
		List<Publicador> lista = query.getResultList();

		return lista;
	}
}
