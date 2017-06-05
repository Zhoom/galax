package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.AppDoUsuarioDAO;
import modelo.dominio.AppDoUsuario;
import modelo.dominio.Usuario;

@WebServlet(name = "biblioteca", urlPatterns = { "/biblioteca" })
public class ServletBiblioteca extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletBiblioteca() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		AppDoUsuarioDAO dao = new AppDoUsuarioDAO();
		List<AppDoUsuario> listaAppUser = dao.buscarTodos(usuario);
		
		request.setAttribute("listaAppUser", listaAppUser);
		
		request.getRequestDispatcher("biblioteca.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
