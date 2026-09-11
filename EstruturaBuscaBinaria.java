
public class EstruturaBuscaBinaria {
// Criando um array tradicional de objetos (já ordenados por ID)

    Produto[] lista = {
        new Produto(10, "Mouse"),
        new Produto(20, "Teclado"),
        new Produto(30, "Monitor")
    };

    int idAlvo = 20;
    int inicio = 0;
    int fim = lista.length - 1; // Array tradicional usa .length
    int resultado = -1;


while (inicio <= fim) {
    int meio = inicio + (fim - inicio) / 2;
    
    // Sintaxe: acessa a posição do array e depois o atributo do objeto
    if (lista[meio].id == idAlvo) {
        resultado = meio;
        break;
    }
    
    if (lista[meio].id < idAlvo) {
        inicio = meio + 1;
    } else {
        fim = meio - 1;
    }
}

}
