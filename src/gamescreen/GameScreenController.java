package gamescreen;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgplayer;

    @FXML
    private ImageView imgcomputer;

    @FXML
    private Label lblplayername;

    @FXML
    private Label lblplayerscore;

    @FXML
    private Label lblcomputerscore;
    
    int playerscore = 0;
    int computerscore = 0;
    boolean player = false;
    String playerimg = "Rock";
    String computerimg = "Rock";
    
    void setimage(){
    	  try{
    		    Image image1 = new Image(new FileInputStream("D:/Workspace/Game/src/gamescreen/"+playerimg+".png"));  
    		    imgplayer.setImage(image1);
    		    Image image2 = new Image(new FileInputStream("D:/Workspace/Game/src/gamescreen/"+computerimg+".png"));
    		    imgcomputer.setImage(image2);
    		    }
    		    catch(Exception e){
    		    	System.out.println("footo ni lbhii");
    		    }
    }
  
    @FXML
    void onPaper(MouseEvent event) {
    	playerimg = "Paper";
    	setimage();
    	pcturn();
    	onCheck();
    }

    void reset(){
    	imgplayer.setImage(null);
    	imgcomputer.setImage(null);
    	playerscore=0;
    	computerscore=0;
    	lblplayerscore.setText("0");
    	lblcomputerscore.setText("0");
    }
    @FXML
    void onReset(MouseEvent event) {
    	reset();

    }

    @FXML
    void onRock(MouseEvent event) {
    	playerimg = "Rock";
    	setimage();
    	pcturn();
    	onCheck();
    }

    @FXML
    void onScissor(MouseEvent event) {
    	playerimg = "Scissor";
    	setimage();
    	pcturn();
    	onCheck();
    }
    
    void pcturn(){
    	Random rand = new Random(); 
        int n = rand.nextInt(3);
        switch(n){
        case 0:
        	computerimg = "Rock";
        	break;
        case 1:
        	computerimg = "Paper";
        	break;
        case 2:
        	computerimg = "Scissor";
        	break;
        }
        setimage();
    }
    void onCheck(){
    	if(playerimg.equals(computerimg))
    		computerscore--;
    	else if(playerimg.equals("Rock") && computerimg.equals("Scissor") || playerimg.equals("Scissor") && computerimg.equals("Paper") || playerimg.equals("Paper") && computerimg.equals("Rock"))
    		player = true;
    	if(player==true)
    		playerscore++;
    	else
    		computerscore++;
    	lblplayerscore.setText(playerscore+"");
    	lblcomputerscore.setText(computerscore+"");
    	player=false;
    	if(playerscore == 5 )
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Results");
    		alert.setHeaderText("Congratulations");
    		alert.setContentText("You Wins");
    		alert.show();
    		reset();

    	}
    	else if(computerscore == 5){
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Results");
    		alert.setHeaderText("Better Luck Next Time.");
    		alert.setContentText("Computer Wins");
    		alert.show();
    		reset();

    	}
    }

    @FXML
    void initialize() {
    	setimage();
      
    }
}
