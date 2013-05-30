/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;


@WebServlet(name = "ServletFoto", urlPatterns = {"/ServletFoto"})public class ServletFoto extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json"); 
        JSONObject objRes = new JSONObject();
        PrintWriter out = response.getWriter(); 
        System.out.print("Llegó archivo al Servidor");
       
        if( ServletFileUpload.isMultipartContent(request) )
        {    
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory); 
            upload.setSizeMax( new Long( 1024*1024*5)); 
            List listUploadFiles;
            FileItem item;
            
            try
            {
                listUploadFiles = upload.parseRequest( request );
                Iterator it = listUploadFiles.iterator();
                
                while( it.hasNext() )
                {
                    item = (FileItem) it.next();                 
                    if( !item.isFormField() )
                    {
                        if( item.getSize() > 0 )
                        {
                            String nombre = item.getName();                            
                            File archivo = new File(getServletContext().getRealPath("segurita"), nombre);
                            item.write(archivo);

                            if ( archivo.exists() )
                            {
                                String rutaFoto = "segurita" + "/" + nombre;
                                System.out.print(rutaFoto);
                                objRes.put("FotoGuardada", "true");
                                objRes.put("RutaFoto", rutaFoto);
                                out.print(objRes);
                            }
                            
                            else
                            {   
                                objRes.put("FotoGuardada", "false");
                                out.print(objRes);
                            }			
                        }
                    }
                }    
            }

            catch( FileUploadException e )
            {
                e.printStackTrace();            
            }

            catch (Exception e)
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
        return "Servlet que recibe peticiones que cargan imagenes al servidor";
    }
}