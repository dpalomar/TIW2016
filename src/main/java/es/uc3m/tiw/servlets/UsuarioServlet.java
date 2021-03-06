package es.uc3m.tiw.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.daos.UsuarioDAO;
import es.uc3m.tiw.daos.UsuarioDAOImpl;

/**
 * @author Grupo 3 - TIW 2016
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private UsuarioDAO dao;
	private Connection con;
	private static final String ALTA="ALTA",EDITAR="EDITAR",BORRAR="BORRAR";
    @PersistenceContext(unitName="WallapopTIW")
    EntityManager em;
    @Resource
    UserTransaction ut;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Las peticiones Get serán tratadas de la misma manera que las peticiones Post.
		doPost(request, response);
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
	private Usuario recuperarDatosUsuario(HttpServletRequest request) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
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
		Usuario usuario = new Usuario();
		
		try {
			try {
				try {
					if (accion.equalsIgnoreCase(ALTA)) {
						
						
						usuario.setEmail(request.getParameter("email"));
						usuario.setPassword(request.getParameter("clave"));
						usuario.setNombre(request.getParameter("nombre"));
						usuario.setApellidos(request.getParameter("apellidos"));
						usuario.setCiudad(request.getParameter("ciudad"));
					
						altaUsuario(usuario);
						
					}else if (accion.equalsIgnoreCase(EDITAR)) {
				
								//recuperamos el usuario de la bbdd
								usuario = recuperarDatosUsuario(request);
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
						usuario = recuperarDatosUsuario(request);
						pagina = "/login.jsp";
						borrarUsuario(usuario);
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
		
		
		
	/**
	 * Modifica los datos del usuario con el UsuarioDao
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
	private void altaUsuario(Usuario usuario){
		try {
			dao.crearUsuario(usuario);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}