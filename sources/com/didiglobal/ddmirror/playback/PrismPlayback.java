package com.didiglobal.ddmirror.playback;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didi.trackupload.sdk.Constants;
import com.didiglobal.ddmirror.monitor.core.GlobalWindowManager;
import com.didiglobal.ddmirror.monitor.core.WindowObserver;
import com.didiglobal.ddmirror.monitor.model.EventData;
import com.didiglobal.ddmirror.playback.model.EventInfo;
import java.util.ArrayList;
import java.util.List;

public class PrismPlayback {
    private static PrismPlayback sPrismPlayback;
    private Context mContext;
    private int mCurrentIndex;
    private List<EventInfo> mEventInfoList;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (PrismPlayback.this.playing) {
                int i = message.what;
                if (i == 1) {
                    PrismPlayback.access$108(PrismPlayback.this);
                    postDelayed(new Runnable() {
                        public void run() {
                            PrismPlayback.this.next(0);
                        }
                    }, 1000);
                } else if (i == 2) {
                    PrismPlayback.this.next(message.arg1);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean playing;

    public interface OnAnimatorListener {
        void onAnimationEnd();
    }

    static /* synthetic */ int access$108(PrismPlayback prismPlayback) {
        int i = prismPlayback.mCurrentIndex;
        prismPlayback.mCurrentIndex = i + 1;
        return i;
    }

    public static PrismPlayback getInstance() {
        PrismPlayback prismPlayback;
        synchronized (PrismPlayback.class) {
            if (sPrismPlayback == null) {
                sPrismPlayback = new PrismPlayback();
            }
            prismPlayback = sPrismPlayback;
        }
        return prismPlayback;
    }

    public void init(Application application) {
        this.mContext = application;
        AppLifecycler.getInstance().init(application);
        GlobalWindowManager.getInstance().getWindowObserver().addWindowObserverListener(new WindowObserver.WindowObserverListener() {
            public void add(Window window) {
                PrismWindowManager.getInstance().addPrismWindow(new PrismWindow(window));
            }

            public void remove(Window window) {
                PrismWindowManager.getInstance().removePrismWindow(window);
            }
        });
    }

    public void playback(List<EventData> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            EventInfo convertEventInfo = PlaybackHelper.convertEventInfo(list.get(i));
            if (convertEventInfo != null) {
                arrayList.add(convertEventInfo);
            }
        }
        this.mCurrentIndex = 0;
        this.mEventInfoList = arrayList;
        startPlayback();
    }

    private void startPlayback() {
        this.playing = true;
        next(0);
    }

    /* access modifiers changed from: private */
    public void next(int i) {
        if (this.mCurrentIndex + 1 > this.mEventInfoList.size()) {
            SystemUtils.showToast(Toast.makeText(this.mContext, "回放结束", 1));
            this.mHandler.sendEmptyMessageDelayed(3, 1000);
            return;
        }
        EventInfo eventInfo = this.mEventInfoList.get(this.mCurrentIndex);
        if (eventInfo.eventType == 0) {
            if (eventInfo.eventData.containsKey("wu")) {
                SystemUtils.showToast(Toast.makeText(this.mContext, "暂不支持web点击", 1));
                this.mHandler.sendEmptyMessage(1);
                return;
            }
            final View findTargetView = PlaybackHelper.findTargetView(PrismWindowManager.getInstance().getTopWindow(), eventInfo);
            if (findTargetView != null) {
                if (!findTargetView.isClickable()) {
                    findTargetView = PlaybackHelper.getClickableView(findTargetView);
                }
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        PrismPlayback.this.highLightTriggerView(findTargetView, new OnAnimatorListener() {
                            public void onAnimationEnd() {
                                MotionHelper.simulateClick(findTargetView);
                                PrismPlayback.this.mHandler.sendEmptyMessage(1);
                            }
                        });
                    }
                }, 100);
            } else if (i == 3) {
                SystemUtils.showToast(Toast.makeText(this.mContext, "回放失败", 0));
            } else {
                Context context = this.mContext;
                StringBuilder sb = new StringBuilder();
                sb.append("正在重试(");
                int i2 = i + 1;
                sb.append(i2);
                sb.append(")");
                SystemUtils.showToast(Toast.makeText(context, sb.toString(), 0));
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.arg1 = i2;
                this.mHandler.sendMessageDelayed(obtainMessage, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            }
        } else if (eventInfo.eventType == 6) {
            SystemUtils.showToast(Toast.makeText(this.mContext, "页面跳转", 0));
            this.mHandler.sendEmptyMessage(1);
        } else if (eventInfo.eventType == 1) {
            SystemUtils.showToast(Toast.makeText(this.mContext, "返回", 0));
            MotionHelper.simulateBack();
            this.mHandler.sendEmptyMessage(1);
        } else if (eventInfo.eventType == 4) {
            this.mHandler.sendEmptyMessage(1);
        } else if (eventInfo.eventType == 5) {
            this.mHandler.sendEmptyMessage(1);
        } else if (eventInfo.eventType == 2) {
            SystemUtils.showToast(Toast.makeText(this.mContext, "App退至后台", 0));
            this.mHandler.sendEmptyMessage(1);
        } else if (eventInfo.eventType == 3) {
            SystemUtils.showToast(Toast.makeText(this.mContext, "App进入前台", 0));
            this.mHandler.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: private */
    public void highLightTriggerView(final View view, final OnAnimatorListener onAnimatorListener) {
        final C167024 r0 = new Drawable() {
            public int getOpacity() {
                return -3;
            }

            public void setAlpha(int i) {
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }

            public void draw(Canvas canvas) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
                Paint paint = new Paint();
                paint.setColor(-1711341568);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(rectF, 8.0f, 8.0f, paint);
            }
        };
        view.getOverlay().add(r0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.5f, 1.0f});
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, boolean z) {
                view.getOverlay().remove(r0);
                OnAnimatorListener onAnimatorListener = onAnimatorListener;
                if (onAnimatorListener != null) {
                    onAnimatorListener.onAnimationEnd();
                }
            }
        });
        ofFloat.setDuration(1200);
        ofFloat.setRepeatCount(1);
        ofFloat.start();
    }
}
