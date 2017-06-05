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

@WebServlet(name = "filtrarApps", urlPatterns = { "/filtrarApps" })
public class ServletFiltrarApps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFiltrarApps() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String appNome = request.getParameter("nome-app");
		
		AppDAO dao = new AppDAO();
		
		List<App> lista = dao.Filtrar(appNome);
		
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("listarapp.jsp").forward(request, response);
	}

}
