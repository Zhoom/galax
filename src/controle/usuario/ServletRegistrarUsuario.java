package controle.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@WebServlet(name = "registrarUsuario", urlPatterns = { "/registrarUsuario" })
public class ServletRegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletRegistrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "Acesso proibido");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> erros = new ArrayList<String>();
		String login = request.getParameter("login-usuario");
		String senha = request.getParameter("senha-usuario");
		String email = request.getParameter("email-usuario");
		
		if ((login == null) || (login.isEmpty())) erros.add("O campo login é obrigatório");
		if ((senha == null) || (senha.isEmpty())) erros.add("O campo senha é obrigatório");
		if ((email == null) || (email.isEmpty())) erros.add("O campo email é obrigatório");
		
		Usuario usuario = new Usuario(login, senha, email);
		
		if(erros.isEmpty()){
			UsuarioDAO userDao = new UsuarioDAO();
			userDao.incluir(usuario);
			
			response.sendRedirect("home.jsp");
		}
		else{
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("registrarusr.jsp").forward(request, response);
		}
	}

}
