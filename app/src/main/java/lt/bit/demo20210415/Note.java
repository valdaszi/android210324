package lt.bit.demo20210415;

import java.time.LocalDateTime;

public class Note {

    private long id;
    private LocalDateTime date;
    private String title;
    private String content;

    public Note(long id, LocalDateTime date, String title, String content) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "date=" + date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
