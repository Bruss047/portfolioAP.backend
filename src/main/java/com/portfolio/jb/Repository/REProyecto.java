package com.portfolio.jb.Repository;

import com.portfolio.jb.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REProyecto extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
