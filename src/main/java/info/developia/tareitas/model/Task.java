package info.developia.tareitas.model;

import java.time.LocalDateTime;

public class Task {
    private final String title;
    private final LocalDateTime created = LocalDateTime.now();

    public Task(String title) {
        this.title = title;
    }
}
