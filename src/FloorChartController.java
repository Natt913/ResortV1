import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class FloorChartController {

  //created fields only for room 100-104.
  //I imagined that once room is clicked you can get info of a guest

  @FXML
  private Button buttonViewRequests;
  @FXML
  private Button buttonMaintenance;
  @FXML
  private Rectangle room100;
  @FXML
  private Rectangle room102;
  @FXML
  private Rectangle room103;
  private Rectangle room101;
  @FXML
  private ImageView logoHome;


  //this is when logo clicked, should take you back home
  public void goBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  //this supposed to shows all rooms as a list or something
  public void viewAsList(ActionEvent actionEvent) {
  }

  public void viewActiveRequests(ActionEvent actionEvent) {
  }

  public void viewMaintenance(ActionEvent actionEvent) {
  }

  public void getInfoRoom100(MouseEvent mouseEvent) {
  }

  public void getInfo(MouseEvent mouseEvent) {
  }

  public void getInforoom103(MouseEvent mouseEvent) {
  }

  public void getInforoom101(MouseEvent mouseEvent) {
  }
}