package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setAlpha;
import com.cardinalcommerce.p060a.setPivotX;
import com.cardinalcommerce.p060a.setTransitionAlpha;
import java.io.Serializable;
import java.util.Stack;

/* renamed from: com.cardinalcommerce.a.setRotation */
final class setRotation implements Serializable {
    setY Cardinal;
    int cca_continue;
    boolean configure = false;
    final int getInstance;
    boolean getSDKVersion = false;
    int init;

    setRotation(int i) {
        this.getInstance = i;
    }

    public final setY cca_continue() {
        return this.Cardinal.init();
    }

    /* access modifiers changed from: package-private */
    public final boolean configure() {
        return this.getSDKVersion;
    }

    /* access modifiers changed from: package-private */
    public final boolean init() {
        return this.configure;
    }

    /* access modifiers changed from: package-private */
    public final void configure(Stack<setY> stack, setScaleY setscaley, byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha) {
        if (settransitionalpha == null) {
            throw new NullPointerException("otsHashAddress == null");
        } else if (this.getSDKVersion || !this.configure) {
            throw new IllegalStateException("finished or not initialized");
        } else {
            setTransitionAlpha.cca_continue cca_continue2 = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d);
            cca_continue2.cca_continue = this.init;
            cca_continue2.configure = settransitionalpha.f3069b;
            cca_continue2.init = settransitionalpha.f3070f;
            setTransitionAlpha settransitionalpha2 = new setTransitionAlpha((setTransitionAlpha.cca_continue) cca_continue2.init(settransitionalpha.f2705e), (byte) 0);
            setPivotX.Cardinal cardinal = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(settransitionalpha2.f2703c)).getInstance(settransitionalpha2.f2704d);
            cardinal.getInstance = this.init;
            setAlpha.getInstance getinstance = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(settransitionalpha2.f2703c)).getInstance(settransitionalpha2.f2704d);
            getinstance.cca_continue = this.init;
            setAlpha setalpha = new setAlpha(getinstance, (byte) 0);
            setscaley.mo18701a(setscaley.cca_continue(bArr2, settransitionalpha2), bArr);
            setY init2 = setClipToOutline.init(setscaley, setscaley.Cardinal(settransitionalpha2), new setPivotX(cardinal, (byte) 0));
            while (!stack.isEmpty() && stack.peek().init == init2.init && stack.peek().init != this.getInstance) {
                setAlpha.getInstance getinstance2 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha.f2703c)).getInstance(setalpha.f2704d);
                getinstance2.getInstance = setalpha.f2667a;
                getinstance2.cca_continue = (setalpha.f2668b - 1) / 2;
                setAlpha setalpha2 = new setAlpha((setAlpha.getInstance) getinstance2.init(setalpha.f2705e), (byte) 0);
                setY init3 = setClipToOutline.init(setscaley, stack.pop(), init2, setalpha2);
                setY sety = new setY(init3.init + 1, init3.getInstance());
                setAlpha.getInstance getinstance3 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha2.f2703c)).getInstance(setalpha2.f2704d);
                getinstance3.getInstance = setalpha2.f2667a + 1;
                getinstance3.cca_continue = setalpha2.f2668b;
                setalpha = new setAlpha((setAlpha.getInstance) getinstance3.init(setalpha2.f2705e), (byte) 0);
                init2 = sety;
            }
            setY sety2 = this.Cardinal;
            if (sety2 == null) {
                this.Cardinal = init2;
            } else if (sety2.init == init2.init) {
                setAlpha.getInstance getinstance4 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha.f2703c)).getInstance(setalpha.f2704d);
                getinstance4.getInstance = setalpha.f2667a;
                getinstance4.cca_continue = (setalpha.f2668b - 1) / 2;
                setAlpha setalpha3 = new setAlpha((setAlpha.getInstance) getinstance4.init(setalpha.f2705e), (byte) 0);
                init2 = new setY(this.Cardinal.init + 1, setClipToOutline.init(setscaley, this.Cardinal, init2, setalpha3).getInstance());
                this.Cardinal = init2;
                setAlpha.getInstance getinstance5 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha3.f2703c)).getInstance(setalpha3.f2704d);
                getinstance5.getInstance = setalpha3.f2667a + 1;
                getinstance5.cca_continue = setalpha3.f2668b;
                new setAlpha((setAlpha.getInstance) getinstance5.init(setalpha3.f2705e), (byte) 0);
            } else {
                stack.push(init2);
            }
            if (this.Cardinal.init == this.getInstance) {
                this.getSDKVersion = true;
                return;
            }
            this.cca_continue = init2.init;
            this.init++;
        }
    }
}
