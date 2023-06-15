
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="vi">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>

            <script type="text/javascript">
                function changeLanguage(lang) {
                    document.documentElement.lang = lang;
                }
            </script>
        </head>
        <body>
            <fmt:setBundle basename="messages_vi_VN" var="bundle" />
            <fmt:setBundle basename="messages_en" var="bundleEN" />

            <a href="#" onclick="changeLanguage('vi');"><fmt:message key="viet" bundle="${bundleEN}" /></a><br>
            <a href="#" onclick="changeLanguage('en');"><fmt:message key="en" bundle="${bundleEN}" /></a>

            <h1><fmt:message key="title" bundle="${bundleEN}" /></h1>
            <label><fmt:message key="name" bundle="${bundleEN}" /></label>
            <input type="text" name="name"><br><br>
            <label><fmt:message key="gender" bundle="${bundleEN}" /></label>
            <input type="radio" name="gender" value="male"><fmt:message key="genMale" bundle="${bundleEN}" />
            <input type="radio" name="gender" value="female"><fmt:message key="genFemale" bundle="${bundleEN}" /><br><br>
            <label><fmt:message key="dob" bundle="${bundleEN}" />:</label>
            <input type="text" name="dob"><br><br><!-- comment -->
            <label><fmt:message key="addr" bundle="${bundleEN}" />:</label>
            <input type="text" name="address"><br><br>
            <button type="submit" name="action" value="process"><fmt:message key="btnProcess" bundle="${bundleEN}" /></button>
            <button type="reset"><fmt:message key="btnRest" bundle="${bundleEN}" /></button>

    </body>
</html>