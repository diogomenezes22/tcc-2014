/**
 *  Game Control
 */
$( document ).ready(function(){

});
 

function moverPeca(){
	var jogador = $("#jogadorAtual").val().split(',');
	
	var jogadorAtual = new Peao('jogador' + jogador[0], jogador[1], jogador[2]);
	var podeAndar = jogador[3];
	var proximaCasa = jogador[4];
	var andar = proximaCasa - jogadorAtual.posicao;
	
	if(podeAndar =="true"){
		andar(jogadorAtual.id, jogadorAtual.idCasa, andar);
	}	
}




function andar(idJogador, idCasa, andar){
	for(var i = 0; i < andar; i++ ){
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

