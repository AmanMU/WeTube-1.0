package com.sliit.servlet;

import com.sliit.model.Video;
import com.sliit.service.VideoServiceImpl;
import com.sliit.service.VideoServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetHomepageVideoServlet", value = "/GetHomepageVideoServlet")
public class GetHomepageVideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Video> videoList;


        VideoServiceInterface videoServiceInterface = new VideoServiceImpl();
        videoList = videoServiceInterface.getVideos();

        request.setAttribute("video", videoList);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
