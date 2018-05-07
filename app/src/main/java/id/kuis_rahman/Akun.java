package id.kuis_rahman;

public class Akun {
    String id, passwd;
    int saldo;

    public Akun(String id, String passwd, int saldo) {
        this.id = id;
        this.passwd = passwd;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
