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
@WebServlet("/AdminProducto")
@MultipartConfig(location = "./../../../eclipseApps/WallapopTIW/imagenes")
public class AdminProductoServlet extends HttpServlet {
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
    public AdminProductoServlet() {
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
		String pagina = "/misProductos.jsp";
		Producto producto = new Producto();
		
		//Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		String productoid= request.getParameter("id");
		int id_usuario = Integer.parseInt("productoid");
		
		
		
	
		
					if (accion.equalsIgnoreCase(ALTA)) {
						
						producto.setTitulo(request.getParameter("titulo"));
						producto.setCategoria(request.getParameter("categoria"));
						producto.setDescripcion(request.getParameter("descripcion"));
						//producto.setImagen(request.getParameter("imagen"));
						producto.setEstado(request.getParameter("estado"));
						producto.setPrecio(request.getParameter("precio"));
						//Cuando se crea un producto debe constar automáticamente como Disponible
						producto.setEstado("Disponible");
						
						
						try {
							Usuario user = dao.recuperarUnUsuarioPorClave(id_usuario);
							//producto.setUsuario(user);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						// Almacenamos en la base de datos el propietario del producto
						//Usuario usuario = (Usuario) sesion.getAttribute("usuario");
						//producto.setUsuario(usuario.getId());
						
						//Recuperar una imagen y guardarla en el servidor
						
						/* cogemos la imagen de la "parte" de la cabecera que la contiene, para ello en el input del formulario
						* teemos que tener una entrada de tipo file y con el nombre que queramos recuperar, en nuestro caso "imagen"
						*/
						/*Part filePart = request.getPart("imagen");
						/*
						* recuperamos el nombre del fichero para poder guardarlo con el mismo nombre en el servidor
						*/
						//String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
						/*
						* Utilizamos el nombre del fichero para guardarlo en la base de datos
						* IMPORTANTE: estamos guardando el nombre del fichero, no la URL completa
						*/
						//String nombreImagen = usuario.getId() + fileName;
					//	producto.setImagen(nombreImagen);
						/*
						* Creamos un fichero con el nombre del fichero, incluyendo la extension (png,jpg...)
						*/
						//File imagen = new File("./../eclipseApps/WallapopTIW/imagenes/"+nombreImagen);
						/*
						* Utilizamos el contenido de la "parte" recuperada para "llenar" el fichero que acabamos de crear
						*/
						/*InputStream fileContent = filePart.getInputStream();
						byte[] buffer = new byte[fileContent.available()];
						fileContent.read(buffer);
						OutputStream outStream = new FileOutputStream(imagen);
						outStream.write(buffer);
						outStream.close();*/
					
						request.setAttribute("producto", producto);
					
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
						pagina = "/login.jsp";
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
						pagina="/producto.jsp";
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
