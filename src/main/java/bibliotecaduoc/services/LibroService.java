package bibliotecaduoc.services;
import bibliotecaduoc.modelo.Libro;
import bibliotecaduoc.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepositorio libroRepositorio;
    public List<Libro> getLibros(){
        return libroRepositorio.obtenerLibros();

    }

    public Libro saveLibro(Libro libro){
        return libroRepositorio.guardar(libro);

    }

    public Libro getLibroId(int id){
        return libroRepositorio.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepositorio.actualizar(libro);
    }
    public String deleteLibro(int id){
        libroRepositorio.eliminar(id);
        return "Producto elimminado";
    }







}
// service almacena datos