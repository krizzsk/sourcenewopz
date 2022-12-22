package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001#B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u001cJ\t\u0010\"\u001a\u00020\u0003HÖ\u0001R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006$"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire;", "Ljava/io/Serializable;", "questionId", "", "question", "button", "answers", "", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire$Answer;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAnswers", "()Ljava/util/List;", "setAnswers", "(Ljava/util/List;)V", "getButton", "()Ljava/lang/String;", "setButton", "(Ljava/lang/String;)V", "getQuestion", "setQuestion", "getQuestionId", "setQuestionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "illegal", "toString", "Answer", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayStatusResponse.kt */
public final class Questionnaire implements Serializable {
    @SerializedName("answer_list")
    private List<Answer> answers;
    @SerializedName("button")
    private String button;
    @SerializedName("question")
    private String question;
    @SerializedName("question_id")
    private String questionId;

    public static /* synthetic */ Questionnaire copy$default(Questionnaire questionnaire, String str, String str2, String str3, List<Answer> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questionnaire.questionId;
        }
        if ((i & 2) != 0) {
            str2 = questionnaire.question;
        }
        if ((i & 4) != 0) {
            str3 = questionnaire.button;
        }
        if ((i & 8) != 0) {
            list = questionnaire.answers;
        }
        return questionnaire.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.question;
    }

    public final String component3() {
        return this.button;
    }

    public final List<Answer> component4() {
        return this.answers;
    }

    public final Questionnaire copy(String str, String str2, String str3, List<Answer> list) {
        return new Questionnaire(str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Questionnaire)) {
            return false;
        }
        Questionnaire questionnaire = (Questionnaire) obj;
        return Intrinsics.areEqual((Object) this.questionId, (Object) questionnaire.questionId) && Intrinsics.areEqual((Object) this.question, (Object) questionnaire.question) && Intrinsics.areEqual((Object) this.button, (Object) questionnaire.button) && Intrinsics.areEqual((Object) this.answers, (Object) questionnaire.answers);
    }

    public int hashCode() {
        String str = this.questionId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.question;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.button;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Answer> list = this.answers;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Questionnaire(questionId=" + this.questionId + ", question=" + this.question + ", button=" + this.button + ", answers=" + this.answers + VersionRange.RIGHT_OPEN;
    }

    public Questionnaire(String str, String str2, String str3, List<Answer> list) {
        this.questionId = str;
        this.question = str2;
        this.button = str3;
        this.answers = list;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final void setQuestionId(String str) {
        this.questionId = str;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final void setQuestion(String str) {
        this.question = str;
    }

    public final String getButton() {
        return this.button;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final List<Answer> getAnswers() {
        return this.answers;
    }

    public final void setAnswers(List<Answer> list) {
        this.answers = list;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire$Answer;", "", "answerId", "", "answer", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "getAnswerId", "setAnswerId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayStatusResponse.kt */
    public static final class Answer {
        @SerializedName("answer")
        private String answer;
        @SerializedName("answer_id")
        private String answerId;

        public static /* synthetic */ Answer copy$default(Answer answer2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = answer2.answerId;
            }
            if ((i & 2) != 0) {
                str2 = answer2.answer;
            }
            return answer2.copy(str, str2);
        }

        public final String component1() {
            return this.answerId;
        }

        public final String component2() {
            return this.answer;
        }

        public final Answer copy(String str, String str2) {
            return new Answer(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Answer)) {
                return false;
            }
            Answer answer2 = (Answer) obj;
            return Intrinsics.areEqual((Object) this.answerId, (Object) answer2.answerId) && Intrinsics.areEqual((Object) this.answer, (Object) answer2.answer);
        }

        public int hashCode() {
            String str = this.answerId;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.answer;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Answer(answerId=" + this.answerId + ", answer=" + this.answer + VersionRange.RIGHT_OPEN;
        }

        public Answer(String str, String str2) {
            this.answerId = str;
            this.answer = str2;
        }

        public final String getAnswerId() {
            return this.answerId;
        }

        public final void setAnswerId(String str) {
            this.answerId = str;
        }

        public final String getAnswer() {
            return this.answer;
        }

        public final void setAnswer(String str) {
            this.answer = str;
        }
    }

    public final boolean illegal() {
        boolean z;
        List<Answer> answers2;
        Questionnaire questionnaire = this;
        String questionId2 = getQuestionId();
        if (questionId2 != null) {
            if (questionId2.length() > 0) {
                z = true;
                if (z && ((answers2 = getAnswers()) == null || !answers2.isEmpty())) {
                }
                return false;
            }
        }
        z = false;
        return false;
    }
}
