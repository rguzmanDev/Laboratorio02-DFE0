package test;

import BeansStatelessBiblioteca.ICalculadoraEstadisticasBibliotecaStateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import BeansSingletonBiblioteca.IConfiguracionBibliotecaSingleton;
import BeansStatefulBiblioteca.IGestorLibros;

public class TestBiblioteca {

    public static void main(String[] args) {
        
        // Probando los TEST
        bibliotecaSingleton();
        gestorLibrosStateful();
        estadisticasBibliotecaStateless();
        
    }
    
    // Aquí pruebo SINGLETON
    private static void bibliotecaSingleton(){
        System.out.println("\nLlamando el EJB de Singleton de Biblioteca");
        try {
            Context jndi = new InitialContext();
            IConfiguracionBibliotecaSingleton configuracion = (IConfiguracionBibliotecaSingleton) jndi.lookup("java:module/ConfiguracionBibliotecaSingleton");

            // Imprimir la cantidad actual de libros para préstamo
            System.out.println("Cantidad de libros para préstamo actual: " + configuracion.getCantidadLibrosParaPrestamo());

            // Cambiar la cantidad de libros para préstamo
            configuracion.setCantidadLibrosParaPrestamo(200);

            // Verificar el cambio
            System.out.println("Nueva cantidad de libros para préstamo: " + configuracion.getCantidadLibrosParaPrestamo());

        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }

    // Aquí pruebo STATEFUL
    private static void gestorLibrosStateful() {
        System.out.println("\nLlamando al EJB Stateful de Gestión de Libros");
        
        try {
            Context ctx = new InitialContext();
            IGestorLibros gestor = (IGestorLibros) ctx.lookup("java:module/GestorLibros");

            // Agregar nuevos libros
            gestor.agregarLibro("1234567890123");
            gestor.agregarLibro("9876543210987");
            
            // Mostrar en consola la cantidad de libros
            System.out.println("Cantidad de libros: " + gestor.contarCantidadDeLibros());

            // Borrar un libro específico
            gestor.borrarLibro("1234567890123");
            System.out.println("Cantidad de libros después de borrar uno: " + gestor.contarCantidadDeLibros());

            // Borrar todos los libros
            gestor.borrarTodosLosLibros();
            System.out.println("Cantidad de libros después de borrar todos: " + gestor.contarCantidadDeLibros());
            
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }

    // Aquí pruebo STATELESS
    private static void estadisticasBibliotecaStateless() {
        System.out.println("\nLlamando el EJB de Stateless para Estadísticas de la Biblioteca");
        
        try {
            Context jndi = new InitialContext();
            ICalculadoraEstadisticasBibliotecaStateless calculadora = (ICalculadoraEstadisticasBibliotecaStateless) jndi.lookup("java:module/CalculadoraEstadisticasBibliotecaStateless");

            // Prueba del método calcularPromedioPrestamosPorUsuario
            int totalPrestamos = 120;
            int totalUsuarios = 30;
            double promedioPrestamos = calculadora.calcularPromedioPrestamosPorUsuario(totalPrestamos, totalUsuarios);
            System.out.println("El promedio de préstamos por usuario es: " + promedioPrestamos);

            // Prueba del método calcularPorcentajeDevolucionesATiempo
            int devolucionesATiempo = 110;
            double porcentajeDevoluciones = calculadora.calcularPorcentajeDevolucionesATiempo(devolucionesATiempo, totalPrestamos);
                        System.out.println("El porcentaje de devoluciones a tiempo es: " + porcentajeDevoluciones + "%");

        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
