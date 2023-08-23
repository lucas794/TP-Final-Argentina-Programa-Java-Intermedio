<%-- 
    Document   : listadoyAccionesAsignatura
    Created on : 19 ago. 2023, 21:04:57
    Author     : lucas
--%>

<%@page import="com.mycompany.pfinal_argprog.persistencia.RecursoAsignaturas"%>
<%@page import="com.mycompany.pfinal_argprog.modelo.Asignatura"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <table class="table table-bordered table-hover text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre de la materia</th>
                    <th scope="col">Nombre del docente a cargo</th>
                    <th scope="col">Accion</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Asignatura> asignaturas = RecursoAsignaturas.listar_asignaturas();

                    for (Asignatura a : asignaturas) {
                %>  
                    <tr>
                        <th scope="row"> <%= a.obtenerIDMateria() %> </th>
                        <td><%= a.obtenerNombreMateria() %></td>
                        <td><%= a.obtenerNombreDelDocente() %></td>
                        <% String url = String.format("../SvBorrarAsignatura?id=%d", a.obtenerIDMateria() );%>
                        <td><a class="btn btn-primary" href="<%= url%>" role="button">Borrar</a>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <div class="col text-center">
            <a class="btn btn-primary text-center" href="http://localhost:8080/pfinal_argprog/vista/alta.jsp" role="button">Volver a altas</a>
        </div> 

    </body>
</html>
