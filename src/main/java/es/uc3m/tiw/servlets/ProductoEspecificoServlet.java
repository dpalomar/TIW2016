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
import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.daos.ProductoDAO;
import es.uc3m.tiw.daos.ProductoDAOImpl;
import es.uc3m.tiw.daos.UsuarioDAO;
import es.uc3m.tiw.daos.UsuarioDAOImpl;
/**
* Servlet implementation class usuarioServlet
*/
@WebServlet("/productoEspecifico")
public class ProductoEspecificoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private ServletConfig config;
private ProductoDAO pdao;
@PersistenceContext(unitName="WallapopTIW")
EntityManager em;
@Resource
UserTransaction ut;
public ProductoEspecificoServlet() {
super();
// TODO Auto-generated constructor stub
}
@Override
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

Producto producto;
HttpSession sesion = request.getSession();
producto=(Producto) sesion.getAttribute("producto");
producto.setTitulo(request.getParameter("titulo"));
producto.setCategoria(request.getParameter("categoria"));
producto.setDescripcion(request.getParameter("descripcion"));
producto.setPrecio(request.getParameter("precio"));
producto.setEstado(request.getParameter("estado"));


try {
sesion.setAttribute("producto", pdao.actualizarProducto(producto));
config.getServletContext().getRequestDispatcher("/producto.jsp").forward(request, response);
} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}