package BeansLocalesBiblioteca.Utilidades;

import jakarta.ejb.Local;


@Local
public interface IUtilidadesBibliotecaLocal {
    boolean esISBNValido(String isbn);
    boolean esTituloValido(String titulo);
}
