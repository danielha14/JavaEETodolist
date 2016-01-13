/**
 * Created by DANIEL on 09/12/2015.
 */

var elementId = 0;
var itemid = 0 ;
$(function(){
    var $template = $(".template");
    var hash = 2;

//$('#signinid').click(function(){
//	$.ajax({
//		url : 'controller/addItem',
//		data : {email:$('email').val(),
//			password:$('password').val()},
//			success : function(ressponse){
//				$('#ajaxGetUserServletResponse').text(responseText);
//			}
//	});
//});
  
//add todoItem
    $(".btn-add-panel").on("click",function(){
        itemid++;
       var todoItem =  $("<div>").attr({'class':'panel panel-default template','id':itemid})
        .append($('<div>').attr({'class':'panel-heading'})
        .append($('<h4>').attr({'class':'panel-title'})
                .append($('<a>ToDoItem</a>')
                    .attr({'data-toggle':'collapse','data-parent':'#accordion','href':'#col-'+itemid}))))
        .append($('<div>').attr({'id':'col-'+itemid,'class':'panel-collapse collapse'})
                .append($('<div>Title:</div>').attr({'class':'panel-body'}))
                .append($('<div> Description : </div>').attr({'class':'panel-body'}))
                .append($('<div>').attr({'class':'panel-footer'})
                    .append($('<a>Delete</a>')
                    .attr({'id':itemid,'type':'button','class':'btn item-delete btn-sm btn-primary'}))));

        $("#accordion").append(todoItem);
    });

//delete todoItem
     $(".container").on('click','.item-delete',function(){
        var itemId = $(this).attr("id");
         $("#"+itemId).remove("div,.panel");
        // $("#"+itemId).toggleClass('myClass');
         //alert(itemId);
    });

    $("h3").hide().show(2000);

});