package BeansSingletonBiblioteca;

import BeansLocalesBiblioteca.Biblioteca.IBibliotecaLocal;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;

@Singleton
public class ConfiguracionBibliotecaSingleton implements IConfiguracionBibliotecaSingleton {
    
    @EJB
    private IBibliotecaLocal biblioteca; // Inyección del EJB local
    
    private int cantidadLibrosParaPrestamo = 100; // Ejemplo: la biblioteca permite 100 préstamos simultáneos por defecto

    @Override
    public int getCantidadLibrosParaPrestamo() {
        return cantidadLibrosParaPrestamo;
    }

    @Override
    public void setCantidadLibrosParaPrestamo(int cantidadLibrosParaPrestamo) {
        this.cantidadLibrosParaPrestamo = cantidadLibrosParaPrestamo;
    }

    // Ejemplo de un nuevo método que utiliza el EJB local
    @Override
    public String obtenerInformacionLibro(String isbn) {
        // Aquí deberías buscar la información del libro por su ISBN
        // Pero para mantenerlo simple, retornaremos un string de prueba
        return "Información del libro con ISBN " + isbn + ": Esta información se manda a llamar al Local";
    }
}
