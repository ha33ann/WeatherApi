<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.WeatherBean"%>
<% WeatherBean wBean = (WeatherBean) request.getAttribute("wBean"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"WeatherApp: <%=wBean.getCityStr()%>"</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
	
	<jsp:include page="WEB-INF/cookieForm.jsp" />
    <div class="main-container">
    	
    	<div class="weather-entry-box">
    	
	        <div class="left-side">
	       		
	            <h3><%=wBean.getCityStr()%></h3>
	            
	           
	        </div>
	        <div class="right-side">
	            <div class="weather-box">
	                <p><%=wBean.getTempC() %>°C</p>
	                <div class="icon-border">
	             		<div class="icon"><%= wBean.getIcon() %></div>
	                </div>
	                
	            </div>
            </div> 
            
        </div>
        
        <div class="detailed-info-box">
        	<div class="left-side">
        		
        	</div>
        	<div class="right-side">
        		<% out.print("<p>Clouds: " + wBean.getCloudsStr() + "</p>");%>
        		<% out.print("<p>Rain: " + wBean.getPrecipitation() + "</p>");%>
        		
        	</div>
        </div>
        
    </div>
</body>
</html>
