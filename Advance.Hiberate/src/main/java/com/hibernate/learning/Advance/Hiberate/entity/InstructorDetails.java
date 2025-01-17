package com.hibernate.learning.Advance.Hiberate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_SEQ")
    @SequenceGenerator(name = "instructor_SEQ",sequenceName ="instructor_SEQ" ,allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column(name = "youTubeChannelInfo")
    private  String youtubeChannelDetails;
    @Column(name = "revenue")
    private int revenue;

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

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannelDetails='" + youtubeChannelDetails + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
