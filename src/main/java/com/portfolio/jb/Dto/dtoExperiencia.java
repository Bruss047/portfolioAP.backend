/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.jb.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    
    
    
    @NotBlank
    private String nombreExp;
    
   @NotBlank
    private String puesto;
    
   @NotBlank
    private String descExp;
    
   @NotBlank
   
    private String fechaInicio;
    
   @NotBlank
   
    private String fechaFin;
    
  

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String puestoE,  String descripcionE, String fechaIn, String fechaFin) {
        this.nombreExp = nombreE;
        this.puesto = puestoE;
        this.descExp = descripcionE;
        this.fechaInicio=fechaIn;
        this.fechaFin=fechaFin;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*@NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    //Getters & Setters

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
