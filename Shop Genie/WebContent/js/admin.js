$(document).ready(function(){

$("#showUnverified").click(function(){
  $(this).hide();
  
  });
$("#verify").click(function(){
	var selected = [];
	$('.data input:checked').each(function() {
	    selected.push($(this).val());
	    alert(selected)
	});
	  
	  });

});