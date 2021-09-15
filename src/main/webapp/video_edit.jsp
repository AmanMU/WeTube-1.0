<%@ page import="com.sliit.model.Video" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Video Edit Page</title>

    <script src="https://kit.fontawesome.com/0b0a6a0f7b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="template/css/mdb.min.css"/>
    <link rel="stylesheet" href="template/css/style.css">


</head>

<%
    Video video = (Video) request.getSession().getAttribute("video");
%>

<body class="bg-gradient-custom-3 overflow-hidden login-body">
<div class="row v-center card-height-550">
    <div class="container col-4 card round-15 shadow-2">
                <button class="btn btn-primary mt-2 py-3 disabled">Add video details</button>
                <form method="post" action="${pageContext.request.contextPath}/EditVideoServlet">
                    <h6 class="d-flex justify-content-center my-3"> ENTER YOUR VIDEO DETAILS AND SELECT THE FILE</h6>
                    <!-- Hidden inputs -->
                    <input type="hidden" id="id" name="id" value="<%=video.getVideoID()%>" />
                    <input type="hidden" id="thumbnail" name="thumbnail" value="<%=video.getThumbnail()%>"/>
                    <input type="hidden" id="video" name="video" value="<%=video.getVideoID()%>" />
                    <input type="hidden" id="date" name="date" value="<%=video.getUploaded_date()%>" />
                    <input type="hidden" id="uploader" name="uploader" value="<%=video.getUploader()%>" />


                    <!-- Title input -->
                    <div class="form-outline w-75 mx-auto mb-4">
                        <input type="text" id="title" name="title" class="form-control" value="<%=video.getTitle()%>" required/>
                        <label class="form-label" for="title">Title</label>
                    </div>

                    <!-- Description input -->
                    <div class="form-outline w-75 mx-auto mb-4">
                        <input type="text" id="description" name="description" value="<%=video.getDescription()%>" class="form-control" required/>
                        <label class="form-label" for="description">Description</label>
                    </div>

                    <!-- Category input -->
                    <div class="form-outline w-75 mx-auto mb-4">

                        <select id="category" name="category" class="form-select" required>
                            <option value="music" <% if(video.getCategory().equals("music")) { %> selected <% } %>>Music</option>
                            <option value="sports" <% if(video.getCategory().equals("sports")) { %> selected <% } %>>Sports</option>
                            <option value="gaming" <% if(video.getCategory().equals("gaming")) { %> selected <% } %>>Gaming</option>
                            <option value="technology" <% if(video.getCategory().equals("technology")) { %> selected <% } %>>Technology</option>
                            <option value="education" <% if(video.getCategory().equals("education")) { %> selected <% } %>>Education</option>
                            <option value="news" <% if(video.getCategory().equals("news")) { %> selected <% } %>>News</option>
                        </select>

                    </div>

                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-block my-4 w-50 mx-auto">SAVE CHANGES</button>
                </form>
    </div>
</div>

<script src="template/js/mdb.min.js"></script>
</body>
</html>