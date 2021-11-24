package com.example.se;

public class UserInformation {
    int userID;             // 사용자의 ID에 따라 저장된 정보인 ID, Email, Penalty, QR정보를 불러와야함
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