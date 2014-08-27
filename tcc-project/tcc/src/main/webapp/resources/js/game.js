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

function habilitarCasa(id){
	$('#' + id).hide('slow');
	$('#' + id).removeClass('casaInativa');
	$('#' + id).addClass('casaAtiva');
	$('#' + id).show('slow');
	
	$('#' +id).droppable({
      drop: function( event, ui ) {
          $( this ).addClass("casaOcupada");
          $( this ).removeClass('casaAtiva');
        }
      });

}

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
}}

function sortearDado(){
	numeroSorteado = Math.floor((Math.random() * 6 +1));
	alert("Número sorteado " + numeroSorteado);
	//chamar pergunta
	//se acertou 
	atualizarJogador();	
	habilitarCasa(jogadorAtual.idCasa);
	//ator deve mover sua peça
		$(jogadorAtual.id).draggable({
			drag: function(event, ui){
				//alert("joguei");
			}
		});
		//apos movido desabilita e passa a vez;
	//se não passa a vez e paga prenda
	
	
	}
