import java.util.Random;

class Threads extends Thread {
    private final int id;

    public Threads(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random random = new Random();
        int tempoEspera = random.nextInt(3000) + 1000; // Tempo entre 1000ms e 4000ms
        
        try {
            System.out.println("Thread " + id + " aguardando " + tempoEspera + " milissegundos.");
            Thread.sleep(tempoEspera); // Dorme por um tempo aleatório
            System.out.println("Thread " + id + " finalizou.");
        } catch (InterruptedException e) {
            System.out.println("Thread " + id + " interrompida: " + e.getMessage());
        }
    }
}

public class ExemploThreads {
    public static void main(String[] args) {
        int n = 5; // Número de threads
        
        for (int i = 1; i <= n; i++) {
            Threads thread = new Threads(i);
            thread.start(); // Inicia a thread
        }
    }
}

