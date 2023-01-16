/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.jb.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expId")
    private int expId;
    
   @Column(name = "nombreEmpresa", nullable = false, length = 48)
    private String nombreExp;
    
   @Column(name = "puesto", nullable = false, length = 48)
    private String puesto;
    
   @Column(name = "descrip", nullable = false, length = 270)
    private String descExp;
   
    @Column(name = "fechaInicio", nullable = false, length = 100)
   private String fechaInicio;
    
 
   @Column(name = "fechaFin", nullable = false, length = 100)
   private String fechaFin;
    
  
    public Experiencia() {
    }

    public Experiencia(String nombreExp,String puestoE, String descExp, String inicio, String fin) {
       
        this.nombreExp = nombreExp;
        this.puesto=puestoE;
        this.descExp = descExp;
        this.fechaInicio= inicio;
        this.fechaFin= fin;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////////////////////////
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }*/
    
}
