<%@ page import="java.util.List"%>
<%@ page import="org.example.socialmediamvc.dto.UserDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container mt-5">
    <c:if test="${not empty globalWarn}">
        <div class="alert alert-warning text-center mx-auto" style="max-width: 500px;">
                ${globalWarn}
        </div>
    </c:if>

    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card shadow-sm border-0 rounded-3">
                <div class="card-header bg-info text-white">
                    <h5 class="mb-0">People You May Know</h5>
                </div>
                <div class="card-body p-4">
                    <c:choose>
                        <c:when test="${not empty suggestedUsers}">
                            <table class="table table-hover align-middle">
                                <thead class="table-light">
                                <tr>
                                    <th>Name</th>
                                    <th style="width: 150px;">Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${suggestedUsers}" var="user">
                                    <tr>
                                        <td>${user.username}</td>
                                        <td>
                                            <form
                                                    action="${pageContext.request.contextPath}/friend-request/accept"
                                                    method="post">
                                                <input type="hidden" name="senderId"
                                                       value="" />
                                                <button type="submit" class="btn btn-sm btn-success">
                                                    <i class="fa-solid fa-check me-1"></i>Accept
                                                </button>
                                            </form>
                                            <form
                                                    action="${pageContext.request.contextPath}/friend-request/decline"
                                                    method="post">
                                                <input type="hidden" name="senderId"
                                                       value="" />
                                                <button type="submit" class="btn btn-sm btn-danger">
                                                    <i class="fa-solid fa-times me-1"></i>Decline
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-info text-center">
                                <i class="fas fa-info-circle me-2"></i>No Friend Request available at the moment.
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>



    <%
        //        List<SentRequestsViewDto> sentedRequest = (List<SentRequestsViewDto>) request.getAttribute("sentedRequests");
//        if (!commonUtil.isNullOrEmpty(sentedRequest)) {
    %>

    <div class="row justify-content-center mt-3">
        <div class="col-md-10">
            <div class="card shadow-sm border-0 rounded-3">
                <div class="card-header bg-info text-white">
                    <h5 class="mb-0">Request You have already sent</h5>
                </div>
                <div class="card-body p-4">
                    <table class="table table-hover align-middle">
                        <thead class="table-light">
                        <tr>
                            <th>Name</th>
                            <th style="width: 150px;">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            //                            for (SentRequestsViewDto requests : sentedRequest) {
                        %>
                        <tr>
                            <td><%%></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/friend-request/cancel" method="post" class="d-inline">
                                    <input type="hidden" name="receiverId" value="<%%>" />
                                    <button class="btn btn-sm btn-danger">
                                        <i class="fa-solid fa-times me-1"></i>Cancel Request
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <%
                            //                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%
        //        }
    %>
</div>
</div>

<%@ include file="footer.jsp"%>
