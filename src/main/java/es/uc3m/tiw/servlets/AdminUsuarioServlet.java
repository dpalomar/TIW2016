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
@WebServlet("/adminUsuarios")
@MultipartConfig(location = "./../../../eclipseApps/WallapopTIW/imagenes")
public class AdminUsuarioServlet extends HttpServlet {
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
    public AdminUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		
		dao = new UsuarioDAOImpl();
		dao.setConexion(em);
		dao.setTransaction(ut);
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

	private Usuario recuperarDatosUsuario(HttpServletRequest request) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		int pk = Integer.parseInt(request.getParameter("id"));
		ut.begin();
		Usuario usuario = dao.recuperarUnUsuarioPorClave(pk);
		ut.commit();
		return  usuario;
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
		String pagina = "/misProductos.jsp";
		Usuario usuario = new Usuario();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		//Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		String productoid= request.getParameter("id");
		int id_usuario = Integer.parseInt("productoid");
		
		
		
	
		
					
		if (accion.equalsIgnoreCase(EDITAR)) {
			
			//recuperamos el usuario de la bbdd
			try {
				usuario = recuperarDatosUsuario(request);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
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
			// actualizamos los valores del usuario con los del formulario
			usuario.setApellidos(request.getParameter("apellidos"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setPassword(request.getParameter("password"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setCiudad(request.getParameter("ciudad"));
			
			sesion.setAttribute("usuario", usuario);
			//hacemos el update en la bbdd
			modificarUsuario(usuario);
			
			pagina="/Perfil.jsp";
			

	
		}else if (accion.equalsIgnoreCase(BORRAR)) {
			try {
				usuario = recuperarDatosUsuario(request);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
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
			pagina = "/login.jsp";
			borrarUsuario(usuario);
		}
	
		
							
		//Siempre que creemos, modifiquemos o borramos un producto. Actualizamos la lista de usuarios
		
		
		try {
			usuarios = (List<Usuario>) dao.listarUsuarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("usuarios", usuarios);
	
			
		
	
			
	//request.setAttribute("producto", producto);
	
		
		//sesion.setAttribute("usuario", u);
		//sesion.setAttribute("autenticado", true);
		
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}
	/**
	 * Modifica los datos del producto con el ProductoDao
	 * @param usuario
	 */
	private void modificarUsuario(Usuario usuario){
		try {
			dao.actualizarUsuario(usuario);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Borra los datos de un usuario con el UsuarioDao
	 * @param usuario
	 */
	private void borrarUsuario(Usuario usuario){
		try {
			dao.borrarUsuario(usuario);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Crea un usuario en la base de datos con el UsuarioDao
	 * @param usuario
	 */

}