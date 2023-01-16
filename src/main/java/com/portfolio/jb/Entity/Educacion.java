/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.jb.Entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int estudId;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombreEd;
    
    @Column(name = "titulo", nullable = false, length = 90)
    private String tituloEd;
    
    @Column(name = "descEd", nullable = false, length = 250)
    private String descEd;
    
     @Column(name = "imgEdu", nullable = false, length = 40)
    private String imgEdu;
    
     @Column(name = "inicio", nullable = false, length = 40)
    private String inicio;
    
    @Column(name = "fin", nullable = false, length = 40)
    private String fin;

    public Educacion() {
    }

    public Educacion(String nombreEd, String tituloEd, String descEd,String imgEdu, String inicio, String fin) {
        this.nombreEd = nombreEd;
        this.tituloEd = tituloEd;
        this.descEd = descEd;
        this.imgEdu = imgEdu;
        this.inicio = inicio;
        this.fin = fin;
    }
    

    
}
