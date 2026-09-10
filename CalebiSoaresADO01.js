export class Camarao {
    constructor ( nome ) {
        this.nome = nome;
        if (this.nome === "Camarão-Mantis") {
            this.expectativaAnos = 5;
            this.habitat = "Recifes de corais e fendas em águas tropicais";
            this.cor = "Arco-íris (extremamente colorido e vibrante)";
            this.alimento = "Caranguejos, moluscos, caracóis e peixes";
            this.curiosidade = "Possui 16 receptores de cores nos olhos e enxerga luz ultravioleta e polarizada.";
        }
        else if (this.nome === "Camarão-Pistola") {
            this.expectativaAnos = 3;
            this.habitat = "Recifes de corais e fundos lamacentos ou arenosos";
            this.cor = "Geralmente esverdeado, marrom ou translúcido";
            this.alimento = "Pequenos peixes, outros camarões e caranguejos";
            this.curiosidade = "Seu estalo gera uma temperatura momentânea de 4.400°C, quase a temperatura do Sol.";
        }
        else {
            this.expectativaAnos = 0;
            this.habitat = "Desconhecido";
            this.cor = "Desconhecida";
            this.alimento = "Desconhecido";
            this.curiosidade = "Animal não cadastrado no sistema.";
            console.log(`[AVISO] O nome "${nome}" não é válido. Escolha "Camarão-Mantis" ou "Camarão-Pistola".`);
        }
    }
    MetododeCaca(arma) {
        if (this.nome === "Camarão-Mantis") {
            arma = "Braço-Porrete";
            console.log(`O ${this.nome} desferiu um golpe devastador com seu ${arma} na velocidade de uma bala, quebrando o vidro do aquário!`);
        }
        else if (this.nome === "Camarão-Pistola") {
            arma = "Garra-Pistola";
            console.log(`O ${this.nome} disparou sua ${arma}, gerando uma bolha de choque a 4.400°C que atordoou a presa com um estalo ensurdecedor!`);
        }
        else {
            console.log(`[ERRO] Animal inválido. Este programa aceita apenas "Camarão-Mantis" ou "Camarão-Pistola".`);
        }
    }
    verificarPredador() {
        let predadores;
        if (this.nome === "Camarão-Mantis") {
            predadores = "Polvos, Tubarões e Garoupas";
            console.log(`Cuidado! O ${this.nome} precisa se esconder na toca, pois seus principais predadores são: ${predadores}.`);
        }
        else if (this.nome === "Camarão-Pistola") {
            predadores = "Moreias e Peixes Grandes";
            console.log(`Perigo! O ${this.nome} depende do seu peixe vigia para não ser engolido por ${predadores}.`);
        }
        else {
            console.log(`[ERRO] Não foi possível verificar predadores. Escolha entre "Camarão-Mantis" ou "Camarão-Pistola".`);
        }
    }
}
