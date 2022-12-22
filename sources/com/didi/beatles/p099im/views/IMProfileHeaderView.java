package com.didi.beatles.p099im.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.adapter.GalleryAdapter;
import com.didi.beatles.p099im.api.entity.IMNewstandResponse;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.imageView.IMCircleImageView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMProfileHeaderView */
public class IMProfileHeaderView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f9917a;

    /* renamed from: b */
    private IMCircleImageView f9918b;

    /* renamed from: c */
    private TextView f9919c;

    /* renamed from: d */
    private IMFolderTextView f9920d;

    /* renamed from: e */
    private RecyclerView f9921e;

    /* renamed from: f */
    private TextView f9922f;

    /* renamed from: g */
    private TextView f9923g;

    /* renamed from: h */
    private GalleryAdapter f9924h;

    /* renamed from: i */
    private ImageView f9925i;

    public IMProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9917a = context;
        m6696a();
    }

    public IMProfileHeaderView(Context context) {
        super(context);
        this.f9917a = context;
        m6696a();
    }

    /* renamed from: a */
    private void m6696a() {
        View inflate = inflate(this.f9917a, R.layout.bts_message_profile_header, this);
        this.f9920d = (IMFolderTextView) inflate.findViewById(R.id.expand_text_view);
        this.f9918b = (IMCircleImageView) inflate.findViewById(R.id.user_portrait);
        this.f9919c = (TextView) inflate.findViewById(R.id.user_nick);
        this.f9921e = (RecyclerView) inflate.findViewById(R.id.gallery_list);
        this.f9922f = (TextView) inflate.findViewById(R.id.aciton_title);
        this.f9923g = (TextView) inflate.findViewById(R.id.summy_txt);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.im_chat_mark);
        this.f9925i = imageView;
        imageView.setImageResource(IMResource.getDrawableID(R.drawable.im_chat_user_mark_icon));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f9917a);
        linearLayoutManager.setOrientation(0);
        this.f9921e.setLayoutManager(linearLayoutManager);
    }

    public void bindUserInfo(final IMNewstandResponse.NewStandInfo newStandInfo) {
        if (newStandInfo != null) {
            IMNewstandResponse.NewStandUserInfo newStandUserInfo = newStandInfo.user;
            if (newStandUserInfo != null) {
                this.f9920d.setText(newStandUserInfo.user_info);
                this.f9919c.setText(newStandUserInfo.user_name);
                if (!TextUtils.isEmpty(newStandUserInfo.user_img)) {
                    BtsImageLoader.getInstance().loadInto((Object) newStandUserInfo.user_img, (View) this.f9918b, (int) R.drawable.bts_im_general_default_avatar);
                }
            }
            IMNewstandResponse.NewStandActivity newStandActivity = newStandInfo.activity;
            if (newStandActivity == null) {
                this.f9922f.setVisibility(8);
                this.f9921e.setVisibility(8);
                return;
            }
            if (newStandActivity.type == 1001) {
                this.f9923g.setVisibility(8);
                GalleryAdapter galleryAdapter = new GalleryAdapter(this.f9917a, newStandActivity.info);
                this.f9924h = galleryAdapter;
                this.f9921e.setAdapter(galleryAdapter);
            } else if (newStandActivity.type == 1002) {
                this.f9923g.setText(newStandInfo.activity.info[0].activity_summary);
                this.f9921e.setVisibility(8);
                this.f9923g.setVisibility(0);
            } else if (newStandActivity.type == 1003) {
                this.f9923g.setVisibility(8);
                this.f9921e.setVisibility(8);
            }
            if (newStandActivity.info == null || newStandActivity.info.length == 0) {
                this.f9921e.setVisibility(8);
            }
            if (TextUtils.isEmpty(newStandInfo.activity.title_url)) {
                this.f9922f.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.f9922f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        IMCommonUtil.startUriActivity(IMProfileHeaderView.this.f9917a, newStandInfo.activity.title_url);
                    }
                });
            }
            this.f9922f.setText(newStandActivity.title);
        }
    }
}
