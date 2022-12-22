package com.didi.beatles.p099im.views.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.beatles.im.views.widget.IMToast */
public class IMToast {

    /* renamed from: a */
    private static WeakReference<Toast> f10501a = null;

    /* renamed from: b */
    private static final String f10502b = "IMToast";

    private IMToast() {
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        WeakReference<Toast> weakReference = f10501a;
        Toast toast = weakReference == null ? null : (Toast) weakReference.get();
        if (toast == null) {
            toast = m7135a(context, i);
            f10501a = new WeakReference<>(toast);
        }
        setIcon(toast, R.drawable.im_widget_tips_toast_warm);
        toast.setDuration(i);
        TextView textView = (TextView) toast.getView().findViewById(R.id.tips_msg);
        if (textView != null) {
            textView.setText(charSequence);
        }
        return toast;
    }

    /* renamed from: a */
    private static Toast m7135a(Context context, int i) {
        Toast makeText = Toast.makeText(context, "", i);
        makeText.setView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.im_widget_tips_toast_view, (ViewGroup) null));
        makeText.setGravity(16, 0, 0);
        return makeText;
    }

    public static Toast makeText(Context context, int i, int i2) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public static void cancelAll() {
        WeakReference<Toast> weakReference = f10501a;
        Toast toast = weakReference == null ? null : (Toast) weakReference.get();
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void setIcon(Toast toast, int i) {
        if (toast == null) {
            IMLog.m6632e(f10502b, "toast is null while setIcon");
        } else if (toast.getView() == null) {
            IMLog.m6632e(f10502b, "toast.getView() is null while setIcon");
        } else {
            ImageView imageView = (ImageView) toast.getView().findViewById(R.id.tips_icon);
            if (imageView == null) {
                IMLog.m6632e(f10502b, "imageView is null while setIcon");
                return;
            }
            imageView.setBackgroundResource(i);
        }
    }

    public static void setText(Toast toast, CharSequence charSequence) {
        if (toast.getView() == null) {
            IMLog.m6632e(f10502b, "toast.getView() is null while setIcon");
            return;
        }
        TextView textView = (TextView) toast.getView().findViewById(R.id.tips_msg);
        if (textView == null) {
            IMLog.m6632e(f10502b, "TextView is null while setIcon");
            return;
        }
        textView.setText(charSequence);
    }
}
