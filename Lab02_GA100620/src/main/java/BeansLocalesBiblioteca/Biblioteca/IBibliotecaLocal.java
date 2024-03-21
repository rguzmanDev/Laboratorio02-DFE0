package BeansLocalesBiblioteca.Biblioteca;

import jakarta.ejb.Local;

@Local
public interface IBibliotecaLocal {
    String buscarLibroPorTitulo(String titulo);
    boolean prestarLibro(String isbn);
    boolean devolverLibro(String isbn);
}
