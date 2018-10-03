$(document).ready(function(){
	var getNameHome = localStorage.getItem("storageNameHome");
	var idHome;
	var status_create;
	var count = 1;
	var dataRoomGet;
	$.ajax({
			async : false,
			method: "get",
			contentType: "application/json",
			url: "http://localhost:8080/smarthome/gethome/"+getNameHome,
	}).done(function(data, textStatus, xhr){
		idHome = data;
		//alert(idHome.id);
	});

	// $.ajax({
	// 		async : false,
	// 		method: "get",
	// 		contentType: "application/json",
	// 		url: "http://localhost:8080/smarthome/getlistrooms/"+getNameHome,
	// }).done(function(data, textStatus, xhr){
	// 	//idHome = data;
	// 	// alert(data[0].nameRoom);
	// });

  	$(".button-add").click(function(){
  		
  		$(".row").append("<div class='col-sm-3 room rroom"+count+"'></div>");
  		$(".rroom"+count).append("<div class='hovereffect hover"+count+"'></div>");
  		$(".hover"+count).append("<img class='img-fluid img-room' src='images/room-icon.jpg'>");
  		$(".hover"+count).append("<div class='overlay olay"+count+"'></div>");
  		$(".olay"+count).append("<input id='name_input"+count+"' name='name_input' type ='text' placeholder = 'Enter name room'>");
  		$(".olay"+count).append("<input id='id_input"+count+"' type='text'>0");
  		$(".olay"+count).append("<p class= 'adbtn"+count+"'></p>");
  		$(".adbtn"+count).append("<button class = 'btn_enter"+count+"'>Enter Room</button>");
  		$(".adbtn"+count).append("<button class = 'btn_enter' id= 'btn-save"+count+"'>Save</button>");
  		$("#btn-save"+count).click(function(){
  			var nameRoom = $("#name_input"+$(this).attr("id").substr(-1)).val();
  			var idRoom = parseInt($("#id_input"+$(this).attr("id").substr(-1)).val());
  			if(isNaN(idRoom)|| idRoom == null){
  				idRoom = 0;
  			}
		/*********************************************************************************/
			// Begin save request
		    $.ajax({
				async : false,
				method: "post",
				data: JSON.stringify({ id: idRoom, homeId:idHome, nameRoom:nameRoom }),
				contentType: "application/json",
				url: "http://localhost:8080/smarthome/createroom/"+ idRoom
			}).done(function(data, textStatus, xhr){
				status_create = xhr.status;
			});
			//End save request
		/**********************************************************************************/

		/*********************************************************************************/
		if(status_create == 201){
			// Begin get request
		    $.ajax({
			async : false,
			method: "get",
			contentType: "application/json",
			url: "http://localhost:8080/smarthome/getroom/"+ nameRoom,
			}).done(function(data, textStatus, xhr){
				dataRoomGet = data;
			});
			//End get request
			
			// Set value for fields value 
			$("#name_input"+$(this).attr("id").substr(-1)).val(dataRoomGet.nameRoom);
			$("#id_input"+$(this).attr("id").substr(-1)).val(dataRoomGet.id);
		}
		/**********************************************************************************/

		});
		count++;
  	});
})