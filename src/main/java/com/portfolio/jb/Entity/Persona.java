package com.portfolio.jb.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaId")
    private Long personaId;
    
    @NotNull
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    
    @NotNull
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    
     @Column(name = "direccion", nullable = false, length = 90)
    private String direccion;
     
      @Column(name = "sobreMi", nullable = false, length = 120)
    private String sobreMi;
      
       @Column(name = "telefono", nullable = false, length = 12)
    private int telefono;
       
        @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    
    @Column(name = "img", nullable = true, length = 120)
    private String img;
    
    //Relaciones con Entidades:
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
    private List<Skills> skill;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
    private List<Experiencia> experiencia;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
    private List<Educacion> educacion;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persId_fk",referencedColumnName = "personaId")
    private List<Proyecto> proyecto;
    
  
    
     public Persona(){
    }
    
     
    public Persona(String nombre, String apellido, String direccion, String aboutMe, int telefono, String email, String img)
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
