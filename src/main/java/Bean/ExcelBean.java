package Bean;

public class ExcelBean {
    private long QQ;
    private String name;
    private String role;

    public ExcelBean(long QQ, String name, String role) {
        this.QQ = QQ;
        this.name = name;
        this.role = role;
    }

    public long getQQ() {
        return QQ;
    }

    public void setQQ(long QQ) {
        this.QQ = QQ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}