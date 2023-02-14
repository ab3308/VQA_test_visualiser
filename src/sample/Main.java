package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Model Prediction Visualiser");
        primaryStage.setScene(new Scene(root, 900, 500));

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        ImageView selectedImage = (ImageView) root.lookup("#imageView");

        Button selectButton = (Button) root.lookup("#selectButton");
        selectButton.setOnAction(event -> {
            File imageFile = fileChooser.showOpenDialog(primaryStage);
            if(imageFile != null && imageFile.exists()){
                javafx.scene.image.Image image = new Image(imageFile.toURI().toString());
                selectedImage.setImage(image);
            }
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
