package tn.beecoder.chiliapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.beecoder.chiliapp.entities.Dish;

import java.util.List;
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
List<Dish> findAll();


    Dish findDishById(Long id);
}
