package br.com.knight.usuario.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.knight.usuario.modelo.Usuario;

/**
 * @author rogerio
 *
 */
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Inject
	private EntityManager manager;
	
	/**
	 * Construtor Padrão
	 */
	public UsuarioRepositoryImpl() {}

	/**
	 * Construtor para teste unitario
	 * 
	 * @param manager
	 */
	public UsuarioRepositoryImpl(EntityManager manager) {
		this.manager = manager;		
	}

	@Override
	public List<Usuario> todos() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
		Root<Usuario> from = query.from(Usuario.class);
		query.select(from);
		TypedQuery<Usuario> typedQuery = manager.createQuery(query);
		return typedQuery.getResultList();
	}

	@Override
	public Usuario buscar(Long id) {
		return manager.find(Usuario.class, id);
	}

	@Override
	public Usuario salvar(Usuario usuario) {		
		return manager.merge(usuario);
	}

	
}
