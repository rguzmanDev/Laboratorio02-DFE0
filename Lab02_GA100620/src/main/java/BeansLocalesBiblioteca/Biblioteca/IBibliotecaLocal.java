package BeansLocalesBiblioteca.Biblioteca;

import javax.ejb.Local;

@Local
public interface IBibliotecaLocal {
    String buscarLibroPorTitulo(String titulo);
    boolean prestarLibro(String isbn);
    boolean devolverLibro(String isbn);
}
