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
public class Login {

    private String nome;
    private char[] pswd;// Sendo usado justamente para aprender bons metodos e praticar

    //Constructor Completo   V V V
    public Login(String nome, char[] pswd) {
        this.nome = nome;
        //Travinha de segurança para evitar perca de dados dentro do array, caso haja alterações com a classe.
        if (pswd != null) {
            this.pswd = pswd.clone(); //pswd.clone() <-- Evita que alterem o array em algum momento no codigo criando um copia exata dos caracteres da senha
        } else {
            this.pswd = null;
        }

    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Retorna pswd, da mesma forma que fizemos no constructor acima
     * (Usamos o "?"(if) e ":"(else) como uma forma de simplificar o if e else),
     * se estiver com algum registro dentro do array é criado uma copia, senão
     * define o array como nulo.
     */
    public char[] getPswd() {
        return pswd != null ? pswd.clone() : null;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPswd(char[] pswd) {
        this.pswd = pswd != null ? pswd.clone() : null;
    }

}
