package com.didi.component.common.util;

import java.util.ArrayList;
import java.util.List;

public class SearchIdUploadManager {

    /* renamed from: a */
    private List<String> f11801a;

    /* renamed from: b */
    private String f11802b;

    /* renamed from: c */
    private String f11803c;

    private SearchIdUploadManager() {
        this.f11801a = new ArrayList();
        this.f11802b = "";
        this.f11803c = "";
    }

    private static class SearchIdUploadHolder {
        /* access modifiers changed from: private */
        public static final SearchIdUploadManager HOLDER = new SearchIdUploadManager();

        private SearchIdUploadHolder() {
        }
    }

    public static SearchIdUploadManager getInstance() {
        return SearchIdUploadHolder.HOLDER;
    }

    public String getBubbleId() {
        return this.f11802b;
    }

    public void setBubbleId(String str) {
        this.f11802b = str;
    }

    public void addSearchId(String str) {
        this.f11801a.add(str);
    }

    public String getSearchIdBunch() {
        List<String> list = this.f11801a;
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f11801a.size(); i++) {
            sb.append(this.f11801a.get(i));
            if (i < this.f11801a.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public String getEstimateAction() {
        return this.f11803c;
    }

    public void setEstimateAction(String str) {
        this.f11803c = str;
    }

    public void clear() {
        this.f11801a.clear();
    }
}
