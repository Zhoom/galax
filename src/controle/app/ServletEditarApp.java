package controle.app;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.AppDAO;
import modelo.dominio.App;
import modelo.dominio.AppRequisitos;

@WebServlet("/editarApp")
public class ServletEditarApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEditarApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("app-codigo");
		Integer appID = Integer.parseInt(codigo);
		
		
		AppDAO dao = new AppDAO();
		App app = dao.buscar(appID);
		
		request.setAttribute("app", app);
		
		RequestDispatcher desp = request.getRequestDispatcher("editarapp.jsp");
		desp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("app-codigo");
		String nome = request.getParameter("app-nome");
		String desenvolvedor = request.getParameter("app-desenvolvedor");
		String preco = request.getParameter("app-preco");
		String descricao = request.getParameter("app-descricao");
		String sobre = request.getParameter("app-sobre");
		
		Float precoV = Float.parseFloat(preco);
		
		Integer appID = null;
		
		try {
			appID = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			appID = null;
		}
		
		String osMin = request.getParameter("app-min-req-os");
		String processorMin = request.getParameter("app-min-req-proc");
		String memoryMin = request.getParameter("app-min-req-mem");
		String videocardMin = request.getParameter("app-min-req-vidc");
		String directxMin = request.getParameter("app-min-req-dicx");
		String armazenamentoMin = request.getParameter("app-min-req-hd");
		
		String osRec = request.getParameter("app-recomend-req-os");
		String processorRec = request.getParameter("app-recomend-req-proc");
		String memoryRec = request.getParameter("app-recomend-req-mem");
		String videocardRec = request.getParameter("app-recomend-req-vidc");
		String directxRec = request.getParameter("app-recomend-req-dicx");
		String armazenamentoRec = request.getParameter("app-recomend-req-hd");

		AppRequisitos requisitosMin = new AppRequisitos(osMin, memoryMin, processorMin, videocardMin, directxMin, armazenamentoMin);
		AppRequisitos requisitosRec = new AppRequisitos(osRec, memoryRec, processorRec, videocardRec, directxRec, armazenamentoRec);
		
		App produto = new App(appID, nome, precoV, desenvolvedor, descricao, sobre, requisitosMin, requisitosRec);
		
		AppDAO dao = new AppDAO();
		dao.alterar(produto);
		
		response.sendRedirect("listarApp");
	}

}
