package softwares.inventarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import softwares.inventarios.entities.entities;

public interface ProductRepository extends JpaRepository<entities, Integer>{

}
