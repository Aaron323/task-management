<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/task/task.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/jquery-ui.min.css">
    <script type="text/javascript" src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/task/task.js"></script>
</head>
<body>
<div id="wrapper">
    <input type="button" value="添加任务" name="add" id="add">
    <table id="tasks">
        <thead>
        <tr>
            <th>任务</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>工期</th>
            <th>进度</th>
            <th>优先级</th>
            <th>资源</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list tasks as task>
            <tr>
                <td>${task.name!'-'}</td>
                <td>${task.startTime!'-'}</td>
                <td>${task.stopTime!'-'}</td>
                <td>${task.duration!'-'}</td>
                <td>${task.progress!'-'}%</td>
                <td>${task.priority!'-'}</td>
                <td>${task.resourceId!'-'}</td>
                <td hidden>${task.id!'-'}</td>
                <td>
                    <a class="edit" href="${task.id}">编辑</a>
                    <a class="delete" href="${request.contextPath}/task/delete/${task.id}">删除</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div id="add_form" class="pop_form "hidden>
        <form action="${request.contextPath}/task/add" method="post">
            <div>
                <label>任务名</label>
                <input type="text" name="name" autocomplete="off">
            </div>
            <div>
                <label>开始时间</label>
                <input type="text" name="startTime" id="addStartTime" autocomplete="off" readonly>
            </div>
            <div>
                <label>结束时间</label>
                <input type="text" name="stopTime" id="addStopTime" autocomplete="off" readonly>
            </div>
            <div>
                <label>工期</label>
                <input type="text" name="duration" autocomplete="off">
            </div>
            <div>
                <label>进度</label>
                <input type="text" name="progress" autocomplete="off">
            </div>
            <div>
                <label>优先级</label>
                <select name="priority">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <div>
                <label>资源</label>
                <select name="resourceId">
                <#list resources as resource>
                    <option name="resourceId" value="${resource.id}">${resource.name}</option>
                </#list>
                </select>
            </div>
            <input type="submit" id="add_submit" hidden>
        </form>
    </div>
    <div id="edit_form" class="pop_form" hidden>
        <form>
            <div>
                <label>任务名</label>
                <input type="text" name="name" id=editName autocomplete="off">
            </div>
            <div>
                <label>开始时间</label>
                <input type="text" name="startTime" id="editStartTime" autocomplete="off" readonly>
            </div>
            <div>
                <label>结束时间</label>
                <input type="text" name="stopTime" id="editStopTime" autocomplete="off" readonly>
            </div>
            <div>
                <label>工期</label>
                <input type="text" name="duration" id="editDuration" autocomplete="off">
            </div>
            <div>
                <label>进度</label>
                <input type="text" name="progress" id="editProgress" autocomplete="off">
            </div>
            <div>
                <label>优先级</label>
                <select name="priority" id="editPriority">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <div>
                <label>资源</label>
                <select name="resourceId" id="editResourceId">
                <#list resources as resource>
                    <option name="resourceId" value="${resource.id}">${resource.name}</option>
                </#list>
                </select>
            </div>
        </form>
    </div>
    <div id="delete_form" hidden>
        <span>确定删除任务吗？</span>
    </div>
    <input type="hidden" id="context" value="${request.contextPath}">
</div>
</body>
</html>