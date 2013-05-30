/**
 *
 * @author Lunita
 */
package javabents;
import org.json.simple.JSONObject;

public class tablas_ambiental 
{
    
    private String id_numero;
    private String cod_ambiente;
    private String id_usuarios;
    private String id_proceso;
    private String actividad;
    private String fecha_de_ingreso;
    private String id_aspecto;
    private String descripcion_del_aspecto;
    private String id_impacto;
    private String descripcion_del_impacto;
    private String legislacion;
    private String cumple_legislacion;
    private String naturaleza;
    private String idextencion;
    private String idpersistencia;
    private String idsinergia;
    private String idefecto;
    private String idrecuperabilidad;
    private String idintensidad;
    private String idmomento;
    private String idreversibilidad;
    private String idacumulacion;
    private String idperiodicidad;
    private String importancia;
    private String clasificacion;
    private String observacion;
    
    public tablas_ambiental ()
    {
    
        this.id_numero = "";
	this.cod_ambiente = "";
	this.id_usuarios = "";
	this.id_proceso = "";
	this.actividad = "";
        this.fecha_de_ingreso = "";
	this.id_aspecto = "";
	this.descripcion_del_aspecto = "";
	this.id_impacto = "";
	this.descripcion_del_impacto = "";
	this.legislacion = "";
	this.cumple_legislacion = "";
	this.naturaleza = "";
	this.idextencion = "";
	this.idpersistencia = "";
	this.idsinergia = "";
	this.idefecto = "";
	this.idrecuperabilidad = "";
	this.idintensidad = "";
	this.idmomento = "";
	this.idreversibilidad = "";
	this.idacumulacion = "";
	this.idperiodicidad = "";
	this.importancia = "";
	this.clasificacion = "";
	this.observacion = "";
    }
    
    public tablas_ambiental(String id_numero, String cod_ambiente, String id_usuarios, String id_proceso, String actividad, String fecha_de_ingreso, String id_aspecto, String descripcion_del_aspecto, String id_impacto, String descripcion_del_impacto, String legislacion, String cumple_legislacion, String naturaleza, String idextencion, String idpersistencia, String idsinergia, String idefecto, String idrecuperabilidad, String idintensidad, String idmomento, String idreversibilidad, String idacumulacion, String idperiodicidad, String importancia, String clasificacion, String observacion)
    {
        this.id_numero = id_numero;
	this.cod_ambiente = cod_ambiente;
	this.id_usuarios = id_usuarios;
	this.id_proceso = id_proceso;
	this.actividad = actividad;
        this.fecha_de_ingreso = fecha_de_ingreso;
	this.id_aspecto = id_aspecto;
	this.descripcion_del_aspecto = descripcion_del_aspecto;
	this.id_impacto = id_impacto;
	this.descripcion_del_impacto = descripcion_del_impacto;
	this.legislacion = legislacion;
	this.cumple_legislacion = cumple_legislacion;
	this.naturaleza = naturaleza;
	this.idextencion = idextencion;
	this.idpersistencia = idpersistencia;
	this.idsinergia = idsinergia;
	this.idefecto = idefecto;
	this.idrecuperabilidad = idrecuperabilidad;
	this.idintensidad = idintensidad;
	this.idmomento = idmomento;
	this.idreversibilidad = idreversibilidad;
	this.idacumulacion = idacumulacion;
	this.idperiodicidad = idperiodicidad;
	this.importancia = importancia;
	this.clasificacion = clasificacion;
	this.observacion = observacion;
    
    }
    
    public JSONObject getJSONObject()
    {
        JSONObject obj = new JSONObject();
        obj.put("id_numero", this.id_numero);
        obj.put("cod_ambiente", this.cod_ambiente);
        obj.put("id_usuarios", this.id_usuarios);
        obj.put("id_proceso", this.id_proceso);
        obj.put("actividad", this.actividad);
        obj.put("fecha_de_ingreso", this.fecha_de_ingreso);
        obj.put("id_aspecto", this.id_aspecto);
        obj.put("descripcion_del_aspecto", this.descripcion_del_aspecto);
        obj.put("id_impacto", this.id_impacto);
        obj.put("descripcion_del_impacto", this.descripcion_del_impacto);
        obj.put("legislacion", this.legislacion);
        obj.put("cumple_legislacion", this.cumple_legislacion);
        obj.put("naturaleza", this.naturaleza);
        obj.put("idextencion", this.idextencion);
        obj.put("idpersistencia", this.idpersistencia);
        obj.put("idsinergia", this.idsinergia);
        obj.put("idefecto", this.idefecto);
        obj.put("idrecuperabilidad", this.idrecuperabilidad);
        obj.put("idintensidad", this.idintensidad);
        obj.put("idmomento", this.idmomento);
        obj.put("idreversibilidad", this.idreversibilidad);
        obj.put("idacumulacion", this.idacumulacion);
        obj.put("idperiodicidad", this.idperiodicidad);
        obj.put("importancia", this.importancia);
        obj.put("clasificacion", this.clasificacion);
        obj.put("observacion", this.observacion);
        
        return obj;
    
    }



public void setidnumero(String id_numero)
    {
        this.id_numero = id_numero;
    }
    
    public String getidnumero()
    {
        return this.id_numero;
    } 
    
    public void setcodambiente(String cod_ambiente)
    {
        this.cod_ambiente = cod_ambiente;
    }
    
    public String getcodambiente()
    {
        return this.cod_ambiente;
    }
    
    public void setidusuarios(String id_usuarios)
    {
        this.id_usuarios = id_usuarios;
    }
    
    public String getidusuarios()
    {
        return this.id_usuarios;
    }
    
    public void setidproceso(String id_proceso)
    {
        this.id_proceso = id_proceso;
    }
    
    public String getidproceso()
    {
        return this.id_proceso;
    }
    
    public void setactividad(String actividad)
    {
        this.actividad = actividad;
    }
    
    public String getactividad()
    {
        return this.actividad;
    }

    public void setfechadeingreso(String fecha_de_ingreso)
    {
        this.fecha_de_ingreso = fecha_de_ingreso;
    }
    
    public String getfechadeingreso()
    {
        return this.fecha_de_ingreso;
    }
    
    public void setidaspecto(String id_aspecto)
    {
        this.id_aspecto = id_aspecto;
    }
    
    public String getidaspecto()
    {
        return this.id_aspecto;
    }
    
    public void setdescripciondelaspecto(String descripcion_del_aspecto)
    {
        this.descripcion_del_aspecto = descripcion_del_aspecto;
    }
    
    public String getdescripciondelaspecto()
    {
        return this.descripcion_del_aspecto;
    }
    
    public void setidimpacto(String id_impacto)
    {
        this.id_impacto = id_impacto;
    }
    
    public String getidimpacto()
    {
        return this.id_impacto;
    }
    
    public void setdescripciondelimpacto(String descripcion_del_impacto)
    {
        this.descripcion_del_impacto = descripcion_del_impacto;
    }
    
    public String getdescripciondelimpacto()
    {
        return this.descripcion_del_impacto;
    }
    
    public void setlegislacion(String legislacion)
    {
        this.legislacion = legislacion;
    }
    
    public String getlegislacion()
    {
        return this.legislacion;
    }
    
    public void setcumplelegislacion(String cumple_legislacion)
    {
        this.cumple_legislacion = cumple_legislacion;
    }
    
    public String getcumplelegislacion()
    {
        return this.cumple_legislacion;
    }
    
    public void setnaturaleza(String naturaleza)
    {
        this.naturaleza = naturaleza;
    }
    
    public String getnaturaleza()
    {
        return this.naturaleza;
    }
    
    public void setextencion(String idextencion)
    {
        this.idextencion = idextencion;
    }
    
    public String getextencion()
    {
        return this.idextencion;
    }
    
    public void setpersistencia(String idpersistencia)
    {
        this.idpersistencia = idpersistencia;
    }
    
    public String getpersistencia()
    {
        return this.idpersistencia;
    }
    
    public void setsinergia(String idsinergia)
    {
        this.idsinergia = idsinergia;
    }
    
    public String getsinergia()
    {
        return this.idsinergia;
    }
    
    public void setefecto(String idefecto)
    {
        this.idefecto = idefecto;
    }
    
    public String getefecto()
    {
        return this.idefecto;
    }
    
    public void setrecuperabilidad(String idrecuperabilidad)
    {
        this.idrecuperabilidad = idrecuperabilidad;
    }
    
    public String getrecuperabilidad()
    {
        return this.idrecuperabilidad;
    }
    
    public void setintensidad(String idintensidad)
    {
        this.idintensidad = idintensidad;
    }
    
    public String getintensidad()
    {
        return this.idintensidad;
    }
    
    public void setmomento(String idmomento)
    {
        this.idmomento = idmomento;
    }
    
    public String getmomento()
    {
        return this.idmomento;
    }
    
    public void setreversibilidad(String idreversibilidad)
    {
        this.idreversibilidad = idreversibilidad;
    }
    
    public String getreversibilidad()
    {
        return this.idreversibilidad;
    }
    
    public void setacumulacion(String idacumulacion)
    {
        this.idacumulacion = idacumulacion;
    }
    
    public String getacumulacion()
    {
        return this.idacumulacion;
    }
    
    public void setperiodicidad(String idperiodicidad)
    {
        this.idperiodicidad = idperiodicidad;
    }
    
    public String getperiodicidad()
    {
        return this.idperiodicidad;
    }
    
    public void setimportancia(String importancia)
    {
        this.importancia = importancia;
    }
    
    public String getimportancia()
    {
        return this.importancia;
    }
    
    public void setclasificacion(String clasificacion)
    {
        this.clasificacion = clasificacion;
    }
    
    public String getclasificacion()
    {
        return this.clasificacion;
    }
    
    public void setobservacion(String observacion)
    {
        this.observacion = observacion;
    }
    
    public String getobservacion()
    {
        return this.observacion;
    }
    
}

