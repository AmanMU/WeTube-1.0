package com.sliit.model;

public class Video {
    private String VideoID;

    private String Uploader;

    private String Title;

    private String Description;

    private String Category;

    private String Thumbnail;

    private String Link;

    private String Uploaded_date;

    public String getUploader() {
        return Uploader;
    }

    public void setUploader(String uploader) {
        Uploader = uploader;
    }

    public String getUploaded_date() {
        return Uploaded_date;
    }

    public void setUploaded_date(String uploaded_date) {
        Uploaded_date = uploaded_date;
    }

    @Override
    public String toString() {
        return "Video{" +
                "VideoID='" + VideoID + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Category='" + Category + '\'' +
                ", Thumbnail='" + Thumbnail + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }

    public String getVideoID() {
        return VideoID;
    }

    public void setVideoID(String videoID) {
        VideoID = videoID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
