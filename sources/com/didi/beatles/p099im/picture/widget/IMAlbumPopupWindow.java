package com.didi.beatles.p099im.picture.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.picture.adapter.IMAlbumAdapter;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p099im.picture.utils.IMStringUtils;
import com.didi.beatles.p099im.views.IMDividerItemDecoration;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.widget.IMAlbumPopupWindow */
public class IMAlbumPopupWindow extends PopupWindow implements View.OnClickListener {

    /* renamed from: a */
    private Context f9455a;

    /* renamed from: b */
    private View f9456b;

    /* renamed from: c */
    private RecyclerView f9457c;

    /* renamed from: d */
    private IMAlbumAdapter f9458d;

    /* renamed from: e */
    private Animation f9459e;

    /* renamed from: f */
    private Animation f9460f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f9461g = false;

    /* renamed from: h */
    private LinearLayout f9462h;

    /* renamed from: i */
    private TextView f9463i;

    /* renamed from: j */
    private Drawable f9464j;

    /* renamed from: k */
    private Drawable f9465k;

    /* renamed from: l */
    private int f9466l;

    public IMAlbumPopupWindow(Context context, int i) {
        this.f9455a = context;
        this.f9466l = i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_picture_album_popup, (ViewGroup) null);
        this.f9456b = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setAnimationStyle(R.style.IMAlbumPopup);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.argb(123, 0, 0, 0)));
        this.f9464j = context.getResources().getDrawable(R.drawable.im_picture_ic_arrow_up);
        this.f9465k = context.getResources().getDrawable(R.drawable.im_picture_ic_arrow_down);
        this.f9459e = AnimationUtils.loadAnimation(context, R.anim.im_picture_album_show);
        this.f9460f = AnimationUtils.loadAnimation(context, R.anim.im_picture_album_dismiss);
        initView();
    }

    public void initView() {
        this.f9462h = (LinearLayout) this.f9456b.findViewById(R.id.ll_album_container);
        this.f9458d = new IMAlbumAdapter(this.f9455a);
        RecyclerView recyclerView = (RecyclerView) this.f9456b.findViewById(R.id.rv_im_album);
        this.f9457c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f9455a));
        RecyclerView recyclerView2 = this.f9457c;
        Context context = this.f9455a;
        recyclerView2.addItemDecoration(new IMDividerItemDecoration(context, 0, 1, context.getResources().getColor(R.color.white)));
        this.f9457c.setAdapter(this.f9458d);
        this.f9462h.setOnClickListener(this);
    }

    public void bindFolder(List<IMLocalMediaFolder> list) {
        this.f9458d.setMimeType(this.f9466l);
        this.f9458d.bindAlbumData(list);
    }

    public void setPictureTitleView(TextView textView) {
        this.f9463i = textView;
    }

    public void showAsDropDown(View view) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                setHeight(view.getResources().getDisplayMetrics().heightPixels - rect.bottom);
            }
            super.showAsDropDown(view);
            this.f9461g = false;
            this.f9457c.startAnimation(this.f9459e);
            IMStringUtils.modifyTextViewDrawable(this.f9463i, this.f9464j, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnAlbumSelectListener(IMAlbumAdapter.OnAlbumSelectListener onAlbumSelectListener) {
        this.f9458d.setOnAlbumSelectListener(onAlbumSelectListener);
    }

    public void dismiss() {
        if (!this.f9461g) {
            IMStringUtils.modifyTextViewDrawable(this.f9463i, this.f9465k, 2);
            this.f9461g = true;
            this.f9457c.startAnimation(this.f9460f);
            dismiss();
            this.f9460f.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    boolean unused = IMAlbumPopupWindow.this.f9461g = false;
                    if (Build.VERSION.SDK_INT <= 16) {
                        IMAlbumPopupWindow.this.m6420a();
                    } else {
                        IMAlbumPopupWindow.super.dismiss();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6420a() {
        new Handler().post(new Runnable() {
            public void run() {
                IMAlbumPopupWindow.super.dismiss();
            }
        });
    }

    public void notifyDataCheckedStatus(List<IMLocalMedia> list) {
        try {
            List<IMLocalMediaFolder> folderData = this.f9458d.getFolderData();
            for (IMLocalMediaFolder checkedNum : folderData) {
                checkedNum.setCheckedNum(0);
            }
            if (list.size() > 0) {
                for (IMLocalMediaFolder next : folderData) {
                    int i = 0;
                    for (IMLocalMedia path : next.getImages()) {
                        String path2 = path.getPath();
                        for (IMLocalMedia path3 : list) {
                            if (path2.equals(path3.getPath())) {
                                i++;
                                next.setCheckedNum(i);
                            }
                        }
                    }
                }
            }
            this.f9458d.bindAlbumData(folderData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.ll_album_container) {
            dismiss();
        }
    }
}
