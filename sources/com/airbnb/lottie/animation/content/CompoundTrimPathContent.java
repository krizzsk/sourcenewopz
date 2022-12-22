package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {

    /* renamed from: a */
    private List<TrimPathContent> f1194a = new ArrayList();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15211a(TrimPathContent trimPathContent) {
        this.f1194a.add(trimPathContent);
    }

    public void apply(Path path) {
        for (int size = this.f1194a.size() - 1; size >= 0; size--) {
            Utils.applyTrimPathIfNeeded(path, this.f1194a.get(size));
        }
    }
}
