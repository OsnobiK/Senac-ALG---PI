
import javax.swing.JOptionPane;

public class CadastroLogin {

    /*
ADO 1 - Atividade em Grupo (Aula 4)

I - Faça uma classe java contendo dois vetores ou crie um objeto java com dois atributos. A ideia é cadastrar uma lista de nomes e uma lista de senhas numéricas, dados que deverão ser digitados via teclado. 

Use a Classe JOptionPane para leitura e exibição dos dados. A classe deverá conter um menu de controle -Tamanho de 5 elementos cada. Opções de menu - 1 ler nome e senha numérica 2 listar nomes e senhas (lado a lado) 3 buscar um nome de forma sequencial 4 buscar uma senha de forma sequencial (trazer a posição caso encontre) 5 classificar por nome usando bubble sort 6 classificar as senhas usando bubble sort. 7 Finalizar.  

II - Responda as questões a seguir

Defina o que você entendeu sobre comportamento assintótico de algoritmos.

Em que consiste a notação Big O.

Em que consiste a notação Big Omega

Em que consiste a notação Big Teta.

Defina uma função constante.

Defina uma função linear.

Defina uma função quadrática / exponencial.
     */
    public static void main(String[] args) {
        //Criando uma lista para os logins de senha e nome dos usuarios
        Login[] listasUsuarios = new Login[5];
        int totalCadastrados = 0;
        String menu = "--- MENU DE LOGINS ---\n"
                + "1. Cadastrar novo usuario\n"
                + "2. Ler nome e senha numerica\n"
                + "3. Listar nomes e senhas\n"
                + "4. Buscar um nome de forma sequencial\n"
                + "5. Buscar uma senha de forma sequencial\n"
                + "6. Classificar por nome\n"
                + "7. Classificar por senha\n"
                + "8. Busca Binaria por senha\n"
                + "9. Sair\n\n"
                + "Escolha uma opção:";
        boolean end = false;
        do {
            String entrada = JOptionPane.showInputDialog(menu);
            int input = Integer.parseInt(entrada);
            switch (input) {
                case 1:
                    if (totalCadastrados < 5) {
                        String nomeUser = JOptionPane.showInputDialog("Digite o nome do Usuario: ");
                        String pswdTexto = JOptionPane.showInputDialog("Digite a Senha do Usuario: ");
                        char[] pswdUser = pswdTexto.toCharArray();//Convertendo o texto Acima ^ para o array de caracter
                        Login novoUser = new Login(nomeUser, pswdUser);//Instanciando no objeto
                        listasUsuarios[totalCadastrados] = novoUser; //salvando na lista de objetos 
                        totalCadastrados++;
                        JOptionPane.showMessageDialog(null, "Cadastros no sistema: " + totalCadastrados + " de 5.  ");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO: Limite de 5 usuários atingido!   ");
                    }
                    ;
                    break;
                case 2:
                    if (totalCadastrados > 0) {
                        int ultimoIndice = totalCadastrados - 1;
                        Login ultimoUser = listasUsuarios[ultimoIndice];
                        String ultimaPswd = new String(ultimoUser.getPswd());
                        String mensagem = "--- ÚLTIMO USUÁRIO CADASTRADO ---\n"
                                + "Nome: " + ultimoUser.getNome() + "\n"
                                + "Senha: " + ultimaPswd;
                        JOptionPane.showMessageDialog(null, mensagem);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado no sistema ainda!");
                    }

                    break;
                case 3:
                    String relatorio = "--- USUÁRIOS CADASTRADOS ---\n";
                    for (int i = 0; i < totalCadastrados; i++) {
                        // Como o getPswd() devolve char[], convertemos para String apenas para exibir
                        String senhaExibicao = new String(listasUsuarios[i].getPswd());
                        relatorio += (i + 1) + ". Nome: " + listasUsuarios[i].getNome()// A string relatorio passa a valer essa string gigante com a atribuição dos valores e um enfeite na saida(pra deixar bonitinho)
                                + " | Senha: " + senhaExibicao + "\n";
                    }
                    if (totalCadastrados == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado ainda.");
                    } else {
                        JOptionPane.showMessageDialog(null, relatorio);
                    }
                    break;
                case 4:
                    if (totalCadastrados == 0) {
                        JOptionPane.showMessageDialog(null, "Não ha Registros para realizar uma busca");
                        break;
                    }
                    String busca = JOptionPane.showInputDialog("Insira o nome do registro que deseja buscar");
                    String Mensagem = "--- RESULTADO DA BUSCA PELO NOME ---";

                    for (int i = 0; i < totalCadastrados; i++) {
                        String senhaBusca = new String(listasUsuarios[i].getPswd());
                        String nomeBusca = listasUsuarios[i].getNome();
                        if (nomeBusca.equals(busca)) {
                            Mensagem += "\nNome: " + listasUsuarios[i].getNome() + "\nSenha: " + senhaBusca;
                            JOptionPane.showMessageDialog(null, Mensagem);
                            break;
                        }
                    }
                case 5:
                    if (totalCadastrados == 0) {
                        JOptionPane.showMessageDialog(null, "Não ha Registros para realizar uma busca");
                        break;
                    }
                    String busca2 = JOptionPane.showInputDialog("Insira a senha do registro que deseja buscar");
                    String Mensagem2 = "--- RESULTADO DA BUSCA PELA SENHA ---";

                    for (int i = 0; i < totalCadastrados; i++) {
                        String senhaBusca = new String(listasUsuarios[i].getPswd());
                        String nomeBusca = listasUsuarios[i].getNome();
                        if (senhaBusca.equals(busca2)) {
                            Mensagem2 += "\nNome: " + listasUsuarios[i].getNome() + "\nSenha: " + senhaBusca;
                            JOptionPane.showMessageDialog(null, Mensagem2);
                            break;
                        }
                    }
                    break;
                case 6:
                    if (totalCadastrados < 2) {
                        JOptionPane.showMessageDialog(null, "Não há registros suficientes para ordenar (mínimo 2).");
                    } else {
                        // 1. Executa o algoritmo Bubble Sort pelos nomes (Ordem Alfabética)
                        for (int i = 0; i < totalCadastrados - 1; i++) {
                            for (int j = 0; j < totalCadastrados - 1 - i; j++) {

                                String nomeAtual = listasUsuarios[j].getNome();
                                String nomeProximo = listasUsuarios[j + 1].getNome();

                                // .compareToIgnoreCase ignora se a letra é maiúscula ou minúscula na hora de ordenar
                                // Se o resultado for maior que 0, significa que o nomeAtual deve ir para depois do nomeProximo
                                if (nomeAtual.compareToIgnoreCase(nomeProximo) > 0) {
                                    // Executa a mesma dança das cadeiras com o objeto auxiliar
                                    Login aux = listasUsuarios[j];
                                    listasUsuarios[j] = listasUsuarios[j + 1];
                                    listasUsuarios[j + 1] = aux;
                                }
                            }
                        }

                        // 2. Monta e exibe o relatório direto na tela
                        String relatorioOrdenado = "--- SISTEMA CLASSIFICADO POR NOME ---\n";
                        for (int i = 0; i < totalCadastrados; i++) {
                            String senhaExibicao = new String(listasUsuarios[i].getPswd());
                            relatorioOrdenado += (i + 1) + ". Nome: " + listasUsuarios[i].getNome() + " | Senha: " + senhaExibicao + "\n";
                        }
                        JOptionPane.showMessageDialog(null, relatorioOrdenado);
                    }
                    break;
                case 7:
                    if (totalCadastrados < 2) {
                        JOptionPane.showMessageDialog(null, "Não há registros suficientes para ordenar (mínimo 2).");
                    } else {
                        // 1. Executa o algoritmo Bubble Sort pelas senhas
                        for (int i = 0; i < totalCadastrados - 1; i++) {
                            for (int j = 0; j < totalCadastrados - 1 - i; j++) {

                                int senhaAtual = Integer.parseInt(new String(listasUsuarios[j].getPswd()));
                                int senhaProxima = Integer.parseInt(new String(listasUsuarios[j + 1].getPswd()));

                                if (senhaAtual > senhaProxima) {
                                    Login aux = listasUsuarios[j];
                                    listasUsuarios[j] = listasUsuarios[j + 1];
                                    listasUsuarios[j + 1] = aux;
                                }
                            }
                        }

                        // 2. Monta e exibe o relatório direto na tela
                        String relatorioOrdenado = "--- SISTEMA CLASSIFICADO POR SENHA ---\n";
                        for (int i = 0; i < totalCadastrados; i++) {
                            String senhaExibicao = new String(listasUsuarios[i].getPswd());
                            relatorioOrdenado += (i + 1) + ". Nome: " + listasUsuarios[i].getNome() + " | Senha: " + senhaExibicao + "\n";
                        }
                        JOptionPane.showMessageDialog(null, relatorioOrdenado);
                    }
                    break;
                case 8:
                    String Alvo = JOptionPane.showInputDialog("Digite a Senha que deseja encontrar?");
                    int alvo1 = Integer.parseInt(Alvo);
                    int inicio = 0;
                    int fim = listasUsuarios.length - 1;
                    int resultado = -1;

                //4 Busque uma senha por busca binária e exiba o nome encontrado
                //juntamente com a senha e a posição
                case 9:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    end = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO!\n\nInsira uma opção valida!");
                    end = false;
                    break;
            }

        } while (!end);
    }
}
