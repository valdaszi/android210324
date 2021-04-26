package lt.bit.demo20210415;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Global {

    public static List<Note> notes;
    public static int selectedIndex = 1;

    static {
        notes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            notes.add(new Note(i + 100, LocalDateTime.now().minusDays(i),
                    "Title " + i, "Content " + i));
        }
    }

    public static Note getSelected() {
        return notes.get(selectedIndex);
    }
}
