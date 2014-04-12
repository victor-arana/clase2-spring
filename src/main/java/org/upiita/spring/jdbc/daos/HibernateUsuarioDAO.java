package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Usuario;

@Component("usuarioDAO")
public class HibernateUsuarioDAO implements UsuarioDAO {
	
	// This is an Hibernate's utility class.
	@Autowired
	private SessionFactory sessionFactory;	

	public Usuario buscaUsuarioPorId(Integer usuarioId) {
		
		Session session = sessionFactory.openSession();
		
		// Transacciones de manera programática. Transacciones declarativas.
		session.beginTransaction();
		
		// Buscar por id en la tabla mapeado or la clase usuario 
		// el renglon cuyo id sea igual a usuario id
		Usuario usuario = (Usuario) session.get(Usuario.class, usuarioId);
		// Termina la transacción
		session.getTransaction().commit();
		// Cerramos la sesión de hibernate
		session.close();
		return usuario;
	}

	public void creaUsuario(Usuario usuario) {
		
		Session session = sessionFactory.openSession();
		
		// Transacciones de manera programática. Transacciones declarativas.
		session.beginTransaction();
		
		// Crea un nuevo renglon en la tabla
		// cuyas columnas se llenan con las propiedades de
		// la instancia usuario
		// Es equivalente a un in
		session.save(usuario);		

		session.getTransaction().commit();
		// Cerramos la sesión de hibernate
		session.close();

	}
	
	public Usuario buscarPorEmail(String email){
		Session session = sessionFactory.openSession();
		
		// Transacciones de manera programática. Transacciones declarativas.
		session.beginTransaction();
		
		Criteria criterio = session.createCriteria(Usuario.class);
		
		criterio.add(Restrictions.eq("email",email));
		
		// Si va a regresar una sola entidad
		Usuario usuario = (Usuario) criterio.uniqueResult();
		

		session.getTransaction().commit();
		// Cerramos la sesión de hibernate
		session.close();
		return usuario;
	}
	
	public List<Usuario> obtenPorNombre(String nombre){
		Session session = sessionFactory.openSession();
		
		// Transacciones de manera programática. Transacciones declarativas.
		session.beginTransaction();
		
		Criteria criterio = session.createCriteria(Usuario.class);
		
		criterio.add(Restrictions.like("nombre","%" + nombre + "%"));
		criterio.add(Restrictions.neq("email",email));
		
		// Si va a regresar una sola entidad
		List<Usuario> usuarios = criterio.list();
		

		session.getTransaction().commit();
		// Cerramos la sesión de hibernate
		session.close();
		
		return usuarios;
	}

}
