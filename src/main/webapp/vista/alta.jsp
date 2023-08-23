<%-- 
    Document   : alta
    Created on : 13 ago. 2023, 10:05:29
    Author     : lucas
--%>

<%@page import="com.mycompany.pfinal_argprog.persistencia.RecursoDocentes"%>
<%@page import="com.mycompany.pfinal_argprog.modelo.Docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.pfinal_argprog.modelo.alertas.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de docentes</title>
        <!--
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        --->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"><!-- comment -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            IAlertas alerta_docentes = (IAlertas) request.getSession().getAttribute("alertas_altas_docentes");

            if (alerta_docentes == null) {
                alerta_docentes = new AlertaDefault();
            }

            out.print(alerta_docentes.generarMensajeAlerta());
        %>
        <%
            IAlertas alerta_asignaturas = (IAlertas) request.getSession().getAttribute("alertas_altas_asignaturas");

            if (alerta_asignaturas == null) {
                alerta_asignaturas = new AlertaDefault();
            }

            out.print(alerta_asignaturas.generarMensajeAlerta());
            
        %>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="alta-docentes-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Alta de docentes</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="alta-asignaturas-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Alta de asignatura</button>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" 
                 id="home" role="tabpanel" aria-labelledby="alta-docentes-tab">
                <div class="container">
                    <h1 class="col text-center">Alta de docente</h1>
                    <div class="card">
                        <div class="card-body">
                            <form action="SvAltasDocentes" method="post">
                                <div class="form-group row">
                                    <label for="legajo" class="col-sm-2 col-form-label text-center">Legajo</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="legajo"
                                               placeholder="Ingrese legajo docente" 
                                               value="<%= alerta_docentes.obtenerInformacionCampos()[0]%>"
                                               >
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="nombre" class="col-sm-2 col-form-label text-center">Nombre</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="nombre"
                                               placeholder="Ingrese nombre"
                                               value="<%= alerta_docentes.obtenerInformacionCampos()[1]%>"
                                               >

                                    </div>
                                </div>

                                <div class=" form-group row">
                                    <label for="apellido" class="col-sm-2 col-form-label text-center">Apellido</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="apellido"
                                               placeholder="Ingrese apellido"
                                               value="<%= alerta_docentes.obtenerInformacionCampos()[2]%>"
                                               >
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="telefono" class="col-sm-2 col-form-label text-center">Telefono</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="telefono"
                                               placeholder="Ingrese telefono"
                                               value="<%= alerta_docentes.obtenerInformacionCampos()[3]%>"
                                               >
                                    </div>
                                </div>
                                <div class="col text-center">                    
                                    <button type="submit" class="btn btn-primary">Generar ALTA</button>
                                </div>
                                <hr>
                            </form>
                            <div class="col text-center">
                                <a class="btn btn-primary" href="http://localhost:8080/pfinal_argprog/vista/listadoyAccionDocentes.jsp" role="button">Listado y Acciones sobre docentes</a>
                            </div>                       
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="alta-asignaturas-tab">
                <div class="tab-pane fade show"
                    id="home" role="tabpanel" aria-labelledby="alta-docentes-tab">
                    <div class="container">
                        <h1 class="col text-center">Alta de asignatura</h1>
                        <div class="card">
                            <form action="SvAltasAsignaturas" method="post">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="legajo" class="col-sm-2 col-form-label text-center">Nombre asignatura</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" name="asignatura"
                                                   placeholder="Ingrese nombre asignatura" 
                                                   value=""
                                                   >
                                        </div>
                                        <label for="seleccionar_docente" class="col-sm-2 col-form-label text-center">Seleccionar docente</label>           
                                        <div class="col-sm-9">           
                                            <select class="form-select" aria-label="Seleccione un docente" name="seleccion_docente">
                                                <option selected>Seleccione un docente</option>
                                                <%
                                                    ArrayList<Docente> docentes = RecursoDocentes.listar_docentes();

                                                    for (Docente d : docentes) {
                                                %>  
                                                <option value="<%= d.obtenerIDDocente()%>"><%= String.format("%s %s", d.obtenerNombre(), d.obtenerApellido())%></option>
                                                <%
                                                    }
                                                %>
                                            </select>    
                                        </div>
                                    </div>

                                    <div class="col text-center">                    
                                        <button type="submit" class="btn btn-primary">Generar ALTA</button>
                                    </div>
                                    <hr>
                                    <div class="col text-center">
                                        <a class="btn btn-primary" href="http://localhost:8080/pfinal_argprog/vista/listadoyAccionesAsignatura.jsp" role="button">Listado y Acciones sobre asignaturas</a>
                                    </div>                       
                                </div>
                            </form>
                        </div>
                    </div>
                </div>    
            </div>
        </div>
        <% request.getSession().setAttribute("alertas_altas_docentes", null);
            request.getSession().setAttribute("alertas_altas_asignaturas", null);
        %> 
    </body>
</html>
