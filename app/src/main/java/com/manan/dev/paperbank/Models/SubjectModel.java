package com.manan.dev.paperbank.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class SubjectModel implements Serializable{
    public String subjectName;
    public ArrayList<examTypeModel> examTypeList = new ArrayList<>();

    public String getSubjectName() {
        return subjectName;
    }

    public SubjectModel() {
    }

    public ArrayList<examTypeModel> getExamTypeList() {

        return examTypeList;
    }

    public void setExamTypeList(ArrayList<examTypeModel> examTypeList) {
        this.examTypeList = examTypeList;
    }

    public SubjectModel(String subjectName, ArrayList<examTypeModel> examTypeList) {
        this.subjectName = subjectName;
        this.examTypeList = examTypeList;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;

    }
}
