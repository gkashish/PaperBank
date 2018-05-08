package com.manan.dev.paperbank.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class examTypeModel implements Serializable{
    public String examType;
    public ArrayList<qpYearModel> qpYearList=new ArrayList<>();

    public String getExamType() {
        return examType;
    }

    public examTypeModel(String examType, ArrayList<qpYearModel> qpYearList) {
        this.examType = examType;
        this.qpYearList = qpYearList;
    }

    public examTypeModel() {

    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public ArrayList<qpYearModel> getQpYearList() {
        return qpYearList;
    }

    public void setQpYearList(ArrayList<qpYearModel> qpYearList) {
        this.qpYearList = qpYearList;
    }
}
