package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Categoria;

public class CategoriaDAO {
	private EntityManager manager;

	public CategoriaDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(Categoria obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(Categoria obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(Categoria obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public Categoria buscar(Integer id) {

		Categoria retorno = this.manager.find(Categoria.class, id);

		return retorno;

	}

	public List<Categoria> buscarTodos() {
		
		String jpql = "FROM Categoria ORDER BY id";
		
		TypedQuery<Categoria> query = manager.createQuery(jpql, Categoria.class);
		List<Categoria> lista = query.getResultList();

		return lista;
	}
}
