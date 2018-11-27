import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AllRequestsController {

    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.MANAGERHOME.getValue());

    }
}
