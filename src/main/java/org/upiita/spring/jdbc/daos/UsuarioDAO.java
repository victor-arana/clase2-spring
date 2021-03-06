package org.upiita.spring.jdbc.daos;

import java.util.List;

// Este es un cambio importante
// Este es un cambio extra

import org.upiita.spring.jdbc.entidades.Usuario;

public interface UsuarioDAO {

	public Usuario buscaUsuarioPorId(Integer usuarioId);

	public void creaUsuario(Usuario usuario);
	
	public Usuario buscarPorEmail(String email);
	
	public List<Usuario> obtenPorNombre(String nombre);

}