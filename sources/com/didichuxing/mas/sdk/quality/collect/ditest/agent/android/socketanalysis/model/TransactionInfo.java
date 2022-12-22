package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.model;

import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionInfo {
    public ConcurrentHashMap<String, Object> data = new ConcurrentHashMap<>();
    public List<String> seqIdList = new ArrayList();
    public Set<String> tlsList = new HashSet();
    public Set<String> verList = new HashSet();

    public boolean isEmpty() {
        return this.data.isEmpty() || this.seqIdList.isEmpty() || this.verList.isEmpty() || this.tlsList.isEmpty();
    }

    public void clear() {
        try {
            if (this.data != null) {
                this.data.clear();
            }
            if (this.seqIdList != null) {
                this.seqIdList.clear();
            }
            if (this.verList != null) {
                this.verList.clear();
            }
            if (this.tlsList != null) {
                this.tlsList.clear();
            }
        } catch (Throwable unused) {
            OLog.m34424w("TransactionInfo clear fail");
        }
    }
}
