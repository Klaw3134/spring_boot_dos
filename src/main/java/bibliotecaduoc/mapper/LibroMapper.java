package bibliotecaduoc.mapper;

import bibliotecaduoc.dto.ClientRequest;
import bibliotecaduoc.modelo.*;

public class LibroMapper {

    public static Libro toModel(ClientRequest request) {
        return new Libro(
            request.getId(),
            request.getIsbn(),
            request.getTitulo(),
            request.getEditorial(),
            request.getFechaPublicacion(),
            request.getAutor()
        );
    }
}
