<%@ page import="com.sliit.model.Video" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload Status Page</title>

    <script src="https://kit.fontawesome.com/0b0a6a0f7b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="template/css/mdb.min.css"/>
    <link rel="stylesheet" href="template/css/style.css">


</head>
<body class="bg-gradient-custom-1 overflow-hidden login-body">
<%
    Video video = (Video)request.getSession().getAttribute("video");
%>
<div class="row v-center">
    <div class="container col-3 w-25 card round-15 shadow-2-strong">
        <div class="alert alert-success m-3" role="alert">
            HURRAY...VIDEO UPLOADED SUCCESSFULLY
        </div>
        <div>
        <form method="post" action="${pageContext.request.contextPath}/GetVideoServlet">
            <div class="row clearfix">

                    <input type="hidden" id="videoID" name="videoID" value="<%=video.getVideoID()%>"/>
            </div>
            <div class="row clearfix">
                <div class="col-12 px-5 mb-4">
                    <button type="submit" class="btn btn-primary btn-block">Play Video</button>
                </div>
            </div>
        </form>
        </div>
    </div>
</div>
<script src="template/js/mdb.min.js"></script>
</body>
</html>
