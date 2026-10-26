package com.example.ms_compras.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import com.example.ms_compras.dto.UsuarioDTO;

@Component
public class UsuarioClient {

    private final RestClient restClient;

    public UsuarioClient() {
        // Se cambia localhost por el nombre del contenedor ms-usuarios en la red de Docker
        this.restClient = RestClient.builder()
                .baseUrl("http://ms-usuarios:8081/api/usuarios")
                .build();
    }

    public UsuarioDTO getUsuario(Long id) {
        return restClient.get()
                .uri("/{id}", id)
                .retrieve()
                .body(UsuarioDTO.class);
    }
}