<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/appjs.js"></script>
    
    <style>
        .myClass {
            background-color: #d7eee3;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>ToDo Items List</h1>
    </div>

    <div class="row">
        <div class="col-sm-6">
            <h3>ToDoItem Title</h3>
            <h3>Hello! here all the tasks you have </h3>
        </div>

        <div class="col-sm-6">
            <button  type="button" class="btn btn-sm btn-primary btn-add-panel">
                <i class="glyphicon glyphicon-plus"></i>
                Add ToDoItem
            </button>
        </div>

    </div><!-- /row 1 -->
    <div class="row">
        <div class="col-sm-6">
            <div  class="panel-group" id="accordion">

                <div  id="del" class="panel panel-default template">
                    <div class="panel-heading" >
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">ToDoItem Title</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <div class="panel-body">Title :</div>
                        <div class="panel-body">Description :</div>
                        <div class="panel-footer">
                            <a id="del" type="button" class="btn item-delete btn-sm btn-primary">Delete</a>
                        </div>
                    </div><!-- /collapse content -->
                </div><!-- /panel-1 -->

            </div><!-- /panel-group -->
        </div>
    </div>
</div><!-- /main container -->

</body>
</html>
    