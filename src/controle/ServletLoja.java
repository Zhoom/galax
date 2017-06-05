package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AppDAO;
import modelo.dominio.App;

@WebServlet(name = "loja", urlPatterns = { "/loja" })
public class ServletLoja extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletLoja() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppDAO dao = new AppDAO();
		List<App> lista = dao.buscarTodos();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("loja.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
