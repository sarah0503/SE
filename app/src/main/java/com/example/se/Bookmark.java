package com.example.se;

public class Bookmark {
    Boolean bookmark_on;    //DB에서 북마크 정보 가져와야함
    int userID;             //DB에서 userID가 bookmark_on 한 것의 정보를 모두 가져와야해서 필요

    void setBookmark(boolean bookmark_on){this.bookmark_on = bookmark_on;}
    Boolean getBookmark(){return this.bookmark_on;}
    void setUserID(int userID) { this.userID = userID; }
    int getUserID() { return userID; }
}