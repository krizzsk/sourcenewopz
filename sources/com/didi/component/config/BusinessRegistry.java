package com.didi.component.config;

import android.text.TextUtils;
import android.util.SparseArray;
import com.didi.component.core.util.CLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessRegistry {

    /* renamed from: a */
    private static BizConfArray f12574a = new BizConfArray();

    /* renamed from: b */
    private static BizConfArray f12575b = new BizConfArray();

    public static void registerLocalBusiness(Entry entry) {
        f12574a.put(entry);
    }

    /* renamed from: a */
    static void m8565a(Entry entry) {
        f12575b.put(entry);
    }

    /* renamed from: a */
    static void m8566a(List<Entry> list) {
        f12575b.putAll(list);
    }

    /* renamed from: a */
    static void m8564a() {
        f12575b.clear();
    }

    public static String sid2ParentSid(String str) {
        return m8563a(str).parentSid;
    }

    public static int sid2Bid(String str) {
        return m8563a(str).bid;
    }

    public static String bid2ParentSid(int i) {
        return m8562a(i).parentSid;
    }

    public static String bid2Sid(int i) {
        return m8562a(i).sid;
    }

    /* renamed from: a */
    private static Entry m8563a(String str) {
        Entry entry;
        if (f12574a.contains(str)) {
            entry = f12574a.get(str);
        } else {
            entry = f12575b.get(str);
        }
        return entry != null ? entry : Entry.NONE;
    }

    /* renamed from: a */
    private static Entry m8562a(int i) {
        Entry entry;
        if (f12574a.contains(i)) {
            entry = f12574a.get(i);
        } else {
            entry = f12575b.get(i);
        }
        return entry != null ? entry : Entry.NONE;
    }

    private static final class BizConfArray {
        private SparseArray<Entry> mBidMap = new SparseArray<>();
        private Map<String, Entry> mSidMap = new HashMap();

        BizConfArray() {
        }

        public synchronized void put(Entry entry) {
            CLog.m8708d("BusinessRegistry put: " + entry);
            if (entry != null) {
                if (!entry.isInvalid()) {
                    this.mSidMap.put(entry.sid, entry);
                    this.mBidMap.put(entry.bid, entry);
                    return;
                }
            }
            CLog.m8708d("BusinessRegistry put: return");
        }

        public synchronized void putAll(List<Entry> list) {
            if (list != null) {
                for (Entry put : list) {
                    put(put);
                }
            }
        }

        public synchronized void clear() {
            this.mSidMap.clear();
            this.mBidMap.clear();
        }

        public synchronized Entry get(String str) {
            return this.mSidMap.get(str);
        }

        public synchronized Entry get(int i) {
            return this.mBidMap.get(i);
        }

        public boolean contains(String str) {
            return this.mSidMap.containsKey(str);
        }

        public boolean contains(int i) {
            return this.mBidMap.indexOfKey(i) >= 0;
        }
    }

    public static final class Entry {
        public static final Entry NONE = new Entry(-1, "", "");
        public int bid;
        public String parentSid;
        public String sid;

        public Entry(int i, String str, String str2) {
            this.bid = i;
            this.sid = str;
            this.parentSid = str2;
        }

        public boolean isInvalid() {
            return TextUtils.isEmpty(this.sid) && this.bid < 0;
        }

        public String toString() {
            return "Entry{bid=" + this.bid + ", sid='" + this.sid + '\'' + ", parentSid='" + this.parentSid + '\'' + '}';
        }
    }
}
