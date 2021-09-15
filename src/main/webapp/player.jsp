<%@ page import="com.sliit.model.Video" %>
<%@ page import="java.nio.file.Paths" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Video Player</title>

    <script src="https://kit.fontawesome.com/0b0a6a0f7b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="template/css/mdb.min.css"/>
    <link rel="stylesheet" href="template/css/style.css">
</head>
<body>
<jsp:include page="/GetVideoServlet" />

<%

    Video video = (Video) request.getAttribute("video");
    String videoName = Paths.get(video.getLink().toString()).getFileName().toString();
%>
<nav class="navbar navbar-light bg-white shadow-0 fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <img src="template/images/logo.png" alt="" width="48" height="48" class="d-inline-block align-text-top">
            WeTube
        </a>

        <form class="d-inline-flex col-6">
            <input class="form-control round-15 me-2 shadow-3" type="search" placeholder="Search..."
                   aria-label="Search">
            <button class="btn round-15 btn-light" type="submit"><i class="fa fa-search" aria-hidden="true"></i>
            </button>
        </form>
        <form action="Login.html">
            <button type="submit" class="btn btn-primary round-15 me-3">Sign In</button>
        </form>
    </div>

</nav>
<div class="d-flex col-10 offset-2 mt-100">
    <video width="900px" height="506px" controlsList="nodownload" controls>
        <source src="videos/<%=videoName%>" type="video/mp4">
    </video>
</div>
<br>
<div class="col-9 offset-2 pe-5 text-wrap">
    <h5><%=video.getTitle()%>
    </h5>
    <p>Uploaded : <%=video.getUploaded_date()%>
    </p>

    <div>
        <hr>
    <p><%=video.getDescription()%></p>
        <hr>
    </div>
    <button class="btn btn-success round-15 me-3" type="button" id="like" data-bs-toggle="button"><i
            class="far fa-thumbs-up pe-1"></i>Like
    </button>
    <button class="btn btn-warning round-15 me-3" type="button" id="unlike" data-bs-toggle="button"><i
            class="far fa-thumbs-down pe-1"></i>Unlike
    </button>
    <button class="btn btn-danger round-15 me-3" type="button" id="report"><i class="fas fa-flag pe-1"></i>Report
    </button>

    <%--   this must be visible only if uploader views the video--%>

    <%--    edit button--%>
    <form method="POST" action="/WeTube/GetVideoServlet?edit=<%=video.getVideoID()%>" class="d-inline-flex">
        <input type="hidden" id="videoID" name="videoID" value="<%=video.getVideoID()%>">
        <button class="btn btn-outline-secondary round-15 me-3" type="submit"><i class="far fa-edit pe-1"></i>Edit Video</button>
    </form>

    <%--    delete button--%>
    <button type="button" class="btn btn-outline-danger round-15 me-3"  data-mdb-toggle="modal" data-mdb-target="#confirmBox">
         Delete Video
    </button>
    <%--    delete button confirmation modal--%>
    <div class="modal fade" aria-label="confirmBox" id="confirmBox" tabindex="-1" aria-labelledby="confirmBoxAria">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmBoxAria">Delete video?</h5>
                    <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    This cannot be undone. Are you sure you want to do this?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-dark" data-mdb-dismiss="modal">Cancel</button>
                    <form method="POST" action="/WeTube/DeleteVideoServlet">
                        <input type="hidden" id="id" name="id" value="<%=video.getVideoID()%>">
                        <button type="submit" class="btn btn-danger danger-color">Delete</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <%--    uploader video management ends here--%>

    <hr>
    <h6><%=video.getUploader()%>
    </h6>
    <button class="btn btn-outline-primary round-15 me-3" type="button" id="subscribe"><i
            class="fas fa-plus-circle pe-1"></i>Subscribe
    </button>
</div>
<hr class="offset-2">
<form class="offset-2 col-7">
    <textarea class="form-control" placeholder="enter your comment here..."></textarea>
</form>
<hr class="offset-2">
<script src="template/js/mdb.min.js"></script>
</body>
</html>