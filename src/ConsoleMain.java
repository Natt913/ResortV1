import java.util.Scanner;

public class ConsoleMain {
  public static void main(String[] args)
  {
    //create new guest user and insert into database
//    User newGuest1 = new User("swallace", 9876,10,"active");
//    newGuest1.insertUserInDB();

    //create new employee user and insert into database
    User newEmp1 = new User("wyattother", 111111,1,2,"active");
    newEmp1.insertUserInDB();
//    newEmp2 = new User("lucam", 1215,1,3,"active");
//    newEmp2.insertUserInDB();


    //instantiate user for authentication and check against database
    Scanner userInput = new Scanner(System.in);
    boolean authenticated = false;
    while (!authenticated) {
      System.out.println("Enter username: ");
      String userNameInput = userInput.nextLine(); // Scans the next token of the input as an int.
      System.out.println("Enter PIN: ");
      int userPINInput = userInput.nextInt(); // Scans the next token of the input as an int.
      userInput.nextLine();
      try {
        User currentUser = new User(userNameInput, userPINInput);
        authenticated = currentUser.getAuthStatus();
      }
      catch(Exception e) {
        System.out.println("Invalid user exception thrown");
      }
    }
    userInput.close();


//    User.printUserList();
  }
}

