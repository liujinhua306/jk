function main_Record() {
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath }/main_Record.action",
		dataType : 'json',
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				var event;
				if(data[i].event==0){
					event="发送get_post请求失败";
				}else{
					event="ping失败";
				}
				var k = "<tr><td>" + data[i].id + "</td><td>" + data[i].url_ip
						+ "</td><td>" + data[i].date + "</td><td>" + event + "</td></tr>";
				$('#Record').append(k);
			}
		}
	});
}
	function main_all() {
		var startrow= $('#startrow').val();
		var pagesize=$('#pagesize').val();
	$
			.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath }/main_All.action",
				data : {
					"startrow" : startrow,
					"pagesize" : pagesize,
				},
				dataType : 'json',
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						var state;
						var colour;
						if (data[i].state == 0) {
							state = "正常";
							colour = "<tr>";
						} else {
							state = "关闭";
							colour = "<tr class='warning'>";
						}
						var get_post;
						if (data[i].get_Post == 0) {
							get_post = "开启";
						} else {
							get_post = "关闭";
						}
						var state1;
						if (data[i].state == 0) {
							state1 = "关闭";
						} else {
							state1 = "开启";
						}

						var a = colour
								+ "<td>"
								+ data[i].id
								+ "</td><td>"
								+ data[i].url_ip
								+ "</td><td>"
								+ data[i].date
								+ "</td><td>"
								+ data[i].email
								+ "</td><td>"
								+ state
								+ "</td><td><input type='button' class='btn btn-primary' value='"
								+ get_post
								+ "' onclick='get_post("
								+ data[i].id
								+ ")' ></td><td><input type='button' class='btn btn-primary' value='"
								+ state1
								+ "' onclick='state("
								+ data[i].id
								+ ")' ></td><td><input type='button' class='btn btn-primary' onclick='modify("
								+ data[i].id
								+ ")' value='修改'  href='#modal-container-831069' role='button' class='btn' data-toggle='modal'>" +
										"</td><td><input type='button' class='btn btn-danger' onclick='del("+data[i].id+")' value='删除'></td></tr>";
						$('#main_all').append(a);
					}
				}
			});
}
function modify(id) {
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath }/main_Query_modify.action",
		data : {
			"id" : id,
		},
		dataType : 'json',
		success : function(data) {
			$("#modify_url").val("http://"+data[0].url_ip);
			$("#modify_email").val(data[0].email);
			$("#modify_id").val(data[0].id);
		}
	});
}
function get_post(id) {
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath }/main_Requestswitch.action",
		data : {
			"id" : id,
		},
		dataType : 'json',
		success : function(data) {
			alert(data[0]);
			$('#main_all').html("");
			main_all();
		}
	});
}
function state(id) {
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath }/main_State.action",
		data : {
			"id" : id,
		},
		dataType : 'json',
		success : function(data) {
			alert(data[0]);
			$('#main_all').html("");
			main_all();
		}
	});
}
function modify_save() {
	var id = $('#modify_id').val();
	var url = $('#modify_url').val();
	var email = $('#modify_email').val();
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath }/main_modify.action",
		data : {
			"id" : id,
			"modify_url" :url,
			"modify_email" : email,
		},
		dataType : 'json',
		success : function(data) {
			alert(data[0]);
			$('#main_all').html("");
			main_all();
			
		}
	});
}
function del(id){
	{
	    event.returnValue = confirm("删除是不可恢复的，你确认要删除吗？");
	   if(event.returnValue==true){
		   $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath }/main_Del.action",
				data : {
					"id" : id,
				},
				dataType : 'json',
				success : function(data) {
					alert(data[0]);
					$('#main_all').html("");
					main_all();
				}
			});
	   }
	}
}
function add(){
	var url= $('#url').val();
	var email = $('#email').val();

	 $.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath }/main_Add.action",
			data : {
				"ip_Monitor.email" : email,
				"ip_Monitor.url_ip":url,
			},
			dataType : 'json',
			success : function(data) {
				alert(data[0]);
				$('#main_all').html("");
				main_all();
			}
		});
}
function paging(){
	$('#startrow').val("0");
	$('#pagesize').val("5");
}

function pageup(){
	var startrow=$('#startrow').val();
	var pagesize=$('#pagesize').val();
	if(parseInt(startrow)<=0){
	alert("无上一页");
	}else{
		$('#startrow').val(parseInt(startrow)-5);
		$('#pagesize').val(parseInt(pagesize)-5);
		$('#main_all').html("");
		main_all();
	}
}
function nextpage(){
	var startrow=$('#startrow').val();
	var pagesize=$('#pagesize').val();
	var sum;
	 $.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath }/main_COUNT.action",
			dataType : 'json',
			success : function(data) {

				var sum=data[0]/5;
				var pagesize1= pagesize/5;
				if(pagesize1>=sum){
				alert("无下一页");
				}else{
					$('#startrow').val(parseInt(startrow)+5);
					$('#pagesize').val(parseInt(pagesize)+5);
					$('#main_all').html("");
					main_all();
				}
			}
		});
}