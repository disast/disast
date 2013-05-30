/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javabents.usuarios;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class usuariosSQL 
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
        
        public JSONArray obtenerUsuarios()
        {
            JSONArray usuarios = new JSONArray();
            JSONObject usuario = new JSONObject();
        
            try
            {
                this.cn = getConnection();
                this.st = this.cn.createStatement();
                String sql;
                sql = "SELECT * FROM usuarios" ;
                this.rs = this.st.executeQuery(sql);
                while(this.rs.next())
                {
                    usuarios usr = new usuarios(rs.getString("id_usuarios"), rs.getString("nombres"), rs.getString("nickname"), rs.getString("clave"), rs.getString("celular"), rs.getString("email"), rs.getString("tipo"),rs.getString("foto_perfil"));
                    usuario = usr.getJSONObject();
                    System.out.printf(usuario.toString());
                    System.out.printf(usuarios.toString());
                    usuarios.add(usuario);
                }
                this.desconectar();
            }
                catch(Exception e)
            {
                e.printStackTrace();
            }
                return(usuarios);
        }
        
        public boolean AutenticarUsuario(String nickname, String clave)
        {
            try
            {
                this.cn = getConnection();
                this.st = this.cn.createStatement();
                String sql;
                sql = "SELECT * FROM usuarios WHERE nickname = '" + nickname + "' AND clave = '" + clave + "';";
                this.rs = this.st.executeQuery(sql);
            
                if (this.rs.first())
                {
                    this.desconectar();
                    return true;
                }
                else
                {
                    this.desconectar();
                    return false;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return false;
        }
        
        public JSONObject TipoUsuario(String nickname, String clave)
        {
            JSONObject usuario = new JSONObject();
            try
            {
                this.cn = getConnection();
                this.st = this.cn.createStatement();
                String sql;
                sql = "SELECT tipo, id_usuarios FROM usuarios WHERE nickname = '" + nickname + "' AND clave = '" + clave + "';";
                this.rs = this.st.executeQuery(sql);
            
                if (this.rs.first())
                {
                    usuario.put("TipoUsuario", this.rs.getString("tipo"));
                    usuario.put("idusuarios", this.rs.getString("id_usuarios"));
                    this.desconectar();
                    return usuario;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            usuario.put("TipoUsuario", "false");
            usuario.put("idusuarios", "false");
            return usuario;
        }
        
    /*************************************************************************************************************
    *************************************************FUNCION MODIFICAR PERFIL*************************************
    **************************************************************************************************************/
    
    public JSONObject datosUsuario(String idUsuario)
    {
        JSONObject usuariosM = new JSONObject();
        try
        {
            this.cn = getConnection();
            this.st = this.cn.createStatement();
            String sql = "SELECT * FROM usuarios WHERE id_usuarios ='" + idUsuario + "';";
            this.rs = this.st.executeQuery(sql);
            this.rs.first();
            usuarios usr = new usuarios(rs.getString("id_usuarios"), rs.getString("nombres"), rs.getString("nickname"), rs.getString("clave"), rs.getString("celular"), rs.getString("email"), rs.getString("tipo"),rs.getString("foto_perfil"));
            usuariosM= usr.getJSONObject();
            System.out.printf(usuariosM.toString());
            this.desconectar();
        }
    
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
        return usuariosM;
    }
    
        public boolean ModificarPerfil(JSONObject datos, String id_usuarios)
        {
            try
            {
                this.cn = getConnection();
                this.st = cn.createStatement();
                usuarios usr = new usuarios("", String.valueOf(datos.get("nombres")), String.valueOf(datos.get("nickname")), String.valueOf(datos.get("clave")), String.valueOf(datos.get("celular")), String.valueOf(datos.get("email")), String.valueOf(datos.get("tipo")),String.valueOf(datos.get("foto_perfil")));
                String tsql;
                tsql = "UPDATE usuarios SET nombres='" + usr.getNombres() + "', nickname='" + usr.getNickname() + "', clave='" + usr.getClave() + "', celular='" + usr.getCelular() + "', email='" + usr.getEmail() + "', tipo='" + usr.getTipo() + "', foto_perfil='" + usr.getfotoperfil()+"' WHERE id_usuarios = " + id_usuarios + ";";                
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

