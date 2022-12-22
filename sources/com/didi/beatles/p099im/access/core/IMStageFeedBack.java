package com.didi.beatles.p099im.access.core;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/beatles/im/access/core/IMStageFeedBack;", "", "()V", "IMStage", "IMStageFeedBackListener", "OutFeedBackData", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.access.core.IMStageFeedBack */
/* compiled from: IMStageFeedBack.kt */
public final class IMStageFeedBack {

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/beatles/im/access/core/IMStageFeedBack$IMStage;", "", "(Ljava/lang/String;I)V", "IM_FEED_LIST_ON_CREATE", "IM_OLD_MESSAGE_LIST_ITEM_CLICK", "IM_CLEAR_UN_READ_COUNT_AFTER", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* renamed from: com.didi.beatles.im.access.core.IMStageFeedBack$IMStage */
    /* compiled from: IMStageFeedBack.kt */
    public enum IMStage {
        IM_FEED_LIST_ON_CREATE,
        IM_OLD_MESSAGE_LIST_ITEM_CLICK,
        IM_CLEAR_UN_READ_COUNT_AFTER
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/beatles/im/access/core/IMStageFeedBack$IMStageFeedBackListener;", "", "onStageFeedBack", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "imStage", "Lcom/didi/beatles/im/access/core/IMStageFeedBack$IMStage;", "outFeedBackData", "Lcom/didi/beatles/im/access/core/IMStageFeedBack$OutFeedBackData;", "(Landroidx/fragment/app/FragmentActivity;Lcom/didi/beatles/im/access/core/IMStageFeedBack$IMStage;Lcom/didi/beatles/im/access/core/IMStageFeedBack$OutFeedBackData;)Ljava/lang/Boolean;", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* renamed from: com.didi.beatles.im.access.core.IMStageFeedBack$IMStageFeedBackListener */
    /* compiled from: IMStageFeedBack.kt */
    public interface IMStageFeedBackListener {
        Boolean onStageFeedBack(FragmentActivity fragmentActivity, IMStage iMStage, OutFeedBackData outFeedBackData);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/beatles/im/access/core/IMStageFeedBack$OutFeedBackData;", "", "()V", "sid", "", "getSid", "()Ljava/lang/Long;", "setSid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "uid", "getUid", "setUid", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* renamed from: com.didi.beatles.im.access.core.IMStageFeedBack$OutFeedBackData */
    /* compiled from: IMStageFeedBack.kt */
    public static final class OutFeedBackData {
        private Long sid;
        private Long uid;

        public final Long getUid() {
            return this.uid;
        }

        public final void setUid(Long l) {
            this.uid = l;
        }

        public final Long getSid() {
            return this.sid;
        }

        public final void setSid(Long l) {
            this.sid = l;
        }
    }
}
