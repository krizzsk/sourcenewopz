package com.didi.soda.business.component.search.helper;

public class SearchMenuPageInfo {

    /* renamed from: a */
    private String f39666a;
    public String mKeyWord;
    public int mKeyWordType = 0;
    public String mRecId;
    public int mTraceCnt = 0;

    public SearchMenuPageInfo(String str) {
        this.f39666a = str;
    }

    public String getShopId() {
        return this.f39666a;
    }

    public void setSearchWord(String str, int i) {
        this.mKeyWord = str;
        this.mKeyWordType = i;
    }

    public void setSearchWord(String str, int i, String str2) {
        this.mKeyWord = str;
        this.mKeyWordType = i;
        this.mRecId = str2;
    }

    public void clearSearchWord() {
        this.mKeyWord = null;
        this.mRecId = null;
        this.mTraceCnt = 0;
    }

    public void autoAddTraceCnt(String str) {
        this.mRecId = str;
        this.mTraceCnt++;
    }

    public void autoAddTraceCnt() {
        this.mTraceCnt++;
    }
}
