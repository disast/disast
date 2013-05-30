/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabents;
import org.json.simple.JSONObject;

public class usuarios 
{
        private String id_usuarios;
        private String nombres;
        private String nickname;
        private String clave;
        private String celular;
        private String email;
        private String tipo;
        private String foto_perfil;

       public usuarios()
       {
            this.id_usuarios = "";
            this.nombres = "";
            this.nickname= "";
            this.clave = "";
            this.celular = "";
            this.email= "";
            this.tipo = "";
            this.foto_perfil = ""; 
       }
       
        public usuarios(String id_usuarios, String nombres, String nickname, String clave, String celular,  String email, String tipo, String foto_perfil)
        {
            this.id_usuarios = id_usuarios;
            this.nombres = nombres;
            this.nickname = nickname;
            this.clave=  clave;
            this.celular = celular;
            this.email = email;
            this.tipo = tipo;
            this.foto_perfil = foto_perfil;
        }
        
        public JSONObject getJSONObject() 
        {
            JSONObject obj = new JSONObject();
            obj.put("id_usuarios", this.id_usuarios);
            obj.put("nombres", this.nombres);
            obj.put("nickname", this.nickname);
            obj.put("clave", this.clave);
            obj.put("celular", this.celular);
            obj.put("email", this.email);
            obj.put("tipo", this.tipo);
            obj.put("foto_perfil", this.foto_perfil);
            return obj;
        }
        
        public void setidusuarios(String id_usuarios)
        {
            this.id_usuarios = id_usuarios;
        }
    
        public String getidusuarios()
        {
            return this.id_usuarios;
        }
        public void setNombres(String nombres)
        {
            this.nombres = nombres;
        }

        public String getNombres()
        {
            return this.nombres;
        }

        public void setNickname(String nickname)
        {
            this.nickname = nickname;
        }

        public String getNickname()
        {
            return this.nickname;
        }

        public void setClave(String clave)
        {
            this.clave = clave;
        }

        public String getClave()
        {
            return this.clave;
        }

        public void setCelular(String celular)
        {
            this.celular = celular;
        }

        public String getCelular()
        {
            return this.celular;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public String getEmail()
        {
            return this.email;
        }

        public void setTipo(String tipo)
        {
            this.tipo = tipo;
        }

        public String getTipo()
        {
            return this.tipo;
        }
        
        public void setfotoperfil(String foto_perfil)
        {
            this.foto_perfil = foto_perfil;
        }

        public String getfotoperfil()
        {
            return this.foto_perfil;
        }
       
}
