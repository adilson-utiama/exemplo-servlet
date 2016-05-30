package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresaServlet extends HttpServlet {
	
	public BuscaEmpresaServlet() {
		System.out.println("Construindo uma Servlet " + this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a Servlet " + this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a Servlet " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter writer = resp.getWriter();
//		writer.println("<html>");
//		writer.println("<body>");
//		writer.println("Resultado da busca:<br/>");
//		writer.println("<ul>");
		
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresas.jsp");
		dispatcher.forward(req, resp);
		
//		for (Empresa empresa : empresas) {
//			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
//		}
//		writer.println("</ul>");
//		writer.println("</body>");
//		writer.println("</html>");
	}
}
