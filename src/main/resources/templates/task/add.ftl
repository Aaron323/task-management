<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加任务</title>
</head>
<body>
<div id="wrapper">
    <form action="${request.contextPath}/task/add" method="post">
        <div>
            <label>任务名</label>
            <input type="text" name="name">
        </div>
        <div>
            <label>开始时间</label>
            <input type="text" name="startTime">
        </div>
        <div>
            <label>结束时间</label>
            <input type="text" name="stopTime">
        </div>
        <div>
            <label>工期</label>
            <input type="text" name="duration">
        </div>
        <div>
            <label>进度</label>
            <input type="text" name="progress">
        </div>
        <div>
            <label>优先级</label>
            <select>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
        </div>
        <div>
            <label>资源</label>
            <select>
                <#list resources as resource>
                    <option name="resourceId" value="${resource.id}">${resource.name}</option>
                </#list>
            </select>
        </div>
        <div>
            <input type="submit" value="添加">
        </div>
    </form>
</div>
</body>
</html>