
<%@page import="com.emergentes.entidades.Estudiante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>

<%
    List<Estudiante> estudiante = (List<Estudiante>) request.getAttribute("estudiante");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <center>
                        
                        <h1 class="text-success">TECNOLOGIAS EMERGENTES II </h1>
                     
                        <h2> PRACTICA JPA</h2>
                        <h2 class="text-bg-dark">DANIELA HUANCA RAMIREZ</h2>
                    </center>
                </div>
            </div>
        </div>
        
        <h1>SEGUIMIENTO ACADEMICO</h1>
        <p><a href="MainController?action=add">NUEVO REGISTRO</a></p>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>email</td>
                <td>fecha de Nacimiento</td>
                <td></td>
                <td></td>
            <tr>
             
                
            <c:forEach var="item" items="${estudiante}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.email}</td>
                    <td>${item.fechaNacimiento}</td>
                    <td><a href="MainController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="MainController?action=delete&id=${item.id}">Eliminar</a></td>
                    
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>

