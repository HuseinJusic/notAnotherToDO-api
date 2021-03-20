package at.huj.NotAnotherToDo.model.TaskModel;

import org.springframework.data.annotation.Id;

public class Category {
    @Id
    private String id;

    private String name;
    private String color;
    private String description;

    public Category(String name, String color, String description) {
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
