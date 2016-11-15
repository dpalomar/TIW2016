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

import es.uc3m.tiw.dominios.Administrador;
import es.uc3m.tiw.dominios.Usuario;


public interface AdministradorDAO {
	
	public abstract Administrador actualizarAdministrador(Administrador administrador) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract void borrarAdministrador(Administrador administrador) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Administrador crearAdministrador(Administrador administrador) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Administrador recuperarUnAdministradorPorMail(String nombre) throws SQLException;

	public abstract Administrador recuperarUnAdministradorPorClave(int pk) throws SQLException;

	public abstract Collection<Administrador> listarAdministrador() throws SQLException;

	public abstract void setConexion(EntityManager em);

	void setTransaction(UserTransaction ut);

}