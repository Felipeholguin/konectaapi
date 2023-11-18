package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.servicios.AfiliadoServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sura/afiliados")
public class AfiliadoControlador {


    @Autowired
    private AfiliadoServicio afiliadoServicio;

    //AgregarAfiliado
    @PostMapping
    public ResponseEntity<?> agregarAfiliado(@RequestBody Afiliado afiliado){
        try{
           Afiliado respuestaServicio=this.afiliadoServicio.registrarAfiliado(afiliado);
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
     @GetMapping("/{id}")
    //BuscarAfiliado
    public ResponseEntity<?>buscarAfiloiado(@PathVariable Integer id){
        try{
          Afiliado respuestaServicio=this.afiliadoServicio.consultarAfiliado(id);
          return ResponseEntity
                  .status(HttpStatus.OK)
                  .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
