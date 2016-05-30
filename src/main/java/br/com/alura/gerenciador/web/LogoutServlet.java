package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("usuarioLogado");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
        dispatcher.forward(req, resp);
		
		//uso com cookie
//		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
//		if(cookie != null) {
//			cookie.setMaxAge(0);
//			resp.addCookie(cookie);
//			writer.println("<html><body>Deslogado com sucesso!!</body></html>");
//		}else {
//			writer.println("<html><body>Usuario não estava logado!</body></html>");
//		}
		
		
//		PrintWriter writer = resp.getWriter();
//		writer.println("<html><body>Deslogado com sucesso!!</body></html>");
		
	}
}
