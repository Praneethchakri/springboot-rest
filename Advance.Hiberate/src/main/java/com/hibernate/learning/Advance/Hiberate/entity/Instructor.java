package com.hibernate.learning.Advance.Hiberate.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "INSTRUCTOR_SEQ")
    @SequenceGenerator(name = "INSTRUCTOR_SEQ",sequenceName = "INSTRUCTOR_SEQ",allocationSize = 1)
    @Column(name = "INSTRUCTOR_ID")
    private int instructorId;
    @Column(name = "INSTRUCTOR_NAME")
    private String instructorName;
    @Column(name = "EMAILID")
    private String mailID;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "instructordetailId")
    @JsonManagedReference
    private InstructorDetails instructorDetail;

    public Instructor(int instructorId, String instructorName, String mailID) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.mailID = mailID;
    }
    public Instructor() {}

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
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", mailID='" + mailID + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
