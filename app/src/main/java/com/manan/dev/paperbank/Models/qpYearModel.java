package com.manan.dev.paperbank.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class qpYearModel implements Serializable{
    public String qpYear;
    public ArrayList<qpLinkModel> qpLinkList = new ArrayList<>();

    public String getQpYear() {
        return qpYear;
    }

    public qpYearModel(String qpYear, ArrayList<qpLinkModel> qpLinkList) {
        this.qpYear = qpYear;
        this.qpLinkList = qpLinkList;
    }

    public qpYearModel() {

    }

    public void setQpYear(String qpYear) {
        this.qpYear = qpYear;
    }

    public ArrayList<qpLinkModel> getQpLinkList() {
        return qpLinkList;
    }

    public void setQpLinkList(ArrayList<qpLinkModel> qpLinkList) {
        this.qpLinkList = qpLinkList;
    }
}
