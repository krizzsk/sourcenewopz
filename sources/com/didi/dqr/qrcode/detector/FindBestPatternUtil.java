package com.didi.dqr.qrcode.detector;

import com.didi.dqr.NotFoundException;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindBestPatternUtil {

    /* renamed from: a */
    private static final int f19048a = DqrConfigHelper.patternCorrectRate();

    /* renamed from: b */
    private static BestPatternMethodEnum f19049b = null;

    public static FinderPattern findBestPattern(List<FinderPattern> list) {
        FinderPattern finderPattern = null;
        for (FinderPattern next : list) {
            if (finderPattern == null || next.getCount() > finderPattern.getCount()) {
                finderPattern = next;
            }
        }
        return finderPattern;
    }

    /* renamed from: com.didi.dqr.qrcode.detector.FindBestPatternUtil$2 */
    static /* synthetic */ class C79012 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dqr$qrcode$detector$BestPatternMethodEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.dqr.qrcode.detector.BestPatternMethodEnum[] r0 = com.didi.dqr.qrcode.detector.BestPatternMethodEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dqr$qrcode$detector$BestPatternMethodEnum = r0
                com.didi.dqr.qrcode.detector.BestPatternMethodEnum r1 = com.didi.dqr.qrcode.detector.BestPatternMethodEnum.TYPE_MIX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dqr$qrcode$detector$BestPatternMethodEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dqr.qrcode.detector.BestPatternMethodEnum r1 = com.didi.dqr.qrcode.detector.BestPatternMethodEnum.TYPE_SHAPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dqr$qrcode$detector$BestPatternMethodEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dqr.qrcode.detector.BestPatternMethodEnum r1 = com.didi.dqr.qrcode.detector.BestPatternMethodEnum.TYPE_MOUDLE_SIZE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.qrcode.detector.FindBestPatternUtil.C79012.<clinit>():void");
        }
    }

    public static FinderPattern[] findBestPoint(List<FinderPattern> list, BestPatternMethodEnum bestPatternMethodEnum) throws NotFoundException {
        int i = C79012.$SwitchMap$com$didi$dqr$qrcode$detector$BestPatternMethodEnum[bestPatternMethodEnum.ordinal()];
        if (i == 1) {
            BestPatternMethodEnum bestPatternMethodEnum2 = f19049b;
            if (bestPatternMethodEnum2 == null || bestPatternMethodEnum2 == BestPatternMethodEnum.TYPE_SHAPE) {
                f19049b = BestPatternMethodEnum.TYPE_MOUDLE_SIZE;
                return m14247a(list);
            } else if (f19049b == BestPatternMethodEnum.TYPE_MOUDLE_SIZE) {
                f19049b = BestPatternMethodEnum.TYPE_SHAPE;
                return m14248b(list);
            }
        } else if (i == 2) {
            f19049b = BestPatternMethodEnum.TYPE_SHAPE;
            return m14248b(list);
        } else if (i == 3) {
            f19049b = BestPatternMethodEnum.TYPE_MOUDLE_SIZE;
            return m14247a(list);
        }
        return m14247a(list);
    }

    /* renamed from: a */
    private static FinderPattern[] m14247a(List<FinderPattern> list) throws NotFoundException {
        int size = list.size();
        if (size >= 3) {
            float f = 0.0f;
            if (size > 3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (FinderPattern estimatedModuleSize : list) {
                    float estimatedModuleSize2 = estimatedModuleSize.getEstimatedModuleSize();
                    f2 += estimatedModuleSize2;
                    f3 += estimatedModuleSize2 * estimatedModuleSize2;
                }
                float f4 = (float) size;
                float f5 = f2 / f4;
                Collections.sort(list, new FurthestFromAverageComparator(f5));
                float max = Math.max(0.2f * f5, (float) Math.sqrt((double) ((f3 / f4) - (f5 * f5))));
                int i = 0;
                while (i < list.size() && list.size() > 3) {
                    if (Math.abs(list.get(i).getEstimatedModuleSize() - f5) > max) {
                        list.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (list.size() > 3) {
                for (FinderPattern estimatedModuleSize3 : list) {
                    f += estimatedModuleSize3.getEstimatedModuleSize();
                }
                Collections.sort(list, new CenterComparator(f / ((float) list.size())));
                list.subList(3, list.size()).clear();
            }
            return new FinderPattern[]{list.get(0), list.get(1), list.get(2)};
        }
        AnalysisManager.report(EventId.FINDER_PATTERN_FIND_FAILED);
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: b */
    private static FinderPattern[] m14248b(List<FinderPattern> list) throws NotFoundException {
        if (list.size() >= 3) {
            boolean usePatternCorrect = DqrConfigHelper.usePatternCorrect();
            if (list.size() == 3 && !usePatternCorrect) {
                return (FinderPattern[]) list.toArray(new FinderPattern[list.size()]);
            }
            if (list.size() > 30) {
                return m14247a(list);
            }
            PointMatchData pointMatchData = null;
            int i = 0;
            while (i < list.size()) {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < list.size()) {
                    int i4 = i3 + 1;
                    for (int i5 = i4; i5 < list.size(); i5++) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(list.get(i));
                        arrayList.add(list.get(i3));
                        arrayList.add(list.get(i5));
                        PointMatchData pointMatchData2 = getPointMatchData(arrayList);
                        if (pointMatchData == null || pointMatchData2.isBetterThan(pointMatchData)) {
                            pointMatchData = pointMatchData2;
                        }
                    }
                    i3 = i4;
                }
                i = i2;
            }
            if (usePatternCorrect && f19048a != 0 && Detector.detectCount % f19048a == 0 && !pointMatchData.isMatch()) {
                PrintStream printStream = System.out;
                printStream.println("pointMatchDatas.get(0) = " + pointMatchData.getDif());
                m14249c(pointMatchData.outPatterns);
            }
            return (FinderPattern[]) pointMatchData.outPatterns.toArray(new FinderPattern[list.size()]);
        }
        AnalysisManager.report(EventId.FINDER_PATTERN_FIND_FAILED);
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: c */
    private static void m14249c(List<FinderPattern> list) {
        Collections.sort(list, new Comparator<FinderPattern>() {
            public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
                if (finderPattern.getEstimatedModuleSize() > finderPattern2.getEstimatedModuleSize()) {
                    return 1;
                }
                return finderPattern.getEstimatedModuleSize() < finderPattern2.getEstimatedModuleSize() ? -1 : 0;
            }
        });
        if (Math.abs(list.get(0).getEstimatedModuleSize() - list.get(1).getEstimatedModuleSize()) > Math.abs(list.get(list.size() - 1).getEstimatedModuleSize() - list.get(list.size() - 2).getEstimatedModuleSize())) {
            list.remove(0);
        } else {
            list.remove(list.size() - 1);
        }
    }

    public static PointMatchData getPointMatchData(List<FinderPattern> list) {
        float a = m14245a(list.get(0), list.get(1));
        float a2 = m14245a(list.get(1), list.get(2));
        float a3 = m14245a(list.get(2), list.get(0));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(a));
        arrayList.add(Float.valueOf(a2));
        arrayList.add(Float.valueOf(a3));
        Collections.sort(arrayList);
        float floatValue = (((((((Float) arrayList.get(0)).floatValue() * ((Float) arrayList.get(0)).floatValue()) + (((Float) arrayList.get(1)).floatValue() * ((Float) arrayList.get(1)).floatValue())) - (((Float) arrayList.get(2)).floatValue() * ((Float) arrayList.get(2)).floatValue())) / 2.0f) / ((Float) arrayList.get(0)).floatValue()) / ((Float) arrayList.get(1)).floatValue();
        if (floatValue > 1.0f) {
            floatValue = 1.0f;
        } else if (floatValue < -1.0f) {
            floatValue = -1.0f;
        }
        PointMatchData pointMatchData = new PointMatchData();
        pointMatchData.angle = (float) Math.acos((double) floatValue);
        pointMatchData.lengthDif = ((Float) arrayList.get(1)).floatValue() / ((Float) arrayList.get(0)).floatValue();
        pointMatchData.outPatterns = list;
        pointMatchData.moduleSizeSD = m14250d(list);
        return pointMatchData;
    }

    /* renamed from: a */
    private static float m14245a(FinderPattern finderPattern, FinderPattern finderPattern2) {
        return (float) Math.sqrt(Math.pow((double) (finderPattern.getX() - finderPattern2.getX()), 2.0d) + Math.pow((double) (finderPattern.getY() - finderPattern2.getY()), 2.0d));
    }

    public static class PointMatchData {
        float angle;
        float lengthDif;
        float moduleSizeSD;
        List<FinderPattern> outPatterns;

        /* access modifiers changed from: package-private */
        public float getDif() {
            return this.lengthDif + ((float) Math.abs((((double) this.angle) - 1.5707963267948966d) / 1.5707963267948966d)) + this.moduleSizeSD;
        }

        /* access modifiers changed from: package-private */
        public boolean isBetterThan(PointMatchData pointMatchData) {
            return pointMatchData == null || getDif() < pointMatchData.getDif();
        }

        public boolean isMatch() {
            return getDif() < DqrConfigHelper.patternCorrectLimit();
        }
    }

    /* renamed from: d */
    private static float m14250d(List<FinderPattern> list) {
        int size = list.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = list.get(i).getEstimatedModuleSize();
        }
        return m14246a(fArr);
    }

    /* renamed from: a */
    private static float m14246a(float[] fArr) {
        double d = 0.0d;
        double d2 = 0.0d;
        for (float f : fArr) {
            d2 += (double) f;
        }
        double d3 = (double) r0;
        double d4 = d2 / d3;
        for (int i = 0; i < r0; i++) {
            d += (((double) fArr[i]) - d4) * (((double) fArr[i]) - d4);
        }
        return (float) Math.sqrt(d / d3);
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs > abs2 ? 1 : 0;
        }
    }

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs > abs2 ? -1 : 0;
        }
    }
}
