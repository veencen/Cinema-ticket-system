package edu.hanu.sqaproject.repository;

import edu.hanu.sqaproject.model.FoodnDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodnDrinkRepository extends JpaRepository<FoodnDrink, Long> {
    FoodnDrink findByName(final String name);
}
