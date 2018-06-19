package by.itacademy.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Letters {

    private static final Letters INSTANCE = new Letters();
    private static final List<String> listLetter;
    private static final int FIRST_LETTER = 1040;
    private static final int END_LETTER = 1072;

    static {
        listLetter = new ArrayList<>();
        for (int i = FIRST_LETTER; i < END_LETTER; i++) {
            listLetter.add(String.valueOf((char) i));
        }
    }

    public List<String> getLetters() {
        return listLetter;
    }

    public static Letters getInstance() {
        return INSTANCE;
    }
}
