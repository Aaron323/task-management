$(function () {
   $("#add").click(function () {
      $("#add_form").dialog({
          resizable: false,
          height: "auto",
          width: 420,
          modal: true,
          draggable: false,
          title: "添加任务",
          buttons: {
              "添加": function(){
                  $("#add_submit").click();
                  $(this).dialog("close");
              },
              "取消": function(){
                  $(this).dialog("close");
              }
          },
          open: function() {
              $('.ui-widget-overlay').css({ opacity: ".6" });
              $("#addStartTime").datepicker({
                  showOtherMonths: true,
                  selectOtherMonths: true,
                  showButtonPanel: true,
                  changeMonth: true,
                  changeYear: true,
                  dateFormat: "yy-mm-dd"
              });
              $("#addStopTime").datepicker({
                  showOtherMonths: true,
                  selectOtherMonths: true,
                  showButtonPanel: true,
                  changeMonth: true,
                  changeYear: true,
                  dateFormat: "yy-mm-dd"
              });
          }
      });
   });
    $(".edit").click(function () {
        var getURL = $("#context").val() + "/task/"+ $(this).attr("href");
        var url = $("#context").val() + "/task/edit";
        $("#edit_form").dialog({
            resizable: false,
            height: "auto",
            width: 420,
            modal: true,
            draggable: false,
            title: "编辑任务",
            buttons: {
                "添加": function(){
                    var task = {}
                    task.name = $("#editName").val();
                    task.startTime = $("#editStartTime").val();
                    task.stopTime = $("#editStopTime").val();
                    task.duration = $("#editDuration").val();
                    task.progress = $("#editProgress").val();
                    task.priority = $("#editPriority").val();
                    task.resourceId = $("#editResourceId").val();
                    $.ajax({
                        data: task,
                        type: "POST",
                        url: url,
                        complete: window.location.href = $("#context").val() + "task"
                    });
                },
                "取消": function(){
                    $(this).dialog("close");
                }
            },
            open: function() {
                $('.ui-widget-overlay').css({ opacity: ".6" });
                $("#editStartTime").datepicker({
                    showOtherMonths: true,
                    selectOtherMonths: true,
                    showButtonPanel: true,
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "yy-mm-dd"
                });
                $("#editStopTime").datepicker({
                    showOtherMonths: true,
                    selectOtherMonths: true,
                    showButtonPanel: true,
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "yy-mm-dd"
                });
                $.ajax({
                    type: "GET",
                    url: getURL,
                    success: function (task) {
                        $("#editName").val(task.name);
                        var startTime = task.startTime.substr(0, 10);
                        $("#editStartTime").val(startTime);
                        var stopTime = task.stopTime.substr(0, 10);
                        $("#editStopTime").val(stopTime);
                        $("#editDuration").val(task.duration);
                        $("#editProgress").val(task.progress);
                        $("#editPriority").val(task.priority);
                        $("#editResourceId").val(task.resourceId);
                    }
                });
            }
        });
        return false;
    });
   $(".delete").click(function () {
       var url = $(this).attr("href");
       $("#delete_form").dialog({
           resizable: false,
           height: 200,
           width: 400,
           modal: true,
           draggable: false,
           title: "提示",
           buttons: {
               "确定": function() {
                   $.ajax({
                       type: "POST",
                       url: url,
                       complete: window.location.href = $("#context").val() + "task"
                   });
               },
               "取消": function() {
                   $(this).dialog("close");
               }
           },
           open: function() {
               $('.ui-widget-overlay').css({ opacity: ".6" });
           },
       });
       return false;
   });
});