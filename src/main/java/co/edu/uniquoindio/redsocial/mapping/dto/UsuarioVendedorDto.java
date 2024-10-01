package co.edu.uniquoindio.redsocial.mapping.dto;

public record UsuarioVendedorDto(
        String username,
        String password,
        String nombre,
        String apellido,
        String email,
        String id
) {
}
