package com.didichuxing.dfbasesdk.touch;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didichuxing.dfbasesdk.touch.TouchData;
import java.util.LinkedList;
import java.util.List;

public class TouchHandler {

    /* renamed from: g */
    private static int[] f46679g = new int[2];

    /* renamed from: h */
    private static int[] f46680h = new int[2];

    /* renamed from: a */
    private Resources f46681a;

    /* renamed from: b */
    private TouchPage f46682b;

    /* renamed from: c */
    private OnTouchDataListener f46683c;

    /* renamed from: d */
    private List<MotionEvent> f46684d = new LinkedList();

    /* renamed from: e */
    private int f46685e = 20;

    /* renamed from: f */
    private View f46686f = null;

    public void onTouchEvent(MotionEvent motionEvent) {
    }

    public TouchHandler(Context context) {
        this.f46681a = context.getResources();
    }

    public void setPage(TouchPage touchPage) {
        this.f46682b = touchPage;
    }

    public void setMotionUpListener(OnTouchDataListener onTouchDataListener) {
        this.f46683c = onTouchDataListener;
    }

    public void setEventLimit(int i) {
        this.f46685e = i;
    }

    /* renamed from: a */
    private boolean m33529a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private TouchData m33528a(MotionEvent motionEvent) {
        TouchPage touchPage;
        TouchData touchData = new TouchData();
        TouchPage touchPage2 = this.f46682b;
        if (touchPage2 != null) {
            touchData.page = touchPage2.getPageName();
        }
        touchData.deviceId = motionEvent.getDeviceId();
        touchData.source = motionEvent.getSource();
        touchData.action = motionEvent.getAction();
        touchData.actionMasked = motionEvent.getActionMasked();
        touchData.actionIndex = motionEvent.getActionIndex();
        touchData.flags = motionEvent.getFlags();
        touchData.downTime = motionEvent.getDownTime();
        touchData.eventTime = motionEvent.getEventTime();
        touchData.metaState = motionEvent.getMetaState();
        touchData.buttonState = motionEvent.getButtonState();
        touchData.xPrecision = motionEvent.getXPrecision();
        touchData.yPrecision = motionEvent.getYPrecision();
        touchData.edgeFlags = motionEvent.getEdgeFlags();
        touchData.pointerCount = motionEvent.getPointerCount();
        if (touchData.pointerCount > 0) {
            touchData.pointers = new TouchData.Pointer[touchData.pointerCount];
            for (int i = 0; i < touchData.pointerCount; i++) {
                TouchData.Pointer[] pointerArr = touchData.pointers;
                TouchData.Pointer pointer = new TouchData.Pointer();
                pointerArr[i] = pointer;
                pointer.pointerId = motionEvent.getPointerId(i);
                pointer.toolType = motionEvent.getToolType(i);
                pointer.f46677x = motionEvent.getX(i);
                pointer.f46678y = motionEvent.getY(i);
                pointer.pressure = motionEvent.getPressure(i);
                pointer.size = motionEvent.getSize(i);
                pointer.touchMajor = motionEvent.getTouchMajor(i);
                pointer.touchMinor = motionEvent.getTouchMinor(i);
                pointer.toolMajor = motionEvent.getToolMajor(i);
                pointer.toolMinor = motionEvent.getToolMinor(i);
                pointer.orientation = motionEvent.getOrientation(i);
                View view = this.f46686f;
                if (view != null) {
                    this.f46686f = m33526a(view, (int) pointer.f46677x, (int) pointer.f46678y);
                }
                if (this.f46686f == null && (touchPage = this.f46682b) != null) {
                    this.f46686f = m33526a(touchPage.getRootView(), (int) pointer.f46677x, (int) pointer.f46678y);
                }
                View view2 = this.f46686f;
                if (view2 != null) {
                    pointer.view = m33527a(view2);
                }
            }
        }
        return touchData;
    }

    /* renamed from: a */
    private TouchData.PView m33527a(View view) {
        CharSequence text;
        TouchData.PView pView = new TouchData.PView();
        pView.f46676id = view.getId() == -1 ? "" : this.f46681a.getResourceEntryName(view.getId());
        pView.type = view.getClass().getSimpleName();
        view.getLocationOnScreen(f46679g);
        pView.locationX = f46679g[0];
        pView.locationY = f46679g[1];
        pView.measuredWidth = view.getMeasuredWidth();
        pView.measuredHeight = view.getMeasuredHeight();
        if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null) {
            pView.content = text.toString();
            if (pView.content.length() > 10) {
                pView.content = pView.content.substring(0, 10);
            }
        }
        return pView;
    }

    /* renamed from: a */
    private View m33526a(View view, int i, int i2) {
        if (!m33530b(view, i, i2)) {
            return null;
        }
        if (!(view instanceof ViewGroup)) {
            return view;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return view;
            }
            View childAt = viewGroup.getChildAt(i3);
            if (m33530b(childAt, i, i2)) {
                return m33526a(childAt, i, i2);
            }
            i3++;
        }
    }

    /* renamed from: b */
    private boolean m33530b(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        view.getLocationOnScreen(f46680h);
        int[] iArr = f46680h;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i4;
        if (i < i3 || i > measuredWidth || i2 < i4 || i2 > measuredHeight) {
            return false;
        }
        return true;
    }
}
