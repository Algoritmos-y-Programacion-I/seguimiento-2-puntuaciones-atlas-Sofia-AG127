/** Análisis (completar)
Descripción del programa:
 Eventos Atlas ha expandido su negocio e incorporado torneos de videojuegos. En cada 
 torneo pueden participar hasta 5 jugadores y disputarse un máximo de 10 rondas. Necesitan asistencia para gestionar
 las puntuaciones, registrando los puntajes en cada ronda y calculando las estadísticas al finalizar el torneo.
Entradas:
 La cantidad de jugadores (entre 1 y 10), la cantidad de rondas (entre 1 y 5) y los puntajes de cada 
 jugador en cada ronda.
Salidas: 
 La cantidad de jugadores y rondas ingresadas. Luego, se muestran los puntajes registrados en cada ronda. 
 Al final, el programa imprime el puntaje total de cada jugador y sus promedios, y anuncia quién obtuvo la puntuación más alta.
Ejemplo:
 # Ingrese el número de jugadores  
 > 3  
 # Ingrese el número de rondas  
 > 4  
 # Ingrese el puntaje del jugador 1 en la ronda 1:  
 > 85  
 # Ingrese el puntaje del jugador 1 en la ronda 2:  
 > 90  
 # Ingrese el puntaje del jugador 1 en la ronda 3:  
 > 70  
 # Ingrese el puntaje del jugador 1 en la ronda 4:  
 > 95  
 # Ingrese el puntaje del jugador 2 en la ronda 1:  
 > 60  
 # Ingrese el puntaje del jugador 2 en la ronda 2:  
 > 75  
 # Ingrese el puntaje del jugador 2 en la ronda 3:  
 > 80  
 # Ingrese el puntaje del jugador 2 en la ronda 4:  
 > 85  
 # Ingrese el puntaje del jugador 3 en la ronda 1:  
 > 95  
 # Ingrese el puntaje del jugador 3 en la ronda 2:  
 > 85  
 # Ingrese el puntaje del jugador 3 en la ronda 3:  
 > 90  
 # Ingrese el puntaje del jugador 3 en la ronda 4:  
 > 100  
 # Resultados del torneo:  
 # El puntaje total del jugador 1 es: 340, Promedio: 85
 # El puntaje total del jugador 2 es: 300, Promedio: 75  
 # El puntaje total del jugador 3 es: 370, Promedio: 92  
 # El jugador con la puntuación más alta es Jugador 3 con 370 puntos
*/

package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	static Scanner escaner = new Scanner(System.in);

	// Declaración de nuestras constantes a utilizar
	
	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	
	public void run()
	{
		// Declaracion de todas las variables a usar en el programa
		// Notificacion al usuario de la solicitud de dato
		// Capturamos el dato con nuestro Scanner (que se llama, escaner)
		// Realizamos los cálculos delegandolos a los métodos
		// Notificación al usuario de los resultados

		int jugadoresCant, rondasCant;
		System.out.println("Ingrese la cantidad de jugadores: ");
        jugadoresCant = escaner.nextInt();
        verificarJugadores(jugadoresCant);

        System.out.println("Ingrese la cantidad de rondas: ");
        rondasCant = escaner.nextInt();
        verificarRondas(rondasCant);

        int [] jugadores = jugadores(jugadoresCant);

        jugadores = puntajeRondas(jugadores, rondasCant);

        resultadoTorneo(jugadores, rondasCant);

        puntuacionAlta(jugadores);
        
	}

	public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}

	public static int[] jugadores(int jugadoresCant) {
    	int [] jugadores = new int [jugadoresCant];
    	return jugadores;
	}

	public static int[] puntajeRondas(int[] jugadores, int rondasCant) {
     for (int i = 0; i < jugadores.length; i++) { 
        jugadores[i] = registrarPuntajePorRondas(i, rondasCant);
    	}
    	return jugadores;
	}

	public static int registrarPuntajePorRondas(int jugador, int rondasCant) {
    	int puntajeTotal = 0;
    	for (int i = 0; i < rondasCant; i++) { 
        	System.out.println("Ingrese el puntaje del jugador " + (jugador + 1) + " en la ronda " + (i + 1) + ": ");
        	puntajeTotal += escaner.nextInt();
    	}
    	return puntajeTotal;
	}

	public static void resultadoTorneo(int[] jugadores, int rondasCant) {
    	System.out.println("Resultados del torneo: ");
    	for (int i = 0; i < jugadores.length; i++) { 
        	System.out.println("El puntaje total del jugador " + (i + 1) + " es: " + jugadores[i] + ", Promedio: " + (jugadores[i]/rondasCant));
    	}
	}

	public static void puntuacionAlta(int[] jugadores) {
    	int puntajeMax = jugadores[0]; 
    	int jugadorGanador = 1; 

    	for (int i = 0; i < jugadores.length; i++) {  
        	if (jugadores[i] > puntajeMax) {
            	puntajeMax = jugadores[i];
            	jugadorGanador = i + 1; 
        	}
    	}

    	System.out.println("El jugador con la puntuación más alta es Jugador " + jugadorGanador + " con " + puntajeMax + " puntos");
	}

	public static void verificarJugadores(int jugadoresCant) {
    	if(jugadoresCant > 10 || jugadoresCant < 1) {
        	System.out.println("Digite una cantidad de jugadores valida");
        	System.exit(0);
    	}
	}

	public static void verificarRondas(int rondasCant) {
    	if(rondasCant > 5 || rondasCant < 1) {
        	System.out.println("Digite una cantidad de rondas valida");
        	System.exit(0);
    	}
	}
}