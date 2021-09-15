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
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

@WebServlet(name = "GetVideoServlet", value = "/GetVideoServlet")
public class GetVideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoID = request.getParameter("id");
        Video video = null;


        VideoServiceInterface videoServiceInterface = new VideoServiceImpl();
        video = videoServiceInterface.getVideoByID(videoID);

        request.setAttribute("video", video);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String videoID = request.getParameter("videoID");
        Video video = null;


        VideoServiceInterface videoServiceInterface = new VideoServiceImpl();
        video = videoServiceInterface.getVideoByID(videoID);


        String url = request.getHeader("referer");
        String filename = null;
        try {
            filename = Paths.get(new URI(url).getPath()).getFileName().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("video", video);

        if (filename.equals("upload_success.jsp")) {
            response.sendRedirect("./player.jsp?id=" + video.getVideoID());
        } else if (filename.equals("player.jsp")) {
            if (request.getParameter("edit") != null) {
                response.sendRedirect("./video_edit.jsp");
            }
        }

    }
}
