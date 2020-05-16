package Router;

import Bean.MessageBean;
import Bean.ReturnBean;
import CallApi.CallApi;
import Manager.RetrofitManager;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStreamReader;

public class Router implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("=== New Http ===");
        MessageBean messageBean = new Gson().fromJson(new InputStreamReader(httpExchange.getRequestBody()), MessageBean.class);
        if ("message".equals(messageBean.getPost_type()) && "group".equals(messageBean.getMessage_type())) {
            CallApi callApi = RetrofitManager.getInstance().create(CallApi.class);
            callApi.sendGroupMessage(messageBean.getGroup_id(), messageBean.getRaw_message()).enqueue(new Callback<ReturnBean>() {
                @Override
                public void onResponse(Call<ReturnBean> call, Response<ReturnBean> response) {

                }

                @Override
                public void onFailure(Call<ReturnBean> call, Throwable t) {

                }
            });
        }
        httpExchange.close();
    }
}
