package SVRobot;

import Manager.ExcelManager;
import Router.Router;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SVRobot {
    public static void main(String[] args) {
        ExcelManager.init();
        HttpServer httpServer;
        try {
            httpServer = HttpServerProvider.provider().createHttpServer(new InetSocketAddress(5701), Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        httpServer.createContext("/", new Router());
        httpServer.setExecutor(Executors.newCachedThreadPool());
        httpServer.start();
    }
}