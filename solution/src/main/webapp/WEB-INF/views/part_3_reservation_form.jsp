<%-- 
    Document   : order
    Created on : Nov 13, 2015, 2:32:40 PM
    Author     : Ivar Grimstad (ivar.grimstad@gmail.com)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation Form</title>
    </head>
    <body onload="document.getElementById('outsideCheck').checked = ${reservation.outside};">
        <h1>Reservation</h1>

        <form name="form" action="" method="post">
            <input type="hidden" name="id" value="${reservation.id}"/>
            <p>
                <label id="item">Name:</label>
                <input type="text" name="name" value="${reservation.name}" />
                <font color="red">${mvc.encoders.html(messages.getMessage("name"))}</font>
            </p>
            <p>
                <label id="count">Count:</label>
                <input type="text" name="count" value="${reservation.count}"/>
                <font color="red">${mvc.encoders.html(messages.getMessage("count"))}</font>
            </p>
            <p>
                <label id="date">Date:</label>
                <input type="date" name="date" value="${reservation.date}"/>
                <font color="red">${mvc.encoders.html(messages.getMessage("date"))}</font>
            </p>
            <p>
                <label id="outside">Outside</label>
                <input id="outsideCheck" type="checkbox" name="outside"/>
            </p>
            <p>
                <input type="submit" value="Save" name="button"/>
            </p>
            <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
        </form>
        <p/>

    </body>

</html>
