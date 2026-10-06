public class Principal {

    public static void main(String[] args) {
        VariableCompartida variable = new VariableCompartida();

        // Número de incrementos por hebra
        final int NUM_INCREMENTOS = 10;

        // Definición de la tarea concurrente
        Runnable tarea = () -> {
            for (int i = 0; i < NUM_INCREMENTOS; i++) {
                variable.inc();
            }
        };

        // Creación de las 2 hebras que comparten la misma instancia
        Thread hebra1 = new Thread(tarea, "Hebra-1");
        Thread hebra2 = new Thread(tarea, "Hebra-2");

        // Inicio concurrente de los hilos
        hebra1.start();
        hebra2.start();

        // Espera a que ambas hebras finalicen su ejecución
        try {
            hebra1.join();
            hebra2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostrar el valor final desde el hilo principal
        System.out.println("Esperado: " + (NUM_INCREMENTOS * 2));
        System.out.println("Obtenido: " + variable.get());
    }
}