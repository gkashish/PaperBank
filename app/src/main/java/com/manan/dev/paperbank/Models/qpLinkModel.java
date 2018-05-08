package com.manan.dev.paperbank.Models;

import java.io.Serializable;

public class qpLinkModel implements Serializable{
    public String qplink;
    public String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQptitle() {
        return qptitle;
    }

    public void setQptitle(String qptitle) {
        this.qptitle = qptitle;
    }

    public String qptitle;

    public qpLinkModel(String qplink) {
        this.qplink = qplink;
    }
    public qpLinkModel(){}

    public String getQplink() {
        return qplink;
    }

    public void setQplink(String qplink) {
        this.qplink = qplink;
    }
}
