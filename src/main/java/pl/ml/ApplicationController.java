package pl.ml;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ml.task.*;

import java.util.List;

@Controller
public class ApplicationController {
    private TaskService taskService;

    public ApplicationController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) boolean finished) {
        List<Task> allTasks = taskService.findAllByFinished(finished);
        model.addAttribute("categories", TaskCategory.values());
        model.addAttribute("tasks", allTasks);
        return "home";
    }

}