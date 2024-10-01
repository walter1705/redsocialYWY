package co.edu.uniquoindio.redsocial.mapping.dto;

import co.edu.uniquoindio.redsocial.model.Usuario;

public record VendedorDto(
        String nombre,
        String apellido,
        String email,
        String id
) {
}
