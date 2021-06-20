package edu.escuelaing.edu.co.httpServer;



import java.net.*;
import java.io.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//solo pued haber una instancia de http server con singleton para que no haya mas instancias
public class HttpServer implements Runnable {
    private static HttpServer _instance = new HttpServer();
    private Thread threadRun = null;
    private ExecutorService pool = Executors.newFixedThreadPool(13);
    private boolean running = true;
    private ServerSocket serverSocket = null;
    private HttpServer(){

    }
    private static HttpServer getInstance(){
        return _instance;
    }
    public static void main(String... args) throws IOException{


        new Thread(HttpServer.getInstance()).start();
        try {
            Thread.sleep(200000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        HttpServer.getInstance().stop();
    }

    private void stop() {
        this.running = false;
        try{
            this.serverSocket.close();
        }catch (IOException e){
            throw new RuntimeException("Error closing server",e);
        }
    }

    public  void startServer() throws IOException {

        int port = getPort();

        Socket clientSocket;

            try {
                serverSocket = new ServerSocket(port);
                while (running){
                    System.out.println("Listo para recibir en puerto ..."+port);
                    clientSocket = serverSocket.accept();
                    ClientSocket clientResponse = new ClientSocket(clientSocket);
                    pool.execute(clientResponse);
                }
                this.pool.shutdown();
            } catch (IOException e) {
                System.err.println("Could not listen on port: "+port);
                System.out.println(e);
                System.exit(1);
            }


        }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }




    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            synchronized (this){
                this.threadRun = Thread.currentThread();
            }
            startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
