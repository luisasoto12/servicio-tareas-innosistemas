package controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import domain.Task;
import service.TaskService;

@RestController
//http://localhost:8080/api/tasks
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //http://localhost:8080/api/tasks
    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    //http://localhost:8080/api/tasks
    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    //http://localhost:8080/api/tasks/{id}
    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    //http://localhost:8080/api/tasks/{id}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    //http://localhost:8080/api/tasks/{id}
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        Task taskDb = taskService.findById(id);
        taskDb.setTitle(task.getTitle());
        taskDb.setDescription(task.getDescription());
        taskDb.setStatus_id(task.getStatus_id());
        taskDb.setDue_date(task.getDue_date());
        taskDb.setProject_id(task.getProject_id());
        taskDb.setAssignee_id(task.getAssignee_id());
        return taskService.update(taskDb);
    }

}
