package com.didi.payment.pix.qrcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.pix.net.response.PixQrChannelResp;
import com.didi.payment.pix.qrcode.PixQrChannelAdapter;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter$PixQrChannelHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "entrys", "", "Lcom/didi/payment/pix/net/response/PixQrChannelResp$Entry;", "getEntrys", "()Ljava/util/List;", "setEntrys", "(Ljava/util/List;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PixQrChannelHolder", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixQrChannelAdapter.kt */
public final class PixQrChannelAdapter extends RecyclerView.Adapter<PixQrChannelHolder> {

    /* renamed from: a */
    private Context f31152a;

    /* renamed from: b */
    private List<PixQrChannelResp.Entry> f31153b = new ArrayList();

    public PixQrChannelAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f31152a = context;
    }

    public final Context getMContext() {
        return this.f31152a;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.f31152a = context;
    }

    public final List<PixQrChannelResp.Entry> getEntrys() {
        return this.f31153b;
    }

    public final void setEntrys(List<PixQrChannelResp.Entry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f31153b = list;
    }

    public PixQrChannelHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f31152a).inflate(R.layout.item_qr_channel, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new PixQrChannelHolder(this, inflate);
    }

    public int getItemCount() {
        return this.f31153b.size();
    }

    public void onBindViewHolder(PixQrChannelHolder pixQrChannelHolder, int i) {
        Intrinsics.checkNotNullParameter(pixQrChannelHolder, "holder");
        pixQrChannelHolder.bind(this.f31153b.get(i));
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter$PixQrChannelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter;Landroid/view/View;)V", "entry", "Lcom/didi/payment/pix/net/response/PixQrChannelResp$Entry;", "getEntry", "()Lcom/didi/payment/pix/net/response/PixQrChannelResp$Entry;", "setEntry", "(Lcom/didi/payment/pix/net/response/PixQrChannelResp$Entry;)V", "imgView", "Landroid/widget/ImageView;", "getImgView", "()Landroid/widget/ImageView;", "setImgView", "(Landroid/widget/ImageView;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "bind", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrChannelAdapter.kt */
    public final class PixQrChannelHolder extends RecyclerView.ViewHolder {
        public PixQrChannelResp.Entry entry;
        private ImageView imgView;
        private TextView textView;
        final /* synthetic */ PixQrChannelAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PixQrChannelHolder(PixQrChannelAdapter pixQrChannelAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(pixQrChannelAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = pixQrChannelAdapter;
            View findViewById = view.findViewById(R.id.pix_qr_channel_item_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.….pix_qr_channel_item_img)");
            this.imgView = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.pix_qr_channel_item_text);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…pix_qr_channel_item_text)");
            this.textView = (TextView) findViewById2;
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixQrChannelAdapter.PixQrChannelHolder.m46593_init_$lambda1(PixQrChannelAdapter.PixQrChannelHolder.this, view);
                }
            });
        }

        public final ImageView getImgView() {
            return this.imgView;
        }

        public final void setImgView(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.imgView = imageView;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final void setTextView(TextView textView2) {
            Intrinsics.checkNotNullParameter(textView2, "<set-?>");
            this.textView = textView2;
        }

        public final PixQrChannelResp.Entry getEntry() {
            PixQrChannelResp.Entry entry2 = this.entry;
            if (entry2 != null) {
                return entry2;
            }
            Intrinsics.throwUninitializedPropertyAccessException(ParamKeys.PARAM_COMPLAIN_ENTRY);
            return null;
        }

        public final void setEntry(PixQrChannelResp.Entry entry2) {
            Intrinsics.checkNotNullParameter(entry2, "<set-?>");
            this.entry = entry2;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-1  reason: not valid java name */
        public static final void m46593_init_$lambda1(PixQrChannelHolder pixQrChannelHolder, View view) {
            Intrinsics.checkNotNullParameter(pixQrChannelHolder, "this$0");
            pixQrChannelHolder.getEntry();
            String linkUrl = pixQrChannelHolder.getEntry().getLinkUrl();
            Integer valueOf = linkUrl == null ? null : Integer.valueOf(StringsKt.indexOf$default((CharSequence) linkUrl, "pix_scan_auto", 0, false, 6, (Object) null));
            if (valueOf == null || valueOf.intValue() < 0) {
                String linkUrl2 = pixQrChannelHolder.getEntry().getLinkUrl();
                Integer valueOf2 = linkUrl2 == null ? null : Integer.valueOf(StringsKt.indexOf$default((CharSequence) linkUrl2, "pix_scan_manual", 0, false, 6, (Object) null));
                if (valueOf2 != null && valueOf2.intValue() >= 0) {
                    FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_choose_manual_ck");
                }
            } else {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_choose_scan_ck");
            }
            DRouter.build(pixQrChannelHolder.getEntry().getLinkUrl()).start((Context) null);
        }

        public final void bind(PixQrChannelResp.Entry entry2) {
            Intrinsics.checkNotNullParameter(entry2, ParamKeys.PARAM_COMPLAIN_ENTRY);
            setEntry(entry2);
            this.textView.setText(entry2.getName());
            GlideUtils.with2load2into(this.this$0.getMContext(), entry2.getIcon(), this.imgView);
        }
    }
}
