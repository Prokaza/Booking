package sfirat.component;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
@Service
public class ImageLouderHelper {
    MultipartFile image;
    String imageName;

    public ImageLouderHelper() {
    }

    public ImageLouderHelper(String imageName, MultipartFile image) {
        this.image = image;
        this.imageName = imageName;
    }

    public void validateImage() {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    public void saveImage(){
        try {
            byte[] bytes = image.getBytes();
            // Creating the directory to store file
            String rootPath = ("D:\\Web\\WebBooking\\src\\main\\webapp\\resources\\image"); //путь где лежат изображения в проетке

            File dir = new File(rootPath + File.separator + "photo_bike");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File saveFile = new File(dir.getAbsolutePath() + File.separator + imageName + ".jpg");

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(saveFile));
            stream.write(bytes);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
