package com.didi.entrega.customer.widget.countdown;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.work.PeriodicWorkRequest;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.passenger.C10448R;
import java.util.ArrayList;
import java.util.List;

public class CountDownTextView extends CustomerAppCompatTextView {

    /* renamed from: a */
    private long f20379a = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;

    /* renamed from: b */
    private long f20380b = 1000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f20381c = "mm:ss";

    /* renamed from: d */
    private boolean f20382d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f20383e = "";

    /* renamed from: f */
    private CountDownTimer f20384f;

    /* renamed from: g */
    private boolean f20385g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CountTimeoutListener f20386h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f20387i = false;
    protected List<BaseBackgroundSpan> mBackSpanList;
    protected char[] mNonNumbers;
    protected String[] mNumbers;
    protected List<ForegroundColorSpan> mTextColorSpanList;

    public interface CountTimeoutListener {
        void onCountTimeout();
    }

    public CountDownTextView(Context context) {
        super(context);
        m14929a(context, (AttributeSet) null);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14929a(context, attributeSet);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14929a(context, attributeSet);
    }

    public void addCountFinishCallback(CountTimeoutListener countTimeoutListener) {
        this.f20386h = countTimeoutListener;
    }

    public void cancel() {
        this.f20385g = false;
        CountDownTimer countDownTimer = this.f20384f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f20384f = null;
            this.f20386h = null;
        }
    }

    public char[] getNonNumInTimerStr(String str) {
        return str.replaceAll("\\d", "").toCharArray();
    }

    public String[] getNumInTimerStr(String str) {
        return str.split("[^\\d]");
    }

    public boolean isCounting() {
        return this.f20385g;
    }

    public void removeCountFinishCallback() {
        this.f20386h = null;
    }

    public void setBackgroundSpan(String str) {
        if (!this.f20382d) {
            m14930a(str);
            this.f20382d = true;
        }
        setText(str);
    }

    public void start(long j) {
        if (!this.f20385g) {
            this.f20379a = Math.max(0, (j * 1000) - System.currentTimeMillis());
            this.f20385g = true;
            getTimer().start();
        }
    }

    /* renamed from: a */
    private void m14929a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaCountDownTextView);
        try {
            this.f20379a = (long) obtainStyledAttributes.getInt(0, 900000);
            this.f20380b = (long) obtainStyledAttributes.getInt(1, 1000);
            this.mBackSpanList = new ArrayList();
            this.mTextColorSpanList = new ArrayList();
        } finally {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    private void m14930a(String str) {
        this.mNumbers = getNumInTimerStr(str);
        this.mNonNumbers = getNonNumInTimerStr(str);
    }

    private CountDownTimer getTimer() {
        if (this.f20384f == null) {
            this.f20384f = new CountDownTimer(this.f20379a, this.f20380b) {
                public void onFinish() {
                    CountDownTextView countDownTextView = CountDownTextView.this;
                    String unused = countDownTextView.f20383e = DurationFormatUtils.formatDuration(0, countDownTextView.f20381c);
                    CountDownTextView countDownTextView2 = CountDownTextView.this;
                    countDownTextView2.setBackgroundSpan(countDownTextView2.f20383e);
                    if (CountDownTextView.this.f20386h != null && !CountDownTextView.this.f20387i) {
                        boolean unused2 = CountDownTextView.this.f20387i = true;
                        CountDownTextView.this.f20386h.onCountTimeout();
                        CountTimeoutListener unused3 = CountDownTextView.this.f20386h = null;
                    }
                }

                public void onTick(long j) {
                    boolean unused = CountDownTextView.this.f20387i = false;
                    if (j > 0) {
                        CountDownTextView countDownTextView = CountDownTextView.this;
                        String unused2 = countDownTextView.f20383e = DurationFormatUtils.formatDuration(j, countDownTextView.f20381c);
                        CountDownTextView countDownTextView2 = CountDownTextView.this;
                        countDownTextView2.setBackgroundSpan(countDownTextView2.f20383e);
                    }
                }
            };
        }
        return this.f20384f;
    }
}
