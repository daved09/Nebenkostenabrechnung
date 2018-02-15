package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.io.Serializable;

public class MainController implements Serializable{


    public MainController(){
    }

    public void closeWindow(ActionEvent event){
        Platform.exit();
    }

    public void openAbout(){
        new AboutController().open();
    }

}
