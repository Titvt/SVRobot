package Router;

import Bean.MessageBean;
import Notice.Notice;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStreamReader;

public class Router implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        MessageBean messageBean = new Gson().fromJson(new InputStreamReader(httpExchange.getRequestBody()), MessageBean.class);
        new Notice(messageBean);
        httpExchange.close();
    }
}