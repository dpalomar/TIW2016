/**
 * 
 */
package es.uc3m.tiw.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominios.Producto;

/**
 * @author David Palomar
 *
 */
public interface ProductoDAO {
	
	public abstract Producto actualizarProducto(Producto producto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract void borrarProducto(Producto producto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Producto crearProducto(Producto nuevoProducto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Producto recuperarUnProductoPorTitulo(String nombre) throws SQLException;

	public abstract Producto recuperarUnProductoPorClave(int pk) throws SQLException;

	public abstract Collection<Producto> listarProductos() throws SQLException;

	public abstract void setConexion(EntityManager em);

	void setTransaction(UserTransaction ut);

	Collection<Producto> buscarPorUsuario(int usuario)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

}