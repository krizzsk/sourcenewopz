package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

public class Layer {

    /* renamed from: a */
    private final List<ContentModel> f1531a;

    /* renamed from: b */
    private final LottieComposition f1532b;

    /* renamed from: c */
    private final String f1533c;

    /* renamed from: d */
    private final long f1534d;

    /* renamed from: e */
    private final LayerType f1535e;

    /* renamed from: f */
    private final long f1536f;

    /* renamed from: g */
    private final String f1537g;

    /* renamed from: h */
    private final List<Mask> f1538h;

    /* renamed from: i */
    private final AnimatableTransform f1539i;

    /* renamed from: j */
    private final int f1540j;

    /* renamed from: k */
    private final int f1541k;

    /* renamed from: l */
    private final int f1542l;

    /* renamed from: m */
    private final float f1543m;

    /* renamed from: n */
    private final float f1544n;

    /* renamed from: o */
    private final int f1545o;

    /* renamed from: p */
    private final int f1546p;

    /* renamed from: q */
    private final AnimatableTextFrame f1547q;

    /* renamed from: r */
    private final AnimatableTextProperties f1548r;

    /* renamed from: s */
    private final AnimatableFloatValue f1549s;

    /* renamed from: t */
    private final List<Keyframe<Float>> f1550t;

    /* renamed from: u */
    private final MatteType f1551u;

    /* renamed from: v */
    private final boolean f1552v;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.f1531a = list;
        this.f1532b = lottieComposition;
        this.f1533c = str;
        this.f1534d = j;
        this.f1535e = layerType;
        this.f1536f = j2;
        this.f1537g = str2;
        this.f1538h = list2;
        this.f1539i = animatableTransform;
        this.f1540j = i;
        this.f1541k = i2;
        this.f1542l = i3;
        this.f1543m = f;
        this.f1544n = f2;
        this.f1545o = i4;
        this.f1546p = i5;
        this.f1547q = animatableTextFrame;
        this.f1548r = animatableTextProperties;
        this.f1550t = list3;
        this.f1551u = matteType;
        this.f1549s = animatableFloatValue;
        this.f1552v = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LottieComposition mo15435a() {
        return this.f1532b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo15436b() {
        return this.f1543m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo15437c() {
        return this.f1544n / this.f1532b.getDurationFrames();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public List<Keyframe<Float>> mo15438d() {
        return this.f1550t;
    }

    public long getId() {
        return this.f1534d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo15439e() {
        return this.f1533c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo15440f() {
        return this.f1537g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo15441g() {
        return this.f1545o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo15444h() {
        return this.f1546p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public List<Mask> mo15445i() {
        return this.f1538h;
    }

    public LayerType getLayerType() {
        return this.f1535e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public MatteType mo15447j() {
        return this.f1551u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public long mo15448k() {
        return this.f1536f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public List<ContentModel> mo15449l() {
        return this.f1531a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public AnimatableTransform mo15450m() {
        return this.f1539i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public int mo15451n() {
        return this.f1542l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public int mo15452o() {
        return this.f1541k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo15453p() {
        return this.f1540j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public AnimatableTextFrame mo15454q() {
        return this.f1547q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public AnimatableTextProperties mo15455r() {
        return this.f1548r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public AnimatableFloatValue mo15456s() {
        return this.f1549s;
    }

    public String toString() {
        return toString("");
    }

    public boolean isHidden() {
        return this.f1552v;
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(mo15439e());
        sb.append("\n");
        Layer layerModelForId = this.f1532b.layerModelForId(mo15448k());
        if (layerModelForId != null) {
            sb.append("\t\tParents: ");
            sb.append(layerModelForId.mo15439e());
            Layer layerModelForId2 = this.f1532b.layerModelForId(layerModelForId.mo15448k());
            while (layerModelForId2 != null) {
                sb.append("->");
                sb.append(layerModelForId2.mo15439e());
                layerModelForId2 = this.f1532b.layerModelForId(layerModelForId2.mo15448k());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!mo15445i().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(mo15445i().size());
            sb.append("\n");
        }
        if (!(mo15453p() == 0 || mo15452o() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(mo15453p()), Integer.valueOf(mo15452o()), Integer.valueOf(mo15451n())}));
        }
        if (!this.f1531a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel next : this.f1531a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
