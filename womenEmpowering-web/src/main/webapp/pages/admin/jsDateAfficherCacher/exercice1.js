$(document).ready(function(){

$('#validateSalaire2').click(function(){
	$("p").show();
});

$('#validateSalaire2').dblclick(function(){
	$('p').hide('slow');
});
$('#basculer').mousedown(function(){
	$('img').slideToggle();
});

})