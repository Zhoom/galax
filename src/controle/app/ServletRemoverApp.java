package controle.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AppDAO;
import modelo.dominio.App;

@WebServlet(name = "removerApp", urlPatterns = { "/removerApp" })
public class ServletRemoverApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRemoverApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("app-codigo");
		Integer appID = Integer.parseInt(codigo);
		
		AppDAO dao = new AppDAO();
		App app = dao.buscar(appID);
		dao.remover(app);
		
		response.sendRedirect("listarApp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
