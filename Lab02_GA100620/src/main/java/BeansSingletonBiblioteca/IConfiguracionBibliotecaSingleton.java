package BeansSingletonBiblioteca;

import javax.ejb.Remote;

@Remote
public interface IConfiguracionBibliotecaSingleton {
    int getCantidadLibrosParaPrestamo();
    void setCantidadLibrosParaPrestamo(int cantidad);

    // Del local
    String obtenerInformacionLibro(String isbn);
}
