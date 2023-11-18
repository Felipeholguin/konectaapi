package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.repositorios.SignoVitalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignoVitalServicio {

    @Autowired
    private SignoVitalRepositorio signoVitalRepositorio;

    public SignoVital registrarSignoVital(SignoVital signoVital)throws Exception{
        try {
            return this.signoVitalRepositorio.save(signoVital);

        }catch (Exception error){
            throw new Exception("error al registrarse");
        }
    }

    public SignoVital consultarsignoVital(Integer idsignoVital)throws Exception{
        try {
            Optional<SignoVital> signoVitalBuscado=this.signoVitalRepositorio.findById(idsignoVital);
            if(signoVitalBuscado.isPresent()){ //lo encontramos en bd
                return signoVitalBuscado.get();

            }else {//No lo encontramos
                throw new Exception("signoVital no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error en la consulta del signoVital");
        }
    }
}
