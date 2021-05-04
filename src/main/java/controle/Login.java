package controle;

import java.util.Scanner;

public class Login {
    public static void fazLogin() {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite seu nome de usuário: ");
            try {

                String nomeUsuario = sc.nextLine();
                if (nomeUsuario.equals("cliente")) {
                    try{
                        System.out.println("Digite sua senha: ");
                        String senhaUsuario = sc.nextLine();
                        if(senhaUsuario.equals("cliente")){
                            System.out.println("senha correta! bem vindo/a!");
                            break;
                        }
                        else{
                            System.out.println("senha incorreta");
                        }
                    }catch (Exception e) {
                        System.out.println("digite seu nome de usuário");
                    }
                    break;
                } else if (nomeUsuario.equals("funcionario")) {
                    System.out.println("digite sua senha");
                    break;
                } else {
                    System.out.println("nome ou senha inválidos");
                }

            } catch (Exception e) {
                System.out.println("digite seu nome de usuário");
            }
        }
    }
}
