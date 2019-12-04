package com.example.booksale.bean;

public class Tab
{
    private  int title;
    private  int icon;
    private  Class fragment;

    public int getTitle() {
        return title;
    }

    public Tab(int title, int icon, Class fragment) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragmen() {
        return fragment;
    }

    public void setFragmen(Class fragmen) {
        this.fragment = fragment;
    }
}
