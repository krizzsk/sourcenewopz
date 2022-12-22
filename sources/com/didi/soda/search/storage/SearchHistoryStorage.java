package com.didi.soda.search.storage;

import com.didi.soda.customer.foundation.storage.CustomerStorage;
import com.didi.soda.customer.foundation.util.StringUtils;

public class SearchHistoryStorage extends CustomerStorage<HistoryTag> {

    /* renamed from: a */
    private static final int f43794a = 30;

    public void addTag(String str) {
        if (str != null && !StringUtils.isEmpty(str)) {
            HistoryTag data = getData();
            if (data.mTagList.contains(str)) {
                data.mTagList.remove(str);
            }
            if (data.mTagList.size() > 30) {
                data.mTagList.remove(29);
            }
            data.mTagList.add(0, str);
            setData(data);
        }
    }

    public HistoryTag getData() {
        HistoryTag historyTag = (HistoryTag) super.getData();
        return historyTag == null ? new HistoryTag() : historyTag;
    }
}
