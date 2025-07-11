<%@ page import="java.util.List"%>
<%@ page import="org.example.socialmediamvc.dto.UserDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container mt-5">

    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card shadow-sm border-0 rounded-3">
                <div class="card-header bg-info text-white">
                    <h5 class="mb-0">Available Friend Requests</h5>
                </div>
                <div class="card-body p-4">
                    <c:choose>
                        <c:when test="${not empty pendingRequests}">
                            <table class="table table-hover align-middle">
                                <thead class="table-light">
                                <tr>
                                    <th>Name</th>
                                    <th>Sent At</th>
                                    <th style="width: 150px;">Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pendingRequests}" var="user">
                                    <tr>
                                        <td>${user.senderName}</td>
                                        <td>${user.sentAt}</td>
                                        <td>
                                            <form
                                                    action="${pageContext.request.contextPath}/friend-request/accept"
                                                    method="post">
                                                <input type="hidden" name="request_id"
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
</div>

<%@ include file="footer.jsp"%>
