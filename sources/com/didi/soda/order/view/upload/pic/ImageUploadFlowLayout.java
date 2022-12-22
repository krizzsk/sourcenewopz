package com.didi.soda.order.view.upload.pic;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0013H\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013J\u001c\u0010\"\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010(\u001a\u00020\u001eJ\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006-"}, mo175978d2 = {"Lcom/didi/soda/order/view/upload/pic/ImageUploadFlowLayout;", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageAddView", "Landroid/view/View;", "getImageAddView", "()Landroid/view/View;", "setImageAddView", "(Landroid/view/View;)V", "imageUrlList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getImageUrlList", "()Ljava/util/ArrayList;", "mListener", "Lcom/didi/soda/order/view/upload/pic/ImageUploadFlowLayout$Companion$FlowLayoutListener;", "getMListener", "()Lcom/didi/soda/order/view/upload/pic/ImageUploadFlowLayout$Companion$FlowLayoutListener;", "setMListener", "(Lcom/didi/soda/order/view/upload/pic/ImageUploadFlowLayout$Companion$FlowLayoutListener;)V", "addImageLayout", "", "child", "url", "base64Str", "createPhotoView", "imageUrl", "goToPreviewImagePage", "imageView", "Landroid/widget/ImageView;", "localImageStr", "initView", "removeImageLayout", "setPhotoLayoutListener", "listener", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ImageUploadFlowLayout.kt */
public final class ImageUploadFlowLayout extends NovaFlowLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_CHILD_NUM = 5;

    /* renamed from: a */
    private View f43623a;

    /* renamed from: b */
    private Companion.FlowLayoutListener f43624b;

    /* renamed from: c */
    private final ArrayList<String> f43625c = new ArrayList<>();

    public void _$_clearFindViewByIdCache() {
    }

    public final View getImageAddView() {
        return this.f43623a;
    }

    public final void setImageAddView(View view) {
        this.f43623a = view;
    }

    public final Companion.FlowLayoutListener getMListener() {
        return this.f43624b;
    }

    public final void setMListener(Companion.FlowLayoutListener flowLayoutListener) {
        this.f43624b = flowLayoutListener;
    }

    public final ArrayList<String> getImageUrlList() {
        return this.f43625c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageUploadFlowLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageUploadFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageUploadFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    public final void initView() {
        this.f43625c.clear();
        View inflate = NovaFlowLayout.inflate(getContext(), R.layout.customer_upload_image_add_layout, (ViewGroup) null);
        this.f43623a = inflate;
        if (inflate != null) {
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ImageUploadFlowLayout.m30919a(ImageUploadFlowLayout.this, view);
                }
            });
        }
        addView(this.f43623a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30919a(ImageUploadFlowLayout imageUploadFlowLayout, View view) {
        Intrinsics.checkNotNullParameter(imageUploadFlowLayout, "this$0");
        Companion.FlowLayoutListener mListener = imageUploadFlowLayout.getMListener();
        if (mListener != null) {
            mListener.onAddBtnClick();
        }
    }

    public final void setPhotoLayoutListener(Companion.FlowLayoutListener flowLayoutListener) {
        Intrinsics.checkNotNullParameter(flowLayoutListener, "listener");
        this.f43624b = flowLayoutListener;
    }

    public final void addImageLayout(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "base64Str");
        Intrinsics.checkNotNullParameter(str2, "url");
        m30917a(m30915a(str, str2), str2);
    }

    /* renamed from: a */
    private final void m30917a(View view, String str) {
        View view2;
        view.setTag(str);
        if (getChildCount() > 0) {
            addView(view, getChildCount() - 1);
            this.f43625c.add(str);
        }
        if (getChildCount() > 5 && (view2 = this.f43623a) != null) {
            view2.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final void m30916a(View view) {
        View view2;
        removeView(view);
        if (view.getTag() instanceof String) {
            ArrayList<String> arrayList = this.f43625c;
            Object tag = view.getTag();
            if (tag != null) {
                arrayList.remove((String) tag);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (getChildCount() <= 5 && (view2 = this.f43623a) != null) {
            view2.setVisibility(0);
        }
    }

    /* renamed from: a */
    private final View m30915a(String str, String str2) {
        Unit unit = null;
        View inflate = NovaFlowLayout.inflate(getContext(), R.layout.customer_upload_image_item_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.customer_upload_image_item_iv);
        Bitmap convertStringToIcon = BitmapUtil.convertStringToIcon(str);
        if (convertStringToIcon != null) {
            imageView.setImageBitmap(convertStringToIcon);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            imageView.setImageResource(R.drawable.customer_skin_icon_business_round_logo);
        }
        View findViewById = inflate.findViewById(R.id.customer_delete_curr_item_view);
        imageView.setOnClickListener(new View.OnClickListener(imageView, str) {
            public final /* synthetic */ ImageView f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                ImageUploadFlowLayout.m30921a(ImageUploadFlowLayout.this, this.f$1, this.f$2, view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener(inflate) {
            public final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ImageUploadFlowLayout.m30920a(ImageUploadFlowLayout.this, this.f$1, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "root");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30921a(ImageUploadFlowLayout imageUploadFlowLayout, ImageView imageView, String str, View view) {
        Intrinsics.checkNotNullParameter(imageUploadFlowLayout, "this$0");
        Intrinsics.checkNotNullExpressionValue(imageView, "image");
        imageUploadFlowLayout.m30918a(imageView, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30920a(ImageUploadFlowLayout imageUploadFlowLayout, View view, View view2) {
        Intrinsics.checkNotNullParameter(imageUploadFlowLayout, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "root");
        imageUploadFlowLayout.m30916a(view);
    }

    /* renamed from: a */
    private final void m30918a(ImageView imageView, String str) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        boolean z = true;
        String string = imageView.getContext().getString(R.string.customer_transition_tag_evaluate_preview_image_named, new Object[]{valueOf});
        Intrinsics.checkNotNullExpressionValue(string, "imageView.context.getStr…e_named, suffix\n        )");
        int width = imageView.getWidth();
        ViewCompat.setTransitionName(imageView, string);
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            DiRouter.request().path(RoutePath.EVALUATE_PREVIEW_IMAGE).putString(Const.PageParams.TRANSITION_NAMES, string).putString(Const.PageParams.LOCAL_PREVIEW_IMAGE, str).putInt(Const.PageParams.PREVIEW_IMAGE_WIDTH, width).open();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/order/view/upload/pic/ImageUploadFlowLayout$Companion;", "", "()V", "MAX_CHILD_NUM", "", "FlowLayoutListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ImageUploadFlowLayout.kt */
    public static final class Companion {

        @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/order/view/upload/pic/ImageUploadFlowLayout$Companion$FlowLayoutListener;", "", "onAddBtnClick", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ImageUploadFlowLayout.kt */
        public interface FlowLayoutListener {
            void onAddBtnClick();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
