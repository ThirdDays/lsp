package com.lsp.service.interfaces;


import com.lsp.domain.po.Borrow;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BorrowService {
    public boolean loadBook(String userId, String bookId, String term);
    public boolean returnBook(String userId,String bookId);
    public List<Borrow> queryBorrowNotBeReturnedButOverdueRecord();
    public List<Borrow> queryUserBorrowRecord(String userId);
}
