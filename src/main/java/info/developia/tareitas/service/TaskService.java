package info.developia.tareitas.service;

import info.developia.gti.Injection;
import info.developia.tareitas.model.Task;

import java.util.List;

@Injection
public class TaskService {

    public List<Task> getAll() {
        return List.of(
                new Task("task1"),
                new Task("task2"),
                new Task("task3")
        );
    }

    public Task create(Task task) {
        return new Task(task.getTitle());
    }
}
