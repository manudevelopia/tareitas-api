package info.developia.tareitas.controller;

import com.google.gson.Gson;
import info.developia.gti.Injection;
import info.developia.tareitas.model.Task;
import info.developia.tareitas.service.TaskService;
import spark.Request;
import spark.Response;

import java.util.List;

@Injection
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getAll(Request req, Response res) {
        res.status(200);
        return taskService.getAll();
    }

    public Task create(Request request, Response response) {
        response.status(201);
        Task newTask = new Gson().fromJson(request.body(), Task.class);
        return taskService.create(newTask);
    }
}
