package com.sliit.servlet;

import com.sliit.service.VideoServiceImpl;
import com.sliit.service.VideoServiceInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteVideoServlet", value = "/DeleteVideoServlet")
public class DeleteVideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoID = request.getParameter("id");

        VideoServiceInterface videoServiceInterface = new VideoServiceImpl();
        videoServiceInterface.deleteVideo(videoID);

        response.sendRedirect("./index.jsp#home");
    }
}
