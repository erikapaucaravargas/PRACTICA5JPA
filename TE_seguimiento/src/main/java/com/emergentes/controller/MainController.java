package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiantes;
import com.emergentes.entidades.Estudiante;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // System.out.println("estamos en el servlet");
        //nuevo();
        //mostrar();
        //editar();
        //mostrar();
        //eliminar();

        BeanEstudiantes dao = new BeanEstudiantes();
        Estudiante es = new Estudiante();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("estudiante", es);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "edit":
                //Avisocontrolleer
               id = Integer.parseInt(request.getParameter("id"));
                es = dao.buscar(id); // Retrieve the student record

                // Format the date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(es.getFechaNacimiento());
                request.setAttribute("fechaNacimientoFormatted", formattedDate);
                
                request.setAttribute("estudiante", es);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
                

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.eliminar(id);
                } catch (Exception ex) {
                    System.out.println("error eliminar" + ex.getMessage());
                }

                response.sendRedirect("MainController");

                break;

            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();
                try {
                    lista = dao.listarTodos();
                } catch (Exception ex) {
                    System.out.println("error al listar" + ex.getMessage());
                }
                request.setAttribute("estudiante", lista);
                request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                break;
            default:
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void nuevo() {
        BeanEstudiantes dao = new BeanEstudiantes();

        Estudiante e = new Estudiante();
        e.setNombre("Joel ");
        e.setApellidos("Torrez Quispe");
        e.setEmail("joel@gmail.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            e.setFechaNacimiento(sdf.parse("1998-06-07"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        dao.insertar(e);
    }

    private void editar() {
        BeanEstudiantes dao = new BeanEstudiantes();
        Integer id = 2;

        Estudiante e = dao.buscar(id);

        e.setNombre("Rolando");
        e.setEmail("ricky@gmail.com");
        dao.editar(e);

    }

    private void eliminar() {
        BeanEstudiantes dao = new BeanEstudiantes();
        Integer id = 5;

        dao.eliminar(id);
    }

    private void mostrar() {
        BeanEstudiantes dao = new BeanEstudiantes();
        List<Estudiante> lista = dao.listarTodos();

        for (Estudiante item : lista) {
            System.out.println(item.toString());
        }
    }

}
   
    


//