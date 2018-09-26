<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Customer Registration</title>
    </head>
    <body>
        <form method="POST" action="@{/save_customer}" modleAttribute="customer">
            <div>
                <input type="hidden" id="cid"  value="null"/></br></br>
            </div>
            <div>
                <lable>Customer Name</lable></br>
                <input type="text" placeholder="Please Enter Name.." id="name" /></br></br>
            </div>
            <div>
                <lable>Customer Address</lable></br>
                <input type="text" placeholder="Please Enter address.." id="address" /></br></br>
            </div>
            <div>
                <lable>Customer Nic</lable></br>
                <input type="text" placeholder="Please Enter nic.." id="nic" /></br></br>
            </div>
             <div>
                <input type="hidden" id="active"  value="true"/></br></br>
            </div>
            <div>
                <input type="submit" value="Save"/></br></br>
            </div>
        </form></br>
        message : ${success}
    </body>
</html>