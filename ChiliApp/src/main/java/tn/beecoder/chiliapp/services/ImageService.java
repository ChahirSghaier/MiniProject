package tn.beecoder.chiliapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.beecoder.chiliapp.entities.Image;
import tn.beecoder.chiliapp.repositories.ImageRepository;
import tn.beecoder.chiliapp.services.interfaces.IServiceImage;
import tn.beecoder.chiliapp.utils.FileUploader;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ImageService implements IServiceImage {
   private ImageRepository imageRepo;
   @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        Image pImage = new Image();
        pImage.setNamePhoto(file.getOriginalFilename());
        pImage.setContentType(file.getContentType());
        pImage.setContent(FileUploader.compressImage(file.getBytes()));
        return imageRepo.save(pImage);
    }
}
