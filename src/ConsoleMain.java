import javafx.collections.ObservableList;

import java.util.Scanner;

public class ConsoleMain {
  public static void main(String[] args)
  {//
    //create new guest user and insert into database
//    User newGuest1 = new User("swallace", 9876,10,"active");
//    newGuest1.insertUserInDB();

    //create new employee user and insert into database
//    User newEmp1 = new User("wyattother", 111111,1,2,"active");
//    newEmp1.insertUserInDB();
//    newEmp2 = new User("lucam", 1215,1,3,"active");
//    newEmp2.insertUserInDB();


    //instantiate user for authentication and check against database
//    Scanner userInput = new Scanner(System.in);
//    boolean authenticated = false;
//    while (!authenticated) {
//      System.out.println("Enter username: ");
//      String userNameInput = userInput.nextLine(); // Scans the next token of the input as an int.
//      System.out.println("Enter PIN: ");
//      int userPINInput = userInput.nextInt(); // Scans the next token of the input as an int.
//      userInput.nextLine();
//      try {
//        User currentUser = new User(userNameInput, userPINInput);
//        authenticated = currentUser.getAuthStatus();
//      }
//      catch(Exception e) {
//        System.out.println("Invalid user exception thrown");
//      }
//    }
//    userInput.close();

//    Get list of users from database
//    ObservableList<User> testEmpList = User.getUserList(2);
//    This code will loop through all users
//    for (User thisUser: testEmpList) {
//       {
//         System.out.println(thisUser.getUserName());
//       }
//    }

//    User.printUserList();

//  This is how to create a new request object
//    Request myTestRequest = new Request(1016, 2, "The toilet has a floater in it!", 8);
//  Upon creation of the object, use this method to insert into database (returns boolean)
//    boolean insertSuccess = myTestRequest.insertRequestInDB();
//    System.out.println(myTestRequest.getReqSrcUserID() + " " + myTestRequest.getRequestDetail());

    // Acquire a list of active requests from the database
    ObservableList<Request> testReqList = Request.getAllRequestList();
    for (Request thisReq: testReqList) {
      {
        System.out.println(thisReq.getRequestID() + " " + thisReq.getRequestDetail());
      }
    }

    for (Request thisReq: testReqList) {
      {
        if (thisReq.getRequestID() == 2) {
          // This is how you can mark a Request as completed. Returns boolean.
          if(thisReq.completeRequest("Tickets ordered and delivered to guest room.") == true) {
            System.out.println("Request marked as completed. Database updated.");
          }
        }
      }
    }
  }
}

