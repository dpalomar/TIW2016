/**
 * 
 */
package es.uc3m.tiw.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Producto;

/**
 * @author David Palomar
 *
 */
public class ProductoDAOImpl implements ProductoDAO {

	private EntityManager em;
	private UserTransaction ut;
	@Override
	public Collection<Producto> listarProductos() throws SQLException{
		
		
		return em.createQuery("select p from Producto p", Producto.class).getResultList();
	}
	@Override
	public Producto recuperarUnProductoPorClave(int pk) throws SQLException{
		
		return em.find(Producto.class, pk);
		
	}
	@Override
	/**
	 * Se asume que el campo usuario es unique y por tanto solo recuperará un usuario en caso de existir
	 */
	public Producto recuperarUnProductoPorTitulo(String titulo) throws SQLException{
		
		Query consulta = em.createQuery("select u from Usuario u where u.usuario=:nom", Producto.class);
		consulta.setParameter("nom", "nombre");
		return (Producto) consulta.getResultList().get(0);
	}
	@Override
	public Producto crearProducto(Producto nuevoProducto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		em.persist(nuevoProducto);
		ut.commit();
		//em.flush();
		return nuevoProducto;/*recuperarUnUsuarioPorNombre(nuevoUsuario.getEmail());*/
		//por que hace falta devolver un usuario
	}
	@Override
	public void borrarProducto(Producto producto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		
		em.remove(em.merge(producto));
		
		ut.commit();
		
	}
	@Override
	public Producto actualizarProducto(Producto producto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		em.merge(producto);
		ut.commit();
		return recuperarUnProductoPorClave(producto.getId());
		
	}
	@Override
	public void setConexion(EntityManager em) {
		this.em = em;
		
	}
	@Override
	public void setTransaction(UserTransaction ut){
		this.ut = ut;
	}

}