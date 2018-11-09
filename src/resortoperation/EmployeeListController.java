package resortoperation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmployeeListController {

    public void getBackHome(MouseEvent mouseEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuestHome.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            Stage myStage = new Stage();
            myStage.setTitle("Home");
            myStage.setScene(new Scene(root1));
            myStage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }
        catch (Exception e){
            System.err.println("Can't open new window");
        }

    }
}
