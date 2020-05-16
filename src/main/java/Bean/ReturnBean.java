package Bean;

public class ReturnBean {
    private String status;
    private int retcode;
    private ReturnDataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public ReturnDataBean getData() {
        return data;
    }

    public void setData(ReturnDataBean data) {
        this.data = data;
    }
}