package com.example.se;

public class UserInformation {
    private int userID;             // 사용자의 ID에 따라 저장된 정보인 ID, Email, Penalty, QR정보를 불러와야함
    private String userName;
    private String userEmail;
    private int penaltyCount;
    String myQR;

    public void setUserID(int userID) { this.userID = userID; }
    public int getUserID() { return userID; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public String getUserEmail() { return userEmail; }
    public void setPenaltyCount(int penaltyCount) { this.penaltyCount = penaltyCount; }
    //DB 에서 QR을 어떻게 받아오는지.........?  String 형태로?
    public int getPenaltyCount() { return penaltyCount; }
    public void setMyQR(String myQR) { this.myQR = myQR; }
    public String getMyQR() { return myQR; }

    UserInformation(){}
    UserInformation(int userID, String userName, String userEmail, int penaltyCount) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.penaltyCount = penaltyCount;
    }
}