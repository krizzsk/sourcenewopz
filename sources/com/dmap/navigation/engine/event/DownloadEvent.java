package com.dmap.navigation.engine.event;

import com.dmap.navigation.jni.swig.StringList;
import java.util.ArrayList;
import java.util.List;

public class DownloadEvent extends NaviEvent {

    /* renamed from: a */
    private final List<String> f51870a;

    public DownloadEvent(StringList stringList) {
        int size = (int) stringList.size();
        if (size > 0) {
            this.f51870a = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                this.f51870a.add(stringList.get(i));
            }
            return;
        }
        this.f51870a = null;
    }

    public String toString() {
        return "DownloadEvent{urls=" + this.f51870a + '}';
    }

    public List<String> getUrls() {
        return this.f51870a;
    }
}
