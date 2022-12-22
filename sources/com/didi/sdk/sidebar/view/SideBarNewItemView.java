package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.facebook.common.util.UriUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rui.config.RConfigConstants;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020 J\u0010\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010$J\u0010\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010$J\u0012\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010-\u001a\u00020\"2\u0006\u0010&\u001a\u00020 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006."}, mo175978d2 = {"Lcom/didi/sdk/sidebar/view/SideBarNewItemView;", "Lcom/didi/sdk/sidebar/view/ComponentView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mDisCountTv", "Landroid/widget/TextView;", "getMDisCountTv", "()Landroid/widget/TextView;", "setMDisCountTv", "(Landroid/widget/TextView;)V", "mIcon", "Landroid/widget/ImageView;", "getMIcon", "()Landroid/widget/ImageView;", "setMIcon", "(Landroid/widget/ImageView;)V", "mMessage", "getMMessage", "setMMessage", "mNewFireToch", "getMNewFireToch", "setMNewFireToch", "mRedPoint", "getMRedPoint", "setMRedPoint", "mTitle", "getMTitle", "setMTitle", "createView", "Landroid/view/View;", "getRedDotVisibility", "", "setDiscountMsg", "", "discountMsg", "", "setFireTorchVisibility", "visibility", "setIcon", "url", "setMessageRedot", "tag", "setName", "name", "setRedDotVisibility", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SideBarNewItemView.kt */
public final class SideBarNewItemView extends ComponentView {

    /* renamed from: a */
    private ImageView f37499a;

    /* renamed from: b */
    private TextView f37500b;

    /* renamed from: c */
    private ImageView f37501c;

    /* renamed from: d */
    private TextView f37502d;

    /* renamed from: e */
    private ImageView f37503e;

    /* renamed from: f */
    private TextView f37504f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBarNewItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ImageView getMIcon() {
        return this.f37499a;
    }

    public final void setMIcon(ImageView imageView) {
        this.f37499a = imageView;
    }

    public final TextView getMTitle() {
        return this.f37500b;
    }

    public final void setMTitle(TextView textView) {
        this.f37500b = textView;
    }

    public final ImageView getMRedPoint() {
        return this.f37501c;
    }

    public final void setMRedPoint(ImageView imageView) {
        this.f37501c = imageView;
    }

    public final TextView getMMessage() {
        return this.f37502d;
    }

    public final void setMMessage(TextView textView) {
        this.f37502d = textView;
    }

    public final ImageView getMNewFireToch() {
        return this.f37503e;
    }

    public final void setMNewFireToch(ImageView imageView) {
        this.f37503e = imageView;
    }

    public final TextView getMDisCountTv() {
        return this.f37504f;
    }

    public final void setMDisCountTv(TextView textView) {
        this.f37504f = textView;
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.sidebar_item_new_view, (ViewGroup) null);
        setMIcon((ImageView) inflate.findViewById(R.id.side_bar_item_icon));
        setMMessage((TextView) inflate.findViewById(R.id.side_bar_item_message));
        setMTitle((TextView) inflate.findViewById(R.id.side_bar_item_title));
        setMRedPoint((ImageView) inflate.findViewById(R.id.side_bar_item_redpoint));
        setMNewFireToch((ImageView) inflate.findViewById(R.id.sidebar_item_fireToch));
        setMDisCountTv((TextView) inflate.findViewById(R.id.sidebar_item_discount));
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        return inflate;
    }

    public void setName(String str) {
        TextView textView = this.f37500b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setIcon(String str) {
        if (str != null) {
            if (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
                ImageView imageView = this.f37499a;
                Intrinsics.checkNotNull(imageView);
                ((RequestBuilder) Glide.with(this.context).load(str).placeholder(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.sidebar_icon_default, this.context.getTheme()))).into(imageView);
            } else if (StringsKt.startsWith$default(str, UriUtil.QUALIFIED_RESOURCE_SCHEME, false, 2, (Object) null)) {
                String host = Uri.parse(str).getHost();
                if (host != null && !StringsKt.startsWith$default(host, "sidebar", false, 2, (Object) null)) {
                    host = Intrinsics.stringPlus("sidebar_", host);
                }
                int identifier = this.context.getResources().getIdentifier(host, RConfigConstants.TYPE_DRAWABLE, this.context.getPackageName());
                ImageView imageView2 = this.f37499a;
                if (imageView2 != null) {
                    imageView2.setImageResource(identifier);
                }
            }
        }
    }

    public final void setRedDotVisibility(int i) {
        ImageView imageView = this.f37501c;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public final void setFireTorchVisibility(int i) {
        ImageView imageView = this.f37503e;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public final void setDiscountMsg(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            TextView textView = this.f37504f;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f37504f;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.f37504f;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
    }

    public final void setMessageRedot(String str) {
        Long l;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            TextView textView = this.f37502d;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f37502d;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (str == null) {
            l = null;
        } else {
            try {
                l = Long.valueOf(Long.parseLong(str));
            } catch (Exception unused) {
                TextView textView3 = this.f37502d;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                    return;
                }
                return;
            }
        }
        if (l.longValue() > 99) {
            TextView textView4 = this.f37502d;
            if (textView4 != null) {
                textView4.setText("99+");
                return;
            }
            return;
        }
        TextView textView5 = this.f37502d;
        if (textView5 != null) {
            textView5.setText(str);
        }
    }

    public final int getRedDotVisibility() {
        ImageView imageView = this.f37501c;
        if (imageView == null) {
            return 0;
        }
        return imageView.getVisibility();
    }
}
