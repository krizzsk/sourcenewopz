package com.didi.safetoolkit.business.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.share.SfContractOptIView;
import com.didi.safetoolkit.business.share.controller.SfGetOptController;
import com.didi.safetoolkit.util.SfInputMethodUtil;
import com.didi.safetoolkit.util.SfViewUtils;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0014J*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u001fH\u0014J\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u0017H\u0014J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\"\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/contacts/SfContactsManageOptActivity;", "Lcom/didi/safetoolkit/base/BaseSafeToolkitActivity;", "Lcom/didi/safetoolkit/business/share/SfContractOptIView;", "()V", "addButton", "Landroid/widget/Button;", "guideLayout", "Landroid/widget/FrameLayout;", "line1", "Landroid/view/View;", "line2", "nameClearIcon", "Landroid/widget/ImageView;", "nameInput", "Landroid/widget/EditText;", "phoneClearIcon", "phoneIcon", "phoneInput", "sfGetOptController", "Lcom/didi/safetoolkit/business/share/controller/SfGetOptController;", "titleBar", "Lcom/didi/safetoolkit/widget/SfCommonTitleBar;", "findViews", "", "getBasicContentLayoutResId", "", "getFallbackView", "hideGuide", "hideLoadingState", "initData", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "isFragmentSponsor", "parseBundle", "bundle", "Landroid/os/Bundle;", "setListener", "showGuide", "showLoadingState", "updateView", "view", "hasContent", "hasFocus", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfContactsManageOptActivity.kt */
public final class SfContactsManageOptActivity extends BaseSafeToolkitActivity implements SfContractOptIView {

    /* renamed from: a */
    private SfCommonTitleBar f34304a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f34305b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f34306c;

    /* renamed from: d */
    private ImageView f34307d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f34308e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ImageView f34309f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Button f34310g;

    /* renamed from: h */
    private FrameLayout f34311h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SfGetOptController f34312i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f34313j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f34314k;

    /* renamed from: l */
    private HashMap f34315l;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f34315l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f34315l == null) {
            this.f34315l = new HashMap();
        }
        View view = (View) this.f34315l.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f34315l.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_contacts_manage_opt;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m24278a(View view, boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (!z) {
            if (layoutParams != null) {
                layoutParams.height = SfViewUtils.dp2px(this, 0.5f);
            }
            if (z2) {
                if (view != null) {
                    view.setBackgroundColor(Color.parseColor("#FF8040"));
                }
            } else if (view != null) {
                view.setBackgroundColor(Color.parseColor("#DDDDDD"));
            }
        } else if (layoutParams != null) {
            layoutParams.height = SfViewUtils.dp2px(this, 1.5f);
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34304a = (SfCommonTitleBar) findViewById(R.id.titleBar);
        this.f34305b = (EditText) findViewById(R.id.nameInput);
        this.f34306c = (EditText) findViewById(R.id.phoneInput);
        this.f34307d = (ImageView) findViewById(R.id.phoneIcon);
        this.f34308e = (ImageView) findViewById(R.id.nameClearIcon);
        this.f34309f = (ImageView) findViewById(R.id.phoneClearIcon);
        this.f34310g = (Button) findViewById(R.id.addButton);
        this.f34311h = (FrameLayout) findViewById(R.id.guideLayout);
        this.f34313j = findViewById(R.id.line1);
        this.f34314k = findViewById(R.id.line2);
        Button button = this.f34310g;
        if (button != null) {
            button.setEnabled(false);
        }
        Button button2 = this.f34310g;
        if (button2 != null) {
            button2.setTextColor(Color.parseColor("#D4D7D9"));
        }
        EditText editText = this.f34306c;
        if (editText != null) {
            editText.requestFocus();
        }
        SfInputMethodUtil sfInputMethodUtil = SfInputMethodUtil.INSTANCE;
        Context context = this;
        EditText editText2 = this.f34306c;
        if (editText2 == null) {
            Intrinsics.throwNpe();
        }
        sfInputMethodUtil.showInputMethod(context, editText2);
        m24278a(this.f34313j, false, true);
        m24278a(this.f34314k, false, false);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        SfGetOptController sfGetOptController;
        Integer num;
        ImageView imageView;
        SfCommonTitleBar sfCommonTitleBar = this.f34304a;
        if (sfCommonTitleBar != null) {
            sfCommonTitleBar.setTitleText("");
        }
        SfGetOptController sfGetOptController2 = new SfGetOptController(this);
        this.f34312i = sfGetOptController2;
        if (sfGetOptController2 != null) {
            Intent intent = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
            sfGetOptController2.parseBundle(intent.getExtras());
        }
        IToggle toggle = Apollo.getToggle("passenger_trusted_contact_display");
        if (!(toggle == null || !toggle.allow() || (num = (Integer) toggle.getExperiment().getParam("hidden", 0)) == null || num.intValue() != 1 || (imageView = this.f34307d) == null)) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.f34307d;
        if (imageView2 != null && imageView2.getVisibility() == 0 && (sfGetOptController = this.f34312i) != null) {
            sfGetOptController.showGuide();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        ImageView imageView = this.f34308e;
        if (imageView != null) {
            imageView.setOnClickListener(new SfContactsManageOptActivity$setListener$1(this));
        }
        ImageView imageView2 = this.f34309f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new SfContactsManageOptActivity$setListener$2(this));
        }
        ImageView imageView3 = this.f34307d;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new SfContactsManageOptActivity$setListener$3(this));
        }
        EditText editText = this.f34306c;
        if (editText != null) {
            editText.setOnFocusChangeListener(new SfContactsManageOptActivity$setListener$4(this));
        }
        EditText editText2 = this.f34305b;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(new SfContactsManageOptActivity$setListener$5(this));
        }
        EditText editText3 = this.f34305b;
        if (editText3 != null) {
            editText3.addTextChangedListener(new SfContactsManageOptActivity$setListener$6(this));
        }
        EditText editText4 = this.f34306c;
        if (editText4 != null) {
            editText4.addTextChangedListener(new SfContactsManageOptActivity$setListener$7(this));
        }
        SfCommonTitleBar sfCommonTitleBar = this.f34304a;
        if (sfCommonTitleBar != null) {
            sfCommonTitleBar.setLeftBtnClickListener(new SfContactsManageOptActivity$setListener$8(this));
        }
        Button button = this.f34310g;
        if (button != null) {
            button.setOnClickListener(new SfContactsManageOptActivity$setListener$9(this));
        }
    }

    public View getFallbackView() {
        SfCommonTitleBar sfCommonTitleBar = this.f34304a;
        return sfCommonTitleBar != null ? sfCommonTitleBar.getLoadingFallback() : null;
    }

    public void showLoadingState() {
        showPDialog();
    }

    public void hideLoadingState() {
        closePDialog();
    }

    public void hideGuide() {
        FrameLayout frameLayout = this.f34311h;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public void showGuide() {
        try {
            View view = null;
            LEGOBubble build = new LEGOBubble.Builder(this).setText(ResourcesHelper.getString(this, R.string.GDriver_Contacts_Contacts_qCeS)).setCloseBtnListener((BubbleCloseListener) null).setCloseBtnVisible(false).setTextTypeface(3).setBgColor(Color.parseColor("#5C6166")).setContentViewOnClick(new SfContactsManageOptActivity$showGuide$guide$1(this)).setDirection("bottom_right").build();
            Intrinsics.checkExpressionValueIsNotNull(build, "LEGOBubble.Builder(this)…                 .build()");
            FrameLayout frameLayout = this.f34311h;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = this.f34311h;
            if (frameLayout2 != null) {
                if (build != null) {
                    view = build.getView();
                }
                frameLayout2.addView(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent, boolean z) {
        SfGetOptController sfGetOptController = this.f34312i;
        if (sfGetOptController != null) {
            sfGetOptController.onActivityResult(i, i2, intent);
        }
        return super.onActivityResult(i, i2, intent, z);
    }
}
