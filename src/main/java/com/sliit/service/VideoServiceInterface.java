package com.sliit.service;

import com.sliit.model.Video;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VideoServiceInterface {
    public void addVideo(Video video);
    public Video getVideoByID(String videoID);
    public ArrayList<Video> getVideos();
    public void editVideo(Video video);
    public void deleteVideo(String videoID);


}
