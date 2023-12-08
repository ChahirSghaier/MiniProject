package tn.beecoder.chiliapp.services.interfaces;

import org.springframework.web.multipart.MultipartFile;
import tn.beecoder.chiliapp.entities.Image;

import java.io.IOException;

public interface IServiceImage {

    Image uploadImage(MultipartFile file) throws IOException;
}
