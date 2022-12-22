package com.didi.global.fintech.cashier.p117ui.widget.tickerview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.LevenshteinUtils */
public class LevenshteinUtils {

    /* renamed from: a */
    static final int f21961a = 0;

    /* renamed from: b */
    static final int f21962b = 1;

    /* renamed from: c */
    static final int f21963c = 2;

    public static int[] computeColumnActions(char[] cArr, char[] cArr2, Set<Character> set) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = i == cArr.length;
            boolean z2 = i2 == cArr2.length;
            if (z && z2) {
                break;
            } else if (z) {
                m15914a((List<Integer>) arrayList, cArr2.length - i2, 1);
                break;
            } else if (z2) {
                m15914a((List<Integer>) arrayList, cArr.length - i, 2);
                break;
            } else {
                boolean contains = set.contains(Character.valueOf(cArr[i]));
                boolean contains2 = set.contains(Character.valueOf(cArr2[i2]));
                if (!contains || !contains2) {
                    if (contains) {
                        arrayList.add(1);
                    } else if (contains2) {
                        arrayList.add(2);
                        i++;
                    } else {
                        arrayList.add(0);
                        i++;
                    }
                    i2++;
                } else {
                    int a = m15913a(cArr, i + 1, set);
                    int a2 = m15913a(cArr2, i2 + 1, set);
                    m15915a(arrayList, cArr, cArr2, i, a, i2, a2);
                    i = a;
                    i2 = a2;
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    /* renamed from: a */
    private static int m15913a(char[] cArr, int i, Set<Character> set) {
        while (i < cArr.length) {
            if (!set.contains(Character.valueOf(cArr[i]))) {
                return i;
            }
            i++;
        }
        return cArr.length;
    }

    /* renamed from: a */
    private static void m15914a(List<Integer> list, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            list.add(Integer.valueOf(i2));
        }
    }

    /* renamed from: a */
    private static void m15915a(List<Integer> list, char[] cArr, char[] cArr2, int i, int i2, int i3, int i4) {
        List<Integer> list2 = list;
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int max = Math.max(i5, i6);
        if (i5 == i6) {
            m15914a(list2, max, 0);
            return;
        }
        int i7 = i5 + 1;
        int i8 = i6 + 1;
        int[] iArr = new int[2];
        iArr[1] = i8;
        iArr[0] = i7;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i9 = 0; i9 < i7; i9++) {
            iArr2[i9][0] = i9;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            iArr2[0][i10] = i10;
        }
        for (int i11 = 1; i11 < i7; i11++) {
            for (int i12 = 1; i12 < i8; i12++) {
                int i13 = i11 - 1;
                int i14 = i12 - 1;
                iArr2[i11][i12] = m15912a(iArr2[i13][i12] + 1, iArr2[i11][i14] + 1, iArr2[i13][i14] + (cArr[i13 + i] == cArr2[i14 + i3] ? 0 : 1));
            }
        }
        ArrayList arrayList = new ArrayList(max * 2);
        int i15 = i7 - 1;
        int i16 = i8 - 1;
        while (true) {
            if (i15 <= 0 && i16 <= 0) {
                break;
            }
            if (i15 == 0) {
                arrayList.add(1);
            } else {
                if (i16 == 0) {
                    arrayList.add(2);
                } else {
                    int i17 = i16 - 1;
                    int i18 = iArr2[i15][i17];
                    int i19 = i15 - 1;
                    int i20 = iArr2[i19][i16];
                    int i21 = iArr2[i19][i17];
                    if (i18 < i20 && i18 < i21) {
                        arrayList.add(1);
                    } else if (i20 < i21) {
                        arrayList.add(2);
                    } else {
                        arrayList.add(0);
                        i15--;
                    }
                }
                i15--;
            }
            i16--;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list2.add(arrayList.get(size));
        }
    }

    /* renamed from: a */
    private static int m15912a(int i, int i2, int i3) {
        return Math.min(i, Math.min(i2, i3));
    }
}
