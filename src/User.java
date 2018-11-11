import org.joda.time.DateTime;

import java.sql.*;

public class User {
  private int userID;
  private int userPIN;
  private int isEmployee;
  private int empType;
  private String userName;
  private String userStatus;
  private Date userCreated;
  private int guestRoomNumber;
  private boolean authenticated = false;
  static Connection databaseConnection = null;

  // Employee constructor
  public User(String userName, int userPIN, int isEmployee, int empType,
              String userStatus) {
    this.userName = userName;
    this.userPIN = userPIN;
    this.isEmployee = isEmployee;
    this.empType = empType;
    this.userStatus = userStatus;
    this.guestRoomNumber = 0;
    System.out.println("User instantiated with employee field values");
  }

  // Guest constructor
  public User(String userName, int userPIN, int guestRoomNumber, String userStatus) {
    this.userName = userName;
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


  public void insertUserInDB() {
    databaseConnection = establishDBConnection();
    try
    {
      Statement statement = databaseConnection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      DateTime dt2 = new DateTime();
      // Code used to format DateTime, not used before db insert, but will be used elsewhere
//      DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd, HH:mm:ss");
//      String dateStr = dt.toString(fmt);

      // Code to use java.sql.Date for timestamps; not currently used as I switched to joda DateTime
//      long millis=System.currentTimeMillis();
//      Date date=new Date(millis);
//      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//      String formattedDate = dateFormat.format(date);

      statement.executeUpdate("insert into Users (userPIN, userName, isEmployee, userStatus, userCreated,"
              + " guestRoomNumber, empType) VALUES (" + userPIN + ",'" + userName + "', " + isEmployee + ",'" + userStatus + "','"
              + dt2 + "'," + guestRoomNumber + "," + empType + ")");
    }
    catch(SQLException e)
    {
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
        System.err.println(e.getMessage());
      }
    }
  }


  public static void printUserList() {
    try
    {
      databaseConnection = establishDBConnection();

      Statement statement = databaseConnection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs = statement.executeQuery("select * from Users");
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("userName"));
        System.out.println("id = " + rs.getInt("userID"));
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
}
