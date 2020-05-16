package Manager;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager INSTANCE;
    private Retrofit retrofit;

    public static RetrofitManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new RetrofitManager();
        return INSTANCE;
    }

    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:5700/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}
