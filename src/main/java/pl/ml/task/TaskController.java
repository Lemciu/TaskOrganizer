package pl.ml.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/add-task")
    public String create(Model model) {
        model.addAttribute("taskToEdit", new Task("", TaskCategory.WORK, false, LocalDateTime.now()));
        model.addAttribute("categories", TaskCategory.values());
        return "task";
    }

    @GetMapping("/edit-task")
    public String create2(@RequestParam Long id,
                          Model model) {
        taskService.findById(id).ifPresent(task -> model.addAttribute("taskToEdit", task));
        model.addAttribute("categories", TaskCategory.values());
        return "task";
    }

    @PostMapping("/save")
    public String editOrAdd(Task task) {
        taskService.save(task);
        return "redirect:/";
    }

    @PostMapping("/completed")
    public String completed(@RequestParam Long id) {
        Task task = taskService.findById(id).orElseThrow();
        taskService.setFinishedTask(task);
        taskService.save(task);
        return "redirect:/";
    }
}
