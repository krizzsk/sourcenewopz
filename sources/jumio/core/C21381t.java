package jumio.core;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.t */
/* compiled from: DrawView.kt */
public final class C21381t extends RelativeLayout {

    /* renamed from: a */
    public C21382a f59673a;

    /* renamed from: jumio.core.t$a */
    /* compiled from: DrawView.kt */
    public interface C21382a {
        /* renamed from: a */
        void mo163103a(int i, int i2);

        /* renamed from: a */
        void mo163104a(Canvas canvas);

        /* renamed from: a */
        void mo163105a(ViewGroup viewGroup);
    }

    public C21381t(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        C21382a aVar = this.f59673a;
        if (aVar != null) {
            aVar.mo163104a(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        C21382a aVar;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0 && (aVar = this.f59673a) != null) {
            aVar.mo163103a(measuredWidth, measuredHeight);
        }
    }

    public final void setDrawViewInterface(C21382a aVar) {
        this.f59673a = aVar;
        if (aVar != null) {
            aVar.mo163105a((ViewGroup) this);
        }
    }
}
