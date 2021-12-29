<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"index"</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <div class="main-container">
        <div class="left-side">
            <h3>Check Weather for a specific city in Sweden</h3>
            <form action="OWservlet" method="get">
                City:<input type="text" name="city" placeholder="Example: Stockholm"/><br/>
                Country:<input type="text" name="country" placeholder="Example: Sweden"/><br/>
                <br>
                <br>
                <input type="submit" value="Check Weather"/>
            </form>
        </div>
        <div class="right-side">
            <div class="weather-box">
            </div>  
        </div>
    </div>
</body>
</html>
