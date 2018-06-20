package by.itacademy.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchManager {

    public static final int PLUS_PAGE = 1;

    private SearchType searchType = SearchType.TITLE;
    private Integer booksOnPage = 1;
    private Integer pageCount;
    private Integer totalBooksCount;
    private Integer selectedPageNumber = 1;
    private String searchString;
    private List<Integer> pageCountList = new ArrayList<>();

    public Integer fillPageCount() {
        int pageCount = totalBooksCount / booksOnPage;

        return totalBooksCount % booksOnPage == 0 ? pageCount : pageCount + PLUS_PAGE;
    }

    public List<Integer> fillPageCountList() {
        for (int i = 1; i < pageCount + 1; i++) {
            pageCountList.add(i);
        }

        return pageCountList;
    }
}
