package p242io.flutter.embedding.engine.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import p242io.flutter.embedding.android.AndroidTouchProcessor;

/* renamed from: io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView */
public class FlutterMutatorView extends FrameLayout {

    /* renamed from: a */
    ViewTreeObserver.OnGlobalFocusChangeListener f57668a;

    /* renamed from: b */
    private FlutterMutatorsStack f57669b;

    /* renamed from: c */
    private float f57670c;

    /* renamed from: d */
    private int f57671d;

    /* renamed from: e */
    private int f57672e;

    /* renamed from: f */
    private int f57673f;

    /* renamed from: g */
    private int f57674g;

    /* renamed from: h */
    private final AndroidTouchProcessor f57675h;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public FlutterMutatorView(Context context, float f, AndroidTouchProcessor androidTouchProcessor) {
        super(context, (AttributeSet) null);
        this.f57670c = f;
        this.f57675h = androidTouchProcessor;
    }

    public FlutterMutatorView(Context context) {
        this(context, 1.0f, (AndroidTouchProcessor) null);
    }

    public static boolean childHasFocus(View view) {
        if (view == null) {
            return false;
        }
        if (view.hasFocus()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (childHasFocus(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(final View.OnFocusChangeListener onFocusChangeListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f57668a == null) {
            C210811 r1 = new ViewTreeObserver.OnGlobalFocusChangeListener() {
                public void onGlobalFocusChanged(View view, View view2) {
                    View.OnFocusChangeListener onFocusChangeListener = onFocusChangeListener;
                    View view3 = this;
                    onFocusChangeListener.onFocusChange(view3, FlutterMutatorView.childHasFocus(view3));
                }
            };
            this.f57668a = r1;
            viewTreeObserver.addOnGlobalFocusChangeListener(r1);
        }
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (onGlobalFocusChangeListener = this.f57668a) != null) {
            this.f57668a = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    public void readyToDisplay(FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.f57669b = flutterMutatorsStack;
        this.f57671d = i;
        this.f57672e = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.f57669b.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset((float) (-this.f57671d), (float) (-this.f57672e));
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f57669b.getFinalMatrix());
        float f = this.f57670c;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate((float) (-this.f57671d), (float) (-this.f57672e));
        return matrix;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f57675h == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.f57671d;
            this.f57673f = i;
            int i2 = this.f57672e;
            this.f57674g = i2;
            matrix.postTranslate((float) i, (float) i2);
        } else if (action != 2) {
            matrix.postTranslate((float) this.f57671d, (float) this.f57672e);
        } else {
            matrix.postTranslate((float) this.f57673f, (float) this.f57674g);
            this.f57673f = this.f57671d;
            this.f57674g = this.f57672e;
        }
        return this.f57675h.onTouchEvent(motionEvent, matrix);
    }
}
