package es.uc3m.tiw.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.UsuarioDAO;
import es.uc3m.tiw.daos.UsuarioDAOImpl;

import es.uc3m.tiw.daos.ProductoDAO;
import es.uc3m.tiw.daos.ProductoDAOImpl;

import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.dominios.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/producto")
@MultipartConfig(location = "./../../../eclipseApps/WallapopTIW/imagenes")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private UsuarioDAO dao;
	private ProductoDAO pdao;
	private List<Producto> productos = new ArrayList<Producto>();
	private Connection con;
	private static final String ALTA="ALTA",EDITAR="EDITAR",BORRAR="BORRAR", VER="VER";
    @PersistenceContext(unitName="WallapopTIW")
    EntityManager em;
    @Resource
    UserTransaction ut;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		
		pdao = new ProductoDAOImpl();
		pdao.setConexion(em);
		pdao.setTransaction(ut);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Las peticiones Get serán tratadas de la misma manera que las peticiones Post.
		doPost(request, response);
	}

	protected void ActualizarLista(){
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		String pagina = "/producto.jsp";
		Producto producto = new Producto();
		
		//Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		String productoid= request.getParameter("id");
		
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		int id_user = user.getId();
		
	
		
	
		
					if (accion.equalsIgnoreCase(ALTA)) {
						
						
						producto.setTitulo(request.getParameter("titulo"));
						producto.setCategoria(request.getParameter("categoria"));
						producto.setDescripcion(request.getParameter("descripcion"));
						//producto.setImagen(request.getParameter("imagen"));
						producto.setEstado(request.getParameter("estado"));
						producto.setPrecio(request.getParameter("precio"));
						//Cuando se crea un producto debe constar automáticamente como Disponible
						producto.setEstado("Disponible");
						producto.setUsuario(id_user);
					
						request.setAttribute("producto", producto);
						
						pagina ="/misProductos.jsp";
					
						// Lo creamos en la base de datos
						altaProducto(producto);
						
						
					}else if (accion.equalsIgnoreCase(EDITAR)) {
						//Producto producto;
						
								//recuperamos el producto de la bbdd
								try {
									producto = pdao.recuperarUnProductoPorClave(Integer.parseInt(productoid));
								} catch (NumberFormatException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								//Modificamos los datos
								producto.setTitulo(request.getParameter("titulo"));
								producto.setCategoria(request.getParameter("categoria"));
								producto.setDescripcion(request.getParameter("descripcion"));
								//producto.setImagen(request.getParameter("imagen"));
								producto.setEstado(request.getParameter("estado"));
								producto.setPrecio(request.getParameter("precio"));
							
								
								sesion.setAttribute("producto", producto);
								
								
								//request.setAttribute("producto", producto);
								
								//hacemos el update en la bbdd
								modificarProducto(producto);
								
								pagina="/producto.jsp";
						
					}else if (accion.equalsIgnoreCase(BORRAR)) {
						
						try {
							producto = pdao.recuperarUnProductoPorClave(Integer.parseInt(productoid));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pagina = "/Perfil";
						borrarProducto(producto);
					}
					
					else if (accion.equalsIgnoreCase(VER)) {
						try {
							producto = pdao.recuperarUnProductoPorClave(Integer.parseInt(productoid));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						pagina = "/Perfil";
						sesion.setAttribute("producto", producto);
		
			
						request.setAttribute("producto", producto);

						
						//config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
						
						
					}
					
					//Siempre que creemos, modifiquemos o borramos un producto. Actualizamos la lista del home.
					
					
					try {
						productos = (List<Producto>) pdao.listarProductos();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					request.setAttribute("productos", productos);
				
	
		
	
			
	//request.setAttribute("producto", producto);
	
		
		//sesion.setAttribute("usuario", u);
		//sesion.setAttribute("autenticado", true);
		
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}
	/**
	 * Modifica los datos del producto con el ProductoDao
	 * @param usuario
	 */
	private void modificarProducto(Producto producto){
		try {
			pdao.actualizarProducto(producto);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Borra los datos de un producto con el ProductoDao
	 * @param usuario
	 */
	private void borrarProducto(Producto producto){
		try {
			pdao.borrarProducto(producto);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Crea un producto en la base de datos con el ProductoDao
	 * @param usuario
	 */
	private void altaProducto(Producto producto){
		try {
			pdao.crearProducto(producto);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
