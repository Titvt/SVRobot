package CallApi;

import Bean.ReturnBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallApi {
    @GET("send_private_msg")
    Call<ReturnBean> sendPrivateMessage(@Query("user_id") long user_id, @Query("message") String message);

    @GET("send_group_msg")
    Call<ReturnBean> sendGroupMessage(@Query("group_id") long group_id, @Query("message") String message);
}