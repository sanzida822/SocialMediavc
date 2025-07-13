
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container mt-4">
    <h3 class="mb-4">Friend Requests</h3>

    <!-- Received Requests Section -->
    <div class="card mb-4">
        <div class="card-header bg-primary text-white">
            <h5>Pending Requests Received</h5>
        </div>
        <div class="card-body">
            <c:choose>
                <c:when test="${not empty viewDto.receivedRequests}">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Sender</th>
                            <th>Date</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${viewDto.receivedRequests}" var="request">
                            <tr>
                                <td>${request.sender.username}</td>
                                <td>${request.friendRequestSent.toString().replace('T', ' ')}</td>                                <td>
                                    <div class="btn-group">
                                        <form action="${pageContext.request.contextPath}/friends/accept-request" method="post">                                            <input type="hidden" name="requestId" value="${request.id}">
                                            <button type="submit" class="btn btn-sm btn-success">Accept</button>
                                        </form>
                                        <form action="${pageContext.request.contextPath}/friends/decline-request" method="post">                                            <input type="hidden" name="requestId" value="${request.id}">
                                            <button type="submit" class="btn btn-sm btn-danger">Decline</button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-info">
                        No pending requests received
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <!-- Sent Requests Section (Only Pending) -->
    <div class="card">
        <div class="card-header bg-secondary text-white">
            <h5>Pending Requests Sent</h5>
        </div>
        <div class="card-body">
            <c:choose>
                <c:when test="${not empty viewDto.sentRequests}">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Receiver</th>
                            <th>Date</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${viewDto.sentRequests}" var="request">
                            <tr>
                                <td>${request.receiver.username}</td>
                                <td>${request.friendRequestSent.toString().replace('T', ' ')}</td>                                <td>
                                <form action="${pageContexgt.request.contextPath}/friends/cancel-request" method="post">                                        <input type="hidden" name="requestId" value="${request.id}">
                                        <button type="submit" class="btn btn-sm btn-warning">Cancel Request</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-info">
                        No pending requests sent
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>