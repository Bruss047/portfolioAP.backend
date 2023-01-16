
package com.portfolio.jb.Service;

import com.portfolio.jb.Entity.Proyecto;
import com.portfolio.jb.Repository.REProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServProyecto {
    
    @Autowired
    REProyecto prRepo;
    
    public List<Proyecto> list(){
        return prRepo.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return prRepo.findById(id);
    }
    public Optional<Proyecto> getByNombre(String nombre){
        return prRepo.findByNombre(nombre);
    }
    
     public boolean existsByNombre(String nombre){
        return prRepo.existsByNombre(nombre);
    }
    public void createSkill(Proyecto proyec){
        prRepo.save(proyec);
    }
    
    public void saveProyecto(Proyecto proyec) {
        prRepo.save(proyec);
    }
    
    public void editSkill(Proyecto proyec) {
        prRepo.save(proyec);
    }
    
    public void delete(int id){
        prRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return prRepo.existsById(id);
    }
    
}
