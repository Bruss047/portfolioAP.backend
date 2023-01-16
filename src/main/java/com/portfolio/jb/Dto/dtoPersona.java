
package com.portfolio.jb.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    
    private String nombre;
    
 
    private String apellido;
    

    private String direccion;
     

    private String sobreMi;
      

    private int telefono;
       
       
    private String email;
    
    

    private String img;
    
    
    //Relaciones con Entidades:
    
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
    
     /*@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)*/
    //private List<Skills> skills;
    
       
    
   // @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
    //private List<Estudios> estudios;

    
    //@OneToMany(cascade = CascadeType.ALL)
   //// @JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
   // private List<Proyectos> proyectos;
    
  
    
     public dtoPersona(){
    }
    
     
    public dtoPersona(String nombre, String apellido, String direccion, String aboutMe, int telefono, String email, String img)
    { 
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.sobreMi=aboutMe;
        this.telefono=telefono;
        this.email=email;
        this.img=img;
    }  

}
