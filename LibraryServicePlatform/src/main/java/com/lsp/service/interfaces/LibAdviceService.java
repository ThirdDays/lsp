package com.lsp.service.interfaces;

import com.lsp.domain.po.LibAdvice;

import java.util.List;

public interface LibAdviceService {
    public boolean addLibAdvice(String content);
    public List<LibAdvice> queryLibAdvice();
}
