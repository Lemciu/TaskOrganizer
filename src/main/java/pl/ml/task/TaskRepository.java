package pl.ml.task;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByFinishedIsTrueOrderByDeadline();

    List<Task> findAllByFinishedIsFalseOrderByDeadline();
}
