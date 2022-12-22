package com.didi.dimina.container.p106ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.Dimina;
import com.taxis99.R;
import java.io.File;

/* renamed from: com.didi.dimina.container.ui.dialog.ImageCloseView */
public class ImageCloseView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f17563a;

    /* renamed from: b */
    private ImageView f17564b;

    /* renamed from: c */
    private OnImageCloseClickListener f17565c;

    /* renamed from: com.didi.dimina.container.ui.dialog.ImageCloseView$OnImageCloseClickListener */
    public interface OnImageCloseClickListener {
        void onClick();

        void onClose();
    }

    public ImageCloseView(Context context) {
        super(context);
        m13082a();
    }

    public ImageCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13082a();
    }

    public ImageCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13082a();
    }

    /* renamed from: a */
    private void m13082a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_image_close_view, this);
        this.f17563a = (ImageView) findViewById(R.id.image);
        this.f17564b = (ImageView) findViewById(R.id.close);
        this.f17563a.setOnClickListener(this);
        this.f17564b.setOnClickListener(this);
    }

    public void setClickListener(OnImageCloseClickListener onImageCloseClickListener) {
        this.f17565c = onImageCloseClickListener;
    }

    public void setImageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http")) {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(getContext(), str, 0, this.f17563a);
            }
            if (str.startsWith("/")) {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(getContext(), new File(str), this.f17563a);
            }
        }
    }

    public void onClick(View view) {
        OnImageCloseClickListener onImageCloseClickListener;
        OnImageCloseClickListener onImageCloseClickListener2;
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f17563a && (onImageCloseClickListener2 = this.f17565c) != null) {
            onImageCloseClickListener2.onClick();
        }
        if (view == this.f17564b && (onImageCloseClickListener = this.f17565c) != null) {
            onImageCloseClickListener.onClose();
        }
    }
}
