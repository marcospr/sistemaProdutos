
function executar(idForm,metodoDesejado){
	document.getElementById(idForm).method.value=metodoDesejado;
	document.getElementById(idForm).target='_self';
	document.getElementById(idForm).submit();
}


function executarRelatorio(idForm,metodoDesejado){
	document.getElementById(idForm).method.value=metodoDesejado;
	document.getElementById(idForm).target='_blank';
	document.getElementById(idForm).submit();
}
