package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {

    /* renamed from: a */
    private boolean f1173a = false;

    /* renamed from: b */
    private final Set<FrameListener> f1174b = new ArraySet();

    /* renamed from: c */
    private final Map<String, MeanCalculator> f1175c = new HashMap();

    /* renamed from: d */
    private final Comparator<Pair<String, Float>> f1176d = new Comparator<Pair<String, Float>>() {
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public interface FrameListener {
        void onFrameRendered(float f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15189a(boolean z) {
        this.f1173a = z;
    }

    public void recordRenderTime(String str, float f) {
        if (this.f1173a) {
            MeanCalculator meanCalculator = this.f1175c.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.f1175c.put(str, meanCalculator);
            }
            meanCalculator.add(f);
            if (str.equals("__container")) {
                for (FrameListener onFrameRendered : this.f1174b) {
                    onFrameRendered.onFrameRendered(f);
                }
            }
        }
    }

    public void addFrameListener(FrameListener frameListener) {
        this.f1174b.add(frameListener);
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.f1174b.remove(frameListener);
    }

    public void clearRenderTimes() {
        this.f1175c.clear();
    }

    public void logRenderTimes() {
        if (this.f1173a) {
            List<Pair<String, Float>> sortedRenderTimes = getSortedRenderTimes();
            SystemUtils.log(3, C1429L.TAG, "Render times:", (Throwable) null, "com.airbnb.lottie.PerformanceTracker", 79);
            for (int i = 0; i < sortedRenderTimes.size(); i++) {
                Pair pair = sortedRenderTimes.get(i);
                SystemUtils.log(3, C1429L.TAG, String.format("\t\t%30s:%.2f", new Object[]{pair.first, pair.second}), (Throwable) null, "com.airbnb.lottie.PerformanceTracker", 82);
            }
        }
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        if (!this.f1173a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f1175c.size());
        for (Map.Entry next : this.f1175c.entrySet()) {
            arrayList.add(new Pair(next.getKey(), Float.valueOf(((MeanCalculator) next.getValue()).getMean())));
        }
        Collections.sort(arrayList, this.f1176d);
        return arrayList;
    }
}
