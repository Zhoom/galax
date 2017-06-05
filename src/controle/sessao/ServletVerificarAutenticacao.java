package controle.sessao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dominio.Usuario;

public abstract class ServletVerificarAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletVerificarAutenticacao() {
        super();
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean autenticado = false;
		HttpSession sessao = request.getSession(false);
		if (sessao != null)
		{
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			if ((usuario != null) && (usuario.getLogin() != null))
				autenticado = true;
		}
		
		if (autenticado)
		{
			super.service(request, response);
		}
		else
		{
			List<String> erros = new ArrayList<String>();
			erros.add("Sua sessão autenticada expirou, por favor autentique-se novamente.");
			
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
