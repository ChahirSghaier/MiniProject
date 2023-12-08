package tn.beecoder.chiliapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.beecoder.chiliapp.entities.Dish;
import tn.beecoder.chiliapp.entities.Image;
import tn.beecoder.chiliapp.exception.RessourceNotFoundException;
import tn.beecoder.chiliapp.repositories.DishRepository;
import tn.beecoder.chiliapp.services.interfaces.IDishService;
import tn.beecoder.chiliapp.services.interfaces.IServiceImage;
import tn.beecoder.chiliapp.utils.FileUploader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishService implements IDishService {
    private DishRepository dishRepository;

    @Override
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void addDish(Dish dish, MultipartFile file) throws IOException {
        Dish newDish ;
        newDish=dishRepository.save(dish);
        uploadImageToDish(newDish.getId(),file);
    }

    @Override
    public void deleteDish(Long id) {
      dishRepository.deleteById(id);
    }

    @Override
    public Dish updateDish(Long id,Dish dish) throws RessourceNotFoundException {
        Dish newDish = new Dish();
        if( dishRepository.findById(id).isPresent()) {
            newDish = dishRepository.findById(id).get();
            newDish.setName(dish.getName());
            newDish.setPrice(dish.getPrice());
            return dishRepository.save(newDish);
        }else{
                throw new RessourceNotFoundException("dish not existed ");
                  }
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDish(Long id) {
        return dishRepository.findById(id).get();
    }

    @Override
    public byte[] getImage(Long id) {
        Dish dish = dishRepository.findDishById(id);
       Optional<Image>  image = dish.getImageList().stream().findFirst();
        return FileUploader.decompressImage(image.get().getContent());
    }

    private IServiceImage serviceImage;

    @Override
    public void uploadImageToDish(Long id, MultipartFile file) throws IOException
    {
       if(dishRepository.findById(id).isPresent())
       {
           Dish dish = dishRepository.findById(id).get();
           Image image =serviceImage.uploadImage(file);
           dish.getImageList().add(image);
           dishRepository.save(dish);
       }else{
           throw new IOException("problem with uploading image to dish");
       }
    }
}
