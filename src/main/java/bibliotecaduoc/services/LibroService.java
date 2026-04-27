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
    public List<Libro> getLibros() {
        // return libroRepository.obtenerLibros();
        return libroRepositorio.findAll();

    }

    public Libro saveLibro(Libro libro) {
        // return libroRepository.guardar(libro);
        return libroRepositorio.save(libro);
    }

    public Libro getLibroId(int id) {
        // return libroRepository.buscarPorId(id);
        return libroRepositorio.findById(id).orElse(null);
    }

    public Libro updateLibro(Libro libro) {
        // return libroRepository.actualizar(libro);
        return libroRepositorio.save(libro);
    }


    public String deleteLibro(int id) {
        // libroRepository.eliminar(id);
        // return "producto eliminado";
        libroRepositorio.deleteById(id);
        return "Libro eliminado";
    }

    // LA ACCIÓN LA HACE EL SERVICE
    public int totalLibros() {
        // return libroRepository.obtenerLibros().size();
        return (int) libroRepositorio.count();
    }

    // LA ACCIÓN LA HACE EL MODELO
    public int totalLibrosV2() {
        return libroRepositorio.totalLibros();
    }

    public List <Libro> buscarPorEditorial (String editorial){
        return libroRepositorio.selectPorEditorial(editorial);
    }





}
// service almacena datos