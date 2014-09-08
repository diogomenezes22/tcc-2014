/**
 *  Game Control
 */
var jogadorAtual = null;
var numeroSorteado = '';
var peao1 = null;
var peao2 = null;
var peao3 = null;
var peao4 = null;
var peao5 = null;

$( document ).ready(function(){
	peao1 = new Peao("jogador1", "juca", 0);
	peao2 = new Peao("jogador2", "ganso", 0);
	jogadorAtual = peao1;
	
});

function atualizarJogador(){
	jogadorAtual.posicao += numeroSorteado;
	jogadorAtual.idCasa = CASA + jogadorAtual.posicao;
	
	if(peao1.id === jogadorAtual.id){
		peao1 = jogadorAtual;
	}else if(peao2.id === jogadorAtual.id){
		peao2 === jogadorAtual;
	}else if(peao3.id === jogadorAtual.id){
		peao3 = jogadorAtual;
	}else if(peao4.id === jogadorAtual.id){
		peao4 = jogadorAtual;
	}else if(peao5.id === jogadorAtual.id){
		peao4 = jogadorAtual;
	}
}

function alternaJogador(){
	if(jogadorAtual === peao1){
		jogadorAtual = peao2;
	}else if(jogadorAtual == peao2){
		jogadorAtual = peao1;
	}
} 

function sortearDado(){
	numeroSorteado = Math.floor((Math.random() * 6 +1));
	alert("Número sorteado " + numeroSorteado);
	//chamar pergunta
	//se acertou
	
	var testeJogador = $("#jogadorAtual").val();
	
	moverPeca(jogadorAtual.id, jogadorAtual.idCasa, numeroSorteado);
	atualizarJogador();
	alternaJogador();
	//ator deve mover sua peça
		//apos movido desabilita e passa a vez;
	//se não passa a vez e paga prenda
	
	
}

function moverPeca(idJogador, idCasa, casas){
	for(var i = 0; i < casas; i++ ){
		$(idJogador).animate({opacity : '0.8'}, 500, function(){
			if(idCasa.length == 6){
				nCasa = idCasa.substr(idCasa.length - 1, idCasa.length);
			}
			else{
				nCasa = idCasa.substr(idCasa.length - 2, idCasa.length);
			}
			idCasa = idCasa.replace(nCasa, "");
			nCasa++;
			idCasa = idCasa.concat(nCasa);
			var jogador = $(idJogador);
			$(idCasa).append(jogador);
		});
	}
}

