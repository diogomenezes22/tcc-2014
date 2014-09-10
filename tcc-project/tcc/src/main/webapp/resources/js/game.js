/**
 *  Game Control
 */
$( document ).ready(function(){

});
 
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

function moverPeca(){
	var id = $("#peaoId").val();
	var nome = $("#jogadorNome").val();
	var posicaoAtual = $("#peaoPosicaoAtual").val();
	var jogadorAtual = new Peao(id, nome, posicaoAtual);
	var podeAndar = $("#peaoPodeAndar").val();
	var proximaCasa = $("#peaoProximaPosicao").val();
	
	var passos = proximaCasa - jogadorAtual.posicao;
	
	if(podeAndar =="true"){
		andar(jogadorAtual.id, jogadorAtual.idCasa, passos);
	}	
}


