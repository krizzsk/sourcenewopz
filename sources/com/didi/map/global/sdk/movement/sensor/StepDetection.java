package com.didi.map.global.sdk.movement.sensor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.util.DLog;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.sdk.movement.apollo.MovementApolloUtil;
import java.util.ArrayList;
import java.util.List;

public class StepDetection implements OrientationListener {

    /* renamed from: a */
    private static final float f27750a = MovementApolloUtil.getEngineStepLength();

    /* renamed from: b */
    private static final long f27751b = 400;

    /* renamed from: c */
    private static final long f27752c = 1000;

    /* renamed from: d */
    private static final float f27753d = 11.0f;

    /* renamed from: e */
    private static final float f27754e = 16.0f;

    /* renamed from: f */
    private static final float f27755f = 0.01f;

    /* renamed from: g */
    private static final float f27756g = 8.61f;

    /* renamed from: h */
    private Context f27757h;

    /* renamed from: i */
    private List<Acceleration> f27758i;

    /* renamed from: j */
    private WorkThread f27759j;

    /* renamed from: k */
    private long f27760k;

    /* renamed from: l */
    private long f27761l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public onDidiMovementListener f27762m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Acceleration f27763n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Acceleration f27764o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f27765p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Movement f27766q = Movement.STAY;

    /* renamed from: r */
    private PdrPoint f27767r;

    /* renamed from: s */
    private int f27768s;

    /* renamed from: t */
    private long f27769t;

    /* renamed from: u */
    private float f27770u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f27771v = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            Movement movement;
            super.handleMessage(message);
            if (message.what == 0 && StepDetection.this.f27762m != null) {
                StepDetection.m19884b(StepDetection.this);
                StepDetection.this.f27762m.onNewStep(StepDetection.this.f27765p);
                StepDetection.this.m19883a();
            }
            if (!(message.what != 1 || StepDetection.this.f27762m == null || (movement = (Movement) message.obj) == StepDetection.this.f27766q || movement == null)) {
                Movement unused = StepDetection.this.f27766q = movement;
                StepDetection.this.f27762m.onPrintLog(StepDetection.this.f27766q.toString());
                StepDetection.this.f27762m.onMovementChanged(StepDetection.this.f27766q);
            }
            if (message.what == 2 && StepDetection.this.f27762m != null) {
                StepDetection.this.f27762m.onPrintLog((String) message.obj);
            }
        }
    };

    /* renamed from: b */
    static /* synthetic */ int m19884b(StepDetection stepDetection) {
        int i = stepDetection.f27765p;
        stepDetection.f27765p = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19883a() {
        DLog.m7384d("StepDetection", "onNew PdrPoint：" + this.f27767r, new Object[0]);
        if (this.f27767r == null) {
            this.f27767r = new PdrPoint(0.0f, 0.0f);
            this.f27768s = this.f27765p;
            this.f27769t = System.currentTimeMillis();
            onDidiMovementListener ondidimovementlistener = this.f27762m;
            if (ondidimovementlistener != null) {
                ondidimovementlistener.onPdrPointChanged(this.f27767r);
                return;
            }
            return;
        }
        int i = this.f27765p;
        int i2 = this.f27768s;
        if (i > i2) {
            float f = f27750a * ((float) (i - i2));
            DLog.m7384d("StepDetection", "步行速度：" + ((f / ((float) (System.currentTimeMillis() - this.f27769t))) * 1000.0f), new Object[0]);
            this.f27767r = PdrPoint.getNextPoint(this.f27767r, f, this.f27770u);
            this.f27768s = this.f27765p;
            this.f27769t = System.currentTimeMillis();
            onDidiMovementListener ondidimovementlistener2 = this.f27762m;
            if (ondidimovementlistener2 != null) {
                ondidimovementlistener2.onPdrPointChanged(this.f27767r);
            }
        }
    }

    public StepDetection(Context context, long j, onDidiMovementListener ondidimovementlistener) {
        this.f27761l = j;
        this.f27762m = ondidimovementlistener;
        this.f27759j = new WorkThread();
        this.f27760k = System.currentTimeMillis();
        this.f27757h = context;
        OrientationManager.getInstance(context).addOrientationListener(this);
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        this.f27770u = (f + 360.0f) % 360.0f;
    }

    public void onReceiveAcceleration(Acceleration acceleration) {
        WorkThread workThread;
        if (acceleration != null) {
            if (this.f27758i == null) {
                this.f27758i = new ArrayList();
            }
            onDidiMovementListener ondidimovementlistener = this.f27762m;
            if (ondidimovementlistener != null) {
                ondidimovementlistener.onShowLine(acceleration.data);
            }
            this.f27758i.add(acceleration);
            if (System.currentTimeMillis() - this.f27760k > this.f27761l && (workThread = this.f27759j) != null) {
                workThread.executeTask(new MyTask(this.f27758i));
                this.f27758i = null;
                this.f27760k = System.currentTimeMillis();
            }
        }
    }

    public void destroy() {
        WorkThread workThread = this.f27759j;
        if (workThread != null) {
            workThread.destroy();
            this.f27759j = null;
        }
        this.f27762m = null;
        Handler handler = this.f27771v;
        if (handler != null) {
            handler.removeMessages(0);
            this.f27771v.removeMessages(1);
            this.f27771v.removeMessages(2);
            this.f27771v = null;
        }
        List<Acceleration> list = this.f27758i;
        if (list != null) {
            list.clear();
            this.f27758i = null;
        }
        OrientationManager.getInstance(this.f27757h).removeOrientationListener(this);
        this.f27757h = null;
    }

    private class MyTask implements Runnable {
        private List<Acceleration> values;

        public MyTask(List<Acceleration> list) {
            this.values = list;
        }

        public void run() {
            int i;
            List<Acceleration> list = this.values;
            if (list == null || !list.isEmpty()) {
                int size = this.values.size();
                int[] iArr = new int[size];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    i = size - 1;
                    if (i3 >= i) {
                        break;
                    }
                    int i4 = i3 + 1;
                    if (this.values.get(i4).data - this.values.get(i3).data > 0.0f) {
                        iArr[i3] = 1;
                    } else if (this.values.get(i4).data - this.values.get(i3).data < 0.0f) {
                        iArr[i3] = -1;
                    } else {
                        iArr[i3] = 0;
                    }
                    i3 = i4;
                }
                for (int i5 = 1; i5 < i; i5++) {
                    if (iArr[i5] == 0) {
                        if (i5 == size - 2) {
                            if (iArr[i5 - 1] >= 0) {
                                iArr[i5] = 1;
                            } else {
                                iArr[i5] = -1;
                            }
                        } else if (iArr[i5 + 1] >= 0) {
                            iArr[i5] = 1;
                        } else {
                            iArr[i5] = -1;
                        }
                    }
                }
                while (i2 < i) {
                    int i6 = i2 + 1;
                    int i7 = iArr[i6] - iArr[i2];
                    Acceleration acceleration = this.values.get(i6);
                    if (i7 == -2) {
                        if (checkThresholdTop(acceleration)) {
                            callBackNewStep();
                        }
                    } else if (i7 == 2) {
                        checkThresholdBom(acceleration);
                    }
                    i2 = i6;
                }
                if (StepDetection.this.f27763n == null || System.currentTimeMillis() - StepDetection.this.f27763n.time > 2000) {
                    callBackMovement(Movement.STAY);
                }
            }
        }

        private void checkThresholdBom(Acceleration acceleration) {
            if (acceleration == null) {
                callBackLog("checkThresholdBom 入参: null ");
            } else if (acceleration.data < StepDetection.f27755f || acceleration.data > StepDetection.f27756g) {
                callBackLog("checkThresholdBom : 不符合阈值，伪波谷： " + acceleration.data);
            } else if (StepDetection.this.f27763n != null) {
                Acceleration unused = StepDetection.this.f27764o = acceleration;
                callBackLog("checkThresholdBom : 新波谷： " + acceleration.data);
            } else {
                callBackLog("checkThresholdBom : 等待波峰： " + acceleration.data);
            }
        }

        private boolean checkThresholdTop(Acceleration acceleration) {
            if (acceleration == null) {
                callBackLog("checkThresholdTop 入参: null ");
                return false;
            } else if (acceleration.data < StepDetection.f27753d || acceleration.data > StepDetection.f27754e) {
                callBackLog("checkThreshold 超出阈值，伪波峰, " + acceleration.data);
                return false;
            } else if (StepDetection.this.f27763n != null) {
                float f = (float) (acceleration.time - StepDetection.this.f27763n.time);
                if (f < 400.0f) {
                    callBackLog("checkThreshold 时间太短，伪波峰, " + acceleration.data + "," + f);
                    return false;
                } else if (f > 1000.0f) {
                    Acceleration unused = StepDetection.this.f27763n = acceleration;
                    Acceleration unused2 = StepDetection.this.f27764o = null;
                    callBackLog("checkThreshold 时间太长,重置， 新波峰, " + acceleration.data + "," + f);
                    return false;
                } else if (StepDetection.this.f27764o == null || StepDetection.this.f27763n.time >= StepDetection.this.f27764o.time) {
                    callBackLog("checkThreshold 连续波峰,丢弃 " + acceleration.data + "," + f);
                    return false;
                } else {
                    Acceleration unused3 = StepDetection.this.f27763n = acceleration;
                    callBackLog("2个波峰＋一个波谷， 走了一步," + acceleration.data + "," + f);
                    return true;
                }
            } else {
                callBackLog("checkThreshold 首个波峰, " + acceleration.data);
                Acceleration unused4 = StepDetection.this.f27763n = acceleration;
                Acceleration unused5 = StepDetection.this.f27764o = null;
                return false;
            }
        }

        private void callBackLog(String str) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            StepDetection.this.f27771v.sendMessage(obtain);
        }

        private void callBackNewStep() {
            Message obtain = Message.obtain();
            obtain.what = 0;
            StepDetection.this.f27771v.sendMessage(obtain);
            callBackMovement(Movement.WALKING);
        }

        private void callBackMovement(Movement movement) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = movement;
            StepDetection.this.f27771v.sendMessage(obtain);
        }
    }

    public static class Acceleration {
        float data;
        long time;

        public Acceleration(float f, long j) {
            this.data = f;
            this.time = j;
        }

        public String toString() {
            return "data: " + this.data + "-----time= " + this.time;
        }
    }
}
