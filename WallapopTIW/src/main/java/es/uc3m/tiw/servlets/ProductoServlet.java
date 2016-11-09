package es.uc3m.tiw.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private UsuarioDAO dao;
	private ProductoDAO pdao;
	private Connection con;
	private static final String ALTA="ALTA",EDITAR="EDITAR",BORRAR="BORRAR";
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
		/*Comprobar en todo momento que el ususario que accede tiene la sesion abierta*/
		HttpSession sesion = request.getSession();
    		if((sesion.getAttribute("autenticado").toString()).equalsIgnoreCase("false")){
				
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);	
			}else{
		
				String accion = request.getParameter("accion");

					String pagina = null;
				
					try {
						try {
							try {
								if (accion.equalsIgnoreCase(ALTA)) {
									pagina = "/altaProducto.jsp";
									
								}else if (accion.equalsIgnoreCase(EDITAR)) {
									Producto producto = recuperarDatosProducto(request);
									request.setAttribute("producto", producto);
									pagina = "/Perfil.jsp";
									
								}else if (accion.equalsIgnoreCase(BORRAR)) {
									Producto producto = recuperarDatosProducto(request);
									pagina = "/login.jsp";
									borrarProducto(producto);
								}
							} catch (SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalStateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (RollbackException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (HeuristicMixedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (HeuristicRollbackException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (NotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
			
			}
	}

	/**
	 * Obtiene los datos del usuario a editar o borrar
	 * @param request
	 * @return
	 * @throws SQLException 
	 * @throws SystemException 
	 * @throws NotSupportedException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws RollbackException 
	 * @throws IllegalStateException 
	 * @throws SecurityException 
	 */
	private Usuario recuperarDatosProducto(HttpServletRequest request) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		int pk = Integer.parseInt(request.getParameter("id"));
		ut.begin();
		Usuario usuario = dao.recuperarUnUsuarioPorClave(pk);
		ut.commit();
		return  usuario;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		String pagina = "/login.jsp";
		
		if (accion.equalsIgnoreCase(ALTA)) {
			Usuario usuario = new Usuario();
			
			usuario.setEmail(request.getParameter("email"));
			usuario.setPassword(request.getParameter("clave"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellidos(request.getParameter("apellidos"));
			usuario.setCiudad(request.getParameter("ciudad"));
		
			altaUsuario(usuario);
			
			/*una vez dado de alta aÃ±adir el ususario a la List*/
			/* listaUsuarios.add(usuario) */
			
		}else if (accion.equalsIgnoreCase(EDITAR)) {
			Usuario usuario;
			try {
				try {
					//recuperamos el usuario de la bbdd
					usuario = recuperarDatosUsuario(request);
					// actualizamos los valores del usuario con los del formulario
					usuario.setApellidos(request.getParameter("apellidos"));
					usuario.setNombre(request.getParameter("nombre"));
					usuario.setPassword(request.getParameter("password"));
					usuario.setEmail(request.getParameter("email"));
					usuario.setCiudad(request.getParameter("ciudad"));
					
					//hacemos el update en la bbdd
					modificarUsuario(usuario);
					
					pagina="/Perfil.jsp";
					
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HeuristicMixedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		
		
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}
	/**
	 * Modifica los datos del usuario con el UsuarioDao
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
	 * Borra los datos de un usuario con el UsuarioDao
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
	 * Crea un usuario en la base de datos con el UsuarioDao
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
