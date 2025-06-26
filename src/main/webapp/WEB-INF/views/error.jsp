<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="alert alert-danger">
        <h4>Error</h4>
        <p>${errorMessage}</p>
    </div>
    <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Go Home</a>
</div>
</body>
</html>
