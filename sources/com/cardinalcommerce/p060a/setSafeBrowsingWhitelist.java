package com.cardinalcommerce.p060a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cardinalcommerce.a.setSafeBrowsingWhitelist */
public class setSafeBrowsingWhitelist<T> extends setWebViewRenderProcessClient<T> {
    public static setWebViewRenderProcessClient<byte[]> Cardinal = new setSafeBrowsingWhitelist<byte[]>() {
        public final /* synthetic */ Object init(Object obj) {
            return Cardinal(obj);
        }

        private static byte[] Cardinal(Object obj) {
            List<Number> list = (List) obj;
            byte[] bArr = new byte[list.size()];
            int i = 0;
            for (Number byteValue : list) {
                bArr[i] = byteValue.byteValue();
                i++;
            }
            return bArr;
        }
    };
    public static setWebViewRenderProcessClient<double[]> CardinalActionCode = new setSafeBrowsingWhitelist<double[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List<Number> list = (List) obj;
            double[] dArr = new double[list.size()];
            int i = 0;
            for (Number doubleValue : list) {
                dArr[i] = doubleValue.doubleValue();
                i++;
            }
            return dArr;
        }
    };
    public static setWebViewRenderProcessClient<Boolean[]> CardinalEnvironment = new setSafeBrowsingWhitelist<Boolean[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Boolean) {
                        boolArr[i] = Boolean.valueOf(((Boolean) next).booleanValue());
                    } else if (next instanceof Number) {
                        boolArr[i] = Boolean.valueOf(((Number) next).intValue() != 0);
                    } else {
                        StringBuilder sb = new StringBuilder("can not convert ");
                        sb.append(next);
                        sb.append(" toBoolean");
                        throw new RuntimeException(sb.toString());
                    }
                    i++;
                }
            }
            return boolArr;
        }
    };
    public static setWebViewRenderProcessClient<Long[]> CardinalError = new setSafeBrowsingWhitelist<Long[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Float) {
                        lArr[i] = (Long) next;
                    } else {
                        lArr[i] = Long.valueOf(((Number) next).longValue());
                    }
                    i++;
                }
            }
            return lArr;
        }
    };
    public static setWebViewRenderProcessClient<Double[]> CardinalRenderType = new setSafeBrowsingWhitelist<Double[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Double) {
                        dArr[i] = (Double) next;
                    } else {
                        dArr[i] = Double.valueOf(((Number) next).doubleValue());
                    }
                    i++;
                }
            }
            return dArr;
        }
    };
    public static setWebViewRenderProcessClient<int[]> cca_continue = new setSafeBrowsingWhitelist<int[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List<Number> list = (List) obj;
            int[] iArr = new int[list.size()];
            int i = 0;
            for (Number intValue : list) {
                iArr[i] = intValue.intValue();
                i++;
            }
            return iArr;
        }
    };
    public static setWebViewRenderProcessClient<float[]> cleanup = new setSafeBrowsingWhitelist<float[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List<Number> list = (List) obj;
            float[] fArr = new float[list.size()];
            int i = 0;
            for (Number floatValue : list) {
                fArr[i] = floatValue.floatValue();
                i++;
            }
            return fArr;
        }
    };
    public static setWebViewRenderProcessClient<Byte[]> configure = new setSafeBrowsingWhitelist<Byte[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Byte) {
                        bArr[i] = (Byte) next;
                    } else {
                        bArr[i] = Byte.valueOf(((Number) next).byteValue());
                    }
                    i++;
                }
            }
            return bArr;
        }
    };
    public static setWebViewRenderProcessClient<Integer[]> getInstance = new setSafeBrowsingWhitelist<Integer[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Integer) {
                        numArr[i] = (Integer) next;
                    } else {
                        numArr[i] = Integer.valueOf(((Number) next).intValue());
                    }
                    i++;
                }
            }
            return numArr;
        }
    };
    public static setWebViewRenderProcessClient<Float[]> getSDKVersion = new setSafeBrowsingWhitelist<Float[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Float) {
                        fArr[i] = (Float) next;
                    } else {
                        fArr[i] = Float.valueOf(((Number) next).floatValue());
                    }
                    i++;
                }
            }
            return fArr;
        }
    };
    public static setWebViewRenderProcessClient<Character[]> getWarnings = new setSafeBrowsingWhitelist<Character[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    chArr[i] = Character.valueOf(next.toString().charAt(0));
                    i++;
                }
            }
            return chArr;
        }
    };
    public static setWebViewRenderProcessClient<char[]> init = new setSafeBrowsingWhitelist<char[]>() {
        public final /* synthetic */ Object init(Object obj) {
            return cca_continue(obj);
        }

        private static char[] cca_continue(Object obj) {
            List<Object> list = (List) obj;
            char[] cArr = new char[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                cArr[i] = obj2.toString().charAt(0);
                i++;
            }
            return cArr;
        }
    };
    public static setWebViewRenderProcessClient<boolean[]> valueOf = new setSafeBrowsingWhitelist<boolean[]>() {
        public final /* synthetic */ Object init(Object obj) {
            return configure(obj);
        }

        private static boolean[] configure(Object obj) {
            List<Boolean> list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            int i = 0;
            for (Boolean booleanValue : list) {
                zArr[i] = booleanValue.booleanValue();
                i++;
            }
            return zArr;
        }
    };
    public static setWebViewRenderProcessClient<long[]> values = new setSafeBrowsingWhitelist<long[]>() {
        public final /* synthetic */ Object init(Object obj) {
            List<Number> list = (List) obj;
            long[] jArr = new long[list.size()];
            int i = 0;
            for (Number intValue : list) {
                jArr[i] = (long) intValue.intValue();
                i++;
            }
            return jArr;
        }
    };

    public T init(Object obj) {
        return obj;
    }

    public setSafeBrowsingWhitelist(setWebContentsDebuggingEnabled setwebcontentsdebuggingenabled) {
        super((setWebContentsDebuggingEnabled) null);
    }

    public final Object configure() {
        return new ArrayList();
    }

    public final void Cardinal(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }
}
