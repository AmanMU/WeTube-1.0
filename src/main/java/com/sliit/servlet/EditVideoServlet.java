package com.sliit.servlet;

import com.sliit.model.Video;
import com.sliit.service.VideoServiceImpl;
import com.sliit.service.VideoServiceInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditVideoServlet", value = "/EditVideoServlet")
public class EditVideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Video editedVideo = new Video();
        editedVideo.setVideoID(request.getParameter("id"));
        editedVideo.setTitle(request.getParameter("title"));
        editedVideo.setDescription(request.getParameter("description"));
        editedVideo.setCategory(request.getParameter("category"));

        VideoServiceInterface videoServiceInterface = new VideoServiceImpl();
        videoServiceInterface.editVideo(editedVideo);

        Video video = videoServiceInterface.getVideoByID(editedVideo.getVideoID());

        response.sendRedirect("./player.jsp?id=" + video.getVideoID());

    }
}
