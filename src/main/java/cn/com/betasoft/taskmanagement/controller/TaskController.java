package cn.com.betasoft.taskmanagement.controller;

import cn.com.betasoft.taskmanagement.domain.Task;
import cn.com.betasoft.taskmanagement.service.ResourceService;
import cn.com.betasoft.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("resources", resourceService.findAll());
        return "task/task";
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public Task findById(@PathVariable("taskId") Long taskId) {
        return taskService.findById(taskId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Task task) {
        taskService.add(task);
        return "redirect:/task";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Task task) {
        taskService.update(task);
        return "redirect:/task";
    }

    @RequestMapping(value="/delete/{taskId}", method = RequestMethod.POST)
    public String delete(@PathVariable("taskId") long taskId) {
        taskService.delete(taskId);
        return "redirect:/task";
    }
}
