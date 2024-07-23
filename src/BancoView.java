import java.util.Formatter;
import java.util.Scanner;

public class BancoView {
    public static void TelaCadastro() {
        Scanner s = new Scanner(System.in);
        System.out.println("Bem Vindo(a) ao banco!");
        System.out.println("----- Cadastro -----");
        System.out.println("Nome: ");
        String nome = s.nextLine();
        System.out.println("Tipo de conta ([1] Corrente [2] Poupança): ");
        int respTipoConta = s.nextInt();
        System.out.println("Saldo: ");
        double saldo = s.nextDouble();
        String tipoConta = BancoController.VerificarTipoConta(respTipoConta);
        BancoController.bancoModel = new BancoModel(tipoConta, nome, saldo);
    }
    public static void InfosUsuario(){
        var retorno = String.format("""
    ---------------------------------------
    Nome: %s
    Conta %s
    Saldo: %.2f
    ---------------------------------------
    """, BancoController.bancoModel.getNome(), BancoController.bancoModel.getTipoConta(), BancoController.bancoModel.getSaldo()) ;
        System.out.println(retorno);
    }


    public static void apresentaOperacoes() {
        BancoController.ClearConsole();
        System.out.println("""
                ***********
                Operacoes
                ***********
                                
                1- Verificar Saldo
                2- Receber valor
                3- Transferir valor
                4- Sair
                        
                Digite a opcao desejada: 
                """);
    }

    public static void MostraSaldo() {
        System.out.println("Saldo atual: " + BancoController.bancoModel.getSaldo());
    }

    public static void RecebeValor() {
        try {
            System.out.println("Qual valor você deseja receber?");
            double recebido = new Scanner(System.in).nextDouble();
            BancoController.validarRecebido(recebido);
            BancoController.bancoModel.setSaldo(BancoController.bancoModel.getSaldo() + recebido);
            System.out.println("Saldo atualizado: " + BancoController.bancoModel.getSaldo());
        } catch (Throwable e) {
            System.out.println("Valor de recebimento inválido");
        }
    }

    public static void TransfValor() {
        try {
            System.out.println("Qual valor você deseja transferir?");
            double transferido = new Scanner(System.in).nextDouble();
            BancoController.validarTransferencia(transferido);
            BancoController.bancoModel.setSaldo(BancoController.bancoModel.getSaldo() - transferido);
            System.out.println("Saldo atualizado: " + BancoController.bancoModel.getSaldo());
        } catch (Throwable e) {
            System.out.println("valor de transferência inválido");
        }
    }
}
