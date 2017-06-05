package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.AppDAO;
import modelo.dao.AppDoUsuarioDAO;
import modelo.dominio.App;
import modelo.dominio.AppDoUsuario;
import modelo.dominio.Usuario;

@WebServlet(name = "comprarApp", urlPatterns = { "/comprarApp" })
public class ServletComprarApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletComprarApp() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appID = request.getParameter("app-id");
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		//if ((usuario == null) && (usuario.getLogin() == null)) response.sendRedirect("login.jsp");
		//TODO: Exeções de saldo do usuario
		
		App app = null;
		try {
			AppDAO appDao = new AppDAO();
			appDao.buscarTodos();
			app = appDao.buscar(Integer.parseInt(appID));
		} catch (Exception e) {
			//TODO: fazer uma exeção ai depois;
		}
		
		AppDoUsuario appDoUsuario = new AppDoUsuario(usuario);
		appDoUsuario.setApp(app);
		
		AppDoUsuarioDAO appDoUsuarioDao = new AppDoUsuarioDAO();
		appDoUsuarioDao.incluir(appDoUsuario);
		
		response.sendRedirect("biblioteca");
	}

}
