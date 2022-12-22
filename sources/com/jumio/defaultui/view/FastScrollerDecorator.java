package com.jumio.defaultui.view;

import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.commons.log.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b+\u0010,J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002R\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006."}, mo175978d2 = {"Lcom/jumio/defaultui/view/FastScrollerDecorator;", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getFastScroller", "Ljava/lang/Class;", "getFastScrollerClass", "", "getVerticalTrackWidth", "getVerticalTrackHeight", "", "isFastScrollerVisible", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "getTouchListener", "Landroid/view/MotionEvent;", "e", "handleTap", "", "upX", "downX", "upY", "downY", "isTap", "x", "verticalTrackWidth", "insideTrackHorizontally", "y", "verticalTrackHeight", "insideTrackVertically", "scrollTo", "", "verticallyScrollTo", "isLayoutRTL", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "fastScroller", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Z", "previousDownY", "F", "previousDownX", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: FastScrollerDecorator.kt */
public final class FastScrollerDecorator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INVALID_SIZE = -1;
    private static final String TAG = FastScrollerDecorator.class.getSimpleName();
    private final RecyclerView.ItemDecoration fastScroller = getFastScroller();
    private boolean isTap;
    private float previousDownX;
    private float previousDownY;
    private final RecyclerView recyclerView;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/FastScrollerDecorator$Companion;", "", "", "INVALID_SIZE", "I", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: FastScrollerDecorator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FastScrollerDecorator(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
        recyclerView2.addOnItemTouchListener(getTouchListener());
    }

    private final RecyclerView.ItemDecoration getFastScroller() {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mOnItemTouchListeners");
            Intrinsics.checkNotNullExpressionValue(declaredField, "RecyclerView::class.java…(\"mOnItemTouchListeners\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.recyclerView);
            if (obj != null) {
                ArrayList arrayList = (ArrayList) obj;
                Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
                if (fastScrollerClass == null) {
                    return null;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    RecyclerView.OnItemTouchListener onItemTouchListener = (RecyclerView.OnItemTouchListener) it.next();
                    if (fastScrollerClass.isInstance(onItemTouchListener)) {
                        return (RecyclerView.ItemDecoration) onItemTouchListener;
                    }
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.OnItemTouchListener>{ kotlin.collections.TypeAliasesKt.ArrayList<androidx.recyclerview.widget.RecyclerView.OnItemTouchListener> }");
        } catch (Exception e) {
            Log.m39477w(TAG, "Could not get FastScroller for recycler view!", (Throwable) e);
        }
    }

    private final Class<RecyclerView.ItemDecoration> getFastScrollerClass() {
        try {
            return Class.forName("androidx.recyclerview.widget.FastScroller");
        } catch (Exception e) {
            Log.m39477w(TAG, "Could not get the class for FastScroller!", (Throwable) e);
            return null;
        }
    }

    private final RecyclerView.OnItemTouchListener getTouchListener() {
        return new FastScrollerDecorator$getTouchListener$1(this);
    }

    private final int getVerticalTrackHeight() {
        if (this.fastScroller == null) {
            return -1;
        }
        return this.recyclerView.getHeight();
    }

    private final int getVerticalTrackWidth() {
        if (this.fastScroller == null) {
            return -1;
        }
        try {
            Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
            if (fastScrollerClass == null) {
                return -1;
            }
            Field declaredField = fastScrollerClass.getDeclaredField("mVerticalTrackWidth");
            Intrinsics.checkNotNullExpressionValue(declaredField, "fastScrollerClass.getDec…ld(\"mVerticalTrackWidth\")");
            declaredField.setAccessible(true);
            return declaredField.getInt(this.fastScroller);
        } catch (Exception e) {
            Log.m39477w(TAG, "Could not get the width for FastScroller track!", (Throwable) e);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public final boolean handleTap(MotionEvent motionEvent) {
        int verticalTrackWidth = getVerticalTrackWidth();
        int verticalTrackHeight = getVerticalTrackHeight();
        if (!(verticalTrackWidth == -1 || verticalTrackHeight == -1)) {
            if (!insideTrackHorizontally(motionEvent.getX(), verticalTrackWidth) || !insideTrackVertically(motionEvent.getY(), verticalTrackHeight) || !isFastScrollerVisible()) {
                this.isTap = false;
            } else if (motionEvent.getAction() == 1 && isTap(motionEvent.getX(), this.previousDownX, motionEvent.getY(), this.previousDownY)) {
                verticallyScrollTo(motionEvent.getY());
                return true;
            } else if (motionEvent.getAction() == 0) {
                this.isTap = true;
                this.previousDownX = motionEvent.getX();
                this.previousDownY = motionEvent.getY();
            }
        }
        return false;
    }

    private final boolean insideTrackHorizontally(float f, int i) {
        if (!isLayoutRTL()) {
            float f2 = (float) i;
            if (f < (((float) this.recyclerView.getWidth()) + this.recyclerView.getX()) - f2 || f > this.recyclerView.getX() + ((float) this.recyclerView.getWidth()) + f2) {
                return false;
            }
            return true;
        } else if (f > ((float) i) + this.recyclerView.getX() || f < this.recyclerView.getX()) {
            return false;
        } else {
            return true;
        }
    }

    private final boolean insideTrackVertically(float f, int i) {
        return f <= this.recyclerView.getY() + ((float) i) && f >= this.recyclerView.getY();
    }

    private final boolean isFastScrollerVisible() {
        Field field;
        if (this.fastScroller == null) {
            return false;
        }
        try {
            Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
            if (fastScrollerClass == null) {
                field = null;
            } else {
                field = fastScrollerClass.getDeclaredField("mState");
            }
            if (field == null) {
                return false;
            }
            field.setAccessible(true);
            if (field.getInt(this.fastScroller) == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.m39477w(TAG, "Could not determine if FastScroller is visible!", (Throwable) e);
            return false;
        }
    }

    private final boolean isLayoutRTL() {
        return ViewCompat.getLayoutDirection(this.recyclerView) == 1;
    }

    private final boolean isTap(float f, float f2, float f3, float f4) {
        float abs = Math.abs(f2 - f);
        float f5 = (float) 20;
        return abs <= f5 && Math.abs(f4 - f3) <= f5;
    }

    private final void verticallyScrollTo(float f) {
        Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
        if (fastScrollerClass != null) {
            try {
                Method declaredMethod = fastScrollerClass.getDeclaredMethod("verticalScrollTo", new Class[]{Float.TYPE});
                Intrinsics.checkNotNullExpressionValue(declaredMethod, "fastScrollerClass.getDec…llTo\", Float::class.java)");
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.fastScroller, new Object[]{Float.valueOf(f)});
            } catch (Exception e) {
                Log.m39477w(TAG, "Could not scroll with FastScroller vertically!", (Throwable) e);
            }
        }
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }
}
