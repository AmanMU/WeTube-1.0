package com.sliit.service;

import com.sliit.model.Video;
import com.sliit.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VideoServiceImpl implements VideoServiceInterface {

    private static Connection connection;
    private PreparedStatement preparedStatement;


    @Override
    public void addVideo(Video video) {
        String addQuery = "insert into video (id, uploader, title, description, category, thumbnail, link, uploaded_date)\n" +
                "                    values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DB.getDBConnection();
            preparedStatement = connection.prepareStatement(addQuery);
            connection.setAutoCommit(false);

            preparedStatement.setString(1, video.getVideoID());
            preparedStatement.setString(2, video.getUploader());
            preparedStatement.setString(3, video.getTitle());
            preparedStatement.setString(4, video.getDescription());
            preparedStatement.setString(5, video.getCategory());
            preparedStatement.setString(6, video.getThumbnail());
            preparedStatement.setString(7, video.getLink());
            preparedStatement.setString(8, video.getUploaded_date());
            preparedStatement.execute();
            connection.commit();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            closeConnectionAndPreparedStatementIfNotNull();
        }
    }

    @Override
    public Video getVideoByID(String videoID) {
        Video vid = new Video();
        String query = "SELECT * from video where id = ?";
        try {
            connection = DB.getDBConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, videoID);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                Video video = new Video();
                video.setVideoID(resultSet.getString(1));
                video.setUploader(resultSet.getString(2));
                video.setTitle(resultSet.getString(3));
                video.setDescription(resultSet.getString(4));
                video.setCategory(resultSet.getString(5));
                video.setThumbnail(resultSet.getString(6));
                video.setLink(resultSet.getString(7));
                video.setUploaded_date(resultSet.getString(8));
                vid = video;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            closeConnectionAndPreparedStatementIfNotNull();
        }


        return vid;
    }

    @Override
    public ArrayList<Video> getVideos() {
        ArrayList<Video> videoArrayList = new ArrayList<>();
        String query = "SELECT * FROM video ORDER BY uploaded_date";
        try {
            connection = DB.getDBConnection();
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Video video = new Video();
                videoArrayList.add(video);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            closeConnectionAndPreparedStatementIfNotNull();
        }

        return videoArrayList;
    }

    @Override
    public void editVideo(Video video) {
        String editQuery = "UPDATE video SET title = ?, description = ?, category = ? WHERE id = ?";

        try {
            connection = DB.getDBConnection();
            preparedStatement = connection.prepareStatement(editQuery);
            connection.setAutoCommit(false);

            preparedStatement.setString(1, video.getTitle());
            preparedStatement.setString(2, video.getDescription());
            preparedStatement.setString(3, video.getCategory());
            preparedStatement.setString(4, video.getVideoID());

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            closeConnectionAndPreparedStatementIfNotNull();
        }
    }

    @Override
    public void deleteVideo(String videoID) {
        String deleteQuery = "DELETE FROM video WHERE id = ?";

        try {
            connection = DB.getDBConnection();
            preparedStatement = connection.prepareStatement(deleteQuery);
            connection.setAutoCommit(false);

            preparedStatement.setString(1, videoID);
            preparedStatement.executeUpdate();
            connection.commit();


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            closeConnectionAndPreparedStatementIfNotNull();
        }
    }

    private void closeConnectionAndPreparedStatementIfNotNull() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

