package CallApi;

import Bean.ReturnBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallApi {
    @GET("send_group_msg")
    Call<ReturnBean> sendGroupMessage(@Query("group_id") long group_id, @Query("message") String message);
}