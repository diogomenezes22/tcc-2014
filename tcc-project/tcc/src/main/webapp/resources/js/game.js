/**
 *  Game Control
 */

$( document ).ready(function(){
	$("#botao1").draggable({
		drag: function(event, ui){
			idPeaoJogado = TRALHA + $(this).attr("id");
		}
	});
});