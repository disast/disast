/**
 *
 * @author Geminis
 */
package modeloSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javabents.tablas_ambiental;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ambientalSQL 
{
        private Connection cn;
    private Statement st;
    private ResultSet rs;
    
        public Connection getConnection()
    {
        this.cn=null;
         
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.cn=DriverManager.getConnection("jdbc:mysql://localhost/disast", "root", "");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cn;
    }
        
        @SuppressWarnings("CallToThreadDumpStack")
    public void desconectar()
    {
        try
        {
            this.cn.close();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
    ////////////////////////////////// //////////////////////////////////
    /*****Esta es la funcion que carga por primera ves las tablas*******/
    /*****POR MEDIO DE UNA SUBCONSULTA PARA QUE ESTA FUNCION FUNCIONE***/
    /******DEBEMOS CRUZAR LAS TABLAS PRINCIPALES Y CAMBIAR**************/
    ///////////////////ALGUNOS DATOS  //////////////////////////////////
    ////////////////////////////////// //////////////////////////////////
    
    public JSONArray tablaambientaL()
    {
        JSONArray ambiental = new JSONArray();
        JSONObject ambientals = new JSONObject();
        
        try
        {
            this.cn = getConnection();
            this.st = this.cn.createStatement();
            String sql;
            sql = "SELECT id_numero,  usuarios.nombres,procesoambiental.proceso, actividad, fecha_de_ingreso, aspectoambiental.aspecto, descripcion_del_aspecto FROM ambiental, zonas, usuarios,procesoambiental,aspectoambiental WHERE zonas.cod_ambiente = ambiental.cod_ambiente AND usuarios.id_usuarios = ambiental.id_usuarios AND procesoambiental.id_proceso = ambiental.id_proceso AND aspectoambiental.id_aspecto = ambiental.id_aspecto ORDER BY id_numero" ;
//            sql = "SELECT id_numero, zonas.ambientes, usuarios.nombres,procesoambiental.proceso, actividad, fecha_de_ingreso, aspectoambiental.aspecto, descripcion_del_aspecto FROM ambiental, zonas, usuarios,procesoambiental,aspectoambiental WHERE zonas.cod_ambiente = ambiental.cod_ambiente AND usuarios.id_usuarios = ambiental.id_usuarios AND procesoambiental.id_proceso = ambiental.id_proceso AND aspectoambiental.id_aspecto = ambiental.id_aspecto ORDER BY id_numero" ;
            this.rs = this.st.executeQuery(sql);
            while(this.rs.next())
            {
//               
                ambientals = new JSONObject();
                ambientals.put("ambientalarea0", rs.getString("id_numero"));
//                ambientals.put("ambientalarea1", rs.getString("zonas.ambientes"));
                ambientals.put("ambientalarea2", rs.getString("usuarios.nombres"));
                ambientals.put("ambientalarea3", rs.getString("procesoambiental.proceso"));
                ambientals.put("ambientalarea4", rs.getString("actividad"));
                ambientals.put("ambientalarea5", rs.getString("fecha_de_ingreso"));
                ambientals.put("ambientalarea6", rs.getString("aspectoambiental.aspecto"));
                ambientals.put("ambientalarea7", rs.getString("descripcion_del_aspecto"));
//                ambientals.put("ambientalarea7", rs.getString("impactoambiental.impacto_ambiental"));
//                ambientals.put("ambientalarea8", rs.getString("descripcion_del_impacto"));
//                ambientals.put("ambientalarea9", rs.getString("legislacion"));
//                ambientals.put("ambientalarea10",rs.getString("cumple_legislacion"));
//                ambientals.put("ambientalarea11", rs.getString("naturaleza"));
//                ambientals.put("ambientalarea12", rs.getString("extencion.extencion"));
//                ambientals.put("ambientalarea13", rs.getString("persistencia.persistencia"));
//                ambientals.put("ambientalarea14", rs.getString("sinergia"));
//                ambientals.put("ambientalarea15", rs.getString("efecto"));
//                ambientals.put("ambientalarea16", rs.getString("recuperabilidad"));
//                ambientals.put("ambientalarea17", rs.getString("intensidad"));
//                ambientals.put("ambientalarea18", rs.getString("momento"));
//                ambientals.put("ambientalarea19", rs.getString("reversibilidad"));
//                ambientals.put("ambientalarea20", rs.getString("recuperabilidad"));
//                ambientals.put("ambientalarea21", rs.getString("acumulacion"));
//                ambientals.put("ambientalarea22", rs.getString("periodicidad"));
//                ambientals.put("ambientalarea23", rs.getString("importancia"));
//                ambientals.put("ambientalarea24", rs.getString("clasificacion"));
//                ambientals.put("ambientalarea25", rs.getString("observacion"));
                System.out.printf(ambientals.toString());
                ambiental.add(ambientals);
        }
            this.desconectar();
        }
             catch(Exception e)
        {
            e.printStackTrace();
        }
            return(ambiental);
    }
    
    
     /************************************************
     ********ESTA FUNCION AGREGA LOS DATOS **********
     **************A LA MATRIZ POR*******************
     *****************MODO VISUAL********************
     *************************************************/
    
    public boolean AgregarMatriz(JSONObject datos)
   {
        try
        {
            this.cn = getConnection();
            this.st = cn.createStatement();
            tablas_ambiental am = new tablas_ambiental("", String.valueOf(datos.get("cod_ambiente")), String.valueOf(datos.get("id_usuarios")), String.valueOf(datos.get("proceso")), String.valueOf(datos.get("actividad")), String.valueOf(datos.get("fecha_de_ingreso")), String.valueOf(datos.get("id_aspecto")), String.valueOf(datos.get("descripcion_del_aspecto")), String.valueOf(datos.get("id_impacto")), String.valueOf(datos.get("descripcion_del_impacto")), String.valueOf(datos.get("legislacion")), String.valueOf(datos.get("cumple_legislacion")), String.valueOf(datos.get("naturaleza")), String.valueOf(datos.get("idextencion")), String.valueOf(datos.get("idpersistencia")), String.valueOf(datos.get("idsinergia")), String.valueOf(datos.get("idefecto")), String.valueOf(datos.get("idrecuperabilidad")), String.valueOf(datos.get("idintensidad")), String.valueOf(datos.get("idmomento")), String.valueOf(datos.get("idreversibilidad")), String.valueOf(datos.get("idacumulacion")), String.valueOf(datos.get("idperiodicidad")), String.valueOf(datos.get("importancia")), String.valueOf(datos.get("clasificacion")), String.valueOf(datos.get("observacion")));
            String tsql;
            tsql = "INSERT INTO ambiental VALUES(DEFAULT,";
            tsql += am.getcodambiente()+","+am.getidusuarios()+",'"+am.getidproceso()+"','"+am.getactividad()+"',"+am.getfechadeingreso()+"',"+am.getidaspecto()+",'"+am.getdescripciondelaspecto()+"',"+am.getidimpacto()+",'"+am.getdescripciondelimpacto()+"','"+am.getlegislacion()+"','"+am.getcumplelegislacion()+"','"+am.getnaturaleza()+"','"+am.getextencion()+"','"+am.getpersistencia()+"','"+am.getsinergia()+"','"+am.getefecto()+"','"+am.getrecuperabilidad()+"','"+am.getintensidad()+"','"+am.getmomento()+"','"+am.getreversibilidad()+"','"+am.getacumulacion()+"','"+am.getperiodicidad()+"','"+am.getimportancia()+"','"+am.getclasificacion()+"','"+am.getobservacion()+"')";
            this.st.execute(tsql);
            this.desconectar();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    
     /************************************************************************
     /**********************Funcion_Servlets_datostablas*********************** 
     /**************Funcion que carga los combo box del formulario************* 
     *************************************************************************/
    
    
    public JSONArray Funcion_Servlets_datostablas()
    {
       
        JSONArray datos = new JSONArray();
        try
        {
                this.cn = getConnection();
                this.st = this.cn.createStatement();
                
 /////////////////////////////////////////////////////////////////////////////////////////////////
                
//                String sql = "SELECT cod_ambiente, ambientes FROM zonas ;";
//                this.rs = this.st.executeQuery(sql);
//                JSONArray zonas = new JSONArray();
//                
//                while(this.rs.next())
//                {
//                    JSONObject ambientalV2 = new JSONObject();
//                    ambientalV2.put("cod_ambiente", rs.getString("cod_ambiente"));
//                    ambientalV2.put("ambientes", rs.getString("ambientes"));
//                    System.out.printf(ambientalV2.toString());
//                    System.out.println(sql);
//                    zonas.add(ambientalV2);
//                }
//                
//                datos.add(zonas);
         
   /////////////////////////////////////////////////////////////////////////////////////////////////
                String sql = "SELECT id_usuarios, nombres FROM usuarios ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray usuario = new JSONArray();
                
                while(this.rs.next())
                {
                    JSONObject ambientalV3 = new JSONObject();
                    ambientalV3.put("id_usuarios", rs.getString("id_usuarios"));
                    ambientalV3.put("nombres", rs.getString("nombres"));
                    System.out.printf(ambientalV3.toString());
                    System.out.println(sql);
                    usuario.add(ambientalV3);
                }
                datos.add(usuario);
             
                /////////////////////////////////////////////////////////////////////////////////////////////////
               sql = "SELECT id_proceso, proceso FROM procesoambiental ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray procesoambiental = new JSONArray();
                
                while(this.rs.next())
                {
                    JSONObject ambientalV90 = new JSONObject();
                    ambientalV90.put("id_proceso", rs.getString("id_proceso"));
                    ambientalV90.put("proceso", rs.getString("proceso"));
                    System.out.printf(ambientalV90.toString());
                    System.out.println(sql);
                    procesoambiental.add(ambientalV90);
                }
                datos.add(procesoambiental);

                /////////////////////////////////////////////////////////////////////
                sql = "SELECT id_aspecto, aspecto FROM aspectoambiental ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray aspectos = new JSONArray();
//           
                while(this.rs.next())
                {   
                    JSONObject ambientalV5 = new JSONObject();
                    ambientalV5.put("id_aspecto", rs.getString("id_aspecto"));
                    ambientalV5.put("aspecto", rs.getString("aspecto"));
                    System.out.printf(ambientalV5.toString());
                    System.out.println(sql);
                    aspectos.add(ambientalV5);
                }
                datos.add(aspectos); 
//                
                /////////////////////////////////////////////////////////
                sql = "SELECT id_impacto, impacto_ambiental FROM impactoambiental;";
                this.rs = this.st.executeQuery(sql);
                JSONArray impactoamb = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV6 = new JSONObject();
                    ambientalV6.put("id_impacto", rs.getString("id_impacto"));
                    ambientalV6.put("impacto_ambiental", rs.getString("impacto_ambiental"));
                    System.out.printf(ambientalV6.toString());
                    System.out.println(sql);
                    impactoamb.add(ambientalV6);
                }
                datos.add(impactoamb);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idextencion, extencion FROM extencion;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idextender = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idextencion", rs.getString("idextencion"));
                    ambientalV7.put("extencion", rs.getString("extencion"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idextender.add(ambientalV7);
                }
                datos.add(idextender);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idpersistencia, persistencia FROM persistencia;";
                this.rs = this.st.executeQuery(sql);
                JSONArray persistenci = new JSONArray();
////                
                while(this.rs.next())
                {
                    JSONObject ambientalV8 = new JSONObject();
                    ambientalV8.put("idpersistencia", rs.getString("idpersistencia"));
                    ambientalV8.put("persistencia", rs.getString("persistencia"));
                    System.out.printf(ambientalV8.toString());
                    System.out.println(sql);
                    persistenci.add(ambientalV8);
                }
                datos.add(persistenci);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idsinergia, sinergia FROM sinergia;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idsine = new JSONArray();
               
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idsinergia", rs.getString("idsinergia"));
                    ambientalV7.put("sinergia", rs.getString("sinergia"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idsine.add(ambientalV7);
                }
                datos.add(idsine);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idefecto, efecto FROM efecto;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idefecty = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idefecto", rs.getString("idefecto"));
                    ambientalV7.put("efecto", rs.getString("efecto"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idefecty.add(ambientalV7);
                }
                datos.add(idefecty);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idrecuperabilidad, recuperabilidad FROM recuperabilidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idrecupera = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idrecuperabilidad", rs.getString("idrecuperabilidad"));
                    ambientalV7.put("recuperabilidad", rs.getString("recuperabilidad"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idrecupera.add(ambientalV7);
                }
                datos.add(idrecupera);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idintensidad, intensidad FROM intensidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idintenci = new JSONArray();
              
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idintensidad", rs.getString("idintensidad"));
                    ambientalV7.put("intensidad", rs.getString("intensidad"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idintenci.add(ambientalV7);
                }
                datos.add(idintenci);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idmomento, momento FROM momento;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idmoment = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idmomento", rs.getString("idmomento"));
                    ambientalV7.put("momento", rs.getString("momento"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idmoment.add(ambientalV7);
                }
                datos.add(idmoment);
                
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idreversibilidad, reversibilidad FROM reversibilidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idrevers = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idreversibilidad", rs.getString("idreversibilidad"));
                    ambientalV7.put("reversibilidad", rs.getString("reversibilidad"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idrevers.add(ambientalV7);
                }
                datos.add(idrevers);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idacumulacion, acumulacion FROM acumulacion;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idacumu = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV89 = new JSONObject();
                    ambientalV89.put("idacumulacion", rs.getString("idacumulacion"));
                    ambientalV89.put("acumulacion",   rs.getString("acumulacion"));
                    System.out.printf(ambientalV89.toString());
                    System.out.println(sql);
                    idacumu.add(ambientalV89);
                }
                datos.add(idacumu);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idperiodicidad, periodicidad FROM periodicidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idperiod = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV88 = new JSONObject();
                    ambientalV88.put("idperiodicidad", rs.getString("idperiodicidad"));
                    ambientalV88.put("periodicidad",   rs.getString("periodicidad"));
                    System.out.printf(ambientalV88.toString());
                    System.out.println(sql);
                    idperiod.add(ambientalV88);
                }
                datos.add(idperiod);
                
                
                
                    
                this.desconectar();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return datos;
     }
    
    
     /****************************************************
//     /****************************************************
//     ****************Funcion que Modifica la  matriz**********
//     *****************************************************
//     ***************************************************/
 

    public JSONArray Funcion_Servlets_datosmodificar(String idNumber)
    {
       
        JSONObject ambientalV = new JSONObject();
        JSONArray datos = new JSONArray();
        try
        {
                this.cn = getConnection();
                this.st = this.cn.createStatement();
                String sql = "SELECT id_numero, zonas.ambientes, usuarios.nombres, procesoambiental.proceso, actividad, fecha_de_ingreso, aspectoambiental.aspecto, descripcion_del_aspecto, impactoambiental.impacto_ambiental, descripcion_del_impacto, legislacion, cumple_legislacion, naturaleza, extencion.extencion, persistencia.persistencia, sinergia.sinergia, efecto.efecto, recuperabilidad.recuperabilidad, intensidad.intensidad, momento.momento, reversibilidad.reversibilidad, acumulacion.acumulacion, periodicidad.periodicidad, importancia, clasificacion, observacion FROM ambiental, zonas, usuarios, procesoambiental, aspectoambiental, impactoambiental, extencion, persistencia, sinergia, efecto, recuperabilidad, intensidad, momento, reversibilidad, acumulacion, periodicidad WHERE zonas.cod_ambiente = ambiental.cod_ambiente AND usuarios.id_usuarios = ambiental.id_usuarios AND procesoambiental.id_proceso = ambiental.id_proceso AND aspectoambiental.id_aspecto = ambiental.id_aspecto AND impactoambiental.id_impacto = ambiental.id_impacto AND extencion.idextencion = ambiental.idextencion AND persistencia.idpersistencia = ambiental.idpersistencia AND sinergia.idsinergia = ambiental.idsinergia AND efecto.idefecto = ambiental.idefecto AND recuperabilidad.idrecuperabilidad = ambiental.idrecuperabilidad AND intensidad.idintensidad = ambiental.idintensidad AND momento.idmomento = ambiental.idmomento AND reversibilidad.idreversibilidad = ambiental.idreversibilidad AND acumulacion.idacumulacion = ambiental.idacumulacion AND periodicidad.idperiodicidad = ambiental.idperiodicidad AND id_numero =" + idNumber + ";";
                this.rs = this.st.executeQuery(sql);
                this.rs.first();
//               
                ambientalV = new JSONObject();
                ambientalV.put("id_numero",rs.getString("id_numero"));
                ambientalV.put("ambientes",rs.getString("zonas.ambientes"));
                ambientalV.put("nombres",  rs.getString("usuarios.nombres"));
                ambientalV.put("proceso",  rs.getString("procesoambiental.proceso"));
                ambientalV.put("actividad",rs.getString("actividad"));
                ambientalV.put("fecha_de_ingreso",rs.getString("fecha_de_ingreso"));
                ambientalV.put("aspecto", rs.getString("aspectoambiental.aspecto"));
                ambientalV.put("descripcion_del_aspecto", rs.getString("descripcion_del_aspecto"));
                ambientalV.put("impacto_ambiental", rs.getString("impactoambiental.impacto_ambiental"));
                ambientalV.put("descripcion_del_impacto", rs.getString("descripcion_del_impacto"));
                ambientalV.put("legislacion", rs.getString("legislacion"));
                ambientalV.put("cumple_legislacion",rs.getString("cumple_legislacion"));
                ambientalV.put("naturaleza", rs.getString("naturaleza"));
                ambientalV.put("extencion", rs.getString("extencion.extencion"));
                ambientalV.put("persistencia", rs.getString("persistencia.persistencia"));
                ambientalV.put("sinergia", rs.getString("sinergia.sinergia"));
                ambientalV.put("efecto", rs.getString("efecto.efecto"));
                ambientalV.put("intensidad", rs.getString("intensidad.intensidad"));
                ambientalV.put("momento", rs.getString("momento.momento"));
                ambientalV.put("reversibilidad", rs.getString("reversibilidad.reversibilidad"));
                ambientalV.put("recuperabilidad", rs.getString("recuperabilidad.recuperabilidad"));
                ambientalV.put("acumulacion", rs.getString("acumulacion.acumulacion"));
                ambientalV.put("periodicidad", rs.getString("periodicidad.periodicidad"));
                ambientalV.put("importancia", rs.getString("importancia"));
                ambientalV.put("clasificacion", rs.getString("clasificacion"));
                ambientalV.put("observacion", rs.getString("observacion"));
                System.out.printf(ambientalV.toString());
                System.out.println(sql);
                datos.add(ambientalV);
                
                
                sql = "SELECT cod_ambiente, ambientes FROM zonas ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray zonas = new JSONArray();
                
                while(this.rs.next())
                {
                    JSONObject ambientalV2 = new JSONObject();
                    ambientalV2.put("cod_ambiente", rs.getString("cod_ambiente"));
                    ambientalV2.put("ambientes", rs.getString("ambientes"));
                    System.out.printf(ambientalV2.toString());
                    System.out.println(sql);
                    zonas.add(ambientalV2);
                }
                
                datos.add(zonas);
//                
//                /////////////////////////////////////////////////////////////////////////////////////////////////
                sql = "SELECT id_usuarios, nombres FROM usuarios ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray usuario = new JSONArray();
                
                while(this.rs.next())
                {
                    JSONObject ambientalV3 = new JSONObject();
                    ambientalV3.put("id_usuarios", rs.getString("id_usuarios"));
                    ambientalV3.put("nombres", rs.getString("nombres"));
                    System.out.printf(ambientalV3.toString());
                    System.out.println(sql);
                    usuario.add(ambientalV3);
                }
//                
                datos.add(usuario);
//                /////////////////////////////////////////////////////////////////////////////////////////////////
               sql = "SELECT id_proceso, proceso FROM procesoambiental ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray procesoambiental = new JSONArray();
                
                while(this.rs.next())
                {
                    JSONObject ambientalV90 = new JSONObject();
                    ambientalV90.put("id_proceso", rs.getString("id_proceso"));
                    ambientalV90.put("proceso", rs.getString("proceso"));
                    System.out.printf(ambientalV90.toString());
                    System.out.println(sql);
                    procesoambiental.add(ambientalV90);
                }
//                
                datos.add(procesoambiental);
//                /////////////////////////////////////////////////////////////////////
                sql = "SELECT id_aspecto, aspecto FROM aspectoambiental ;";
                this.rs = this.st.executeQuery(sql);
                JSONArray aspectos = new JSONArray();
//           
                while(this.rs.next())
                {   
                    JSONObject ambientalV5 = new JSONObject();
                    ambientalV5.put("id_aspecto", rs.getString("id_aspecto"));
                    ambientalV5.put("aspecto", rs.getString("aspecto"));
                    System.out.printf(ambientalV5.toString());
                    System.out.println(sql);
                    aspectos.add(ambientalV5);
                }
                datos.add(aspectos); 
//                
//                ///////////////////////////////////////////////////////
                sql = "SELECT id_impacto, impacto_ambiental FROM impactoambiental;";
                this.rs = this.st.executeQuery(sql);
                JSONArray impactoamb = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV6 = new JSONObject();
                    ambientalV6.put("id_impacto", rs.getString("id_impacto"));
                    ambientalV6.put("impacto_ambiental", rs.getString("impacto_ambiental"));
                    System.out.printf(ambientalV6.toString());
                    System.out.println(sql);
                    impactoamb.add(ambientalV6);
                }
                datos.add(impactoamb);
                
                  ///////////////////////////////////////////////////////
                sql = "SELECT idextencion, extencion FROM extencion;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idextendera = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idextencion", rs.getString("idextencion"));
                    ambientalV7.put("extencion", rs.getString("extencion"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idextendera.add(ambientalV7);
                }
                datos.add(idextendera);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idpersistencia, persistencia FROM persistencia;";
                this.rs = this.st.executeQuery(sql);
                JSONArray persistenci = new JSONArray();
////                
                while(this.rs.next())
                {
                    JSONObject ambientalV8 = new JSONObject();
                    ambientalV8.put("idpersistencia", rs.getString("idpersistencia"));
                    ambientalV8.put("persistencia", rs.getString("persistencia"));
                    System.out.printf(ambientalV8.toString());
                    System.out.println(sql);
                    persistenci.add(ambientalV8);
                }
                datos.add(persistenci);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idsinergia, sinergia FROM sinergia;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idsine = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idsinergia", rs.getString("idsinergia"));
                    ambientalV7.put("sinergia", rs.getString("sinergia"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idsine.add(ambientalV7);
                }
                datos.add(idsine);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idefecto, efecto FROM efecto;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idefecty = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idefecto", rs.getString("idefecto"));
                    ambientalV7.put("efecto", rs.getString("efecto"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idefecty.add(ambientalV7);
                }
                datos.add(idefecty);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idrecuperabilidad, recuperabilidad FROM recuperabilidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idrecupera = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idrecuperabilidad", rs.getString("idrecuperabilidad"));
                    ambientalV7.put("recuperabilidad", rs.getString("recuperabilidad"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idrecupera.add(ambientalV7);
                }
                datos.add(idrecupera);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idintensidad, intensidad FROM intensidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idintenci = new JSONArray();
//                
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idintensidad", rs.getString("idintensidad"));
                    ambientalV7.put("intensidad", rs.getString("intensidad"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idintenci.add(ambientalV7);
                }
                datos.add(idintenci);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idmomento, momento FROM momento;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idmoment = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idmomento", rs.getString("idmomento"));
                    ambientalV7.put("momento", rs.getString("momento"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idmoment.add(ambientalV7);
                }
                datos.add(idmoment);
                
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idreversibilidad, reversibilidad FROM reversibilidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idrevers = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV7 = new JSONObject();
                    ambientalV7.put("idreversibilidad", rs.getString("idreversibilidad"));
                    ambientalV7.put("reversibilidad", rs.getString("reversibilidad"));
                    System.out.printf(ambientalV7.toString());
                    System.out.println(sql);
                    idrevers.add(ambientalV7);
                }
                datos.add(idrevers);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idacumulacion, acumulacion FROM acumulacion;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idacumu = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV89 = new JSONObject();
                    ambientalV89.put("idacumulacion", rs.getString("idacumulacion"));
                    ambientalV89.put("acumulacion",   rs.getString("acumulacion"));
                    System.out.printf(ambientalV89.toString());
                    System.out.println(sql);
                    idacumu.add(ambientalV89);
                }
                datos.add(idacumu);
                
                /////////////////////////////////////////////////////////
                sql = "SELECT idperiodicidad, periodicidad FROM periodicidad;";
                this.rs = this.st.executeQuery(sql);
                JSONArray idperiod = new JSONArray();
           
                while(this.rs.next())
                {
                    JSONObject ambientalV88 = new JSONObject();
                    ambientalV88.put("idperiodicidad", rs.getString("idperiodicidad"));
                    ambientalV88.put("periodicidad",   rs.getString("periodicidad"));
                    System.out.printf(ambientalV88.toString());
                    System.out.println(sql);
                    idperiod.add(ambientalV88);
                }
                datos.add(idperiod);
                    
                this.desconectar();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return datos;
     }
    
      public boolean ModificarMatrizSQL(JSONObject datos, String id_numero)
    {
        try
        {
            this.cn = getConnection();
            this.st = cn.createStatement();
            tablas_ambiental am = new tablas_ambiental("", String.valueOf(datos.get("cod_ambiente")), String.valueOf(datos.get("id_usuarios")), String.valueOf(datos.get("id_proceso")), String.valueOf(datos.get("actividad")), String.valueOf(datos.get("fecha_de_ingreso")), String.valueOf(datos.get("id_aspecto")), String.valueOf(datos.get("descripcion_del_aspecto")), String.valueOf(datos.get("id_impacto")), String.valueOf(datos.get("descripcion_del_impacto")), String.valueOf(datos.get("legislacion")), String.valueOf(datos.get("cumple_legislacion")), String.valueOf(datos.get("naturaleza")), String.valueOf(datos.get("idextencion")), String.valueOf(datos.get("idpersistencia")), String.valueOf(datos.get("idsinergia")), String.valueOf(datos.get("idefecto")), String.valueOf(datos.get("idrecuperabilidad")), String.valueOf(datos.get("idintensidad")), String.valueOf(datos.get("idmomento")), String.valueOf(datos.get("idreversibilidad")), String.valueOf(datos.get("idacumulacion")), String.valueOf(datos.get("idperiodicidad")), String.valueOf(datos.get("importancia")), String.valueOf(datos.get("clasificacion")), String.valueOf(datos.get("observacion")));
            String tsql;
            tsql = "UPDATE ambiental SET cod_ambiente='" + am.getcodambiente() + "', id_usuarios='" + am.getidusuarios() + "', id_proceso='" + am.getidproceso() + "', actividad='" + am.getactividad() +  "', fecha_de_ingreso='" + am.getfechadeingreso() +"', id_aspecto='" + am.getidaspecto() + "', descripcion_del_aspecto='" + am.getdescripciondelaspecto() + "', id_impacto='" + am.getidimpacto() + "', descripcion_del_impacto='" + am.getdescripciondelimpacto() + "', legislacion='" + am.getlegislacion() + "', cumple_legislacion='" + am.getcumplelegislacion() + "', naturaleza='" + am.getnaturaleza() + "', idextencion='" + am.getextencion() + "', idpersistencia='" + am.getpersistencia() + "', idsinergia='" + am.getsinergia() + "', idefecto='" + am.getefecto() + "', idrecuperabilidad='" + am.getrecuperabilidad() + "', idintensidad='" + am.getintensidad() + "', idmomento='" + am.getmomento() + "',idreversibilidad='" + am.getreversibilidad() + "', idacumulacion='" + am.getacumulacion() + "', idperiodicidad='" + am.getperiodicidad() + "', importancia='" + am.getimportancia() + "', clasificacion='" + am.getclasificacion() + "', observacion='" + am.getobservacion() + "' WHERE id_numero = " + id_numero + ";";
            this.st.execute(tsql);
            this.desconectar();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
      
 /*******************************************************************************************************************
 //////////////////////////////ESTA FUNCION VIZUALIZA  LOS DATOS DE LA MATRIZ POR MODO VISUAL //////////////////////
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
     public JSONObject Funcion_Servlets_visualizar(String idNumber)
    {
       
        JSONObject ambientalV = new JSONObject();
        
        try
        {
                this.cn = getConnection();
                this.st = this.cn.createStatement();
                String sql = "SELECT id_numero, zonas.ambientes, usuarios.nombres, procesoambiental.proceso, actividad, fecha_de_ingreso, aspectoambiental.aspecto, descripcion_del_aspecto, impactoambiental.impacto_ambiental, descripcion_del_impacto, legislacion, cumple_legislacion, naturaleza, extencion.extencion, persistencia.persistencia, sinergia.sinergia, efecto.efecto, recuperabilidad.recuperabilidad, intensidad.intensidad, momento.momento, reversibilidad.reversibilidad, acumulacion.acumulacion, periodicidad.periodicidad, importancia, clasificacion, observacion FROM ambiental, zonas, usuarios, procesoambiental, aspectoambiental, impactoambiental, extencion, persistencia, sinergia, efecto, recuperabilidad, intensidad, momento, reversibilidad, acumulacion, periodicidad WHERE zonas.cod_ambiente = ambiental.cod_ambiente AND usuarios.id_usuarios = ambiental.id_usuarios AND procesoambiental.id_proceso = ambiental.id_proceso AND aspectoambiental.id_aspecto = ambiental.id_aspecto AND impactoambiental.id_impacto = ambiental.id_impacto AND extencion.idextencion = ambiental.idextencion AND persistencia.idpersistencia = ambiental.idpersistencia AND sinergia.idsinergia = ambiental.idsinergia AND efecto.idefecto = ambiental.idefecto AND recuperabilidad.idrecuperabilidad = ambiental.idrecuperabilidad AND intensidad.idintensidad = ambiental.idintensidad AND momento.idmomento = ambiental.idmomento AND reversibilidad.idreversibilidad = ambiental.idreversibilidad AND acumulacion.idacumulacion = ambiental.idacumulacion AND periodicidad.idperiodicidad = ambiental.idperiodicidad AND id_numero =" + idNumber + ";";
                this.rs = this.st.executeQuery(sql);
                this.rs.first();
//               
                    ambientalV = new JSONObject();
                    ambientalV.put("id_numero", rs.getString("id_numero"));
                    ambientalV.put("ambientes",  rs.getString("zonas.ambientes"));
                    ambientalV.put("nombres", rs.getString("usuarios.nombres"));
                    ambientalV.put("proceso", rs.getString("procesoambiental.proceso"));
                    ambientalV.put("actividad", rs.getString("actividad"));
                    ambientalV.put("fecha_de_ingreso", rs.getString("fecha_de_ingreso"));
                    ambientalV.put("aspecto", rs.getString("aspectoambiental.aspecto"));
                    ambientalV.put("descripcion_del_aspecto", rs.getString("descripcion_del_aspecto"));
                    ambientalV.put("impacto_ambiental", rs.getString("impactoambiental.impacto_ambiental"));
                    ambientalV.put("descripcion_del_impacto", rs.getString("descripcion_del_impacto"));
                    ambientalV.put("legislacion", rs.getString("legislacion"));
                    ambientalV.put("cumple_legislacion",rs.getString("cumple_legislacion"));
                    ambientalV.put("naturaleza", rs.getString("naturaleza"));
                    ambientalV.put("extencion", rs.getString("extencion.extencion"));
                    ambientalV.put("persistencia", rs.getString("persistencia.persistencia"));
                    ambientalV.put("sinergia", rs.getString("sinergia.sinergia"));
                    ambientalV.put("efecto", rs.getString("efecto.efecto"));
                    ambientalV.put("intensidad", rs.getString("intensidad.intensidad"));
                    ambientalV.put("momento", rs.getString("momento.momento"));
                    ambientalV.put("reversibilidad", rs.getString("reversibilidad.reversibilidad"));
                    ambientalV.put("recuperabilidad", rs.getString("recuperabilidad.recuperabilidad"));
                    ambientalV.put("acumulacion", rs.getString("acumulacion.acumulacion"));
                    ambientalV.put("periodicidad", rs.getString("periodicidad.periodicidad"));
                    ambientalV.put("importancia", rs.getString("importancia"));
                    ambientalV.put("clasificacion", rs.getString("clasificacion"));
                    ambientalV.put("observacion", rs.getString("observacion"));
                    System.out.printf(ambientalV.toString());
                    
                    
                    this.desconectar();
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }

            return ambientalV;
     }  
      
     
          /****************************************************
//     /****************************************************
//     ****************Funcion Elimiar  del matriz**********
//     *****************************************************
//     ***************************************************/
//     
//     
     public boolean BorrarREgistroAmbiental(String idNumber)
    {
            try
            {
                this.cn = getConnection();
                this.st = cn.createStatement();
                String tsql;
                tsql = "DELETE FROM ambiental WHERE id_numero = " + idNumber + ";";
                this.st.execute(tsql);
                this.desconectar();
            }

            catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }

            return true;
    }
}
