package lulutexteditor;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private TextArea text_;
    
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
        text_ = ((TextArea)root.lookup("#text"));
        text_.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            textWatching();
        });
    }
    
    
    public void lulu(ActionEvent e){
        // TODO Save text inside a file and call LuluRun :)
    }
    
    public void textWatching(){
        System.out.println(text_.getText());
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
