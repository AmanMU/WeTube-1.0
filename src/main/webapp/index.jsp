<%@ page import="com.sliit.model.Video" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Page</title>

    <script src="https://kit.fontawesome.com/0b0a6a0f7b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="template/css/mdb.min.css"/>
    <link rel="stylesheet" href="template/css/style.css">


</head>
<body>
<jsp:include page="/GetHomepageVideoServlet"/>

<div class="row clearfix">
    <nav class="navbar navbar-light bg-white shadow-0 fixed-top">
        <div class="col-2 flex-row">
            <a class="navbar-brand" href="index.jsp">
                <img src="template/images/logo.png" alt="" width="48" height="48" class="d-inline-block align-text-top">
                WeTube
            </a>
        </div>
        <div class="col-7">
            <form>
                <div class="col-9 d-inline-block">
                    <input class="form-control round-15 shadow-3" type="search" placeholder="Search..."
                           aria-label="Search"></div>
                <div class="d-inline-block h-100">
                    <button class="btn round-15 align-self-center" type="submit"><i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </div>
            </form>
        </div>
        <div class="d-flex flex-row-reverse">
            <form action="video_upload.jsp">
                <button type="submit" class="btn btn-outline-secondary round-15">Upload<i class="fas fa-video ps-2"></i>
                </button>
            </form>
        </div>
        <div class="d-flex flex-row-reverse me-4">
            <form action="Login.html">
                <button type="submit" class="btn btn-primary round-15">Sign In</button>
            </form>
        </div>
    </nav>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-2  position-fixed mt-100 nav nav-pills flex-column flex-wrap vh-100 overflow-auto text-black pt-0"
             role="tablist">
            <a href="#home" role="tab" class="nav-link nav-link-round-15 m-1 active" aria-controls="home" data-mdb-toggle="pill"
               aria-selected="true"><i class="fas fa-home px-2"></i> Home</a>
            <a href="#explore" role="tab" class="nav-link nav-link-round-15 m-1" aria-controls="explore" data-mdb-toggle="pill"
               aria-selected="false"><i class="fas fa-compass px-2"></i> Explore</a>
        </div>

        <div class="tab-content">
            <div class="tab-pane fade show active" role="tabpanel" id="home" aria-labelledby="home">
                <! -- Video Container -->
                <div class="col-10 offset-2 pe-4 mt-100">
                    <div class="row clearfix">
                        <! -- video cards -->

                        <%
                            ArrayList<Video> videoList = (ArrayList<Video>) request.getAttribute("video");
                            for(Video video : videoList) {
                        %>


                        <div class="col-lg-3">
                            <div class="card d-inline-block w-100 mb-4 round-15 overflow-hidden">
                                <img src="<%=video.getThumbnail()%>"
                                     class="card-img-top w-100 object-fit-cover"
                                     alt="...">
                                <div class="card-body pt-1">
                                    <h5 class="card-title font-weight-bold"><%=video.getTitle()%>></h5>
                                    <p class="card-text text-black-50 mb-0"><%=video.getUploader()%></p>
<%--                                    <p class="card-text text-black-50">10 views</p>--%>
                                </div>
                            </div>
                        </div>
                        <% } %>

                    </div>
                </div>
            </div>

            <div class="tab-pane fade" role="tabpanel" id="explore" aria-labelledby="explore">
                <div class="col-10 offset-2 pe-4 mt-100">
                    <div class="row clearfix">
                        <div class="col-lg-4">
                            <div class="card card-gradient-1 text-black mb-4 round-15 p-4 text-center">
                                <i class="fas fa-futbol fa-3x d-flex justify-content-center p-2"></i>
                                Sport
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card card-gradient-2 text-black mb-4 round-15 p-4 text-center">
                                <i class="fas fa-music fa-3x d-flex justify-content-center p-2"></i>Music
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card card-gradient-3 text-black mb-4 round-15 p-4 text-center">
                                <i class="fas fa-gamepad fa-3x d-flex justify-content-center p-2"></i>Gaming
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card card-gradient-4 text-black mb-4 round-15 p-4 text-center">
                                <i class="fas fa-desktop fa-3x d-flex justify-content-center p-2"></i>Technology
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card card-gradient-5 text-black mb-4 round-15 p-4 text-center">
                                <i class="fas fa-book-reader fa-3x d-flex justify-content-center p-2"></i>Education
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card bg-gradient-custom-3 text-black mb-4 round-15 p-4 text-center">
                                <i class="far fa-newspaper fa-3x d-flex justify-content-center p-2"></i>News
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>


<script src="template/js/mdb.min.js"></script>
</body>
</html>
