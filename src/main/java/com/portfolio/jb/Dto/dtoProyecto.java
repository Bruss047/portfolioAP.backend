
package com.portfolio.jb.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String img;
    
    @NotBlank
    private String urlP;

    @NotBlank
    private String fecha;
    
    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion, String img, String urlP, String fecha) {
  
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.urlP = urlP;
        this.fecha= fecha;
    } 
}
