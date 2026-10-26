package com.example.ms_compras.controller;

import com.example.ms_compras.client.UsuarioClient;
import com.example.ms_compras.dto.UsuarioDTO;
import com.example.ms_compras.model.Compra;
import com.example.ms_compras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @GetMapping
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @PostMapping
    public Compra realizarCompra(@RequestBody Compra compra, 
                                 @RequestHeader(value = "Authorization", required = false) String auth) {
        // Consultar ms-usuarios a través de UsuarioClient (RestClient)
       UsuarioDTO usuario = usuarioClient.getUsuario(compra.getIdUsuario());
        
        if (usuario == null) {
            throw new RuntimeException("El usuario no existe");
        }

        compra.setFechaCompra(LocalDateTime.now());
        return compraRepository.save(compra);
    }
}