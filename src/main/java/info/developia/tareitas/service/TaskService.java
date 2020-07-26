package info.developia.tareitas.service;

import info.developia.gti.Injection;
import info.developia.tareitas.model.Task;

import java.util.List;

@Injection
public class TaskService {

    Persistence persistence = new Persistence();

    public List<Task> getAll() {
        return persistence.doSomething();
    }

    public Task create(Task task) {
        return new Task(task.getTitle());
    }
}
