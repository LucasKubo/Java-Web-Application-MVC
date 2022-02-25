package controlador.pessoafisica;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.PessoaFisica;
import modelo.repositorio.PessoaFisicaRepositorio;

/**
 * Servlet implementation class ListarPessoaFisicaServlet
 */
@WebServlet({ "/pessoafisica", "/pessoafisica/listar" })
public class ListarPessoaFisicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPessoaFisicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Implementar a consulta
		PessoaFisicaRepositorio pf = new PessoaFisicaRepositorio();
		Collection<PessoaFisica> pessoasFisicas = pf.recuperarPessoasFisicas();
		
		//Configurando Collection de pessoasFisicas como atributo da request
		request.setAttribute("pessoasFisicas", pessoasFisicas);
		
		//Redirecionamento da request para a view (lembrando que a raiz das requisições é sempre webapp)
		//A view ira tratar a request.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/pessoafisica/listar.jsp");
		rd.forward(request, response);
		
	}

}
