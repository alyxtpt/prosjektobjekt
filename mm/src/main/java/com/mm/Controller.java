package com.mm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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

    public void openFile(ActionEvent e) throws IOException {
        List<Double> info = new ArrayList<Double>();
        FileChooser fileChooser = new FileChooser();
        ExtensionFilter ex = new ExtensionFilter("Text Files", "*.txt");

        fileChooser.getExtensionFilters().add(ex);

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            Scanner fileIn = null;

            try {
                fileIn = new Scanner(selectedFile);
                if (selectedFile.isFile()) {
                    while (fileIn.hasNextLine()) {
                        String line = fileIn.nextLine();
                        info.add(Double.valueOf(line));
                    }
                }
            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            } finally {
                fileIn.close();
            }
        }
        weapon = new Weapons(info.get(0),info.get(1),info.get(2));
        HealthBars.highsc = info.get(3);

        root = FXMLLoader.load(getClass().getResource("upgrade.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
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
