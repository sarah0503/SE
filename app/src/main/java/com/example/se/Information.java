package com.example.se;

public class Information {
    int userID;
    String userEmail;
    int penaltyCount;
    String myQR;

    void setUserID(int userID) { this.userID = userID; }
    int getUserID() { return userID; }
    void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    String getUserEmail() { return userEmail; }
    void setPenaltyCount(int penaltyCount) { this.penaltyCount = penaltyCount; }
    int getPenaltyCount() {return penaltyCount; }
    void setMyQR(String myQR) { this.myQR = myQR; }
    String getMyQR() {return myQR; }
}