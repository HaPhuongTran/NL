$(document).ready(function(){
	$(".contain_form").hide();

    $(".info").click(function(){
        $(".contain_form").show();
    });

    $(".close_button").click(function(){
        $(".contain_form").hide();
    });
	
    $('.create-btn').click(function(){
    	var numberRoom = $("#number_room").val();
    	var nameHome = $("#name_project").val();
    	var data;

    	var request = $.ajax({
			url: "http://localhost:8080/smarthome/createhome/",
			method: 'POST',
			data: { nameHome:nameHome },
			dataType: "json",
			contentType: "application/json"
		});
		request.done(function( msg ) {
		 	alert(msg)
		});
      	// set number room for create_room.js
    	localStorage.setItem("storageNumber",numberRoom);
    });
});