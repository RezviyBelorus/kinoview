<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>kinoview - Login</title>
</head>
<body>
<p>
    Login into your account:
</p>
<!--todo: action-->
<form action="http://localhost:8080/users/login" method="POST">
    <div class="tableConeiner">
        <div class="tableRow">
            <label for="login">
                Login or email:
            </label>
            <input type="text" id="login" name="emailOrLogin" value="" placeholder="alex@gmail.com" required>
            <br>
            <label for="password">
                Password:
            </label>
            <input type="password" id="password" name="password" value="" placeholder="your password" required>
        </div>
        <div class="tableRow">
            <input type="submit" value="Login">
            <a href="restorePassword.html">Forgot password?</a>
        </div>
    </div>
</form>
<form action="signUp.html" method="get">
    <div class="tableConteiner">
        <div class="tableRow">
            <button type="submit">Sign up</button>
        </div>
    </div>

</form>
</body>
</html>