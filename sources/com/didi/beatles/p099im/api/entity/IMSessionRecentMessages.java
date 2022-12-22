package com.didi.beatles.p099im.api.entity;

import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.module.entity.IMFeedMessage;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.utils.IMLog;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMSessionRecentMessages */
public class IMSessionRecentMessages implements Serializable, Cloneable {
    private static final int INVALID_INDEX = -1;
    private static final String TAG = IMSessionRecentMessages.class.getSimpleName();
    private transient int mCapacity = 6;
    @SerializedName("list")
    private LinkedList<IMFeedMessage> mList;

    private void checkList() {
        if (this.mList == null) {
            this.mList = new LinkedList<>();
        }
    }

    public void initRecentMessages(long j) {
        this.mCapacity = IMContextInfoHelper.getRecentMessagesCount4Feed(j);
    }

    public <T extends List<IMFeedMessage>> void appendMessages(T t) {
        Iterator it = t.iterator();
        while (it.hasNext()) {
            appendMessage((IMFeedMessage) it.next());
        }
    }

    public <T extends List<IMFeedMessage>> void appendReverseMessages(T t) {
        if (t != null && !t.isEmpty()) {
            for (int size = t.size() - 1; size >= 0; size--) {
                if (size < t.size()) {
                    try {
                        appendMessage((IMFeedMessage) t.get(size));
                    } catch (Exception e) {
                        IMLog.m6632e(TAG, "[appendReverseMessages]", e);
                    }
                }
            }
        }
    }

    public void appendMessage(IMFeedMessage iMFeedMessage) {
        checkList();
        if (iMFeedMessage != null) {
            String str = TAG;
            IMLog.m6631d(str, "[appendMessage] len=" + this.mList.size() + ";\tmessage=" + iMFeedMessage.getCreateTime() + "@" + iMFeedMessage.getContent());
            this.mList.addFirst(iMFeedMessage);
        } else {
            IMTraceError.trackError("RecentMessages", new NullPointerException("Null node"));
        }
        trimToSize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r0 < r9.mCapacity) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void appendAndSortMessage(com.didi.beatles.p099im.module.entity.IMFeedMessage r10) {
        /*
            r9 = this;
            r9.checkList()
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r0 = r9.mList
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0019
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r0 = r9.mList
            r0.add(r10)
            java.lang.String r10 = TAG
            java.lang.String r0 = "[appendMessage] Add message for empty list."
            com.didi.beatles.p099im.utils.IMLog.m6631d(r10, r0)
            goto L_0x00cf
        L_0x0019:
            long r1 = r10.getCreateTime()
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r3 = r9.mList
            java.lang.Object r3 = r3.peekFirst()
            com.didi.beatles.im.module.entity.IMFeedMessage r3 = (com.didi.beatles.p099im.module.entity.IMFeedMessage) r3
            long r3 = r3.getCreateTime()
            r5 = 0
            r6 = -1
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0032
            r0 = 0
        L_0x0030:
            r5 = -1
            goto L_0x0076
        L_0x0032:
            long r1 = r10.getCreateTime()
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r3 = r9.mList
            java.lang.Object r3 = r3.peekLast()
            com.didi.beatles.im.module.entity.IMFeedMessage r3 = (com.didi.beatles.p099im.module.entity.IMFeedMessage) r3
            long r3 = r3.getCreateTime()
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x004b
            int r1 = r9.mCapacity
            if (r0 >= r1) goto L_0x0074
            goto L_0x0030
        L_0x004b:
            if (r5 >= r0) goto L_0x0074
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r1 = r9.mList
            java.lang.Object r1 = r1.get(r5)
            com.didi.beatles.im.module.entity.IMFeedMessage r1 = (com.didi.beatles.p099im.module.entity.IMFeedMessage) r1
            long r2 = r10.getCreateTime()
            long r7 = r1.getCreateTime()
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0063
            r0 = r5
            goto L_0x0030
        L_0x0063:
            long r2 = r10.getCreateTime()
            long r7 = r1.getCreateTime()
            int r1 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0071
            r0 = -1
            goto L_0x0076
        L_0x0071:
            int r5 = r5 + 1
            goto L_0x004b
        L_0x0074:
            r0 = -1
            goto L_0x0030
        L_0x0076:
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "  [appendMessage] insertIndex="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ";\tupdateIndex="
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.didi.beatles.p099im.utils.IMLog.m6631d(r1, r2)
            if (r0 == r6) goto L_0x00b2
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r1 = r9.mList
            r1.add(r0, r10)
            java.lang.String r10 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[appendMessage] Insert : "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.didi.beatles.p099im.utils.IMLog.m6631d(r10, r0)
            goto L_0x00cf
        L_0x00b2:
            if (r5 == r6) goto L_0x00cf
            java.util.LinkedList<com.didi.beatles.im.module.entity.IMFeedMessage> r0 = r9.mList
            r0.set(r5, r10)
            java.lang.String r10 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[appendMessage] Update : "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.didi.beatles.p099im.utils.IMLog.m6631d(r10, r0)
        L_0x00cf:
            r9.trimToSize()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.api.entity.IMSessionRecentMessages.appendAndSortMessage(com.didi.beatles.im.module.entity.IMFeedMessage):void");
    }

    private void trimToSize() {
        while (true) {
            int size = this.mList.size();
            if (size <= this.mCapacity) {
                String str = TAG;
                IMLog.m6631d(str, "[trimToSize] enough capacity." + size);
                return;
            }
            onMessageRemoved(this.mList.pollLast());
        }
    }

    /* access modifiers changed from: protected */
    public void onMessageRemoved(IMFeedMessage iMFeedMessage) {
        if (iMFeedMessage != null) {
            String str = TAG;
            IMLog.m6631d(str, "[onMessageRemoved] message=" + iMFeedMessage.getMid() + "@" + iMFeedMessage.getContent());
        }
    }

    public List<IMFeedMessage> getMessages() {
        return this.mList;
    }
}
