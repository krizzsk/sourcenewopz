package com.didi.beatles.p099im.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.data.IMInnerData */
public class IMInnerData {

    /* renamed from: a */
    private static IMInnerData f9162a = null;

    /* renamed from: d */
    private static final int f9163d = 10;

    /* renamed from: b */
    private String f9164b;

    /* renamed from: c */
    private Map<Long, String> f9165c = new HashMap();

    /* renamed from: e */
    private List<IMEmojiPerfixListener> f9166e = new ArrayList();

    /* renamed from: com.didi.beatles.im.data.IMInnerData$IMEmojiPerfixListener */
    public interface IMEmojiPerfixListener {
        void emojiPrefixUpdate(String str);
    }

    private IMInnerData() {
    }

    public static IMInnerData getInstance() {
        if (f9162a == null) {
            f9162a = new IMInnerData();
        }
        return f9162a;
    }

    public String getEmojiPrefix() {
        return this.f9164b;
    }

    public void setEmojiPrefix(String str) {
        this.f9164b = str;
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.f9166e.size(); i++) {
                this.f9166e.get(i).emojiPrefixUpdate(str);
            }
        }
    }

    public void addRecommendInfo(Long l, String str) {
        if (this.f9165c.size() >= 10) {
            this.f9165c.clear();
        }
        this.f9165c.put(l, str);
    }

    public String getRecommendInfo(Long l) {
        return this.f9165c.get(l);
    }

    public void addEmojiPrefixObserver(IMEmojiPerfixListener iMEmojiPerfixListener) {
        this.f9166e.add(iMEmojiPerfixListener);
    }

    public void removeEmojiPrefixObserver(IMEmojiPerfixListener iMEmojiPerfixListener) {
        this.f9166e.remove(iMEmojiPerfixListener);
    }
}
