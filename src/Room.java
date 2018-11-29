import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Room {
  private int roomNumber;
  private int roomStatus = 0;
  private int guestUserID;
  private String roomNotes;
  private String roomCheckedIn;
  private String roomCheckingOut;
  private int roomHousekeepingStatus;
  static Connection databaseConnection = null;

  public Room(int roomNumber, int roomStatus, int guestUserID, String roomNotes, String roomCheckedIn,
              String roomCheckingOut, int roomHousekeepingStatus) {
    this.roomNumber = roomNumber;
    this.roomStatus = roomStatus;
    this.guestUserID = guestUserID;
    this.roomNotes = roomNotes;
    this.roomCheckedIn = roomCheckedIn;
    this.roomCheckingOut = roomCheckingOut;
  }

  public boolean checkIn(int guestUserID) {
    roomStatus = 1;
    this.guestUserID = guestUserID;
    return true;
  }

  public boolean checkOut() {
    roomStatus = 0;
    guestUserID = 0;
    return true;
  }

  public static Connection establishDBConnection() {
    Connection databaseConnection = null;
    try {
      databaseConnection = DriverManager.getConnection("jdbc:sqlite:database/ResortProject.db");
      return databaseConnection;
    }
    catch(SQLException e) {
      System.err.println(e.getMessage());
    }
    return null;
  }

  public static ObservableList<Room> initRoomsFromDB() {
    ObservableList<Room> returnRoomList = FXCollections.observableArrayList();
    try
    {
      databaseConnection = establishDBConnection();

      Statement statement = User.databaseConnection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs = statement.executeQuery("select * from Rooms" );
      while(rs.next())
      {
        // read the result set and instantiate an object for each user
        Room tempRoom;
        // Use employee constructor if user is an employee
        tempRoom = new Room(
                rs.getInt("roomNumber"),
                rs.getInt("roomStatus"),
                rs.getInt("guestUserID"),
                rs.getString("roomNotes"),
                rs.getString("roomCheckedIn"),
                rs.getString("roomCheckingOut"),
                rs.getInt("roomHousekeepingStatus"));

        returnRoomList.add(tempRoom);
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory",
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally {
      try
      {
        if(databaseConnection != null)
          databaseConnection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e.getMessage());
      }
    }
    return returnRoomList;
  }

//  public boolean insertUserInDB() {
//    databaseConnection = establishDBConnection();
//    int insertResult = 0;
//    try {
//      Statement statement = databaseConnection.createStatement();
//      statement.setQueryTimeout(30);  // set timeout to 30 sec.
//
//      DateTime dt2 = new DateTime();
//
//      insertResult = statement.executeUpdate("insert into Users (userPIN, userName, userFirstName, userLastName,"
//              + "userEmail, userPhone, isEmployee, userStatus, userCreated, guestRoomNumber, empType) VALUES ("
//              + userPIN + ",'" + userName + "', '" + userFirstName + "', '" + userLastName + "', '" + userEmail + "', '"
//              + userPhone + "', " + isEmployee + ",'" + userStatus + "','" + dt2 + "', " + guestRoomNumber + ", "
//              + empType + ")");
//    } catch (SQLException e) {
//      System.err.println(e.getMessage());
//    } finally {
//      try {
//        if (databaseConnection != null)
//          databaseConnection.close();
//      } catch (SQLException e) {
//        System.err.println(e.getMessage());
//      }
//    }
//    System.out.println("Insert Result " + insertResult);
//    if (insertResult == 1) return true;
//    return false;
//  }

}