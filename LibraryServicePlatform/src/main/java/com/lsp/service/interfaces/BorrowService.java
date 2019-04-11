package com.lsp.service.interfaces;


import java.sql.Timestamp;
import java.util.Date;

public interface BorrowService {
    public boolean loadBook(String identifier, String bookId, Timestamp returnTime);
    public boolean returnBook(String identifier,String bookId);
}
