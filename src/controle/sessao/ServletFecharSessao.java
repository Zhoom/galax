package controle.sessao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "fecharSessao", urlPatterns = { "/fecharSessao" })
public class ServletFecharSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFecharSessao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if (sessao != null)
		{
			sessao.removeAttribute("usuario");
			sessao.invalidate();
		}
		
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
