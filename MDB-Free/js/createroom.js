$(document).ready(function(){
	var getNameHome = localStorage.getItem("storageNameHome");
	var dataHome;
	var status_create;
	var loadRoom = 0;
	var dataRoomGet;
	var listRoom;
	var nameRoom;

	$(".room-table").hide();
	//Begin get home
	$.ajax({
			async : false,
			method: "get",
			contentType: "application/json",
			url: "http://localhost:8080/smarthome/gethome/"+getNameHome,
	}).done(function(data, textStatus, xhr){
		dataHome = data;
	});
	//End get Home


	//Begin list room
	$.ajax({
			async : false,
			method: "get",
			contentType: "application/json",
			url: "http://localhost:8080/smarthome/getlistrooms/"+ getNameHome,
	}).done(function(data, textStatus, xhr){
		listRoom = data;
	});
	//End get list room


	for(loadRoom; loadRoom < listRoom.length; loadRoom++){
		appentRoom(loadRoom);
		$(".nameroom"+loadRoom).val(listRoom[loadRoom].nameRoom);
		$(".idroom"+loadRoom).val(listRoom[loadRoom].id);
		save(loadRoom);
	}


	function appentRoom(countRoom){
  		$("tbody").append(
  			"<tr class = 'row"+countRoom+"'>"
  				+ "<td class = 'roomnamecol"+countRoom+"'>"
  				+ "<input placeholder='Room Name' type='text' id='nameroom' class='form-control nameroom"+countRoom+"'>"
  				+ "<input type='hidden' class='form-control idroom"+countRoom+"'>"
  				+ "</td>"

  				+ "<td class = 'componentcol"+countRoom+"'>"
  				+ "<a class='trigger teal lighten-4 component"+countRoom+"'>No component in this room</a>"
  				+ "<a class='trigger info-color text-white add-component"+countRoom+"'>Add<i class='fa fa-plus ml-2'></i></a>"
  				+ "</td>"

  				+ "<td class = 'closecol"+countRoom+"'>"
  				+ "<a><i class='fa fa-save mx-1 save-btn"+countRoom+"'></i></a>"
  				+ "<a><i class='fa fa-times mx-1 delete-btn"+countRoom+"'></i></a>"
  				+ "</td>"
  			+"</tr>");
  		deleteRoom(countRoom);
  		$(".room-table").show();
	}


	function deleteRoom(countRoom){
		$(".delete-btn"+countRoom).click(function(){
			$(".row"+countRoom).remove();
		});
	}


	function save(saveCount){
		  	$(".save-btn"+saveCount).click(function(){
  			nameRoom = $(".nameroom"+ saveCount).val();
  			var idRoom = parseInt($(".idroom"+ saveCount).val());
  			if(isNaN(idRoom)|| idRoom == null){
  				idRoom = 0;
  			}
  			//Begin create room
		    $.ajax({
				async : false,
				method: "post",
				data: JSON.stringify({ id: idRoom, homeId:dataHome, nameRoom:nameRoom }),
				contentType: "application/json",
				url: "http://localhost:8080/smarthome/createroom"
			}).done(function(data, textStatus, xhr){
				status_create = xhr.status;
			});
			//End create room

			getRoom(saveCount);
		});
	}


	function getRoom(getRoomCount){
	    $.ajax({
		async : false,
		method: "get",
		contentType: "application/json",
		url: "http://localhost:8080/smarthome/getroom/"+ nameRoom,
		}).done(function(data, textStatus, xhr){
			dataRoomGet = data;
		});
		
		// Set value for fields value 
		$(".nameroom"+getRoomCount).val(dataRoomGet.nameRoom);
		$(".idroom"+getRoomCount).val(dataRoomGet.id);
	}

	function addcomponent(addCount){
		$(".add-component"+addCount).click(function(){
			//edit tag "<a class='trigger teal lighten-4 component"+countRoom+"'>No component in this room</a>" 
			// become multiselect
			// create new branch before edit
		});
	}


  	$(".add-btn").click(function(){
  		appentRoom(loadRoom + 1);
 		save(loadRoom + 1);
		loadRoom++;
  	});
});