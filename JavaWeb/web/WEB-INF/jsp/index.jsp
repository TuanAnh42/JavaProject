<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>

    </head>
    <body>

        <form method="POST" action="RegisterServlet">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br><br>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br><br>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob"><br><br>

            <label for="gender">Gender:</label>
            <select id="gender" name="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select><br><br>

            <label for="hobby">Hobby:</label>
            <input type="text" id="hobby" name="hobby"><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br><br>

            <label for="repassword">Confirm Password:</label>
            <input type="password" id="repassword" name="repassword"><br><br>

            <input type="submit" value="Submit">
        </form>

    </body>
</html>
