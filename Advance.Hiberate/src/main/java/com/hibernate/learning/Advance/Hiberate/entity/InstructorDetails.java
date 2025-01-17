package com.hibernate.learning.Advance.Hiberate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "INSTRUCTORDETAILS_SEQ")
    @SequenceGenerator(name = "INSTRUCTORDETAILS_SEQ",sequenceName ="INSTRUCTORDETAILS_SEQ" ,allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column(name = "YOUTUBECHANNELINFO")
    private  String youtubeChannelDetails;
    @Column(name = "REVENUE")
    private int revenue;
    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    @JsonBackReference
    private Instructor instructor;

    public InstructorDetails(int id, String youtubeChannelDetails, int revenue) {
        this.id = id;
        this.youtubeChannelDetails = youtubeChannelDetails;
        this.revenue = revenue;
    }

    public InstructorDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannelDetails() {
        return youtubeChannelDetails;
    }

    public void setYoutubeChannelDetails(String youtubeChannelDetails) {
        this.youtubeChannelDetails = youtubeChannelDetails;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public Instructor getInstructor() {
        return instructor;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannelDetails='" + youtubeChannelDetails + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
