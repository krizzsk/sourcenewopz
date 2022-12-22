package com.didichuxing.comp.telecom.core.voip;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/NoticeText;", "Ljava/io/Serializable;", "hideTime", "", "showTime", "text", "", "ttsNum", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getHideTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowTime", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getTtsNum", "setTtsNum", "(Ljava/lang/Integer;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didichuxing/comp/telecom/core/voip/NoticeText;", "equals", "", "other", "", "hashCode", "timeRange", "Lkotlin/ranges/IntRange;", "toString", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipCallModel.kt */
public final class NoticeText implements Serializable {
    @SerializedName("hide_time")
    private final Integer hideTime;
    @SerializedName("show_time")
    private final Integer showTime;
    @SerializedName("text")
    private String text;
    @SerializedName("tts_num")
    private Integer ttsNum;

    public static /* synthetic */ NoticeText copy$default(NoticeText noticeText, Integer num, Integer num2, String str, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = noticeText.hideTime;
        }
        if ((i & 2) != 0) {
            num2 = noticeText.showTime;
        }
        if ((i & 4) != 0) {
            str = noticeText.text;
        }
        if ((i & 8) != 0) {
            num3 = noticeText.ttsNum;
        }
        return noticeText.copy(num, num2, str, num3);
    }

    public final Integer component1() {
        return this.hideTime;
    }

    public final Integer component2() {
        return this.showTime;
    }

    public final String component3() {
        return this.text;
    }

    public final Integer component4() {
        return this.ttsNum;
    }

    public final NoticeText copy(Integer num, Integer num2, String str, Integer num3) {
        return new NoticeText(num, num2, str, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoticeText)) {
            return false;
        }
        NoticeText noticeText = (NoticeText) obj;
        return Intrinsics.areEqual((Object) this.hideTime, (Object) noticeText.hideTime) && Intrinsics.areEqual((Object) this.showTime, (Object) noticeText.showTime) && Intrinsics.areEqual((Object) this.text, (Object) noticeText.text) && Intrinsics.areEqual((Object) this.ttsNum, (Object) noticeText.ttsNum);
    }

    public int hashCode() {
        Integer num = this.hideTime;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.showTime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str = this.text;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num3 = this.ttsNum;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "NoticeText(hideTime=" + this.hideTime + ", showTime=" + this.showTime + ", text=" + this.text + ", ttsNum=" + this.ttsNum + ")";
    }

    public NoticeText(Integer num, Integer num2, String str, Integer num3) {
        this.hideTime = num;
        this.showTime = num2;
        this.text = str;
        this.ttsNum = num3;
    }

    public final Integer getHideTime() {
        return this.hideTime;
    }

    public final Integer getShowTime() {
        return this.showTime;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final Integer getTtsNum() {
        return this.ttsNum;
    }

    public final void setTtsNum(Integer num) {
        this.ttsNum = num;
    }

    public final IntRange timeRange() {
        Integer num;
        if (this.showTime == null || (num = this.hideTime) == null) {
            Integer num2 = this.showTime;
            if (num2 == null || num2.intValue() < 0) {
                return null;
            }
            return new IntRange(this.showTime.intValue(), Integer.MAX_VALUE);
        } else if (Intrinsics.compare(num.intValue(), this.showTime.intValue()) <= 0 || this.showTime.intValue() < 0) {
            return null;
        } else {
            return new IntRange(this.showTime.intValue(), this.hideTime.intValue());
        }
    }
}
