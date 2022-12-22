package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.style.custom.IMCustomContext;
import com.didi.beatles.p099im.access.style.custom.IMCustomViewHelper;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMLocationCusView;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMLocationEntity;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMLocationRenderView */
public class IMLocationRenderView extends IMBaseRenderView<IMLocationCusView> {

    /* renamed from: a */
    private TextView f10326a;

    /* renamed from: b */
    private int f10327b;

    public IMLocationRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
        this.f10327b = i;
    }

    /* access modifiers changed from: protected */
    public IMLocationCusView createCustomView(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return IMCustomViewHelper.createLocation(iMBusinessConfig, iMCustomContext);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View tryLoadCustomView = tryLoadCustomView(viewGroup);
        if (tryLoadCustomView != null) {
            return tryLoadCustomView;
        }
        View inflate = this.inflater.inflate(R.layout.bts_im_message_location, viewGroup, false);
        if (inflate == null) {
            return null;
        }
        if (this.isMine) {
            inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_white_bubble_selector));
        } else {
            inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        if (!isCustomView()) {
            onFindViewByIdImpl();
        }
    }

    /* access modifiers changed from: protected */
    public void onFindViewByIdImpl() {
        this.f10326a = (TextView) findViewById(R.id.bts_im_location_address);
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
        this.adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (isCustomView()) {
            ((IMLocationCusView) this.mCusViewRender).bindContent(iMMessage);
        } else {
            onSetUpViewImpl(iMMessage);
        }
    }

    /* access modifiers changed from: protected */
    public void onSetUpViewImpl(IMMessage iMMessage) {
        IMLocationEntity iMLocationEntity = (IMLocationEntity) IMJsonUtil.objectFromJson(this.message.getContent(), IMLocationEntity.class);
        if (iMLocationEntity != null) {
            this.f10326a.setText(iMLocationEntity.displayname);
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        String str;
        String str2;
        IMLocationEntity iMLocationEntity = (IMLocationEntity) IMJsonUtil.objectFromJson(this.message.getContent(), IMLocationEntity.class);
        if (iMLocationEntity == null) {
            IMLog.m6632e(TAG, "IMLocationEntity is null");
            return;
        }
        int businessId = this.message.getBusinessId();
        if (IMEngine.getInstance(IMContextInfoHelper.getContext()) != null) {
            str = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(businessId).getLocationTopScheme();
            if (TextUtils.isEmpty(str)) {
                str = IMContextInfoHelper.locationTopScheme();
            }
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format(IMResource.getString(R.string.im_location_share_custom_scheme), new Object[]{str, iMLocationEntity.displayname, iMLocationEntity.address, Double.valueOf(iMLocationEntity.lat), Double.valueOf(iMLocationEntity.lng), iMLocationEntity.country_iso_code});
        } else {
            str2 = String.format(IMResource.getString(R.string.im_location_share), new Object[]{iMLocationEntity.displayname, iMLocationEntity.address, Double.valueOf(iMLocationEntity.lat), Double.valueOf(iMLocationEntity.lng), iMLocationEntity.country_iso_code});
        }
        IMCommonUtil.startUriActivity(getContext(), str2);
    }
}
