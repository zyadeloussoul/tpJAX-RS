package ma.WebServices.repository;

import ma.WebServices.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface CompteRepository  extends JpaRepository<Compte, Long> {

}
