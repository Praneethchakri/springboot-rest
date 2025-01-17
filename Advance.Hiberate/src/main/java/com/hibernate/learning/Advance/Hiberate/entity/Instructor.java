package com.hibernate.learning.Advance.Hiberate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_SEQ")
    @SequenceGenerator(name = "instructor_SEQ",sequenceName = "instructor_SEQ",allocationSize = 1)
    @Column(name = "instructor_id")
    private int instructorId;
    @Column(name = "instructor_Name")
    private String instructorName;
    @Column(name = "emailId")
    private String mailID;

    @OneToOne
    @JoinColumn(name = "instructorDetail_Id")
    private InstructorDetails instructorDetailId;


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

    public InstructorDetails getInstructorDetailId() {
        return instructorDetailId;
    }

    public void setInstructorDetailId(InstructorDetails instructorDetailId) {
        this.instructorDetailId = instructorDetailId;
    }
}
