<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.WCLProject.model.DAO.MakeupDAO" %>
<%@ page import="com.WCLProject.model.DTO.Makeup" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wedding Makeup Platform</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .makeup-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            padding: 0 150px;
        }
        .makeup-item {
            width: 22%;
            margin: 15px;
            text-align: center;
        }
        .makeup-item img {
            width: 100%;
            height: auto;
        }
        .pagination {
            text-align: center;
            margin-top: 20px;
        }
        .pagination a {
            margin: 0 5px;
            text-decoration: none;
            color: #333;
        }
        .pagination strong {
            margin: 0 5px;
            color: #333;
        }
    </style>
</head>
<body>
    <h1>MAKEUPS</h1>
    <div class="makeup-container">
        <%
            int currentPage = 1;
            int pageSize = 8;

            String pageParam = request.getParameter("page");
            if (pageParam != null && pageParam.matches("\\d+")) { // 숫자 형식인지 확인
                currentPage = Integer.parseInt(pageParam);
            }

            MakeupDAO makeupDAO = new MakeupDAO();
            List<Makeup> makeups = makeupDAO.getMakeupsByVendor(currentPage, pageSize);
            int totalMakeups = makeupDAO.getTotalMakeupCount();
            int totalPages = (int) Math.ceil((double) totalMakeups / pageSize);
        %>
        
        <%
		    for (int i = 0; i < makeups.size(); i++) {
		        Makeup makeup = makeups.get(i);
		%>
        <div class="makeup-item">
            <img src="<%= request.getContextPath() %>/makeupimages/<%= makeup.getPhotoPath() %>" alt="<%= makeup.getMakeupBrand() %>">
            <h3><%= makeup.getMakeupBrand() %></h3>
            <p><%= makeup.getMakeupConcept() %></p>
            <p><%= makeup.getMakeupContent() %></p>
        </div>
        <% } %>
    </div>
    <div class="pagination">
        <%
            for (int i = 1; i <= totalPages; i++) {
                if (i == currentPage) {
        %>
        <strong><%= i %></strong>
        <%
                } else {
        %>
        <a href="?page=<%= i %>"><%= i %></a>
        <%
                }
            }
        %>
    </div>
</body>
</html>