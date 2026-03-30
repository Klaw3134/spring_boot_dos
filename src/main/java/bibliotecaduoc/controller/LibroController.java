package bibliotecaduoc.controller;
import bibliotecaduoc.modelo.Libro;
import bibliotecaduoc.services.LibroService;
import bibliotecaduoc.dto.ClientRequest;
import bibliotecaduoc.mapper.LibroMapper;
import bibliotecaduoc.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public ResponseEntity<?> agregarLibro(@Valid @RequestBody ClientRequest request, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(libroService.saveLibro(LibroMapper.toModel(request)));
    }

    @GetMapping("{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id){
        Libro libro = libroService.getLibroId(id);
        
        if (libro == null) {
            throw new ResourceNotFoundException("Libro no encontrado para id: " + id);
        }
        
        return ResponseEntity.ok(libro);
    }

    @PutMapping ("{id}")
    public Libro actualizaLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable int id){
    Libro libro = libroService.getLibroId(id);

    if (libro == null) {
    throw new ResourceNotFoundException("Libro no encontrado para id: " + id);
    }

    libroService.deleteLibro(id);
    return ResponseEntity.ok("Libro eliminado correctamente, id: " + id);
    }
    

}
