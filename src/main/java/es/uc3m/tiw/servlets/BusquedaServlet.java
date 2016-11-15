package es.uc3m.tiw.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.daos.ProductoDAO;
import es.uc3m.tiw.daos.ProductoDAOImpl;

/**
 * Servlet implementation class buscarProductosSimple
 */

	@WebServlet("/busqueda")
	public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Producto> productos = null;
	private ProductoDAO pdao;
	private ServletConfig config;
	@PersistenceContext(unitName="WallapopTIW")
    EntityManager em;
    @Resource
    UserTransaction ut;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   public BusquedaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	this.config = config;
   		pdao = new ProductoDAOImpl();
   		pdao.setConexion(em);
   		pdao.setTransaction(ut);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = null;
		productos = null;
		String pagina="/home.jsp";
		if(request.getParameter("busqueda").equals("") || request.getParameter("busqueda") == null){
			config.getServletContext().getRequestDispatcher(pagina).forward(request,response);
		}
		
		else{
			busqueda = request.getParameter("busqueda");
		}
			try {
				productos = (List<Producto>) pdao.listarProductos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		for(int i = 0; i < productos.size(); i++){
			if(!productos.get(i).getDescripcion().contains(busqueda) && !productos.get(i).getTitulo().contains(busqueda) 
			    ){
				productos.remove(productos.get(i));
				i--;
			}
			
		}
		request.setAttribute("productos", productos);
		config.getServletContext().getRequestDispatcher(pagina).forward(request,response);
		
	}
}