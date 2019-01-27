/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lulutexteditor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author mdsinalpha
 */
public class LuluTextEditor extends Application {
    
    public static final String TITLE = "LULU COMPILER V2.1";
    public static final String FXML_PATH = "LuluTextEditor.fxml";
    
    @FXML
    private TextArea text;
    
    @FXML
    private ListView error;
    
    @FXML
    private CheckBox reveal;
    
    @FXML
    private CheckBox simulate;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_PATH));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(TITLE);
        stage.show();
    }
    
    
    public void lulu(ActionEvent e){
        // TODO Save text inside a file and call LuluRun :)
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
