public class BancoController {

    public static BancoModel bancoModel;

    public static String VerificarTipoConta(int respTipoConta) {
        if (respTipoConta == 1) {
            return "Corrente";
        } else if (respTipoConta == 2) {
            return "Poupança";
        } else {
            System.out.println("valor Invalido!");
            return "";
        }
    }

    public static void ClearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void validarRecebido(double recebido) throws Exception {
        if (recebido <= 0) {
            throw new Exception();
        }
    }

    public static void validarTransferencia(double transferido) throws Exception {
        if (transferido > bancoModel.getSaldo()) {
            throw new Exception();
        }
    }
}