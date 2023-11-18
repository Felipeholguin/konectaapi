package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AfiliadoServicio {

    @Autowired
    private AfiliadoRepositorio afiliadoRepositorio;

    //Registrar un Afiliado
    public Afiliado registrarAfiliado(Afiliado afiliado) throws Exception{
        try {
            return this.afiliadoRepositorio.save(afiliado);

        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception("error al registrarse");
        }
    }

    //Consultar un Afiliado
    public Afiliado consultarAfiliado(Integer idAfiliado)throws Exception{
        try {
           Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(idAfiliado);
           if(afiliadoBuscado.isPresent()){ //lo encontramos en bd
               return afiliadoBuscado.get();
           }else {//No lo encontramos
               throw new Exception("Afiloado no encontrado");
           }
        }catch (Exception error){
            throw new Exception("error en la consulta del afiliado");
        }
    }

    //Consultar Afiliados

    //Modificar Datos Afiliado

    //Borrar Afiliado
}
