package BeansStatefulBiblioteca;


import java.util.HashSet;
import java.util.Set;
import BeansLocalesBiblioteca.Biblioteca.IBibliotecaLocal;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;

@Stateful
public class GestorLibros implements IGestorLibros {
    
    @EJB
    private IBibliotecaLocal biblioteca; // Inyección del EJB local
    
    private final Set<String> libros = new HashSet<>();

    @Override
    public void agregarLibro(String isbn) {
        libros.add(isbn);
    }

    @Override
    public void borrarLibro(String isbn) {
        libros.remove(isbn);
    }

    @Override
    public int contarCantidadDeLibros() {
        return libros.size();
    }

    @Override
    public void borrarTodosLosLibros() {
        libros.clear();
    }
    
    // Ejemplo de un método que utiliza el EJB local
    @Override
    public String obtenerInformacionLibro(String isbn) {
        // Simulación de obtener información de un libro. La implementación real buscaría detalles en el EJB local o la base de datos
        return "Información del libro con ISBN " + isbn + ": Este es un ejemplo de la información del libro.";
    }
}
