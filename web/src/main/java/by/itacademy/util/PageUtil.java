package by.itacademy.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageUtil {

    private static final Integer PLUS_PAGE = 1;

    public static Integer getCountPages(Integer totalBooksCount, Integer countBooksOnPage) {
        Integer countPages = totalBooksCount / countBooksOnPage;

        return totalBooksCount % countBooksOnPage == 0 ? countPages : countPages + PLUS_PAGE;
    }

    public static List<Integer> getPageCountList(Integer countPages) {
        List<Integer> pageCountList = new ArrayList<>();
        for (int i = 1; i <= countPages; i++) {
            pageCountList.add(i);
        }

        return pageCountList;
    }
}
