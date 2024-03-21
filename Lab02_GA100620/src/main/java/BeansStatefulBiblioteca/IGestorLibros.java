package BeansStatefulBiblioteca;

import javax.ejb.Remote;

@Remote
public interface IGestorLibros {
    void agregarLibro(String isbn);
    void borrarLibro(String isbn);
    int contarCantidadDeLibros();
    void borrarTodosLosLibros();
    
    // Del local
    String obtenerInformacionLibro(String isbn);
}
