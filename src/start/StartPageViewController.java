package start;
/**
 * Sample Skeleton for 'StartPageView.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartPageViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void OnClick(MouseEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("gamescreen/GameScreen.fxml"));
			Scene scene = new Scene(root,600,400);
			Stage stage=new Stage();
			stage.setTitle("DASHBOARD");
			stage.setScene(scene);
			stage.show();
} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
