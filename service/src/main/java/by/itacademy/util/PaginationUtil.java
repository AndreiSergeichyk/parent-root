package by.itacademy.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaginationUtil {

    public static final int ONE = 1;

    public static Integer getOffset(Integer limit, Integer numberPages) {

        return (numberPages - ONE) * limit;
    }

}
