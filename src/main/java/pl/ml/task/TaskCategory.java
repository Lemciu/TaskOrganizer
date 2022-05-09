package pl.ml.task;

public enum TaskCategory {
    HOME("Dom"),
    WORK("Praca"),
    HOBBY("Hobby");

    private String description;

    TaskCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
