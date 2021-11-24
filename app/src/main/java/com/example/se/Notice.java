package com.example.se;

public class Notice {
    String title;
    String date;
    String content;

    void setTitle(String title){
        this.title = title;
    }
    String getTitle(){return title;}

    void setDate(String date){this.date = date;}
    String getDate() { return date; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
