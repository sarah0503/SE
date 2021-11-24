package com.example.se;

public class Bookmark {     //DB에서 북마크 정보 가져와야함
    Boolean bookmark_on;

    void setBookmark(boolean bookmark_on){this.bookmark_on = bookmark_on;}
    Boolean getBookmark(){return this.bookmark_on;}
}