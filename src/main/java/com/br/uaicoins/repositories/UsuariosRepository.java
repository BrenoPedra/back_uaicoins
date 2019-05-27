package com.br.uaicoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.uaicoins.models.db.Usuario;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
}
