import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Request {
    private int requestID;
    private int assignedAsTask;
    private int reqSrcUserID;
    private int empType;
    private String requestDateTime;
    private String requestDetail;
    private int requestStatus;
    private String requestEnteredTimestamp;
    private String requestedCompletedTimeStamp;
    private String requestEmpNotes;

    public Request(int requestID, String requestDateTime, int assignedAsTask, int reqSrcUserID, int empType,
                   String requestDetail, int requestStatus, String requestEnteredTimestamp,
                   String requestedCompletedTimeStamp, String requestEmpNotes) {
        this.requestID = requestID;
        this.assignedAsTask = assignedAsTask;
        this.reqSrcUserID = reqSrcUserID;
        this.empType = empType;
        this.requestDateTime = requestDateTime;
        this.requestDetail = requestDetail;
        this.requestStatus = requestStatus;
        this.requestEnteredTimestamp = requestEnteredTimestamp;
        this.requestedCompletedTimeStamp = requestedCompletedTimeStamp;
        this.requestEmpNotes = requestEmpNotes;
    }

    public boolean insertRequestInDB(){
        User.databaseConnection = User.establishDBConnection();
        int insertResult = 0;
        try {
            Statement statement = User.databaseConnection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            DateTime dt2 = new DateTime();

            insertResult = statement.executeUpdate("INSERT INTO Requests (requestID, requestDateTime, " +
                    "assignedAsTask, reqSrcUserID, emptType, requestDetail, requestStatus, requestEnteredTimestamp, " +
                    "requestCompletedTimestamp, requestEmpNotes) VALUES ("
                    + requestID + ",'" + requestDateTime + "', '" + assignedAsTask + "', '" + reqSrcUserID +
                    "', '" + empType + "', '" + requestDetail + "', " + requestStatus + ",'" +
                    requestEnteredTimestamp + "','" + requestedCompletedTimeStamp + "', " + requestEmpNotes + ")");
        } catch (
        SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (User.databaseConnection != null)
                    User.databaseConnection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Insert Result " + insertResult);
        if (insertResult == 1) return true;
        return false;
    }

    public void deleteRequest() {
        User.databaseConnection = User.establishDBConnection();
        try {
            Statement statement = User.databaseConnection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            int deleteResult = statement.executeUpdate("DELETE FROM Requests WHERE requestID=" + this.requestID);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (User.databaseConnection != null)
                    User.databaseConnection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static ObservableList<Request> getAllRequestList() {
        ObservableList<Request> returnRequestList = FXCollections.observableArrayList();
        try {
            User.databaseConnection = User.establishDBConnection();

            Statement statement = User.databaseConnection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("SELECT * FROM Requests");
            while (rs.next()) {
                // read the result set and instantiate an object for each user
                Request tempRequest;
                tempRequest = new Request(
                        rs.getInt("requestID"),
                        rs.getString("requestDateTime"),
                        rs.getInt("assignedAsTask"),
                        rs.getInt("reqSrcUserID"),
                        rs.getInt("empType"),
                        rs.getString("requestDetail"),
                        rs.getInt("requestStatus"),
                        rs.getString("requestEnteredTimestamp"),
                        rs.getString("requestCompletedTimestamp"),
                        rs.getString("requestEmpNotes")
                );
                returnRequestList.add(tempRequest);
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
                if(User.databaseConnection != null)
                    User.databaseConnection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return returnRequestList;
    }

    public static ObservableList<Request> getSelectedRequestList(int employeeType) {
        ObservableList<Request> returnRequestList = FXCollections.observableArrayList();
        String query = "";

        if(employeeType >= 1 && employeeType <= 5){
            query = "SELECT * FROM Requests WHERE empType=" + employeeType;
            User.databaseConnection = User.establishDBConnection();
            try{
                Statement statement = User.databaseConnection.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    // read the result set and instantiate an object for each user
                    Request tempRequest;
                    tempRequest = new Request(
                            rs.getInt("requestID"),
                            rs.getString("requestDateTime"),
                            rs.getInt("assignedAsTask"),
                            rs.getInt("reqSrcUserID"),
                            rs.getInt("empType"),
                            rs.getString("requestDetail"),
                            rs.getInt("requestStatus"),
                            rs.getString("requestEnteredTimestamp"),
                            rs.getString("requestCompletedTimestamp"),
                            rs.getString("requestEmpNotes")
                    );
                    returnRequestList.add(tempRequest);
                }
                } catch(SQLException e){
                    // if the error message is "out of memory",
                    // it probably means no database file is found
                    System.err.println(e.getMessage());
                }
                finally {
                    try
                    {
                        if(User.databaseConnection != null)
                            User.databaseConnection.close();
                    }
                    catch(SQLException e)
                    {
                        // connection close failed.
                        System.err.println(e.getMessage());
                    }
                }
                return returnRequestList;
            }
            else{
                System.err.println("INVALID EMPLOYEE!");
        }
        return null;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getAssignedAsTask() {
        return assignedAsTask;
    }

    public void setAssignedAsTask(int assignedAsTask) {
        this.assignedAsTask = assignedAsTask;
    }

    public int getReqSrcUserID() {
        return reqSrcUserID;
    }

    public void setReqSrcUserID(int reqSrcUserID) {
        this.reqSrcUserID = reqSrcUserID;
    }

    public int getEmpType() {
        return empType;
    }

    public void setEmpType(int empType) {
        this.empType = empType;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }
//
    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getRequestDetail() {
        return requestDetail;
    }

    public void setRequestDetail(String requestDetail) {
        this.requestDetail = requestDetail;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestEnteredTimestamp() {
        return requestEnteredTimestamp;
    }

    public void setRequestEnteredTimestamp(String requestEnteredTimestamp) {
        this.requestEnteredTimestamp = requestEnteredTimestamp;
    }

    public String getRequestedCompletedTimeStamp() {
        return requestedCompletedTimeStamp;
    }

    public void setRequestedCompletedTimeStamp(String requestedCompletedTimeStamp) {
        this.requestedCompletedTimeStamp = requestedCompletedTimeStamp;
    }

    public String getRequestEmpNotes() {
        return requestEmpNotes;
    }

    public void setRequestEmpNotes(String requestEmpNotes) {
        this.requestEmpNotes = requestEmpNotes;
    }
}
