import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MaintenanceController {

  public ImageView logoHome;
  public Rectangle room101;
  public Rectangle room102;
  public Rectangle room100;
  public Rectangle room103;

  public void goBackHome(MouseEvent mouseEvent) {
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
