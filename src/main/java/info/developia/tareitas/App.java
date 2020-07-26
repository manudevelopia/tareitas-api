package info.developia.tareitas;

import info.developia.gti.Injection;
import info.developia.gti.Injector;
import info.developia.tareitas.controller.Router;

@Injection
public class App {
    private final Router router;

    public App(Router router) {
        this.router = router;
    }

    public void start() {
        router.controllers();
    }

    public static void main(String[] args) {
        Injector injector = new Injector();
        App app = (App)injector.getInstanceOf(App.class);
        app.start();
    }
}
