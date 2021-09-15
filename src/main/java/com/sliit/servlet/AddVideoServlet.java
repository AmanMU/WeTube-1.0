package com.sliit.servlet;


import com.sliit.model.Video;
import com.sliit.service.VideoServiceImpl;
import com.sliit.service.VideoServiceInterface;
import com.sliit.util.forVideo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "AddVideoServlet", value = "/AddVideoServlet")
@MultipartConfig
public class AddVideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //Processing Thumbnail from form
        Part imagePart = request.getPart("thumbnail");
        String imageName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String imageExt = "." + com.google.common.io.Files.getFileExtension(imageName);
        File imageUploadPath = new File("D:\\MyFiles\\Projects\\WeTube\\src\\main\\webapp\\thumbnails");

        File tempImage = File.createTempFile("THUMBNAIL-", imageExt, imageUploadPath);
        String tempImagePath = tempImage.getPath();
        try (InputStream imageContent = imagePart.getInputStream()) {
            Files.copy(imageContent, tempImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }


        //Processing video from form
        Part videoPart = request.getPart("video");
        String videoName = Paths.get(videoPart.getSubmittedFileName()).getFileName().toString();
        String videoExt = "." + com.google.common.io.Files.getFileExtension(videoName);
        File videoUploadPath = new File("D:\\MyFiles\\Projects\\WeTube\\src\\main\\webapp\\videos");
        File tempVideo = File.createTempFile("WeTube_VID-", videoExt, videoUploadPath);

        try (InputStream videoContent = videoPart.getInputStream()) {
            Files.copy(videoContent, tempVideo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        //get current date
        Date date = new Date();
        SimpleDateFormat myFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uploadedDate = myFormat.format(date);

        //set attributes for video object
        Video video = new Video();
        video.setVideoID(forVideo.generateID());
        video.setUploader("testusername");
        video.setTitle(request.getParameter("title"));
        video.setDescription(request.getParameter("description"));
        video.setCategory(request.getParameter("category"));
        video.setThumbnail(tempImagePath);
        video.setLink(tempVideo.toPath().toString());
        video.setUploaded_date(uploadedDate);




        VideoServiceInterface videoServiceInterface = new VideoServiceImpl();
        videoServiceInterface.addVideo(video);


        request.getSession().setAttribute("video", video);
        response.sendRedirect("./upload_success.jsp");
    }
}
