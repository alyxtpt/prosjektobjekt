package com.mm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Text highscore;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        highscore.setText(Integer.toString((int) HealthBars.highsc));
    }


    public void switchToMain(ActionEvent event) throws IOException {
        HealthBars.highsc = 0;

        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
