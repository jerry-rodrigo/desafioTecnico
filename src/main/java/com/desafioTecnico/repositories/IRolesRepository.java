package com.desafioTecnico.repositories;

import com.desafioTecnico.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {
    //Método para buscar un role por su nombre en nuestra base de datos
    //@Query("SELECT r FROM Roles r WHERE UPPER(r.name) = UPPER(:name)")
    Optional<Roles> findByName(String name);
}
