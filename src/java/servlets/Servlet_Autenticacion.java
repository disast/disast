/**
 *
 * @author Geminis
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloSQL.usuariosSQL;
import org.json.simple.JSONObject;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Servlet_Autenticacion", urlPatterns = {"/Servlet_Autenticacion"})public class Servlet_Autenticacion extends HttpServlet 
{
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");   
        String clave = request.getParameter("password");   
        usuariosSQL usr = new usuariosSQL();
        JSONObject obj = new JSONObject();
        System.out.print(obj.toString());
        System.out.print(usuario);
        System.out.print(clave);
        
        if (usr.AutenticarUsuario(usuario, clave))
        {   
           
            obj =  usr.TipoUsuario(usuario, clave);
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(20* 60); 
            session.setAttribute("TipoUsuario", String.valueOf(obj.get("TipoUsuario")));
            session.setAttribute("idusuarios", String.valueOf(obj.get("idusuarios")));
            session.setAttribute("Usuario", usuario);
            session.setAttribute("Clave", clave);
            System.out.print(String.valueOf(session.getAttribute("TipoUsuario")));
            System.out.print(String.valueOf(session.getAttribute("idusuarios")));
            System.out.print(String.valueOf(session.getAttribute("Usuario")));
            System.out.print(String.valueOf(session.getAttribute("Clave")));
            String tipoUsuario = String.valueOf(obj.get("TipoUsuario"));
            out.print(obj);
        
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
    }// </editor
}
