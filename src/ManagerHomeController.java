
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class ManagerHomeController {

  public Button buttonNewAccount;
  public Button buttonFloorChart;
  public Button buttonAllRequests;
  public Button buttonEmployees;
  public Button viewFoodServices;

  //these are request radio buttons - they suppose to disappear when req is done
  public CheckBox radio1;
  public CheckBox radio2;
  public CheckBox radio3;
  public CheckBox radio4;
  //when this button is clicked - radio disappears
  public Button buttonDone;

  @FXML
  public TableView<Request> allRequestsTable;


  public void initialize(){
    ObservableList<Request> allRequests = Request.getAllRequestList();

    TableColumn requestIDCol = new TableColumn("RequestID");
    requestIDCol.setMinWidth(20);
    requestIDCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("requestID"));

    TableColumn assignedEmployeeCol = new TableColumn("Assigned Employee");
    assignedEmployeeCol.setMinWidth(20);
    assignedEmployeeCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("empType"));

    TableColumn requestEnteredTimestampCol = new TableColumn("Request submitted on");
    requestEnteredTimestampCol.setMinWidth(60);
    requestEnteredTimestampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEnteredTimestamp"));

    TableColumn detailsCol = new TableColumn("Details");
    detailsCol.setMinWidth(60);
    detailsCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestDetail"));

    TableColumn requestStatusCol = new TableColumn("Status");
    requestStatusCol.setMinWidth(20);
    requestStatusCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestStatus"));

    TableColumn requestedCompletedTimeStampCol = new TableColumn("Completed on");
    requestedCompletedTimeStampCol.setMinWidth(60);
    requestedCompletedTimeStampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestCompletedTimestamp"));

    TableColumn requestEmpNotesCol = new TableColumn("Employee Notes");
    requestEmpNotesCol.setMinWidth(60);
    requestEmpNotesCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEmpNotes"));

    allRequestsTable.setItems(allRequests);
    allRequestsTable.getColumns().clear();
    allRequestsTable.getColumns().addAll(requestIDCol, assignedEmployeeCol, requestEnteredTimestampCol, detailsCol, requestStatusCol,
            requestedCompletedTimeStampCol, requestEmpNotesCol);
  }

  //brings to create new guest account screen
  public void buttonNewAccount(ActionEvent actionEvent) {
    Main.setPane(SCREENS.CREATENEWGUEST.getValue());
  }

  //brings to view floor chart screen
  public void viewFloorChart(ActionEvent actionEvent) {
    Main.setPane(SCREENS.FLOORCHART.getValue());
  }

  public void viewAllRequests(ActionEvent actionEvent) {
    ObservableList<Request> allRequests = Request.getAllRequestList();

    TableColumn requestIDCol = new TableColumn("RequestID");
    requestIDCol.setMinWidth(20);
    requestIDCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("requestID"));

    TableColumn assignedEmployeeCol = new TableColumn("Assigned Employee");
    assignedEmployeeCol.setMinWidth(20);
    assignedEmployeeCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("empType"));

    TableColumn requestEnteredTimestampCol = new TableColumn("Request submitted on");
    requestEnteredTimestampCol.setMinWidth(60);
    requestEnteredTimestampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEnteredTimestamp"));

    TableColumn detailsCol = new TableColumn("Details");
    detailsCol.setMinWidth(60);
    detailsCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestDetail"));

    TableColumn requestStatusCol = new TableColumn("Status");
    requestStatusCol.setMinWidth(20);
    requestStatusCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestStatus"));

    TableColumn requestedCompletedTimeStampCol = new TableColumn("Completed on");
    requestedCompletedTimeStampCol.setMinWidth(60);
    requestedCompletedTimeStampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestCompletedTimestamp"));

    TableColumn requestEmpNotesCol = new TableColumn("Employee Notes");
    requestEmpNotesCol.setMinWidth(60);
    requestEmpNotesCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEmpNotes"));

    allRequestsTable.setItems(allRequests);
    allRequestsTable.getColumns().clear();
    allRequestsTable.getColumns().addAll(requestIDCol, assignedEmployeeCol, requestEnteredTimestampCol, detailsCol, requestStatusCol,
            requestedCompletedTimeStampCol, requestEmpNotesCol);
  }

  public void viewAllEmployees(ActionEvent actionEvent) {
    Main.setPane(SCREENS.EMPLOYEELIST.getValue());
    // Messing around with loading from FXML at this point in order to fire initialize() method at right time.
    // This is going to be an all-or-nothing kind of change.
//
//    try {
////      Main.root.getChildren().remove(Main.grid.get(Main.current));
//      Main.root.getChildren().removeAll(Main.grid);
//      Main.root.getChildren().add(FXMLLoader.load(Main.class.getResource("employeeList.fxml")));
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//    }
  }

  public void RequestIsDone(ActionEvent actionEvent) {
  }

  public void logOut(){
    Main.setPane(SCREENS.LOGIN.getValue());
  }

  public void createReport(){
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);
    try {
      PDPageContentStream contentStream = new PDPageContentStream(document, page);

      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(100,750);
      contentStream.showText("FGCU Resort - Manager Report");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(20,700);
      contentStream.showText("# STAFF");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,680);

      //has to load from query
      contentStream.showText("Maintenance: 5");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,660);
      //has to load from query
      contentStream.showText("Valet: 1");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,640);
      //has to load from query
      contentStream.showText("Housekeeping: 3");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,620);
      //has to load from query
      contentStream.showText("Managers: 2");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(20,580);
      //has to load from query
      contentStream.showText("Reserved Rooms: 10");
      contentStream.endText();


      contentStream.close();

      document.save("./reports/managerReport.pdf");
      document.close();

      System.out.println("Report created");
    } catch(IOException e){
      System.out.println(e.toString());
    }



  }
}
