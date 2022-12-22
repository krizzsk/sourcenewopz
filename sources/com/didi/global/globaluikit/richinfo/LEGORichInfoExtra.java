package com.didi.global.globaluikit.richinfo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.global.globaluikit.richinfo.model.CustomViewSpanModel;
import com.didi.global.globaluikit.richinfo.model.RichInfoExtraItem;
import com.didi.global.globaluikit.richinfo.model.RichInfoExtraModel;
import com.didi.global.globaluikit.utils.UiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class LEGORichInfoExtra {

    /* renamed from: a */
    private static final String f22623a = "image";

    /* renamed from: b */
    private static final String f22624b = "text";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f22625c;

    private interface GlideBitmapListener {
        void onBitmapCreated(Bitmap bitmap);
    }

    interface ImageCallback {
        void onImageLoaded(CustomViewSpan customViewSpan);
    }

    interface SpansCallback {
        void onSpansLoaded(List<CustomViewSpanModel> list);
    }

    public LEGORichInfoExtra(Context context) {
        this.f22625c = context;
    }

    /* renamed from: a */
    public void mo67094a(List<RichInfoExtraModel> list, SpansCallback spansCallback) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (RichInfoExtraModel next : list) {
            final RichInfoExtraModel richInfoExtraModel = next;
            final CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
            final List<RichInfoExtraModel> list2 = list;
            final SpansCallback spansCallback2 = spansCallback;
            m16303a(next, (ImageCallback) new ImageCallback() {
                public void onImageLoaded(CustomViewSpan customViewSpan) {
                    CustomViewSpanModel customViewSpanModel = new CustomViewSpanModel();
                    customViewSpanModel.model = richInfoExtraModel;
                    customViewSpanModel.index = richInfoExtraModel.insert_index;
                    customViewSpanModel.span = customViewSpan;
                    copyOnWriteArrayList2.add(customViewSpanModel);
                    if (copyOnWriteArrayList2.size() == list2.size()) {
                        spansCallback2.onSpansLoaded(LEGORichInfoExtra.this.m16302a((List<CustomViewSpanModel>) copyOnWriteArrayList2));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<CustomViewSpanModel> m16302a(List<CustomViewSpanModel> list) {
        CustomViewSpanModel customViewSpanModel = list.get(0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            if (customViewSpanModel.index <= list.get(i).index) {
                arrayList2.add(list.get(i));
            } else {
                arrayList.add(list.get(i));
            }
        }
        if (arrayList.size() > 1) {
            m16302a((List<CustomViewSpanModel>) arrayList);
        }
        if (arrayList2.size() > 1) {
            m16302a((List<CustomViewSpanModel>) arrayList2);
        }
        list.clear();
        list.addAll(arrayList2);
        list.add(customViewSpanModel);
        list.addAll(arrayList);
        return list;
    }

    /* renamed from: a */
    private void m16303a(RichInfoExtraModel richInfoExtraModel, ImageCallback imageCallback) {
        Iterator<RichInfoExtraItem> it;
        int[] iArr;
        RichInfoExtraModel richInfoExtraModel2 = richInfoExtraModel;
        ImageCallback imageCallback2 = imageCallback;
        FrameLayout frameLayout = new FrameLayout(this.f22625c);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LinearLayout linearLayout = new LinearLayout(this.f22625c);
        frameLayout.addView(linearLayout);
        linearLayout.setGravity(16);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (!TextUtils.isEmpty(richInfoExtraModel2.bg_image)) {
            atomicInteger.incrementAndGet();
            final LinearLayout linearLayout2 = linearLayout;
            final AtomicInteger atomicInteger2 = atomicInteger;
            final ImageCallback imageCallback3 = imageCallback;
            final FrameLayout frameLayout2 = frameLayout;
            m16304a(richInfoExtraModel2.bg_image, (GlideBitmapListener) new GlideBitmapListener() {
                public void onBitmapCreated(Bitmap bitmap) {
                    ImageCallback imageCallback;
                    linearLayout2.setBackground(new BitmapDrawable(LEGORichInfoExtra.this.f22625c.getResources(), bitmap));
                    atomicInteger2.decrementAndGet();
                    if (atomicInteger2.get() == 0 && (imageCallback = imageCallback3) != null) {
                        imageCallback.onImageLoaded(new CustomViewSpan(frameLayout2));
                    }
                }
            });
        } else if (!(richInfoExtraModel2.bg_color == null || richInfoExtraModel2.bg_color.colors == null)) {
            try {
                if (richInfoExtraModel2.bg_color.type == 0) {
                    iArr = new int[]{Color.parseColor(richInfoExtraModel2.bg_color.colors[0]), Color.parseColor(richInfoExtraModel2.bg_color.colors[0])};
                } else {
                    iArr = new int[richInfoExtraModel2.bg_color.colors.length];
                    for (int i = 0; i < richInfoExtraModel2.bg_color.colors.length; i++) {
                        iArr[i] = Color.parseColor(richInfoExtraModel2.bg_color.colors[i]);
                    }
                }
                GradientDrawable gradientDrawable = new GradientDrawable(richInfoExtraModel2.bg_color.direction == 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TOP_BOTTOM, iArr);
                gradientDrawable.setCornerRadius((float) m16296a(this.f22625c, (float) (richInfoExtraModel2.corner_radius * 2)));
                linearLayout.setBackground(gradientDrawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (richInfoExtraModel2.padding != null) {
            linearLayout.setPadding(m16296a(this.f22625c, (float) richInfoExtraModel2.padding.left), m16296a(this.f22625c, (float) richInfoExtraModel2.padding.top), m16296a(this.f22625c, (float) richInfoExtraModel2.padding.right), m16296a(this.f22625c, (float) richInfoExtraModel2.padding.bottom));
        }
        if (richInfoExtraModel2.margin != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(m16296a(this.f22625c, (float) richInfoExtraModel2.margin.left), m16296a(this.f22625c, (float) richInfoExtraModel2.margin.top), m16296a(this.f22625c, (float) richInfoExtraModel2.margin.right), m16296a(this.f22625c, (float) richInfoExtraModel2.margin.bottom));
            linearLayout.setLayoutParams(layoutParams);
        }
        if (richInfoExtraModel2.items != null && !richInfoExtraModel2.items.isEmpty()) {
            Iterator<RichInfoExtraItem> it2 = richInfoExtraModel2.items.iterator();
            while (it2.hasNext()) {
                RichInfoExtraItem next = it2.next();
                if (next != null && !TextUtils.isEmpty(next.type)) {
                    if (next.type.equalsIgnoreCase("image")) {
                        ImageView imageView = new ImageView(this.f22625c);
                        int a = next.width <= 0 ? -2 : m16296a(this.f22625c, (float) next.width);
                        int a2 = next.height <= 0 ? -2 : m16296a(this.f22625c, (float) next.height);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a, a2);
                        if (next.margin != null) {
                            int a3 = m16296a(this.f22625c, (float) next.margin.left);
                            int a4 = m16296a(this.f22625c, (float) next.margin.top);
                            int a5 = m16296a(this.f22625c, (float) next.margin.right);
                            int a6 = m16296a(this.f22625c, (float) next.margin.bottom);
                            layoutParams2.setMargins(a3, a4, a5, a6);
                            a = (a - a3) - a5;
                            a2 = (a2 - a4) - a6;
                        }
                        int i2 = a2;
                        final int i3 = a;
                        imageView.setLayoutParams(layoutParams2);
                        if (!TextUtils.isEmpty(next.url)) {
                            atomicInteger.incrementAndGet();
                            String str = next.url;
                            final int i4 = i2;
                            final ImageView imageView2 = imageView;
                            final AtomicInteger atomicInteger3 = atomicInteger;
                            final ImageCallback imageCallback4 = imageCallback;
                            it = it2;
                            C86723 r0 = r1;
                            final FrameLayout frameLayout3 = frameLayout;
                            C86723 r1 = new GlideBitmapListener() {
                                public void onBitmapCreated(Bitmap bitmap) {
                                    ImageCallback imageCallback;
                                    int i;
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(LEGORichInfoExtra.this.f22625c.getResources(), bitmap);
                                    int i2 = i3;
                                    if (!(i2 == -2 || (i = i4) == -2)) {
                                        Drawable unused = LEGORichInfoExtra.this.m16299a(bitmapDrawable, i2, i);
                                    }
                                    imageView2.setImageDrawable(bitmapDrawable);
                                    atomicInteger3.decrementAndGet();
                                    if (atomicInteger3.get() == 0 && (imageCallback = imageCallback4) != null) {
                                        imageCallback.onImageLoaded(new CustomViewSpan(frameLayout3));
                                    }
                                }
                            };
                            m16304a(str, (GlideBitmapListener) r0);
                        } else {
                            it = it2;
                        }
                        linearLayout.addView(imageView);
                    } else {
                        it = it2;
                        if (next.type.equalsIgnoreCase("text")) {
                            TextView textView = new TextView(this.f22625c);
                            if (next.margin != null) {
                                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                                layoutParams3.setMargins(m16296a(this.f22625c, (float) next.margin.left), m16296a(this.f22625c, (float) next.margin.top), m16296a(this.f22625c, (float) next.margin.right), m16296a(this.f22625c, (float) next.margin.bottom));
                                textView.setLayoutParams(layoutParams3);
                            }
                            if (next.rich_info != null) {
                                next.rich_info.bindTextView(textView);
                                linearLayout.addView(textView);
                            }
                            it2 = it;
                        }
                    }
                    it2 = it;
                }
            }
        }
        if (atomicInteger.get() == 0 && imageCallback2 != null) {
            imageCallback2.onImageLoaded(new CustomViewSpan(frameLayout));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Drawable m16299a(Drawable drawable, int i, int i2) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap a = m16298a(drawable);
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) intrinsicWidth), ((float) i2) / ((float) intrinsicHeight));
        return new BitmapDrawable((Resources) null, Bitmap.createBitmap(a, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true));
    }

    /* renamed from: a */
    private Bitmap m16298a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    private void m16304a(String str, final GlideBitmapListener glideBitmapListener) {
        Context context = this.f22625c;
        if (context instanceof FragmentActivity) {
            if (((FragmentActivity) context).isDestroyed()) {
                return;
            }
        } else if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        Glide.with(this.f22625c).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
            public void onLoadCleared(Drawable drawable) {
            }

            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                GlideBitmapListener glideBitmapListener = glideBitmapListener;
                if (glideBitmapListener != null) {
                    glideBitmapListener.onBitmapCreated(bitmap);
                }
            }
        });
    }

    /* renamed from: a */
    private int m16296a(Context context, float f) {
        return UiUtils.dip2px(context, f / 2.0f);
    }
}
