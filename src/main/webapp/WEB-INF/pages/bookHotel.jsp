<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <title>Bootstrap Sign up Form Horizontal</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
          rel='stylesheet'>
    <style>
        .ui-datepicker {
            width: 12em;
        }

        h1 {
            color: green;
        }
    </style>

    <style>
        body {
            color: #999;
            background: #f3f3f3;
            font-family: 'Roboto', sans-serif;
        }

        .hotels-form {
            width: 500px;
            margin: 0 auto;
            padding: 30px 0;
        }

        .hotels-form h2 {
            color: #333;
            margin: 0 0 30px 0;
            display: inline-block;
            padding: 0 30px 10px 0;
            border-bottom: 3px solid #5cd3b4;
        }

        .hotels-form form {
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #fff;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        .hotels-form .form-group {
            margin-bottom: 20px;
        }

        .hotels-form label {
            font-weight: normal;
            font-size: 13px;
        }

        .hotels-form input[type="checkbox"] {
            margin-top: 2px;
        }

        .hotels-form .btn {
            font-size: 16px;
            font-weight: bold;
            background: #5cd3b4;
            border: none;
            margin-top: 20px;
            min-width: 140px;
        }

        .hotels-form .btn:hover, .signup-form .btn:focus {
            background: #41cba9;
            outline: none !important;
        }

        .hotels-form a {
            color: #5cd3b4;
            text-decoration: underline;
        }

        .hotels-form a:hover {
            text-decoration: none;
        }

        .hotels-form form a {
            color: #5cd3b4;
            text-decoration: none;
        }

        .hotels-form form a:hover {
            text-decoration: underline;
        }

        .topnav {
            background-color: #fff;
            overflow: hidden;
        }

        .topnav a, b {
            float: left;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #5cd3b4;
            color: black;
        }
    </style>

    <div class="topnav">
        <a class="active" href="/">Home</a>

        <div style="float: right">
            <c:if test="${empty login}">
                <div>
                    <a href="/auth/sign-in">Sign-in</a>
                    <a href="/auth/sign-up">Sign-up</a>
                </div>
            </c:if>
            <c:if test="${!empty login}">
                <a class="active" href="/bookedRooms">Booked hotels</a>
                <div>
                    <b>Hello, ${login}</b>
                    <a href="/auth/logout">Logout</a>
                </div>
            </c:if>
        </div>
    </div>

</head>
<body>
<form action="/book" method="POST">
    <div class="hotels-form">
        <div class="col-xs-8 col-xs-offset-4">
        </div>

        <div class="form-group">
            <label class="control-label col-xs-4">Start date</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" name="dateFrom" id="dateFrom">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-xs-4">End date</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" name="dateTo" id="dateTo">
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
        </script>
        <script>
            $(document).ready(function () {

                $(function () {
                    $("#dateFrom").datepicker({});
                });

                $(function () {
                    $("#dateTo").datepicker({});
                });

                $('#dateFrom').change(function () {
                    startDate = $(this).datepicker('getDate');
                    $("#dateTo").datepicker("option", "minDate", startDate);
                })

                $('#dateTo').change(function () {
                    endDate = $(this).datepicker('getDate');
                    $("#dateFrom").datepicker("option", "maxDate", endDate);
                })
            })
        </script>

        <input type="hidden" name="hotelId" value="${hotelId}">

        <div class="form-group">
            <label class="control-label col-xs-4">Count of rooms</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" name="countRooms" id="countRooms">
            </div>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-primary btn-lg" value="Book">
        </div>

    </div>
</form>
</body>
</html>