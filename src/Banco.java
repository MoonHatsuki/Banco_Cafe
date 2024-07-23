import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        BancoView.TelaCadastro();
        int op;
        do {
            BancoView.InfosUsuario();
            BancoView.apresentaOperacoes();
            Scanner s = new Scanner(System.in);
            op = s.nextInt();
            switch (op) {

                case 1:
                    BancoView.MostraSaldo();
                    break;
                case 2:
                    BancoView.RecebeValor();
                    break;
                case 3:
                    BancoView.TransfValor();
                    break;
                case 4:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (op != 4);
    }
}