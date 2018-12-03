import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.ou;

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
  private Rectangle room101;
  @FXML
  private Rectangle room102;
  @FXML
  private Rectangle room103;
  @FXML
  private Rectangle room104;
  @FXML
  private Rectangle room105;
  @FXML
  private Rectangle room106;
  @FXML
  private Rectangle room107;
  @FXML
  private Rectangle room108;
  @FXML
  private Rectangle room109;
  @FXML
  private Rectangle room110;
  @FXML
  private Rectangle room111;
  @FXML
  private Rectangle room112;
  @FXML
  private Rectangle room113;
  @FXML
  private Rectangle room114;
  @FXML
  private Rectangle room115;
  @FXML
  private ImageView logoHome;
  Rectangle[] rectArray = new Rectangle[16];
  public static Paint colorRed =  Paint.valueOf("#bc2705");
  public static Paint colorGray =  Paint.valueOf("#603ef8");
  public static Paint colorPurp =  Paint.valueOf("#908c8b");
  public static Paint colorGreen =  Paint.valueOf("#36c900");

  private void initRectArray() {
    rectArray[0] = room100;
    rectArray[1] = room101;
    rectArray[2] = room102;
    rectArray[3] = room103;
    rectArray[4] = room104;
    rectArray[5] = room105;
    rectArray[6] = room106;
    rectArray[7] = room107;
    rectArray[8] = room108;
    rectArray[9] = room109;
    rectArray[10] = room110;
    rectArray[11] = room111;
    rectArray[12] = room112;
    rectArray[13] = room113;
    rectArray[14] = room114;
    rectArray[15] = room115;
  }

  public void initialize() {
    initRectArray();
    System.out.println("Init floor chart!");
    ObservableList<Room> roomList = Room.initRoomsFromDB();
    int index=0;
    for (Room thisRoom: roomList) {
      {
        System.out.println(thisRoom.getRoomNumber() + " " + thisRoom.getRoomStatus());
        if (thisRoom.getRoomStatus() == 0) {
          rectArray[index].setFill(colorGreen);
        }
        else if (thisRoom.getRoomStatus() == 1) {
          rectArray[index].setFill(colorRed);
        }
        else if (thisRoom.getRoomStatus() == 2) {
          rectArray[index].setFill(colorPurp);
        }
        else if (thisRoom.getRoomStatus() == 3) {
          rectArray[index].setFill(colorGray);
        }
        index++;
      }
    }
  }

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