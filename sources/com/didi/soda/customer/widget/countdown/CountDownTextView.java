package com.didi.soda.customer.widget.countdown;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.work.PeriodicWorkRequest;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.widget.text.RichTextView;
import java.util.ArrayList;
import java.util.List;

public class CountDownTextView extends RichTextView {

    /* renamed from: a */
    private long f41670a = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;

    /* renamed from: b */
    private long f41671b = 1000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f41672c = "mm:ss";

    /* renamed from: d */
    private boolean f41673d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f41674e = "";

    /* renamed from: f */
    private CountDownTimer f41675f;

    /* renamed from: g */
    private boolean f41676g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CountTimeoutListener f41677h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f41678i = false;
    protected List<BaseBackgroundSpan> mBackSpanList;
    protected char[] mNonNumbers;
    protected String[] mNumbers;
    protected List<ForegroundColorSpan> mTextColorSpanList;

    public interface CountTimeoutListener {
        void onCountTimeout();
    }

    public CountDownTextView(Context context) {
        super(context);
        m29438a(context, (AttributeSet) null);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29438a(context, attributeSet);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29438a(context, attributeSet);
    }

    public void addCountFinishCallback(CountTimeoutListener countTimeoutListener) {
        this.f41677h = countTimeoutListener;
    }

    public void cancel() {
        this.f41676g = false;
        CountDownTimer countDownTimer = this.f41675f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f41675f = null;
            this.f41677h = null;
        }
    }

    public char[] getNonNumInTimerStr(String str) {
        return str.replaceAll("\\d", "").toCharArray();
    }

    public String[] getNumInTimerStr(String str) {
        return str.split("[^\\d]");
    }

    public boolean isCounting() {
        return this.f41676g;
    }

    public void removeCountFinishCallback() {
        this.f41677h = null;
    }

    public void setBackgroundSpan(String str) {
        if (!this.f41673d) {
            m29439a(str);
            this.f41673d = true;
        }
        setText(str);
    }

    public void start(long j) {
        if (!this.f41676g) {
            this.f41670a = Math.max(0, (j * 1000) - System.currentTimeMillis());
            this.f41676g = true;
            getTimer().start();
        }
    }

    /* renamed from: a */
    private void m29438a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CountDownTextView);
        try {
            this.f41670a = (long) obtainStyledAttributes.getInt(0, 900000);
            this.f41671b = (long) obtainStyledAttributes.getInt(1, 1000);
            this.mBackSpanList = new ArrayList();
            this.mTextColorSpanList = new ArrayList();
        } finally {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    private void m29439a(String str) {
        this.mNumbers = getNumInTimerStr(str);
        this.mNonNumbers = getNonNumInTimerStr(str);
    }

    private CountDownTimer getTimer() {
        if (this.f41675f == null) {
            this.f41675f = new CountDownTimer(this.f41670a, this.f41671b) {
                public void onFinish() {
                    CountDownTextView countDownTextView = CountDownTextView.this;
                    String unused = countDownTextView.f41674e = DurationFormatUtils.formatDuration(0, countDownTextView.f41672c);
                    CountDownTextView countDownTextView2 = CountDownTextView.this;
                    countDownTextView2.setBackgroundSpan(countDownTextView2.f41674e);
                    if (CountDownTextView.this.f41677h != null && !CountDownTextView.this.f41678i) {
                        boolean unused2 = CountDownTextView.this.f41678i = true;
                        CountDownTextView.this.f41677h.onCountTimeout();
                        CountTimeoutListener unused3 = CountDownTextView.this.f41677h = null;
                    }
                }

                public void onTick(long j) {
                    boolean unused = CountDownTextView.this.f41678i = false;
                    if (j > 0) {
                        CountDownTextView countDownTextView = CountDownTextView.this;
                        String unused2 = countDownTextView.f41674e = DurationFormatUtils.formatDuration(j, countDownTextView.f41672c);
                        CountDownTextView countDownTextView2 = CountDownTextView.this;
                        countDownTextView2.setBackgroundSpan(countDownTextView2.f41674e);
                    }
                }
            };
        }
        return this.f41675f;
    }
}
