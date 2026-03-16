package com.mm;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static Weapons weapon;

    public void bow(ActionEvent e) {
        weapon = new Weapons("bow");
        try {
            switchToFight(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sword(ActionEvent e) {
        weapon = new Weapons("sword");
        try {
            switchToFight(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mace(ActionEvent e) {
        weapon = new Weapons("mace");
        try {
            switchToFight(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void switchToPlay(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("play.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFight(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fight.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
