package es.uc3m.tiw.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominios.Administrador;
import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Usuario;


public class AdministradorDAOImpl implements AdministradorDAO {

		private EntityManager em;
		private UserTransaction ut;
		@Override
	
	public Administrador actualizarAdministrador(Administrador administrador) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{

			ut.begin();
			em.merge(administrador);
			ut.commit();
			return recuperarUnAdministradorPorClave(administrador.getId());
		}
		
	public void borrarAdministrador(Administrador administrador) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		
		em.remove(em.merge(administrador));
		
		ut.commit();
	
	}

	public Administrador crearAdministrador(Administrador administrador) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		em.persist(administrador);
		ut.commit();
		//em.flush();
		return administrador;/*recuperarUnUsuarioPorNombre(nuevoUsuario.getEmail());*/
		//por que hace falta devolver un usuario
	}

	public Administrador recuperarUnAdministradorPorMail(String mail) throws SQLException{
		Query consulta = em.createQuery("select u from Administrador u where u.Administrador=:mail", Administrador.class);
		consulta.setParameter("mail", "email");
		return (Administrador) consulta.getResultList().get(0);
	}

	public Administrador recuperarUnAdministradorPorClave(int pk) throws SQLException{
		return em.find(Administrador.class, pk);
	}

	public Collection<Administrador> listarAdministrador() throws SQLException{
		return em.createQuery("select adm from Administrador adm", Administrador.class).getResultList();
	}

	public void setConexion(EntityManager em){
		this.em = em;
	}

	public void setTransaction(UserTransaction ut){
		this.ut = ut;
	}

}