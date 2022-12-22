package com.didi.beatles.p099im.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.beatles.im.views.IMTipsToast */
public class IMTipsToast {

    /* renamed from: a */
    private static WeakReference<Toast> f9961a = null;

    /* renamed from: b */
    private static final String f9962b = "IMTipsToast";

    /* renamed from: c */
    private static IMStyleManager.Style f9963c = IMStyleManager.Style.DEFAULT;

    private IMTipsToast() {
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        WeakReference<Toast> weakReference = f9961a;
        Toast toast = weakReference == null ? null : (Toast) weakReference.get();
        if (toast == null) {
            toast = m6714a(context, i);
            f9961a = new WeakReference<>(toast);
        }
        IMBusinessConfig businessConfig = IMResource.getBusinessConfig();
        if (!(businessConfig == null || businessConfig.getIMStyle() == f9963c)) {
            f9963c = businessConfig.getIMStyle();
            toast = m6714a(context, i);
            f9961a = new WeakReference<>(toast);
        }
        toast.setDuration(i);
        TextView textView = (TextView) toast.getView().findViewById(R.id.tips_msg);
        if (textView != null) {
            textView.setText(charSequence);
        }
        return toast;
    }

    /* renamed from: a */
    private static Toast m6714a(Context context, int i) {
        Toast makeText = Toast.makeText(context, "", i);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (f9963c == IMStyleManager.Style.GLOBAL_PSG) {
            makeText.setView(layoutInflater.inflate(R.layout.bts_im_view_tips_global_psg, (ViewGroup) null));
        } else {
            makeText.setView(layoutInflater.inflate(R.layout.bts_im_view_tips, (ViewGroup) null));
            makeText.setGravity(16, 0, 0);
        }
        return makeText;
    }

    public static Toast makeText(Context context, int i, int i2) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public static void cancelAll() {
        WeakReference<Toast> weakReference = f9961a;
        Toast toast = weakReference == null ? null : (Toast) weakReference.get();
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void setIcon(Toast toast, int i) {
        if (toast.getView() == null) {
            IMLog.m6632e(f9962b, "toast.getView() is null while setIcon");
            return;
        }
        ImageView imageView = (ImageView) toast.getView().findViewById(R.id.tips_icon);
        if (imageView == null) {
            IMLog.m6632e(f9962b, "imageView is null while setIcon");
            return;
        }
        imageView.setBackgroundResource(i);
    }

    public static void setIconKeepSize(Toast toast, int i) {
        Bitmap alterSizeBitmap;
        int drawableID = IMResource.getDrawableID(i);
        if (toast.getView() == null) {
            IMLog.m6632e(f9962b, "toast.getView() is null while setIcon");
            return;
        }
        ImageView imageView = (ImageView) toast.getView().findViewById(R.id.tips_icon);
        if (imageView == null) {
            IMLog.m6632e(f9962b, "imageView is null while setIcon");
            return;
        }
        Resources resources = IMContextInfoHelper.getContext().getResources();
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        if (decodeResource != null && (alterSizeBitmap = alterSizeBitmap(BitmapFactory.decodeResource(resources, drawableID), decodeResource.getHeight(), decodeResource.getWidth())) != null) {
            imageView.setBackground(new BitmapDrawable(resources, alterSizeBitmap));
        }
    }

    public static Bitmap alterSizeBitmap(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void setText(Toast toast, CharSequence charSequence) {
        if (toast.getView() == null) {
            IMLog.m6632e(f9962b, "toast.getView() is null while setIcon");
            return;
        }
        TextView textView = (TextView) toast.getView().findViewById(R.id.tips_msg);
        if (textView == null) {
            IMLog.m6632e(f9962b, "TextView is null while setIcon");
            return;
        }
        textView.setText(charSequence);
    }
}
