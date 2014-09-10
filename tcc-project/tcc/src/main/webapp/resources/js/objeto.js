/**
 *  Object Domain
 */
var CASA = '#casa';

function Peao( _id, _nome, _posicao){
	this.id =  _id;
	this.nome = _nome;
	this.posicao = _posicao;
	this.idCasa = CASA + _posicao;	
}

function Casa(_id, _tipo, _peoes){
	this.id = '#' + _id;
	this.tipo = _tipo;
	this.peoes = _peoes;
}

