package com.didi.foundation.sdk.tts;

public class PlayData {

    /* renamed from: a */
    TtsPriority f21373a;

    /* renamed from: b */
    boolean f21374b;

    /* renamed from: c */
    private String f21375c;

    /* renamed from: d */
    private int f21376d;

    /* renamed from: e */
    private PlayData f21377e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PlayData f21378f;

    public enum TtsPriority {
        NORMAL_PRIORITY,
        MIDDLE_PRIORITY,
        HIGH_PRIORITY
    }

    PlayData() {
        this.f21373a = TtsPriority.NORMAL_PRIORITY;
        this.f21374b = true;
        this.f21377e = this;
        this.f21378f = this.f21378f;
    }

    PlayData(int i) {
        this();
        this.f21376d = i;
        this.f21374b = false;
    }

    PlayData(String str) {
        this();
        this.f21375c = str;
        this.f21374b = true;
    }

    public String getTts() {
        return this.f21375c;
    }

    public int getRawId() {
        return this.f21376d;
    }

    public PlayData getNext() {
        return this.f21378f;
    }

    public static class Builder {
        private PlayData mCurrentPlayData;
        private PlayData mHeaderPlayData;
        private TtsPriority mPriority;

        public Builder(TtsPriority ttsPriority) {
            this.mPriority = ttsPriority;
        }

        public Builder() {
        }

        public Builder tts(String str) {
            PlayData playData = new PlayData(str);
            if (this.mHeaderPlayData == null) {
                this.mHeaderPlayData = playData;
                this.mCurrentPlayData = playData;
            } else {
                PlayData unused = this.mCurrentPlayData.f21378f = playData;
                this.mCurrentPlayData = playData;
            }
            TtsPriority ttsPriority = this.mPriority;
            if (ttsPriority != null) {
                playData.f21373a = ttsPriority;
            }
            return this;
        }

        public Builder rawId(int i) {
            PlayData playData = new PlayData(i);
            if (this.mHeaderPlayData == null) {
                TtsPriority ttsPriority = this.mPriority;
                if (ttsPriority != null) {
                    playData.f21373a = ttsPriority;
                }
                this.mHeaderPlayData = playData;
                this.mCurrentPlayData = playData;
            } else {
                PlayData unused = this.mCurrentPlayData.f21378f = playData;
                this.mCurrentPlayData = playData;
            }
            return this;
        }

        public PlayData build() {
            return this.mHeaderPlayData;
        }
    }

    public String toString() {
        return "PlayData{priority=" + this.f21373a + ", mTts='" + this.f21375c + '\'' + ", mRawId=" + this.f21376d + ", mNext=" + this.f21378f + '}';
    }
}
