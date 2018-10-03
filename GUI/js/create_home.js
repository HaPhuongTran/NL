$(document).ready(function(){
	$(".contain_form").hide();

    $(".info").click(function(){
        $(".contain_form").show();
    });

    $(".close_button").click(function(){
        $(".contain_form").hide();
    });
    var status_create = 0;
    $(".create-btn").click(function(){
    	var nameHome = $("#name_project").val();
    	var numberRoom = $("#number_room").val();

    	$.ajax({
			async : false,
			method: "post",
			data: JSON.stringify({ nameHome:nameHome }),
			contentType: "application/json",
			url: "http://localhost:8080/smarthome/createhome/"
		}).done(function(data, textStatus, xhr){
			status_create = xhr.status;
		});

		if(status_create == 201){
			localStorage.setItem("storageNumber",numberRoom);
			localStorage.setItem("storageNameHome",nameHome);
			document.location.href = "newproject.html";
		}
    });
});