package ni.edu.nicamazon.dto;

public class ErrorDetail {
    private String title;

    private int state;

    private String description;

    private long time;

    private String techMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTechMessage() {
        return techMessage;
    }

    public void setTechMessage(String techMessage) {
        this.techMessage = techMessage;
    }
}
