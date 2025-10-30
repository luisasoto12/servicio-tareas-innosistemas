package service;

import java.util.List;
import org.springframework.stereotype.Service;
import domain.Task;
import exception.BadRequestException;
import exception.ResourceNotFoundException;
import repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void deleteById(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
        taskRepository.delete(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
    }

    @Override
    public Task save(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new BadRequestException("El título de la tarea es obligatorio");
        }
        if (task.getStatus_id() == null) {
            throw new BadRequestException("El estado de la tarea es obligatorio");
        }
        if (task.getProject_id() == null) {
            throw new BadRequestException("El proyecto de la tarea es obligatorio");
        }
        if (task.getAssignee_id() == null) {
            throw new BadRequestException("El responsable de la tarea es obligatorio");
        }
        
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        if (task.getId() == null) {
            throw new BadRequestException("El ID de la tarea es obligatorio para actualizar");
        }
        
        taskRepository.findById(task.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + task.getId()));
        
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new BadRequestException("El título de la tarea es obligatorio");
        }
        if (task.getStatus_id() == null) {
            throw new BadRequestException("El estado de la tarea es obligatorio");
        }
        if (task.getProject_id() == null) {
            throw new BadRequestException("El proyecto de la tarea es obligatorio");
        }
        if (task.getAssignee_id() == null) {
            throw new BadRequestException("El responsable de la tarea es obligatorio");
        }
        
        return taskRepository.save(task);
    }

}
