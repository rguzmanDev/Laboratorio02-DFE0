package BeansLocalesBiblioteca.Utilidades;

import javax.ejb.Local;

@Local
public interface IUtilidadesBibliotecaLocal {
    boolean esISBNValido(String isbn);
    boolean esTituloValido(String titulo);
}
