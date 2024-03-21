package BeansStatelessBiblioteca;

import jakarta.ejb.Remote;


@Remote
public interface ICalculadoraEstadisticasBibliotecaStateless {
    double calcularPromedioPrestamosPorUsuario(int totalPrestamos, int totalUsuarios);
    double calcularPorcentajeDevolucionesATiempo(int devolucionesATiempo, int totalPrestamos);
    
    // Del local
    String obtenerInformacionLibro(String isbn);
}
