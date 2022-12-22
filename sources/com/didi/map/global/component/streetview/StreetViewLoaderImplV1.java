package com.didi.map.global.component.streetview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.map.global.component.streetview.IStreetViewLoader;
import com.didi.map.global.component.streetview.StreetViewComp;
import com.didi.map.global.component.streetview.utils.DisplayUtil;
import com.taxis99.R;

public class StreetViewLoaderImplV1 implements IStreetViewLoader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f26218a;

    /* renamed from: b */
    private ImageView f26219b;

    /* renamed from: c */
    private TextView f26220c;

    /* renamed from: d */
    private TextView f26221d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f26222e = false;

    public void cancelStreetViewLoad() {
    }

    public int getLayoutResId() {
        return R.layout.map_comp_layout_street_view_dialog_v1;
    }

    public View createView(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(getLayoutResId(), (ViewGroup) null);
        this.f26218a = (ImageView) inflate.findViewById(R.id.streetImg);
        this.f26219b = (ImageView) inflate.findViewById(R.id.closeImg);
        this.f26221d = (TextView) inflate.findViewById(R.id.issueTv);
        this.f26220c = (TextView) inflate.findViewById(R.id.tipsTv);
        Drawable drawable = inflate.getResources().getDrawable(R.drawable.map_comp_ic_street_view_arrow);
        drawable.setAutoMirrored(true);
        this.f26221d.setCompoundDrawablePadding(DisplayUtil.dp2px(inflate.getContext(), 5.0f));
        this.f26221d.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        return inflate;
    }

    public void load(StreetViewCompParams streetViewCompParams, final ImageView imageView, final StreetViewComp.ILoadCallback iLoadCallback) {
        FragmentActivity activity = streetViewCompParams.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (streetViewCompParams.isShowGuideTipsText()) {
                this.f26220c.setVisibility(0);
            } else {
                this.f26220c.setVisibility(8);
            }
            this.f26222e = false;
            LazyHeaders.Builder builder = new LazyHeaders.Builder();
            builder.addHeader("X-Goog-Maps-Experience-ID", streetViewCompParams.getTripId());
            Glide.with(streetViewCompParams.getActivity()).asBitmap().load((Object) new GlideUrl(streetViewCompParams.getStreetViewUrl(), (Headers) builder.build())).into(new CustomTarget<Bitmap>() {
                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    if (bitmap != null) {
                        if (StreetViewLoaderImplV1.this.f26218a != null) {
                            StreetViewLoaderImplV1.this.f26218a.setImageBitmap(bitmap);
                        }
                        ImageView imageView = imageView;
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                    StreetViewComp.ILoadCallback iLoadCallback = iLoadCallback;
                    if (iLoadCallback != null) {
                        iLoadCallback.onSuccess();
                    }
                    boolean unused = StreetViewLoaderImplV1.this.f26222e = true;
                }

                public void onLoadCleared(Drawable drawable) {
                    StreetViewComp.ILoadCallback iLoadCallback = iLoadCallback;
                    if (iLoadCallback != null) {
                        iLoadCallback.onFail();
                    }
                    boolean unused = StreetViewLoaderImplV1.this.f26222e = false;
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    StreetViewComp.ILoadCallback iLoadCallback = iLoadCallback;
                    if (iLoadCallback != null) {
                        iLoadCallback.onFail();
                    }
                    boolean unused = StreetViewLoaderImplV1.this.f26222e = false;
                }
            });
        }
    }

    public void setListener(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener) {
        ImageView imageView = this.f26219b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StreetViewLoaderImplV1.m18559b(IStreetViewLoader.OnStreetViewActionListener.this, view);
                }
            });
        }
        TextView textView = this.f26221d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StreetViewLoaderImplV1.m18557a(IStreetViewLoader.OnStreetViewActionListener.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m18559b(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener, View view) {
        if (onStreetViewActionListener != null) {
            onStreetViewActionListener.hideView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18557a(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener, View view) {
        if (onStreetViewActionListener != null) {
            onStreetViewActionListener.goFeedback();
        }
    }
}
