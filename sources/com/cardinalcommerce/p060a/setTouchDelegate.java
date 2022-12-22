package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setAlpha;
import com.cardinalcommerce.p060a.setPivotX;
import com.cardinalcommerce.p060a.setTransitionAlpha;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* renamed from: com.cardinalcommerce.a.setTouchDelegate */
public final class setTouchDelegate implements Serializable {
    private transient setScaleY Cardinal;
    private Stack<setY> CardinalError;
    private int cca_continue;
    private setY cleanup;
    int configure;
    private final List<setRotation> getInstance;
    private Map<Integer, setY> getSDKVersion;
    private List<setY> getWarnings;
    private final int init;
    private boolean valueOf;
    private Map<Integer, LinkedList<setY>> values;

    private setTouchDelegate(setScaleY setscaley, int i, int i2) {
        this.Cardinal = setscaley;
        this.init = i;
        this.cca_continue = i2;
        if (i2 <= i && i2 >= 2) {
            int i3 = i - i2;
            if (i3 % 2 == 0) {
                this.getWarnings = new ArrayList();
                this.values = new TreeMap();
                this.CardinalError = new Stack<>();
                this.getInstance = new ArrayList();
                for (int i4 = 0; i4 < i3; i4++) {
                    this.getInstance.add(new setRotation(i4));
                }
                this.getSDKVersion = new TreeMap();
                this.configure = 0;
                this.valueOf = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    setTouchDelegate(setTouchDelegate settouchdelegate, byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha) {
        this.Cardinal = settouchdelegate.Cardinal;
        this.init = settouchdelegate.init;
        this.cca_continue = settouchdelegate.cca_continue;
        this.cleanup = settouchdelegate.cleanup;
        ArrayList arrayList = new ArrayList();
        this.getWarnings = arrayList;
        arrayList.addAll(settouchdelegate.getWarnings);
        this.values = settouchdelegate.values;
        Stack<setY> stack = new Stack<>();
        this.CardinalError = stack;
        stack.addAll(settouchdelegate.CardinalError);
        this.getInstance = settouchdelegate.getInstance;
        this.getSDKVersion = new TreeMap(settouchdelegate.getSDKVersion);
        this.configure = settouchdelegate.configure;
        cca_continue(bArr, bArr2, settransitionalpha);
        settouchdelegate.valueOf = true;
    }

    setTouchDelegate(setStateListAnimator setstatelistanimator, int i) {
        this(setstatelistanimator.init, setstatelistanimator.Cardinal, setstatelistanimator.f2998b);
        this.configure = i;
        this.valueOf = true;
    }

    setTouchDelegate(setStateListAnimator setstatelistanimator, byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha) {
        this(setstatelistanimator.init, setstatelistanimator.Cardinal, setstatelistanimator.f2998b);
        init(bArr, bArr2, settransitionalpha);
    }

    setTouchDelegate(setStateListAnimator setstatelistanimator, byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha, int i) {
        this(setstatelistanimator.init, setstatelistanimator.Cardinal, setstatelistanimator.f2998b);
        init(bArr, bArr2, settransitionalpha);
        while (this.configure < i) {
            cca_continue(bArr, bArr2, settransitionalpha);
            this.valueOf = false;
        }
    }

    public setTouchDelegate(setTouchDelegate settouchdelegate, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.Cardinal = new setScaleY(new setLeft(mQVwithSHA256KDFAndSharedInfo));
        this.init = settouchdelegate.init;
        this.cca_continue = settouchdelegate.cca_continue;
        this.cleanup = settouchdelegate.cleanup;
        ArrayList arrayList = new ArrayList();
        this.getWarnings = arrayList;
        arrayList.addAll(settouchdelegate.getWarnings);
        this.values = settouchdelegate.values;
        Stack<setY> stack = new Stack<>();
        this.CardinalError = stack;
        stack.addAll(settouchdelegate.CardinalError);
        this.getInstance = settouchdelegate.getInstance;
        TreeMap treeMap = new TreeMap(settouchdelegate.getSDKVersion);
        this.getSDKVersion = treeMap;
        int i = settouchdelegate.configure;
        this.configure = i;
        this.valueOf = settouchdelegate.valueOf;
        if (this.getWarnings == null) {
            throw new IllegalStateException("authenticationPath == null");
        } else if (this.values == null) {
            throw new IllegalStateException("retain == null");
        } else if (this.CardinalError == null) {
            throw new IllegalStateException("stack == null");
        } else if (this.getInstance == null) {
            throw new IllegalStateException("treeHashInstances == null");
        } else if (treeMap == null) {
            throw new IllegalStateException("keep == null");
        } else if (!setVerticalFadingEdgeEnabled.cca_continue(this.init, (long) i)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    private void init(byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha) {
        if (settransitionalpha != null) {
            setPivotX setpivotx = new setPivotX((setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d), (byte) 0);
            setAlpha setalpha = new setAlpha((setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d), (byte) 0);
            for (int i = 0; i < (1 << this.init); i++) {
                setTransitionAlpha.cca_continue cca_continue2 = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d);
                cca_continue2.cca_continue = i;
                cca_continue2.configure = settransitionalpha.f3069b;
                cca_continue2.init = settransitionalpha.f3070f;
                settransitionalpha = new setTransitionAlpha((setTransitionAlpha.cca_continue) cca_continue2.init(settransitionalpha.f2705e), (byte) 0);
                setScaleY setscaley = this.Cardinal;
                setscaley.mo18701a(setscaley.cca_continue(bArr2, settransitionalpha), bArr);
                C2130u Cardinal2 = this.Cardinal.Cardinal(settransitionalpha);
                setPivotX.Cardinal cardinal = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx.f2703c)).getInstance(setpivotx.f2704d);
                cardinal.getInstance = i;
                cardinal.Cardinal = setpivotx.f2920b;
                cardinal.cca_continue = setpivotx.f2921f;
                setpivotx = new setPivotX((setPivotX.Cardinal) cardinal.init(setpivotx.f2705e), (byte) 0);
                setY init2 = setClipToOutline.init(this.Cardinal, Cardinal2, setpivotx);
                setAlpha.getInstance getinstance = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha.f2703c)).getInstance(setalpha.f2704d);
                getinstance.cca_continue = i;
                setalpha = new setAlpha((setAlpha.getInstance) getinstance.init(setalpha.f2705e), (byte) 0);
                while (!this.CardinalError.isEmpty() && this.CardinalError.peek().init == init2.init) {
                    int i2 = i / (1 << init2.init);
                    if (i2 == 1) {
                        this.getWarnings.add(init2.init());
                    }
                    if (i2 == 3 && init2.init < this.init - this.cca_continue) {
                        setRotation setrotation = this.getInstance.get(init2.init);
                        setY init3 = init2.init();
                        setrotation.Cardinal = init3;
                        setrotation.cca_continue = init3.init;
                        if (setrotation.cca_continue == setrotation.getInstance) {
                            setrotation.getSDKVersion = true;
                        }
                    }
                    if (i2 >= 3 && (i2 & 1) == 1 && init2.init >= this.init - this.cca_continue && init2.init <= this.init - 2) {
                        if (this.values.get(Integer.valueOf(init2.init)) == null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(init2.init());
                            this.values.put(Integer.valueOf(init2.init), linkedList);
                        } else {
                            this.values.get(Integer.valueOf(init2.init)).add(init2.init());
                        }
                    }
                    setAlpha.getInstance getinstance2 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha.f2703c)).getInstance(setalpha.f2704d);
                    getinstance2.getInstance = setalpha.f2667a;
                    getinstance2.cca_continue = (setalpha.f2668b - 1) / 2;
                    setAlpha setalpha2 = new setAlpha((setAlpha.getInstance) getinstance2.init(setalpha.f2705e), (byte) 0);
                    setY init4 = setClipToOutline.init(this.Cardinal, this.CardinalError.pop(), init2, setalpha2);
                    init2 = new setY(init4.init + 1, init4.getInstance());
                    setAlpha.getInstance getinstance3 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha2.f2703c)).getInstance(setalpha2.f2704d);
                    getinstance3.getInstance = setalpha2.f2667a + 1;
                    getinstance3.cca_continue = setalpha2.f2668b;
                    setalpha = new setAlpha((setAlpha.getInstance) getinstance3.init(setalpha2.f2705e), (byte) 0);
                }
                this.CardinalError.push(init2);
            }
            this.cleanup = this.CardinalError.pop();
            return;
        }
        throw new NullPointerException("otsHashAddress == null");
    }

    private void cca_continue(byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha) {
        Object obj;
        List<setY> list;
        if (settransitionalpha == null) {
            throw new NullPointerException("otsHashAddress == null");
        } else if (!this.valueOf) {
            int i = this.configure;
            int i2 = this.init;
            if (i <= (1 << i2) - 2) {
                int Cardinal2 = setVerticalFadingEdgeEnabled.Cardinal(i, i2);
                if (((this.configure >> (Cardinal2 + 1)) & 1) == 0 && Cardinal2 < this.init - 1) {
                    this.getSDKVersion.put(Integer.valueOf(Cardinal2), this.getWarnings.get(Cardinal2).init());
                }
                setPivotX setpivotx = new setPivotX((setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d), (byte) 0);
                setAlpha setalpha = new setAlpha((setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d), (byte) 0);
                if (Cardinal2 == 0) {
                    setTransitionAlpha.cca_continue cca_continue2 = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d);
                    cca_continue2.cca_continue = this.configure;
                    cca_continue2.configure = settransitionalpha.f3069b;
                    cca_continue2.init = settransitionalpha.f3070f;
                    settransitionalpha = new setTransitionAlpha((setTransitionAlpha.cca_continue) cca_continue2.init(settransitionalpha.f2705e), (byte) 0);
                    setScaleY setscaley = this.Cardinal;
                    setscaley.mo18701a(setscaley.cca_continue(bArr2, settransitionalpha), bArr);
                    C2130u Cardinal3 = this.Cardinal.Cardinal(settransitionalpha);
                    setPivotX.Cardinal cardinal = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx.f2703c)).getInstance(setpivotx.f2704d);
                    cardinal.getInstance = this.configure;
                    cardinal.Cardinal = setpivotx.f2920b;
                    cardinal.cca_continue = setpivotx.f2921f;
                    this.getWarnings.set(0, setClipToOutline.init(this.Cardinal, Cardinal3, new setPivotX((setPivotX.Cardinal) cardinal.init(setpivotx.f2705e), (byte) 0)));
                } else {
                    setAlpha.getInstance getinstance = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha.f2703c)).getInstance(setalpha.f2704d);
                    int i3 = Cardinal2 - 1;
                    getinstance.getInstance = i3;
                    getinstance.cca_continue = this.configure >> Cardinal2;
                    setScaleY setscaley2 = this.Cardinal;
                    setscaley2.mo18701a(setscaley2.cca_continue(bArr2, settransitionalpha), bArr);
                    setY init2 = setClipToOutline.init(this.Cardinal, this.getWarnings.get(i3), this.getSDKVersion.get(Integer.valueOf(i3)), new setAlpha((setAlpha.getInstance) getinstance.init(setalpha.f2705e), (byte) 0));
                    this.getWarnings.set(Cardinal2, new setY(init2.init + 1, init2.getInstance()));
                    this.getSDKVersion.remove(Integer.valueOf(i3));
                    for (int i4 = 0; i4 < Cardinal2; i4++) {
                        if (i4 < this.init - this.cca_continue) {
                            list = this.getWarnings;
                            obj = this.getInstance.get(i4).cca_continue();
                        } else {
                            list = this.getWarnings;
                            obj = this.values.get(Integer.valueOf(i4)).removeFirst();
                        }
                        list.set(i4, obj);
                    }
                    int min = Math.min(Cardinal2, this.init - this.cca_continue);
                    for (int i5 = 0; i5 < min; i5++) {
                        int i6 = this.configure + 1 + ((1 << i5) * 3);
                        if (i6 < (1 << this.init)) {
                            setRotation setrotation = this.getInstance.get(i5);
                            setrotation.Cardinal = null;
                            setrotation.cca_continue = setrotation.getInstance;
                            setrotation.init = i6;
                            setrotation.configure = true;
                            setrotation.getSDKVersion = false;
                        }
                    }
                }
                for (int i7 = 0; i7 < ((this.init - this.cca_continue) >> 1); i7++) {
                    setRotation instance = getInstance();
                    if (instance != null) {
                        instance.configure(this.CardinalError, this.Cardinal, bArr, bArr2, settransitionalpha);
                    }
                }
                this.configure++;
                return;
            }
            throw new IllegalStateException("index out of bounds");
        } else {
            throw new IllegalStateException("index already used");
        }
    }

    private setRotation getInstance() {
        setRotation setrotation = null;
        for (setRotation next : this.getInstance) {
            if (!next.configure() && next.init()) {
                if (setrotation != null) {
                    int i = Integer.MAX_VALUE;
                    if (((!next.configure || next.getSDKVersion) ? Integer.MAX_VALUE : next.cca_continue) >= ((!setrotation.configure || setrotation.getSDKVersion) ? Integer.MAX_VALUE : setrotation.cca_continue)) {
                        int i2 = (!next.configure || next.getSDKVersion) ? Integer.MAX_VALUE : next.cca_continue;
                        if (setrotation.configure && !setrotation.getSDKVersion) {
                            i = setrotation.cca_continue;
                        }
                        if (i2 == i) {
                            if (next.init >= setrotation.init) {
                            }
                        }
                    }
                }
                setrotation = next;
            }
        }
        return setrotation;
    }
}
