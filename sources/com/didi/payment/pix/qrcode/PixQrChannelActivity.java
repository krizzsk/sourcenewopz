package com.didi.payment.pix.qrcode;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.activity.AutoDetectQRCodeActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.response.PixQrChannelResp;
import com.didi.payment.pix.qrcode.p138vm.PixQrChannelVM;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001fH\u0014J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, mo175978d2 = {"Lcom/didi/payment/pix/qrcode/PixQrChannelActivity;", "Lcom/didi/payment/commonsdk/activity/AutoDetectQRCodeActivity;", "Lcom/didi/payment/pix/qrcode/vm/PixQrChannelVM;", "()V", "adapter", "Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter;", "getAdapter", "()Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter;", "setAdapter", "(Lcom/didi/payment/pix/qrcode/PixQrChannelAdapter;)V", "imgView", "Landroid/widget/ImageView;", "getImgView", "()Landroid/widget/ImageView;", "setImgView", "(Landroid/widget/ImageView;)V", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "titleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "getTitleBar", "()Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "setTitleBar", "(Lcom/didi/sdk/view/titlebar/CommonTitleBar;)V", "getTitleBarView", "Landroid/view/View;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onReceivePopbackEvent", "registeBackstackEvent", "", "subscribeUi", "vm", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixQrChannelActivity.kt */
public final class PixQrChannelActivity extends AutoDetectQRCodeActivity<PixQrChannelVM> {
    public PixQrChannelAdapter adapter;
    public ImageView imgView;
    public RecyclerView recycleView;
    public CommonTitleBar titleBar;

    public boolean registeBackstackEvent() {
        return true;
    }

    public final ImageView getImgView() {
        ImageView imageView = this.imgView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imgView");
        return null;
    }

    public final void setImgView(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.imgView = imageView;
    }

    public final RecyclerView getRecycleView() {
        RecyclerView recyclerView = this.recycleView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        return null;
    }

    public final void setRecycleView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recycleView = recyclerView;
    }

    public final PixQrChannelAdapter getAdapter() {
        PixQrChannelAdapter pixQrChannelAdapter = this.adapter;
        if (pixQrChannelAdapter != null) {
            return pixQrChannelAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void setAdapter(PixQrChannelAdapter pixQrChannelAdapter) {
        Intrinsics.checkNotNullParameter(pixQrChannelAdapter, "<set-?>");
        this.adapter = pixQrChannelAdapter;
    }

    public final CommonTitleBar getTitleBar() {
        CommonTitleBar commonTitleBar = this.titleBar;
        if (commonTitleBar != null) {
            return commonTitleBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        return null;
    }

    public final void setTitleBar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "<set-?>");
        this.titleBar = commonTitleBar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_qr_channel);
        m21899a();
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new PixQrChannelVM.Factory(application)).get(PixQrChannelVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …xQrChannelVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((PixQrChannelVM) getVm());
        ((PixQrChannelVM) getVm()).loadData();
        initQRDetectVm();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_choose_sw");
    }

    /* access modifiers changed from: protected */
    public void onReceivePopbackEvent() {
        finish();
    }

    public void subscribeUi(PixQrChannelVM pixQrChannelVM) {
        Intrinsics.checkNotNullParameter(pixQrChannelVM, "vm");
        super.subscribeUi(pixQrChannelVM);
        pixQrChannelVM.getQrChannel().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PixQrChannelActivity.m21901a(PixQrChannelActivity.this, (PixQrChannelResp.Data) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21901a(PixQrChannelActivity pixQrChannelActivity, PixQrChannelResp.Data data) {
        Intrinsics.checkNotNullParameter(pixQrChannelActivity, "this$0");
        if (data != null) {
            pixQrChannelActivity.getTitleBar().setTitle(data.getTitle());
            GlideUtils.with2load2into(pixQrChannelActivity, data.getIconUrl(), pixQrChannelActivity.getImgView());
            if (data.getEntryList() != null) {
                PixQrChannelAdapter adapter2 = pixQrChannelActivity.getAdapter();
                List<PixQrChannelResp.Entry> entryList = data.getEntryList();
                Intrinsics.checkNotNull(entryList);
                adapter2.setEntrys(entryList);
                pixQrChannelActivity.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return getTitleBar();
    }

    /* renamed from: a */
    private final void m21899a() {
        View findViewById = findViewById(R.id.layout_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_title_bar)");
        setTitleBar((CommonTitleBar) findViewById);
        getTitleBar().setRightVisible(4);
        getTitleBar().setTitleBarLineVisible(8);
        getTitleBar().setVisibility(0);
        decoretaTitlebar(getTitleBar());
        getTitleBar().setLeftImage((int) R.drawable.common_title_back_arrow, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrChannelActivity.m21900a(PixQrChannelActivity.this, view);
            }
        });
        View findViewById2 = findViewById(R.id.pix_qr_channel_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_qr_channel_img)");
        setImgView((ImageView) findViewById2);
        View findViewById3 = findViewById(R.id.pix_qr_recyclerview);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_qr_recyclerview)");
        setRecycleView((RecyclerView) findViewById3);
        Context context = this;
        getRecycleView().setLayoutManager(new LinearLayoutManager(context));
        setAdapter(new PixQrChannelAdapter(context));
        getRecycleView().setAdapter(getAdapter());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21900a(PixQrChannelActivity pixQrChannelActivity, View view) {
        Intrinsics.checkNotNullParameter(pixQrChannelActivity, "this$0");
        pixQrChannelActivity.onBackPressed();
    }
}
