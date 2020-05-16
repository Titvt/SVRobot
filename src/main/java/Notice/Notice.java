package Notice;

import Bean.ExcelBean;
import Bean.MessageBean;
import Bean.ReturnBean;
import CallApi.CallApi;
import Manager.ExcelManager;
import Manager.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Notice {
    public Notice(MessageBean messageBean) {
        if (!"message".equals(messageBean.getPost_type()))
            return;
        if (!"private".equals(messageBean.getMessage_type()))
            return;
        if (!messageBean.getRaw_message().startsWith("通知"))
            return;
        List<ExcelBean> excels = ExcelManager.getExcels();
        String name = null;
        for (ExcelBean excel : excels)
            if (messageBean.getUser_id() == excel.getQQ() && "辅导员".equals(excel.getRole())) {
                name = excel.getName();
                break;
            }
        if (name == null)
            return;
        if (messageBean.getRaw_message().startsWith("通知所有人 ")) {
            CallApi callApi = RetrofitManager.getInstance().create(CallApi.class);
            for (ExcelBean excel : excels)
                if (!"辅导员".equals(excel.getRole()))
                    callApi.sendPrivateMessage(excel.getQQ(), "辅导员 " + name + " 发布了通知：\n" + messageBean.getRaw_message().substring(6)).enqueue(new Callback<ReturnBean>() {
                        @Override
                        public void onResponse(Call<ReturnBean> call, Response<ReturnBean> response) {

                        }

                        @Override
                        public void onFailure(Call<ReturnBean> call, Throwable t) {

                        }
                    });
        } else {
            String part = messageBean.getRaw_message().substring(2);
            String role = part.substring(0, part.indexOf(' '));
            CallApi callApi = RetrofitManager.getInstance().create(CallApi.class);
            for (ExcelBean excel : excels)
                if (role.equals(excel.getRole()))
                    callApi.sendPrivateMessage(excel.getQQ(), "辅导员 " + name + " 发布了通知：\n" + messageBean.getRaw_message().substring(role.length() + 3)).enqueue(new Callback<ReturnBean>() {
                        @Override
                        public void onResponse(Call<ReturnBean> call, Response<ReturnBean> response) {

                        }

                        @Override
                        public void onFailure(Call<ReturnBean> call, Throwable t) {

                        }
                    });
        }
    }
}