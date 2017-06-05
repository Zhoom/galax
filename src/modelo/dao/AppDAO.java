package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.App;

public class AppDAO {
	private EntityManager manager;

	public AppDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(App obj) {

		//Abrir Transação
		this.manager.getTransaction().begin();
		
		try {
			//Tentar inserir objeto(dado) e efeturar o commit.
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			//Caso de erro, imprimir o erro, e efetuar o rollback.
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(App obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(App obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	//Declara um método chamado buscar que irá receber um valor Int pela varavel appID por alguem que chamar este método para enviar um valor
	public App buscar(Integer appID) {

		//armazena dentro do objeto retorno a linha na tabela com o appID informado
		//this.manager.find(App.class, appID) informa que, o plugin de gerenciador de tabelas, irá utilizar seu método find para localizar na tabela App utilizando o appID informado
		App retorno = this.manager.find(App.class, appID);

		//retorna a informação obtida na busca
		return retorno;

	}

	public List<App> buscarTodos() {
		
		String jpql = "FROM App";
		
		TypedQuery<App> query = manager.createQuery(jpql, App.class);
		List<App> lista = query.getResultList();

		return lista;
	}
	
	public List<App> Filtrar(String appNome) {
		
		String jpql = "FROM App WHERE appNome LIKE :appNome";
		
		TypedQuery<App> query = manager.createQuery(jpql, App.class);
		query.setParameter("appNome", "%" + appNome + "%");
		
		List<App> lista = query.getResultList();

		return lista;
	}
}
