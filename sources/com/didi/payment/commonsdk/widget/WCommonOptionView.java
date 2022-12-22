package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/widget/WCommonOptionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkImg", "Landroid/widget/ImageView;", "getCheckImg", "()Landroid/widget/ImageView;", "setCheckImg", "(Landroid/widget/ImageView;)V", "itemNameTv", "Landroid/widget/TextView;", "getItemNameTv", "()Landroid/widget/TextView;", "setItemNameTv", "(Landroid/widget/TextView;)V", "setChecked", "", "checked", "", "checkedRes", "", "setOptionName", "charSequence", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WCommonOptionView.kt */
public final class WCommonOptionView extends LinearLayout {
    public ImageView checkImg;
    public TextView itemNameTv;

    public WCommonOptionView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.pix_option_item_lay, this, true);
        View findViewById = findViewById(R.id.option_check_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.option_check_img)");
        setCheckImg((ImageView) findViewById);
        View findViewById2 = findViewById(R.id.option_item_name_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.option_item_name_tv)");
        setItemNameTv((TextView) findViewById2);
    }

    public final ImageView getCheckImg() {
        ImageView imageView = this.checkImg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("checkImg");
        return null;
    }

    public final void setCheckImg(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.checkImg = imageView;
    }

    public final TextView getItemNameTv() {
        TextView textView = this.itemNameTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemNameTv");
        return null;
    }

    public final void setItemNameTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.itemNameTv = textView;
    }

    public final void setChecked(int i) {
        getCheckImg().setImageResource(i);
    }

    public final void setChecked(boolean z) {
        getCheckImg().setSelected(z);
        if (z) {
            getCheckImg().setImageResource(R.drawable.w_common_icon_checked);
        } else {
            getCheckImg().setImageResource(R.drawable.w_common_icon_unchecked);
        }
    }

    public final void setOptionName(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        getItemNameTv().setText(charSequence);
    }
}
