package SVRobot;

import Router.Router;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SVRobot {
    public static void main(String[] args) {
        HttpServer httpserver;
        try {
            httpserver = HttpServerProvider.provider().createHttpServer(new InetSocketAddress(5701), Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        httpserver.createContext("/", new Router());
        httpserver.setExecutor(Executors.newCachedThreadPool());
        System.out.println("=== Start Server ===");
        httpserver.start();
    }
}
