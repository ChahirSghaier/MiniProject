package tn.beecoder.chiliapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.beecoder.chiliapp.entities.Image;

import java.util.List;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
List<Image> findAllByDish_Id(Long idDish);
}
