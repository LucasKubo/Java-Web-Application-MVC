package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({ "/Index", "/Home" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        //Poderia criar uma conexão com banco de dados, mas nesse caso irei utilizar o Hibernate
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request -> encapsula metadados da requisição
		//response -> encapsula a resposta que será dada para a requisição
		//response.getWriter() -> retorna um printWritter do Java.io. Utilizado para escrever na saída da resposta.
		
		//Fazer o index.jsp como resposta da requisição
		//Para isso, utilizamos um objeto do tipo RequestDispatcher, que serve para receber uma requisição e encaminhar para outro recurso (servlet, jsp, html)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		rd.forward(request, response);
	}

}
