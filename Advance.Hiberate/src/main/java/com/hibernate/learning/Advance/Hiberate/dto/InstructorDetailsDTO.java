package com.hibernate.learning.Advance.Hiberate.dto;

public class InstructorDetailsDTO {
    private int id;
    private  String youtubeChannelDetails;
    private int revenue;

    private InstructorDTO instructorDTO;

    public InstructorDetailsDTO(int id, String youtubeChannelDetails, int revenue) {
        this.id = id;
        this.youtubeChannelDetails = youtubeChannelDetails;
        this.revenue = revenue;
    }

    public InstructorDetailsDTO(int id, String youtubeChannelDetails, int revenue, InstructorDTO instructorDTO) {
        this.id = id;
        this.youtubeChannelDetails = youtubeChannelDetails;
        this.revenue = revenue;
        this.instructorDTO = instructorDTO;
    }

    public InstructorDetailsDTO() {
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

    public InstructorDTO getInstructorDTO() {
        return instructorDTO;
    }

    public void setInstructorDTO(InstructorDTO instructorDTO) {
        this.instructorDTO = instructorDTO;
    }

    @Override
    public String toString() {
        return "InstructorDetailsDTO{" +
                "id=" + id +
                ", youtubeChannelDetails='" + youtubeChannelDetails + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
