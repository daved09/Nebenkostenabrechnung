package gui;

import com.sun.jndi.toolkit.url.Uri;
import javafx.scene.layout.AnchorPane;
import resoureceloader.RessourceLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sun.security.util.Resources;

import java.io.IOException;
import java.io.Serializable;

public class AboutController implements Serializable {

    @FXML
    private Button btnClose;

    @FXML
    private TextArea txtAbout;

    public void initialize(){
        loadWindow();
    }


    private void loadWindow(){
        String text = RessourceLoader.loadContent("texts/about.txt");
        txtAbout.setText(text);
    }

    public void open(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/about.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("About me");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(ActionEvent event){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}
