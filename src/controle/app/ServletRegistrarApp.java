package controle.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AppDAO;
import modelo.dominio.App;
import modelo.dominio.AppRequisitos;

@WebServlet(name = "registrarApp", description = "Registrar um App", urlPatterns = { "/registrarApp" })
public class ServletRegistrarApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRegistrarApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "Acesso proibido");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> erros = new ArrayList<String>();
		String id = request.getParameter("app-codigo");
		String nome = request.getParameter("app-nome");
		String desenvolvedor = request.getParameter("app-desenvolvedor");
		String preco = request.getParameter("app-preco");
		String descricao = request.getParameter("app-descricao");
		String sobre = request.getParameter("app-sobre");
		
		Float precoV = null;
		
		Integer appID = null;
		
		try {
			appID = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			appID = null;
		}
		
		if ((nome == null) || (nome.isEmpty())) erros.add("O campo Nome é obrigatório");
		if ((desenvolvedor == null) || (desenvolvedor.isEmpty())) erros.add("O campo Desenvolvedor é obrigatório");
		if ((descricao == null) || (descricao.isEmpty())) erros.add("O campo Descricao é obrigatório");
		if ((sobre == null) || (sobre.isEmpty())) erros.add("O campo Sobre é obrigatório");
		
		try {
			precoV = Float.parseFloat(preco);
		} catch (NumberFormatException er) {
			erros.add("O campo Preço é inválido");
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
		
		if(erros.isEmpty()){
			AppDAO dao = new AppDAO();
			dao.incluir(produto);
			
			response.sendRedirect("listarApp");
		}
		else{
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("editarApp.jsp").forward(request, response);
		}
	}

}
//baixo acoplamento é que você tem facilidade em mudar as coisas. ex: banco de dados
//quando terminar de gravar um formulario use o .sendRedirect para que redirecione para outra o tela e o usuario não fique floodando no banco