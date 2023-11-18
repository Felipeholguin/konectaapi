package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.repositorios.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamenServicio {

    @Autowired
    private ExamenRepositorio examenRepositorio;

    public Examen registrarExamen(Examen examen) throws Exception{
        try {
            return this.examenRepositorio.save(examen);

        }catch (Exception error){
            throw new Exception("error al registrarse");
        }
    }

    public Examen consultarExamen(Integer idExamen)throws Exception{
        try {
            Optional<Examen> examenBuscado=this.examenRepositorio.findById(idExamen);
            if(examenBuscado.isPresent()){ //lo encontramos en bd
                return examenBuscado.get();

            }else {//No lo encontramos
                throw new Exception("Examen no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error en la consulta del examen");
        }
    }
}
