package controle.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AppDAO;
import modelo.dominio.App;

@WebServlet("/listarApp")
public class ServletListarApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletListarApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppDAO dao = new AppDAO();
		List<App> lista = dao.buscarTodos();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("listarapp.jsp").forward(request, response);
		
	}

}