package com.hibernate.learning.Advance.Hiberate.dto;

import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;


public class InstructorDTO {

    private int instructorId;
    private String instructorName;
    private String mailID;
    private InstructorDetails instructorDetail;

    public InstructorDTO(int instructorId, String instructorName, String mailID) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.mailID = mailID;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public InstructorDetails getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetails instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "InstructorDTO{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", mailID='" + mailID + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
