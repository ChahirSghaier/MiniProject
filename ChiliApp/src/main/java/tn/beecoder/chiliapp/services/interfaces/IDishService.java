package tn.beecoder.chiliapp.services.interfaces;

import org.apache.coyote.Response;
import org.springframework.web.multipart.MultipartFile;
import tn.beecoder.chiliapp.entities.Dish;
import tn.beecoder.chiliapp.exception.RessourceNotFoundException;

import java.io.IOException;
import java.util.List;

public interface IDishService {
    public void addDish(Dish dish);
    public void deleteDish(Long id);
    public Dish updateDish(Long id,Dish dish) throws RessourceNotFoundException;
    public List<Dish> getAllDishes();
    public Dish getDish(Long id);
    public byte[] getImage(Long id);

    void uploadImageToDish(Long id, MultipartFile file) throws IOException;
}
