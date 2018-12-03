import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class FoodServiceController {
    public TextField totalAmount;
    public Button buttonSubmitOrder;
    //I created quantity fields only for the forst item in each category
    public TextField quantityCalmari;
    public TextField quantityCaprese;
    public TextField quantityZucchini;
    public TextField quantityVegetables;
    public TextField quantityPotato;
    public TextField quantitySalad;
    public TextField quantityChicken;
    public TextField quantityShrimp;
    public TextField quantityBeef;
    public TextField quantityMushroom;
    public TextField quantityTiramisu;
    public TextField quantityPannaCotta;
    public TextField quantityZeppole;
    public TextField roomNumber;

    public Text calmariPrice;
    public Text capresePrice;
    public Text zucchiniPrice;
    public Text chickenPrice;
    public Text shrimpPrice;
    public Text beefPrize;
    public Text mushroomPrice;
    public Text mixedVegetablesPrice;
    public Text potatoPrice;
    public Text saladPrice;
    public Text tiramisuPrice;
    public Text pannaCottaPrice;
    public Text zeppolePrice;


    private String requestDetail;
    private float valueTotalPrice;

    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

    private void requestDetailAdd(String value) {
        if(requestDetail.isEmpty())
            requestDetail = value.trim();
        else
            requestDetail += ", \r\n" + value.trim();
    }

    public void submitRequest(ActionEvent event){

        requestDetail = "";

        if(getIntValue(quantityCalmari) > 0) requestDetailAdd( "Appetizers - Calamari: " + getIntValue(quantityCalmari));
        if(getIntValue(quantityCaprese) > 0) requestDetailAdd( "Appetizers - Tomato caprese: " + getIntValue(quantityCaprese));
        if(getIntValue(quantityZucchini) > 0) requestDetailAdd( "Appetizers - Zucchini Fritte: " + getIntValue(quantityZucchini));

        if(getIntValue(quantityChicken) > 0) requestDetailAdd( "Entrées - Parmesean Chicken: " + getIntValue(quantityChicken));
        if(getIntValue(quantityShrimp) > 0) requestDetailAdd( "Entrées - Shrimp Scapi: " + getIntValue(quantityShrimp));
        if(getIntValue(quantityBeef) > 0) requestDetailAdd( "Entrées - Beef Tenderloin: " + getIntValue(quantityBeef));
        if(getIntValue(quantityMushroom) > 0) requestDetailAdd( "Entrées - Mushroom Rissotto: " + getIntValue(quantityMushroom));

        if(getIntValue(quantityVegetables) > 0) requestDetailAdd( "Sides - Mixed Vegetables: " + getIntValue(quantityVegetables));
        if(getIntValue(quantityPotato) > 0) requestDetailAdd( "Sides - Mashed Potatos: " + getIntValue(quantityPotato));
        if(getIntValue(quantitySalad) > 0) requestDetailAdd( "Sides - Ceasar salad: " + getIntValue(quantitySalad));

        if(getIntValue(quantityTiramisu) > 0) requestDetailAdd( "Desserts - Tiramisu: " + getIntValue(quantityTiramisu));
        if(getIntValue(quantityPannaCotta) > 0) requestDetailAdd( "Desserts - Panna Cotta: " + getIntValue(quantityPannaCotta));
        if(getIntValue(quantityZeppole) > 0) requestDetailAdd( "Desserts - Zeppole: " + getIntValue(quantityZeppole));

        requestDetailAdd("Total amount: " + totalAmount.getText().trim() );

        Request thisRequest = new Request(User.globalCurrentUser.getUserID(), 5, requestDetail,
                User.globalCurrentUser.getGuestRoomNumber());
        thisRequest.insertRequestInDB();

        //After DB method returns true
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
        alert.setContentText("Food request successfully submitted!");

        alert.showAndWait();

        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

    public void onEnterOnExitMouse(MouseEvent event) {
        updateTotalPrice();
    }

    public void onChangeInput(KeyEvent event) {
        System.out.println(event.getText());
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        valueTotalPrice = 0;

        if(getIntValue(quantityCalmari) > 0) valueTotalPrice += Math.abs(getIntValue(quantityCalmari)) * getFloatValue(calmariPrice);
        if(getIntValue(quantityCaprese) > 0) valueTotalPrice += Math.abs(getIntValue(quantityCaprese)) * getFloatValue(capresePrice);
        if(getIntValue(quantityZucchini) > 0) valueTotalPrice += Math.abs(getIntValue(quantityZucchini)) * getFloatValue(zucchiniPrice);

        if(getIntValue(quantityChicken) > 0) valueTotalPrice += Math.abs(getIntValue(quantityChicken)) * getFloatValue(chickenPrice);
        if(getIntValue(quantityShrimp) > 0) valueTotalPrice += Math.abs(getIntValue(quantityShrimp)) * getFloatValue(shrimpPrice);
        if(getIntValue(quantityBeef) > 0) valueTotalPrice += Math.abs(getIntValue(quantityBeef)) * getFloatValue(beefPrize);
        if(getIntValue(quantityMushroom) > 0) valueTotalPrice += Math.abs(getIntValue(quantityMushroom)) * getFloatValue(mushroomPrice);

        if(getIntValue(quantityVegetables) > 0) valueTotalPrice += Math.abs(getIntValue(quantityVegetables)) * getFloatValue(mixedVegetablesPrice);
        if(getIntValue(quantityPotato) > 0) valueTotalPrice += Math.abs(getIntValue(quantityPotato)) * getFloatValue(potatoPrice);
        if(getIntValue(quantitySalad) > 0) valueTotalPrice += Math.abs(getIntValue(quantitySalad)) * getFloatValue(saladPrice);

        if(getIntValue(quantityTiramisu) > 0) valueTotalPrice += Math.abs(getIntValue(quantityTiramisu)) * getFloatValue(tiramisuPrice);
        if(getIntValue(quantityPannaCotta) > 0) valueTotalPrice += Math.abs(getIntValue(quantityPannaCotta)) * getFloatValue(pannaCottaPrice);
        if(getIntValue(quantityZeppole) > 0) valueTotalPrice += Math.abs(getIntValue(quantityZeppole)) * getFloatValue(zeppolePrice);

        totalAmount.setText("$ "+valueTotalPrice);
    }

    public int getIntValue(TextField textField) {
        int value = 0;
        if(textField.getText() != null && textField.getText().trim().length() > 0)
        {
            try {
                value = Integer.parseInt(textField.getText().trim());
            } catch (NumberFormatException ex) {
                //
            }
        }
        return value;
    }

    public float getFloatValue(Text textField) {
        float value = 0;
        if(textField.getText() != null && textField.getText().trim().length() > 0)
        {
            try {
                value = Float.parseFloat(textField.getText().trim());
            } catch (NumberFormatException ex) {
                //
            }
        }
        return value;
    }
}
