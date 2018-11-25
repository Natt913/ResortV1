import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;

public class User {
  private int userID;
  private int userPIN;
  private int isEmployee;
  private int empType;
  public String userName;
  public String userFirstName;
  public String userLastName;
  public String userEmail;
  private String userStatus;
  private Date userCreated;
  private int guestRoomNumber;
  private boolean authenticated = false;
  static Connection databaseConnection = null;

  // Employee constructor
  public User(int userID, String userName, int userPIN, int isEmployee, int empType,
              String userStatus) {
    this.userID = userID;
    this.userName = userName;
    this.userPIN = userPIN;
    this.isEmployee = isEmployee;
    this.empType = empType;
    this.userStatus = userStatus;
    this.guestRoomNumber = 0;
    System.out.println("User instantiated with employee field values");
  }

  // Employee Constructor New
  public User(int userID, String userName, String userFirstName, String userLastName, String userEmail, int userPIN,
              int isEmployee, int empType, String userStatus) {
    this.userID = userID;
    this.userName = userName;
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.userEmail = userEmail;
    this.userPIN = userPIN;
    this.isEmployee = isEmployee;
    this.empType = empType;
    this.userStatus = userStatus;
    this.guestRoomNumber = 0;
    System.out.println("User instantiated with employee field values");
  }

  // Guest Constructor
  public User(int userID, String userName, int userPIN, int guestRoomNumber, String userStatus) {
    this.userID = userID;
    this.userName = userName;
    this.userPIN = userPIN;
    this.isEmployee = 0;
    this.guestRoomNumber = guestRoomNumber;
    this.userStatus = userStatus;
    System.out.println("User instantiated with guest field values");
  }

  // Guest Constructor New
  public User(int userID, String userName, String userFirstName, String userLastName, String userEmail, int userPIN,
              int guestRoomNumber, String userStatus) {
    this.userID = userID;
    this.userName = userName;
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.userEmail = userEmail;
    this.userPIN = userPIN;
    this.isEmployee = 0;
    this.guestRoomNumber = guestRoomNumber;
    this.userStatus = userStatus;
    System.out.println("User instantiated with guest field values");
  }


  // Authentication Constructor
  public User(String userName, int userPIN) throws Exception {
    databaseConnection = establishDBConnection();
    try
    {
      Statement statement = databaseConnection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs = statement.executeQuery("select * from Users where userName = '" + userName + "' and userPIN = " + userPIN);
      int resultCount = 0;

      while(rs.next())
      {
        resultCount++;
        System.out.println("Result");
        this.userName = userName;
        this.userID = rs.getInt(1);
        this.userPIN = userPIN;
        this.isEmployee = rs.getInt(4);
        this.userStatus = rs.getString(5);
        this.guestRoomNumber = rs.getInt(7);
        this.empType = rs.getInt(8);
        this.authenticated = true;
        // set all object fields now
        System.out.println("Authenticated");
        System.out.println("name = " + this.userName);
        System.out.println("id = " + this.userID);
        System.out.println("isEmployee = " + this.isEmployee);
        System.out.println("userStatus = " + this.userStatus);
        System.out.println("guestRoomNumber = " + this.guestRoomNumber);
        System.out.println("empType = " + this.empType);
      }
      if (resultCount == 0) {
        System.out.println("No results found with those login credentials");
        throw new Exception("Invalid username and password combo");
      }
      System.out.println("Number of records in ResultSet: " + resultCount);
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


  public boolean insertUserInDB() {
    databaseConnection = establishDBConnection();
    int insertResult = 0;
    try {
      Statement statement = databaseConnection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      DateTime dt2 = new DateTime();

      insertResult = statement.executeUpdate("insert into Users (userPIN, userName, userFirstName, userLastName, userEmail, isEmployee, userStatus, userCreated,"
              + " guestRoomNumber, empType) VALUES (" + userPIN + ",'" + userName + "', '" + userFirstName + "', '" + userLastName + "', " + userEmail + "', " + isEmployee + ",'" + userStatus + "','"
              + dt2 + "'," + guestRoomNumber + "," + empType + ")");
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        if (databaseConnection != null)
          databaseConnection.close();
      } catch (SQLException e) {
        System.err.println(e.getMessage());
      }
    }
    System.out.println("Insert Result " + insertResult);
    if (insertResult == 1) return true;
    return false;
  }


  public static ObservableList<User> getUserList(int empTypeFilter) {
    ObservableList<User> returnUserList = FXCollections.observableArrayList();
    if (empTypeFilter == 1) {
      String empTypeQ = "where empType = 1";
    }
    else if (empTypeFilter == 0) {
      String empTypeQ = "where empType = 0";
    }
    else {
      String empTypeQ = "";
    }
    try
    {
      databaseConnection = establishDBConnection();

      Statement statement = databaseConnection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs = statement.executeQuery("select * from Users where isEmployee = " + empTypeFilter );
      while(rs.next())
      {
        // read the result set and instantiate an object for each user
        User tempUser;
        // Use employee constructor if user is an employee
        if (rs.getInt("isEmployee") == 1) {
          tempUser = new User(
                  rs.getInt("userID"),
                  rs.getString("userName"),
                  rs.getString("userFirstName"),
                  rs.getString("userLastName"),
                  rs.getString("userEmail"),
                  rs.getInt("userPIN"),
                  rs.getInt("isEmployee"),
                  rs.getInt("empType"),
                  rs.getString("userStatus"));
        }
        // Use guest constructor if user is an guest
        else {
          tempUser = new User(
                  rs.getInt("userID"),
                  rs.getString("userName"),
                  rs.getString("userFirstName"),
                  rs.getString("userLastName"),
                  rs.getString("userEmail"),
                  rs.getInt("userPIN"),
                  rs.getInt("guestRoomNumber"),
                  rs.getString("userStatus"));
        }
        returnUserList.add(tempUser);
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
    return returnUserList;
  }

  public boolean getAuthStatus() {
    return this.authenticated;
  }

  public int isEmployee() {
    return this.isEmployee;
  }
  public int getEmpType() {
    return this.empType;
  }
  public int getUserID() {
    return this.userID;
  }
  public String getUserName() {
    return this.userName;
  }
  public String getUserFirstName() {
    return this.userFirstName;
  }
  public String getUserLastName() {
    return this.userLastName;
  }
  public String getUserEmail() {
    return this.userEmail;
  }
}
