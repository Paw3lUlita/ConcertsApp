package pl.coderslab.concertsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.concertsapp.entity.Band;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    Band findByName(String bandName);

    List<Band> findBandsByUserId(Long userId);


}
