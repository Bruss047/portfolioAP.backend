
package com.portfolio.jb.Dto;


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    
   @NotBlank
    private String nombreEd;
    @NotBlank
    private String tituloEd;
    @NotBlank
    private String descEd;
    @NotBlank
    private String imgEdu;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;
    
    

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String tituloE, String descEd, String inicio, String fin) {
        this.nombreEd = nombreE;
        this.tituloEd = tituloE;
        this.descEd=descEd;
        this.descEd = descEd;
        this.inicio = inicio;
        this.fin = fin;
    }

  


    
}
