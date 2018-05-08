package com.manan.dev.paperbank.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class batchModel implements Serializable{
    public batchModel(String batchName, ArrayList<SubjectModel> subjectList) {
        this.batchName = batchName;
        this.subjectList = subjectList;
    }

    public String batchName;
    public ArrayList<SubjectModel> subjectList = new ArrayList<>();

    public String getBatchName() {
        return batchName;
    }

    public batchModel() {
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public ArrayList<SubjectModel> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<SubjectModel> subjectList) {
        this.subjectList = subjectList;
    }
}
