package com.lsp.dao;

import com.lsp.domain.po.LibAdvice;

import java.util.List;

public interface LibAdviceDAO {
    public int addLibAdvice(LibAdvice libAdvice);
    public List<LibAdvice> queryLibAdvice();
}
