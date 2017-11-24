$(document).ready(function(){
	$('#inputSeach').css('right','-1500px');
});
	var flag = true;
function activator(){
	if(flag){
		$('#inputSeach').css("right","50px");
		flag = false;
	}
	else{
		$('#inputSeach').css("right","-1500px");
		flag = true;
	}
}