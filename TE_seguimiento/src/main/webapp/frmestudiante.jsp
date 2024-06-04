<%@page import="com.emergentes.entidades.Estudiante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO</h1>
        <form action="MainController"  method="post">
            <input type="hidden" name="id" value="${estudiante.id}"/>
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}"/></td>
                </tr>

                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellidos" value="${estudiante.apellidos}"/></td>
                </tr>

                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" value="${estudiante.email}"/></td>
                </tr>

                <tr>
                    <td>Fecha de Nacimiento</td>
                    <td><input type="date" name="fechaNacimiento" value="${fechaNacimientoFormatted}" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>


        </form>


    </body>
</html>
