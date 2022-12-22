package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.setVerticalScrollbarOverlay */
public final class setVerticalScrollbarOverlay {
    public static final setNetworkAvailable<Iterable<? extends Object>> Cardinal = new setNetworkAvailable<Iterable<? extends Object>>() {
        public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            setLayoutAnimation.init(appendable);
            boolean z = true;
            for (Object next : (Iterable) obj) {
                if (z) {
                    z = false;
                } else {
                    setLayoutAnimation.values(appendable);
                }
                if (next == null) {
                    appendable.append("null");
                } else {
                    setAddStatesFromChildren.init(next, appendable, setlayoutanimation);
                }
            }
            setLayoutAnimation.CardinalError(appendable);
        }
    };

    /* renamed from: a */
    private static setNetworkAvailable<setClipToPadding> f3084a = new setNetworkAvailable<setClipToPadding>() {
        public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            ((setClipToPadding) obj).Cardinal(appendable);
        }
    };

    /* renamed from: b */
    private static setNetworkAvailable<setClipToPadding> f3085b = new setNetworkAvailable<setClipToPadding>() {
        public final /* bridge */ /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            ((setClipToPadding) obj).init(appendable, setlayoutanimation);
        }
    };

    /* renamed from: c */
    private static setNetworkAvailable<setTransitionGroup> f3086c = new setNetworkAvailable<setTransitionGroup>() {
        public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            appendable.append(((setTransitionGroup) obj).Cardinal(setlayoutanimation));
        }
    };
    public static final setNetworkAvailable<Object> cleanup = new setLayoutAnimationListener();

    /* renamed from: d */
    private static setNetworkAvailable<setMotionEventSplittingEnabled> f3087d = new setNetworkAvailable<setMotionEventSplittingEnabled>() {
        public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            appendable.append(((setMotionEventSplittingEnabled) obj).configure());
        }
    };

    /* renamed from: e */
    private static setNetworkAvailable<Enum<?>> f3088e = new setNetworkAvailable<Enum<?>>() {
        public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            setlayoutanimation.Cardinal(appendable, ((Enum) obj).name());
        }
    };

    /* renamed from: f */
    private static setNetworkAvailable<Object> f3089f = new setNetworkAvailable<Object>() {
        public final void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            appendable.append(obj.toString());
        }
    };
    public static final setNetworkAvailable<Map<String, ? extends Object>> getInstance = new setNetworkAvailable<Map<String, ? extends Object>>() {
        public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
            setLayoutAnimation.getInstance(appendable);
            boolean z = true;
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (value != null || !setlayoutanimation.cca_continue()) {
                    if (z) {
                        z = false;
                    } else {
                        setLayoutAnimation.Cardinal(appendable);
                    }
                    setVerticalScrollbarOverlay.configure(entry.getKey().toString(), value, appendable, setlayoutanimation);
                }
            }
            setLayoutAnimation.cca_continue(appendable);
        }
    };
    public static final setNetworkAvailable<Object> init = new setHorizontalScrollbarOverlay();
    public ConcurrentHashMap<Class<?>, setNetworkAvailable<?>> cca_continue = new ConcurrentHashMap<>();
    public LinkedList<C2126init> configure = new LinkedList<>();

    public setVerticalScrollbarOverlay() {
        configure(new setNetworkAvailable<String>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setlayoutanimation.Cardinal(appendable, (String) obj);
            }
        }, String.class);
        configure(new setNetworkAvailable<Double>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                Double d = (Double) obj;
                if (d.isInfinite()) {
                    appendable.append("null");
                } else {
                    appendable.append(d.toString());
                }
            }
        }, Double.class);
        configure(new setNetworkAvailable<Date>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                appendable.append(Typography.quote);
                setAddStatesFromChildren.configure(((Date) obj).toString(), appendable, setlayoutanimation);
                appendable.append(Typography.quote);
            }
        }, Date.class);
        configure(new setNetworkAvailable<Float>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                Float f = (Float) obj;
                if (f.isInfinite()) {
                    appendable.append("null");
                } else {
                    appendable.append(f.toString());
                }
            }
        }, Float.class);
        configure(f3089f, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        configure(f3089f, Boolean.class);
        configure(new setNetworkAvailable<int[]>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setLayoutAnimation.init(appendable);
                boolean z = false;
                for (int i : (int[]) obj) {
                    if (z) {
                        setLayoutAnimation.Cardinal(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Integer.toString(i));
                }
                setLayoutAnimation.CardinalError(appendable);
            }
        }, int[].class);
        configure(new setNetworkAvailable<short[]>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setLayoutAnimation.init(appendable);
                boolean z = false;
                for (short s : (short[]) obj) {
                    if (z) {
                        setLayoutAnimation.Cardinal(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Short.toString(s));
                }
                setLayoutAnimation.CardinalError(appendable);
            }
        }, short[].class);
        configure(new setNetworkAvailable<long[]>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setLayoutAnimation.init(appendable);
                boolean z = false;
                for (long j : (long[]) obj) {
                    if (z) {
                        setLayoutAnimation.Cardinal(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Long.toString(j));
                }
                setLayoutAnimation.CardinalError(appendable);
            }
        }, long[].class);
        configure(new setNetworkAvailable<float[]>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setLayoutAnimation.init(appendable);
                boolean z = false;
                for (float f : (float[]) obj) {
                    if (z) {
                        setLayoutAnimation.Cardinal(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Float.toString(f));
                }
                setLayoutAnimation.CardinalError(appendable);
            }
        }, float[].class);
        configure(new setNetworkAvailable<double[]>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setLayoutAnimation.init(appendable);
                boolean z = false;
                for (double d : (double[]) obj) {
                    if (z) {
                        setLayoutAnimation.Cardinal(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Double.toString(d));
                }
                setLayoutAnimation.CardinalError(appendable);
            }
        }, double[].class);
        configure(new setNetworkAvailable<boolean[]>() {
            public final /* synthetic */ void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
                setLayoutAnimation.init(appendable);
                boolean z = false;
                for (boolean z2 : (boolean[]) obj) {
                    if (z) {
                        setLayoutAnimation.Cardinal(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Boolean.toString(z2));
                }
                setLayoutAnimation.CardinalError(appendable);
            }
        }, boolean[].class);
        this.configure.addLast(new C2126init(setClipToPadding.class, f3085b));
        this.configure.addLast(new C2126init(setOnHierarchyChangeListener.class, f3084a));
        this.configure.addLast(new C2126init(setTransitionGroup.class, f3086c));
        this.configure.addLast(new C2126init(setMotionEventSplittingEnabled.class, f3087d));
        this.configure.addLast(new C2126init(Map.class, getInstance));
        this.configure.addLast(new C2126init(Iterable.class, Cardinal));
        this.configure.addLast(new C2126init(Enum.class, f3088e));
        this.configure.addLast(new C2126init(Number.class, f3089f));
    }

    /* renamed from: com.cardinalcommerce.a.setVerticalScrollbarOverlay$init */
    public static class C2126init {
        public setNetworkAvailable<?> cca_continue;
        public Class<?> init;

        public C2126init(Class<?> cls, setNetworkAvailable<?> setnetworkavailable) {
            this.init = cls;
            this.cca_continue = setnetworkavailable;
        }
    }

    public final <T> void configure(setNetworkAvailable<T> setnetworkavailable, Class<?>... clsArr) {
        for (Class<?> put : clsArr) {
            this.cca_continue.put(put, setnetworkavailable);
        }
    }

    public static void configure(String str, Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        if (str == null) {
            appendable.append("null");
        } else if (!setlayoutanimation.Cardinal(str)) {
            appendable.append(str);
        } else {
            appendable.append(Typography.quote);
            setAddStatesFromChildren.configure(str, appendable, setlayoutanimation);
            appendable.append(Typography.quote);
        }
        setLayoutAnimation.configure(appendable);
        if (obj instanceof String) {
            setlayoutanimation.Cardinal(appendable, (String) obj);
        } else {
            setAddStatesFromChildren.init(obj, appendable, setlayoutanimation);
        }
    }
}
