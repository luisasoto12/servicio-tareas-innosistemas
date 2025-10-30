package service;

import java.util.List;
import domain.Task;

public interface TaskService {
    Task save(Task task);
    List<Task> findAll();
    Task findById(Long id);
    Task update(Task task);
    void deleteById(Long id);   
}
