package BeansLocalesBiblioteca.Biblioteca;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class BibliotecaBean implements IBibliotecaLocal {

    private Map<String, Libro> inventario = new HashMap<>();

    public BibliotecaBean() {
        // Inicializar algunos libros en el inventario para testeo
        inventario.put("123456789", new Libro("123456789", "El señor de los anillos", "J.R.R. Tolkien", false));
    }

    @Override
    public String buscarLibroPorTitulo(String titulo) {
        for (Libro libro : inventario.values()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isPrestado()) {
                return libro.toString();
            }
        }
        return "Libro no disponible";
    }

    @Override
    public boolean prestarLibro(String isbn) {
        Libro libro = inventario.get(isbn);
        if (libro != null && !libro.isPrestado()) {
            libro.setPrestado(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean devolverLibro(String isbn) {
        Libro libro = inventario.get(isbn);
        if (libro != null && libro.isPrestado()) {
            libro.setPrestado(false);
            return true;
        }
        return false;
    }
}
