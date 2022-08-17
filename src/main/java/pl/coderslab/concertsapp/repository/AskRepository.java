package pl.coderslab.concertsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.concertsapp.entity.Ask;

import pl.coderslab.concertsapp.entity.Club;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {

    @Query("SELECT a FROM Ask a WHERE a.event.club.id = :clubId")
    List<Ask> findAllByClub(Long clubId);

}
