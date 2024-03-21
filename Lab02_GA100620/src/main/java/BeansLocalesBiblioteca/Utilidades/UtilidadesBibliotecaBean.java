package BeansLocalesBiblioteca.Utilidades;

import jakarta.ejb.Stateless;

@Stateless
public class UtilidadesBibliotecaBean implements IUtilidadesBibliotecaLocal {

    @Override
    public boolean esISBNValido(String isbn) {
        // Implementar lógica para validar el número ISBN (simplificado)
        return isbn != null && isbn.matches("[0-9]{13}");
    }

    @Override
    public boolean esTituloValido(String titulo) {
        // Implementar lógica para validar que el título no es nulo ni vacío
        return titulo != null && !titulo.trim().isEmpty();
    }
}
