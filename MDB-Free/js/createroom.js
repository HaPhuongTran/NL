$(document).ready(function(){
	var getNameHome = localStorage.getItem("storageNameHome");
	var dataHome;
	var status_create;
	var loadRoom = 0;
	var dataRoomGet;
	var listRoom;
	var nameRoom;

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
		$("#name_input"+loadRoom).val(listRoom[loadRoom].nameRoom);
		$("#id_input"+loadRoom).val(listRoom[loadRoom].id);
		save(loadRoom);
		enterRoom(loadRoom);
	}
});