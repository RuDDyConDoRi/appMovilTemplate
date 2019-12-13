package com.ctr.template;

public class StructNote {
    public int     id;
    public String  singer;
    public String  title;
    public String otroDato;

    public StructNote(int id, String singer, String title, String otroDato) {
        this.id = id;
        this.singer = singer;
        this.title = title;
        this.otroDato = otroDato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOtroDato() {
        return otroDato;
    }

    public void setOtroDato(String otroDato) {
        this.otroDato = otroDato;
    }
}