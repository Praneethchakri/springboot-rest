package com.hibernate.learning.Advance.Hiberate.dto;

import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;


public class InstructorDTO {

    private int instructorId;
    private String instructorName;
    private String mailID;
    private InstructorDetailsDTO instructorDetailDTO;

    public InstructorDTO(int instructorId, String instructorName, String mailID) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.mailID = mailID;
    }

    public InstructorDTO(int instructorId, String instructorName, String mailID, InstructorDetailsDTO instructorDetailsDTO) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.mailID = mailID;
        this.instructorDetailDTO = instructorDetailsDTO;
    }

    public InstructorDTO() {
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

    public InstructorDetailsDTO getInstructorDetailDTO() {
        return instructorDetailDTO;
    }

    public void setInstructorDetailDTO(InstructorDetailsDTO instructorDetailDTO) {
        this.instructorDetailDTO = instructorDetailDTO;
    }

    @Override
    public String toString() {
        return "InstructorDTO{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", mailID='" + mailID + '\'' +
                ", instructorDetailDTO=" + instructorDetailDTO +
                '}';
    }
}
