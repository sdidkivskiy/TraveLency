<%--
  Created by IntelliJ IDEA.
  User: s.didkivskiy
  Date: 19.08.2020
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <title>Sign in</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #999;
            background: #f3f3f3;
            font-family: 'Roboto', sans-serif;
        }

        .form-control {
            border-color: #eee;
            min-height: 41px;
            box-shadow: none !important;
        }

        .form-control:focus {
            border-color: #5cd3b4;
        }

        .form-control, .btn {
            border-radius: 3px;
        }

        .signin-form {
            width: 500px;
            margin: 0 auto;
            padding: 30px 0;
        }

        .signin-form h2 {
            color: #333;
            margin: 0 0 30px 0;
            display: inline-block;
            padding: 0 30px 10px 0;
            border-bottom: 3px solid #5cd3b4;
        }

        .signin-form form {
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #fff;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        .signin-form .form-group {
            margin-bottom: 20px;
        }

        .signin-form label {
            font-weight: normal;
            font-size: 13px;
        }

        .signin-form input[type="checkbox"] {
            margin-top: 2px;
        }

        .signin-form .btn {
            font-size: 16px;
            font-weight: bold;
            background: #5cd3b4;
            border: none;
            margin-top: 20px;
            min-width: 140px;
        }

        .signin-form .btn:hover, .signin-form .btn:focus {
            background: #41cba9;
            outline: none !important;
        }

        .signin-form a {
            color: #5cd3b4;
            text-decoration: underline;
        }

        .signin-form a:hover {
            text-decoration: none;
        }

        .signin-form form a {
            color: #5cd3b4;
            text-decoration: none;
        }

        .signin-form form a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="signin-form">
    <form action="/auth/sign-in" method="post" class="form-horizontal">
        <div class="col-xs-8 col-xs-offset-4">
            <h2>Sign-In</h2>
        </div>

        <div class="form-group">
            <label class="control-label col-xs-4">Sign-in</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" name="loginOrEmail" required="required">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-xs-4">Password</label>
            <div class="col-xs-8">
                <input type="password" class="form-control" name="password" required="required">
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-8 col-xs-offset-4">
                <button type="submit" class="btn btn-primary btn-lg">Sign In</button>
            </div>
        </div>

    </form>
    <div class="text-center">Don't have an account yet? <a href="/auth/sign-up">Create an Account</a></div>
</div>
</body>
</html>