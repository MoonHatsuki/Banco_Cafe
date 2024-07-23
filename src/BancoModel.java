public class BancoModel {
    private String tipoConta;
    private String nome;
    private double saldo;

    public BancoModel(String tipoConta, String nome, double saldo) {
        this.tipoConta = tipoConta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
