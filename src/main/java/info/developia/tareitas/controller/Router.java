package info.developia.tareitas.controller;

import info.developia.gti.Injection;

import static spark.Spark.*;

@Injection
public class Router {
    private final TaskController taskController;
    private final JsonTransformer jsonTransformer;

    public Router(TaskController taskController) {
        this.taskController = taskController;
        jsonTransformer = new JsonTransformer();
    }

    public void controllers() {
        path("/tasks", () -> {
            get("", taskController::getAll, jsonTransformer);
            post("", taskController::create, jsonTransformer);
        });
    }
}
