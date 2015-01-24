package com.example.opensoft;

/**
 * Created by Arvind on 24-01-2015.
 */
public class ListElement {
    public int icon;
    public String title;
    public String info;
    public ListElement(String title,String info){
        this.title=title;
        this.info=info;
        this.icon= R.drawable.ic_launcher;
    }
    public ListElement(String title,String info,int iconRef){
        this.title=title;
        this.info=info;
        this.icon=iconRef;
    }
    public ListElement(String title){
        this.title=title;
        this.info="";
        this.icon= R.drawable.ic_launcher;
    }
}