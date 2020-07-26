package info.developia.tareitas.model;

import java.time.LocalDateTime;

public class Task {
    private final String title;
    private final LocalDateTime created;

    public Task(String title) {
        this.title = title;
        this.created = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }
}
