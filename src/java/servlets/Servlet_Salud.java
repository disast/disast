/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloSQL.usuariosSQL;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Geminis
 */
@WebServlet(name = "Servlet_Salud", urlPatterns = {"/Servlet_Salud"})public class Servlet_Salud extends HttpServlet 
{
    private String tipoUsuario;
    private String idUsuario;
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json"); 
        PrintWriter out = response.getWriter(); 
        JSONObject jsonObj = (JSONObject) JSONValue.parse(request.getParameter("adminSalud"));
        String op = String.valueOf(jsonObj.get("opcionesSalud")); 
        System.out.print(op);
        System.out.print(jsonObj.toString());
        usuariosSQL usr = new usuariosSQL();
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(20 * 60);
        
        
          /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//       ////////////////////////////////////////////CARGAR Y MODIFICAR PERFIL////////////////////////////////////////////
//       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//       
       if (op.equals("Perfil_Segurita"))
        {
            System.out.print(String.valueOf(session.getAttribute("idusuarios")));
            JSONObject usuariosM = usr.datosUsuario(String.valueOf(session.getAttribute("idusuarios")));
            out.print(usuariosM);
        }
       
       if (op.equals("ModPerfil"))
        {
            JSONObject objRes = new JSONObject();
            JSONParser parser = new JSONParser();

            try 
            {
                Object obj = parser.parse(String.valueOf(jsonObj.get("Datos")));

                JSONObject jsonObject = (JSONObject) obj;
                System.out.print(jsonObject.toString());
                
                if (usr.ModificarPerfil(jsonObject, String.valueOf(session.getAttribute("idusuarios"))))
                {
                    objRes.put("ModPerfil", "true");
                    out.print(objRes);
                }

                else
                {
                    objRes.put("ModPerfil", "false");
                    out.print(objRes);
                }
                
            } 
            catch (ParseException e) 
            {
                e.printStackTrace();
            }
        }
   
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>
    
}
