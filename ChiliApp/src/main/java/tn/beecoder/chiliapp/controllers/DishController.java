package tn.beecoder.chiliapp.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.beecoder.chiliapp.entities.Dish;
import tn.beecoder.chiliapp.exception.RessourceNotFoundException;
import tn.beecoder.chiliapp.services.interfaces.IDishService;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dish")
@AllArgsConstructor
public class DishController {
    private IDishService dishService;
    @PostMapping("/add")
    public void addDish(@RequestBody Dish dish) {
        dishService.addDish(dish);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDish(@PathVariable("id") Long id){
        dishService.deleteDish(id);
    }
    @PutMapping("/update/{id}")
    public Dish updateDish(@PathVariable("id") Long id,@RequestBody Dish dish) throws RessourceNotFoundException {
       return dishService.updateDish(id,dish);
    }
    @GetMapping("/all")
    public List<Dish> getAllDishes(){
        return dishService.getAllDishes();
    }
    @GetMapping("/{id}")
    public Dish getDish(@PathVariable("id") Long id){
        return dishService.getDish(id);
    }
    @PutMapping("/{id}/uploadingPhoto/")
    public void uploadImageToDish(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file) throws IOException{
     dishService.uploadImageToDish(id,file);
    }
    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> getImageDish(@PathVariable("id") Long id)
    {
        byte[] image = dishService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
