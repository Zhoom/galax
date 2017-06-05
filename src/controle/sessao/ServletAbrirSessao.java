package controle.sessao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@WebServlet(name = "abrirSessao", urlPatterns = { "/abrirSessao" })
public class ServletAbrirSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAbrirSessao() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "Acesso proibido");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> erros = new ArrayList<String>();
		String login = request.getParameter("login-usuario");
		String senha = request.getParameter("senha-usuario");
		
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario usuario = userDao.buscarLogin(login);
		
		if (usuario == null) erros.add("O usuário" + login + " não existe!");
		else if (!usuario.getSenhaHash().equals(senha)) erros.add("A senha está incorreta");
		
		if (erros.isEmpty())
		{
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("usuario", usuario);
			
			response.sendRedirect("home.jsp");
		}
		else
		{
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
