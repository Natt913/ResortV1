import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ValetController {


  //created fields only for room 100-104.
  //I imagined that once room is clicked you can get info of a guest
  public ImageView logoHome;
  public Rectangle room101;
  public Rectangle room102;
  public Rectangle room100;
  public Rectangle room103;


  //this is when logo clicked, should take you back home
  public void goBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void getInforoom101(MouseEvent mouseEvent) {
  }

  public void getInfo(MouseEvent mouseEvent) {
  }

  public void getInfoRoom100(MouseEvent mouseEvent) {
  }

  public void getInforoom103(MouseEvent mouseEvent) {
  }

  public void logOut(){
    Main.setPane(SCREENS.LOGIN.getValue());
  }
}
