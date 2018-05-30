package by.itacademy.service;

import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.entity.Book;
import by.itacademy.util.PaginationUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {

    private static final BookService INSTANCE = new BookService();

    public List<Book> findAll(Integer limit, Integer numberPages) {
        Integer offset = PaginationUtil.getOffset(limit, numberPages);

        return BookDaoImpl.getInstance().findAll(limit, offset);
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}
