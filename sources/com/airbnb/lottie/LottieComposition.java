package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition {

    /* renamed from: a */
    private final PerformanceTracker f1121a = new PerformanceTracker();

    /* renamed from: b */
    private final HashSet<String> f1122b = new HashSet<>();

    /* renamed from: c */
    private Map<String, List<Layer>> f1123c;

    /* renamed from: d */
    private Map<String, LottieImageAsset> f1124d;

    /* renamed from: e */
    private Map<String, Font> f1125e;

    /* renamed from: f */
    private List<Marker> f1126f;

    /* renamed from: g */
    private SparseArrayCompat<FontCharacter> f1127g;

    /* renamed from: h */
    private LongSparseArray<Layer> f1128h;

    /* renamed from: i */
    private List<Layer> f1129i;

    /* renamed from: j */
    private Rect f1130j;

    /* renamed from: k */
    private float f1131k;

    /* renamed from: l */
    private float f1132l;

    /* renamed from: m */
    private float f1133m;

    /* renamed from: n */
    private boolean f1134n;

    /* renamed from: o */
    private int f1135o = 0;

    public void init(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        this.f1130j = rect;
        this.f1131k = f;
        this.f1132l = f2;
        this.f1133m = f3;
        this.f1129i = list;
        this.f1128h = longSparseArray;
        this.f1123c = map;
        this.f1124d = map2;
        this.f1127g = sparseArrayCompat;
        this.f1125e = map3;
        this.f1126f = list2;
    }

    public void addWarning(String str) {
        Logger.warning(str);
        this.f1122b.add(str);
    }

    public void setHasDashPattern(boolean z) {
        this.f1134n = z;
    }

    public void incrementMatteOrMaskCount(int i) {
        this.f1135o += i;
    }

    public boolean hasDashPattern() {
        return this.f1134n;
    }

    public int getMaskAndMatteCount() {
        return this.f1135o;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> hashSet = this.f1122b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f1121a.mo15189a(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f1121a;
    }

    public Layer layerModelForId(long j) {
        return this.f1128h.get(j);
    }

    public Rect getBounds() {
        return this.f1130j;
    }

    public float getDuration() {
        return (float) ((long) ((getDurationFrames() / this.f1133m) * 1000.0f));
    }

    public float getStartFrame() {
        return this.f1131k;
    }

    public float getEndFrame() {
        return this.f1132l;
    }

    public float getFrameRate() {
        return this.f1133m;
    }

    public List<Layer> getLayers() {
        return this.f1129i;
    }

    public List<Layer> getPrecomps(String str) {
        return this.f1123c.get(str);
    }

    public SparseArrayCompat<FontCharacter> getCharacters() {
        return this.f1127g;
    }

    public Map<String, Font> getFonts() {
        return this.f1125e;
    }

    public List<Marker> getMarkers() {
        return this.f1126f;
    }

    public Marker getMarker(String str) {
        this.f1126f.size();
        for (int i = 0; i < this.f1126f.size(); i++) {
            Marker marker = this.f1126f.get(i);
            if (marker.matchesName(str)) {
                return marker;
            }
        }
        return null;
    }

    public boolean hasImages() {
        return !this.f1124d.isEmpty();
    }

    public Map<String, LottieImageAsset> getImages() {
        return this.f1124d;
    }

    public float getDurationFrames() {
        return this.f1132l - this.f1131k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f1129i) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    public static class Factory {
        private Factory() {
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromAsset(context, str).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context, int i, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromRawRes(context, i).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonInputStream(inputStream, (String) null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromJsonString(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonString(str, (String) null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonReader(jsonReader, (String) null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromFileSync(Context context, String str) {
            return LottieCompositionFactory.fromAssetSync(context, str).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, (String) null).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean z) {
            if (z) {
                Logger.warning("Lottie now auto-closes input stream!");
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, (String) null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
            return LottieCompositionFactory.fromJsonSync(jSONObject, (String) null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(String str) {
            return LottieCompositionFactory.fromJsonStringSync(str, (String) null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader) throws IOException {
            return LottieCompositionFactory.fromJsonReaderSync(jsonReader, (String) null).getValue();
        }

        private static final class ListenerAdapter implements Cancellable, LottieListener<LottieComposition> {
            private boolean cancelled;
            private final OnCompositionLoadedListener listener;

            private ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.cancelled = false;
                this.listener = onCompositionLoadedListener;
            }

            public void onResult(LottieComposition lottieComposition) {
                if (!this.cancelled) {
                    this.listener.onCompositionLoaded(lottieComposition);
                }
            }

            public void cancel() {
                this.cancelled = true;
            }
        }
    }
}
