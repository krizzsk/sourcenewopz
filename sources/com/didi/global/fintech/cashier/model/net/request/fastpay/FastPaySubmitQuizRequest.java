package com.didi.global.fintech.cashier.model.net.request.fastpay;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayRequestCommonParams;", "question_id", "", "answer_id_list", "", "(Ljava/lang/String;Ljava/util/List;)V", "getAnswer_id_list", "()Ljava/util/List;", "setAnswer_id_list", "(Ljava/util/List;)V", "getQuestion_id", "()Ljava/lang/String;", "setQuestion_id", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySubmitQuizRequest.kt */
public final class FastPaySubmitQuizRequest extends FastPayRequestCommonParams {
    @SerializedName("answer_id_list")
    private List<String> answer_id_list;
    @SerializedName("question_id")
    private String question_id;

    public FastPaySubmitQuizRequest() {
        this((String) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPaySubmitQuizRequest copy$default(FastPaySubmitQuizRequest fastPaySubmitQuizRequest, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPaySubmitQuizRequest.question_id;
        }
        if ((i & 2) != 0) {
            list = fastPaySubmitQuizRequest.answer_id_list;
        }
        return fastPaySubmitQuizRequest.copy(str, list);
    }

    public final String component1() {
        return this.question_id;
    }

    public final List<String> component2() {
        return this.answer_id_list;
    }

    public final FastPaySubmitQuizRequest copy(String str, List<String> list) {
        return new FastPaySubmitQuizRequest(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPaySubmitQuizRequest)) {
            return false;
        }
        FastPaySubmitQuizRequest fastPaySubmitQuizRequest = (FastPaySubmitQuizRequest) obj;
        return Intrinsics.areEqual((Object) this.question_id, (Object) fastPaySubmitQuizRequest.question_id) && Intrinsics.areEqual((Object) this.answer_id_list, (Object) fastPaySubmitQuizRequest.answer_id_list);
    }

    public int hashCode() {
        String str = this.question_id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.answer_id_list;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FastPaySubmitQuizRequest(question_id=" + this.question_id + ", answer_id_list=" + this.answer_id_list + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPaySubmitQuizRequest(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    public final String getQuestion_id() {
        return this.question_id;
    }

    public final void setQuestion_id(String str) {
        this.question_id = str;
    }

    public final List<String> getAnswer_id_list() {
        return this.answer_id_list;
    }

    public final void setAnswer_id_list(List<String> list) {
        this.answer_id_list = list;
    }

    public FastPaySubmitQuizRequest(String str, List<String> list) {
        this.question_id = str;
        this.answer_id_list = list;
    }
}
