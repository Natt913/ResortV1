import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class FoodServicesControllerView {

  public Text roomNumber;
  public Text appetizer;
  public Text entre;
  public Text sides;
  public Text drink;
  public Text dessert;
  public Text specialeReqiest;
  public Button buttomReady;
  public Text roomNumber1;
  public Text appetizer1;
  public Text entre1;
  public Text sides1;
  public Text drink1;
  public Text dessert1;
  public Button buttomReady1;
  public Text specialReqiest1;
  public ImageView backButton;

  public void goBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void getRoomNumber(MouseEvent mouseEvent) {
  }

  public void markAsReady(ActionEvent actionEvent) {
  }

  public void logOut(){
    Main.setPane(SCREENS.LOGIN.getValue());
  }
}
