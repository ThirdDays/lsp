package com.lsp.service.abstracts;

import com.lsp.domain.Book;
import com.lsp.service.interfaces.BookService;

import java.util.List;

public abstract class AbstractBookService implements BookService {

    /*
        function:该方法用于查找书籍
     */
    public List<Book> findBook(String index) {

        return null;
    }
}
