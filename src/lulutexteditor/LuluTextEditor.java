package lulutexteditor;

import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
        // Saving text inside a file and calling LuluRun :)
        File program = new File("__program.lulu");
        try{
            if(!program.exists()) program.createNewFile();
            FileWriter writer = new FileWriter(program);
            writer.write(text.getText());
            writer.flush();
            writer.close();
            String cmd = "java -jar lulu.jar";
            if(reveal.isSelected()) cmd += " -reveal";
            if(simulate.isSelected()) cmd += " -simulate";
            Runtime.getRuntime().exec(cmd);
        }catch(Exception ee){
            ee.printStackTrace();
        }
              
    }
    
    public void textWatching(){
       
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
