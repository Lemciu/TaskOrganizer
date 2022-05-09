package pl.ml.task;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAllByFinished(boolean finished) {
        return finished ? taskRepository.findAllByFinishedIsTrueOrderByDeadline()
                : taskRepository.findAllByFinishedIsFalseOrderByDeadline();
    }

    public void setFinishedTask(Task task) {
        task.setFinished(true);
    }
}
