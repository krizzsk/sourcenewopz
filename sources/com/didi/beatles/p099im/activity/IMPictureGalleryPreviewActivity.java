package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.picture.adapter.IMPicturePreviewFragmentAdapter;
import com.didi.beatles.p099im.picture.anim.IMOptAnimationLoader;
import com.didi.beatles.p099im.picture.config.IMPictureConfig;
import com.didi.beatles.p099im.picture.entity.IMEventEntity;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.observable.IMMediaObservable;
import com.didi.beatles.p099im.utils.IMScreenUtil;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.widget.IMViewPager;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMPictureGalleryPreviewActivity */
public class IMPictureGalleryPreviewActivity extends IMPictureBaseActivity implements View.OnClickListener, Animation.AnimationListener, IMPicturePreviewFragmentAdapter.OnCallBackActivity {

    /* renamed from: a */
    private ImageView f8992a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f8993b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMViewPager f8994c;

    /* renamed from: d */
    private FrameLayout f8995d;

    /* renamed from: e */
    private TextView f8996e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f8997f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<IMLocalMedia> f8998g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<IMLocalMedia> f8999h = new ArrayList();

    /* renamed from: i */
    private IMPicturePreviewFragmentAdapter f9000i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Animation f9001j;

    /* renamed from: k */
    private boolean f9002k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f9003l;

    /* renamed from: m */
    private int f9004m;

    /* renamed from: n */
    private Handler f9005n;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public static void startActivity(Context context, List<IMLocalMedia> list, int i) {
        Intent intent = new Intent(context, IMPictureGalleryPreviewActivity.class);
        Bundle bundle = new Bundle();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        bundle.putSerializable(IMPictureConfig.EXTRA_SELECT_LIST, (Serializable) list);
        bundle.putInt("position", i);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, List<IMLocalMedia> list, List<IMLocalMedia> list2, boolean z) {
        Intent intent = new Intent(context, IMPictureGalleryPreviewActivity.class);
        Bundle bundle = new Bundle();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        bundle.putSerializable(IMPictureConfig.EXTRA_PREVIEW_SELECT_LIST, (Serializable) list);
        bundle.putSerializable(IMPictureConfig.EXTRA_SELECT_LIST, (Serializable) list2);
        bundle.putBoolean(IMPictureConfig.EXTRA_BOTTOM_PREVIEW, z);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.activity_im_picture_gallery_preview);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.f9005n = new Handler();
        this.f9004m = IMScreenUtil.instance(this).getScreenWidth();
        Animation loadAnimation = IMOptAnimationLoader.loadAnimation(this, R.anim.im_picture_modal_in);
        this.f9001j = loadAnimation;
        loadAnimation.setAnimationListener(this);
        this.f8992a = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.f8993b = (TextView) findViewById(R.id.tv_preview_select);
        this.f8994c = (IMViewPager) findViewById(R.id.preview_pager);
        this.f8995d = (FrameLayout) findViewById(R.id.fl_bottom_bar);
        this.f8996e = (TextView) findViewById(R.id.tv_send_image);
        this.f8992a.setOnClickListener(this);
        this.f8996e.setOnClickListener(this);
        this.f8997f = getIntent().getIntExtra("position", 0);
        this.f8999h = (List) getIntent().getSerializableExtra(IMPictureConfig.EXTRA_SELECT_LIST);
        if (getIntent().getBooleanExtra(IMPictureConfig.EXTRA_BOTTOM_PREVIEW, false)) {
            this.f8998g = (List) getIntent().getSerializableExtra(IMPictureConfig.EXTRA_PREVIEW_SELECT_LIST);
        } else {
            this.f8998g = IMMediaObservable.getInstance().readLocalMedias();
        }
        m6107c();
        this.f8993b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                if (IMPictureGalleryPreviewActivity.this.f8998g != null && IMPictureGalleryPreviewActivity.this.f8998g.size() > 0) {
                    IMLocalMedia iMLocalMedia = (IMLocalMedia) IMPictureGalleryPreviewActivity.this.f8998g.get(IMPictureGalleryPreviewActivity.this.f8994c.getCurrentItem());
                    if (!IMPictureGalleryPreviewActivity.this.f8993b.isSelected()) {
                        IMPictureGalleryPreviewActivity.this.f8993b.setSelected(true);
                        IMPictureGalleryPreviewActivity.this.f8993b.startAnimation(IMPictureGalleryPreviewActivity.this.f9001j);
                        z = true;
                    } else {
                        IMPictureGalleryPreviewActivity.this.f8993b.setSelected(false);
                        z = false;
                    }
                    if (IMPictureGalleryPreviewActivity.this.f8999h.size() < IMPictureGalleryPreviewActivity.this.config.maxSelectNum || !z) {
                        if (!z) {
                            Iterator it = IMPictureGalleryPreviewActivity.this.f8999h.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                IMLocalMedia iMLocalMedia2 = (IMLocalMedia) it.next();
                                if (iMLocalMedia2.getPath().equals(iMLocalMedia.getPath())) {
                                    IMPictureGalleryPreviewActivity.this.f8999h.remove(iMLocalMedia2);
                                    IMPictureGalleryPreviewActivity.this.m6109d();
                                    IMPictureGalleryPreviewActivity.this.m6100a(iMLocalMedia2);
                                    break;
                                }
                            }
                        } else {
                            if (IMPictureGalleryPreviewActivity.this.config.selectionMode == 1) {
                                IMPictureGalleryPreviewActivity.this.m6105b();
                            }
                            IMPictureGalleryPreviewActivity.this.f8999h.add(iMLocalMedia);
                            iMLocalMedia.setNum(IMPictureGalleryPreviewActivity.this.f8999h.size());
                            IMPictureGalleryPreviewActivity.this.f8993b.setText(String.valueOf(iMLocalMedia.getNum()));
                        }
                        IMPictureGalleryPreviewActivity.this.onSelectNumChange(true);
                        return;
                    }
                    Context context = IMPictureGalleryPreviewActivity.this.mContext;
                    IMPictureGalleryPreviewActivity iMPictureGalleryPreviewActivity = IMPictureGalleryPreviewActivity.this;
                    SystemUtils.showToast(IMTipsToast.makeText(context, (CharSequence) iMPictureGalleryPreviewActivity.getString(R.string.im_picture_message_max_num, new Object[]{Integer.valueOf(iMPictureGalleryPreviewActivity.config.maxSelectNum)}), 0));
                    IMPictureGalleryPreviewActivity.this.f8993b.setSelected(false);
                }
            }
        });
        this.f8994c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                IMPictureGalleryPreviewActivity iMPictureGalleryPreviewActivity = IMPictureGalleryPreviewActivity.this;
                iMPictureGalleryPreviewActivity.m6102a(iMPictureGalleryPreviewActivity.config.previewEggs, i, i2);
            }

            public void onPageSelected(int i) {
                int unused = IMPictureGalleryPreviewActivity.this.f8997f = i;
                IMLocalMedia iMLocalMedia = (IMLocalMedia) IMPictureGalleryPreviewActivity.this.f8998g.get(IMPictureGalleryPreviewActivity.this.f8997f);
                int unused2 = IMPictureGalleryPreviewActivity.this.f9003l = iMLocalMedia.getPosition();
                if (!IMPictureGalleryPreviewActivity.this.config.previewEggs) {
                    TextView c = IMPictureGalleryPreviewActivity.this.f8993b;
                    c.setText(iMLocalMedia.getNum() + "");
                    IMPictureGalleryPreviewActivity.this.m6100a(iMLocalMedia);
                    IMPictureGalleryPreviewActivity iMPictureGalleryPreviewActivity = IMPictureGalleryPreviewActivity.this;
                    iMPictureGalleryPreviewActivity.onImageChecked(iMPictureGalleryPreviewActivity.f8997f);
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(IMEventEntity iMEventEntity) {
        if (iMEventEntity.what == 2770) {
            this.f9005n.postDelayed(new Runnable() {
                public void run() {
                    IMPictureGalleryPreviewActivity.this.onBackPressed();
                }
            }, 150);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6102a(boolean z, int i, int i2) {
        List<IMLocalMedia> list;
        if (z && this.f8998g.size() > 0 && (list = this.f8998g) != null) {
            if (i2 < this.f9004m / 2) {
                IMLocalMedia iMLocalMedia = list.get(i);
                this.f8993b.setSelected(isSelected(iMLocalMedia));
                int num = iMLocalMedia.getNum();
                TextView textView = this.f8993b;
                textView.setText(num + "");
                m6100a(iMLocalMedia);
                onImageChecked(i);
                return;
            }
            int i3 = i + 1;
            IMLocalMedia iMLocalMedia2 = list.get(i3);
            this.f8993b.setSelected(isSelected(iMLocalMedia2));
            int num2 = iMLocalMedia2.getNum();
            TextView textView2 = this.f8993b;
            textView2.setText(num2 + "");
            m6100a(iMLocalMedia2);
            onImageChecked(i3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6105b() {
        List<IMLocalMedia> list = this.f8999h;
        if (list != null && list.size() > 0) {
            EventBus.getDefault().post(new IMEventEntity(2774, this.f8999h.get(0).getPosition(), this.f8999h));
            this.f8999h.clear();
        }
    }

    /* renamed from: c */
    private void m6107c() {
        IMPicturePreviewFragmentAdapter iMPicturePreviewFragmentAdapter = new IMPicturePreviewFragmentAdapter(this.f8998g, this, this);
        this.f9000i = iMPicturePreviewFragmentAdapter;
        this.f8994c.setAdapter(iMPicturePreviewFragmentAdapter);
        this.f8994c.setCurrentItem(this.f8997f);
        onSelectNumChange(false);
        onImageChecked(this.f8997f);
        if (this.f8998g.size() > 0) {
            IMLocalMedia iMLocalMedia = this.f8998g.get(this.f8997f);
            this.f9003l = iMLocalMedia.getPosition();
            TextView textView = this.f8993b;
            textView.setText(iMLocalMedia.getNum() + "");
            m6100a(iMLocalMedia);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6100a(IMLocalMedia iMLocalMedia) {
        this.f8993b.setText("");
        for (IMLocalMedia next : this.f8999h) {
            if (next.getPath().equals(iMLocalMedia.getPath())) {
                iMLocalMedia.setNum(next.getNum());
                this.f8993b.setText(String.valueOf(iMLocalMedia.getNum()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6109d() {
        int size = this.f8999h.size();
        int i = 0;
        while (i < size) {
            i++;
            this.f8999h.get(i).setNum(i);
        }
    }

    public void onImageChecked(int i) {
        List<IMLocalMedia> list = this.f8998g;
        if (list == null || list.size() <= 0) {
            this.f8993b.setSelected(false);
        } else {
            this.f8993b.setSelected(isSelected(this.f8998g.get(i)));
        }
    }

    public boolean isSelected(IMLocalMedia iMLocalMedia) {
        for (IMLocalMedia path : this.f8999h) {
            if (path.getPath().equals(iMLocalMedia.getPath())) {
                return true;
            }
        }
        return false;
    }

    public void onSelectNumChange(boolean z) {
        this.f9002k = z;
        if (this.f8999h.size() > 0) {
            this.f8996e.setEnabled(true);
            this.f8996e.setAlpha(1.0f);
            this.f8996e.setText(String.format(getString(R.string.im_picture_send_with_count), new Object[]{Integer.valueOf(this.f8999h.size())}));
        } else {
            this.f8996e.setEnabled(false);
            this.f8996e.setText(String.format(getString(R.string.im_picture_send), new Object[0]));
            this.f8996e.setAlpha(0.5f);
        }
        m6101a(this.f9002k);
    }

    /* renamed from: a */
    private void m6101a(boolean z) {
        if (z) {
            EventBus.getDefault().post(new IMEventEntity(2774, this.f9003l, this.f8999h));
        }
    }

    public void onAnimationEnd(Animation animation) {
        m6101a(this.f9002k);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.common_title_bar_left_img) {
            onBackPressed();
        }
        if (id == R.id.tv_send_image) {
            int size = this.f8999h.size();
            if (this.f8999h.size() > 0) {
                IMLocalMedia iMLocalMedia = this.f8999h.get(0);
            }
            if (this.config.minSelectNum <= 0 || size >= this.config.minSelectNum || this.config.selectionMode != 2) {
                onResult(this.f8999h);
                return;
            }
            SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.im_picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}), 0));
        }
    }

    public void onResult(List<IMLocalMedia> list) {
        EventBus.getDefault().post(new IMEventEntity(2771, list));
        if (!this.config.isCompress) {
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        Handler handler = this.f9005n;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f9005n = null;
        }
        Animation animation = this.f9001j;
        if (animation != null) {
            animation.cancel();
            this.f9001j = null;
        }
    }

    public void onActivityBackPressed() {
        onBackPressed();
    }
}
