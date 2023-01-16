
package com.portfolio.jb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proyId")
    private int proyId;
    
    @Column(name = "nombreProyecto", nullable = false, length = 48)
    private String nombre;
    
    @Column(name = "descProyecto", nullable = false, length = 140)
    private String descripcion;
    
    @Column(name = "imgProyecto", nullable = false, length = 140)
    private String img;
    
    @Column(name = "urlP", nullable = false, length = 160)
    private String urlP;

    
    @Column(name = "fechaProyecto", nullable = false, length = 80)
    private String fecha;
    
 
    
    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String img, String urlP, String fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.urlP = urlP;
        this.fecha= fecha;
    }
    
}
