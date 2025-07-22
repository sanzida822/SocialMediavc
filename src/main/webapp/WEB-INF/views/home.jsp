<%--<%@page import="com.social.util.CommonUtil"%>--%>
<%--<%@page import="com.social.dto.PostDto"%>--%>

<%--<%@page import="com.social.model.User"%>--%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="true" %>
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="org.example.socialmediamvc.dto.PostResponseDto" %>
<%@ page import="org.example.socialmediamvc.dto.ImageResponseDto" %>


<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="<%=request.getContextPath()%>/create" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Privacy</label> <select
                        class="form-control" id="privacySelect" name="privacy">
                    <option value="PUBLIC">Public</option>
                    <option value="FRIENDS">Friends</option>
                    <option value="ONLY_ME">Only me</option>
                </select>
                </div>

                <div class="form-group mt-3">
					<textarea class="form-control" id="exampleFormControlTextarea1"
                              placeholder="Share your thoughts" rows="3" name="content"></textarea>
                </div>

                <div class="form-group mt-3">
                    <label for="images">Upload Images</label> <input type="file"
                                                                     name="images" id="images" multiple
                                                                     class="form-control-file">
                </div>

                <button type="submit" class="btn btn-info mt-4 w-100">Post</button>
            </form>
        </div>
    </div>
    <%
        List<PostResponseDto> postDtos = (List<PostResponseDto>) request.getAttribute("posts");

        if (postDtos != null && !postDtos.isEmpty()) {
            for (PostResponseDto post : postDtos) {
    %>
    <div class="row justify-content-center mt-5">
        <div class="card mb-4 shadow-sm">
            <div class="card-header d-flex justify-content-between align-items-center">
                <div>
                    <h5 class="mb-0">
                        <%= post.getUser().getUsername() %>
                        <span style="color: RebeccaPurple" class="post-privacy">
                    </span>
                    </h5>
                    <small class="text-muted"><%= post.getCreatedAt() %>
                    </small>
                </div>
            </div>

            <div class="card-body">

                <%-- Display content only if it's not null or empty --%>
                <%
                    String content = post.getContent();
                    if (content != null && !content.trim().isEmpty()) {
                %>
                <p><%= content %>
                </p>
                <%
                    }
                %>

                <%-- Display images if available --%>
                <%
                    List<ImageResponseDto> images = post.getImages();
                    if (images != null && !images.isEmpty()) {
                %>
                <div id="carouselPost<%= post.getId() %>" class="carousel slide" data-bs-ride="carousel">

                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <%
                            for (int i = 0; i < images.size(); i++) {
                        %>
                        <li data-bs-target="#carouselPost<%= post.getId() %>" data-bs-slide-to="<%= i %>"
                            class="<%= (i == 0) ? "active" : "" %>"></li>
                        <%
                            }
                        %>
                    </ol>

                    <!-- Slides -->
                    <div class="carousel-inner">
                        <%
                            for (int i = 0; i < images.size(); i++) {
                                ImageResponseDto img = images.get(i);
                        %>
                        <div class="carousel-item <%= (i == 0) ? "active" : "" %>">
                            <img class="d-block mx-auto img-fluid rounded" style="max-height:400px;"
                                 src="<%= request.getContextPath() %>/images/<%= img.getId() %>" alt="Post Image">
                        </div>
                        <%
                            }
                        %>
                    </div>

                    <!-- Controls -->
                    <a class="carousel-control-prev" href="#carouselPost<%= post.getId() %>" role="button"
                       data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>

                    <a class="carousel-control-next" href="#carouselPost<%= post.getId() %>" role="button"
                       data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>


            </div>

            <%
                } // end if images
            %>

        </div>
    </div>
</div>
<%
    } // end for loop
} else {
%>
<p>No posts to display.</p>
<%
    }
%>
