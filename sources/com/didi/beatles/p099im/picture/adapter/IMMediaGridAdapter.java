package com.didi.beatles.p099im.picture.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.picture.anim.IMOptAnimationLoader;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.beatles.p099im.picture.config.IMPictureSelectionConfig;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.Animator;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.utils.imageloader.IMImageRequestOptions;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter */
public class IMMediaGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private static final int f9360a = 450;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f9361b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f9362c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnMediaSelectChangedListener f9363d;

    /* renamed from: e */
    private int f9364e;

    /* renamed from: f */
    private List<IMLocalMedia> f9365f = new ArrayList();

    /* renamed from: g */
    private List<IMLocalMedia> f9366g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f9367h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f9368i = 2;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9369j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f9370k = false;

    /* renamed from: l */
    private boolean f9371l;

    /* renamed from: m */
    private int f9372m;

    /* renamed from: n */
    private int f9373n;

    /* renamed from: o */
    private float f9374o;

    /* renamed from: p */
    private Animation f9375p;

    /* renamed from: q */
    private IMPictureSelectionConfig f9376q;

    /* renamed from: r */
    private int f9377r;

    /* renamed from: s */
    private boolean f9378s;

    /* renamed from: t */
    private boolean f9379t;

    /* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter$OnMediaSelectChangedListener */
    public interface OnMediaSelectChangedListener {
        void onMediaPreviewClick(IMLocalMedia iMLocalMedia, int i);

        void onMediaSelectChange(List<IMLocalMedia> list);

        void onTakePhoto();
    }

    public IMMediaGridAdapter(Context context, IMPictureSelectionConfig iMPictureSelectionConfig) {
        this.f9361b = context;
        this.f9376q = iMPictureSelectionConfig;
        this.f9368i = iMPictureSelectionConfig.selectionMode;
        this.f9362c = iMPictureSelectionConfig.showCameraInGallery;
        this.f9364e = iMPictureSelectionConfig.maxSelectNum;
        this.f9367h = iMPictureSelectionConfig.enablePreview;
        this.f9369j = iMPictureSelectionConfig.enPreviewVideo;
        this.f9370k = iMPictureSelectionConfig.enablePreviewAudio;
        this.f9371l = iMPictureSelectionConfig.enableSelectOverlay;
        this.f9372m = iMPictureSelectionConfig.overrideWidth;
        this.f9373n = iMPictureSelectionConfig.overrideHeight;
        this.f9374o = iMPictureSelectionConfig.sizeMultiplier;
        this.f9377r = iMPictureSelectionConfig.mimeType;
        this.f9378s = iMPictureSelectionConfig.zoomAnim;
        this.f9375p = IMOptAnimationLoader.loadAnimation(context, R.anim.im_picture_modal_in);
    }

    public void setShowCamera(boolean z) {
        this.f9362c = z;
    }

    public void bindImagesData(List<IMLocalMedia> list) {
        this.f9365f = list;
        notifyDataSetChanged();
    }

    public void bindSelectImages(List<IMLocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        for (IMLocalMedia add : list) {
            arrayList.add(add);
        }
        this.f9366g = arrayList;
        m6365b();
        OnMediaSelectChangedListener onMediaSelectChangedListener = this.f9363d;
        if (onMediaSelectChangedListener != null) {
            onMediaSelectChangedListener.onMediaSelectChange(this.f9366g);
        }
    }

    public List<IMLocalMedia> getSelectedImages() {
        if (this.f9366g == null) {
            this.f9366g = new ArrayList();
        }
        return this.f9366g;
    }

    public List<IMLocalMedia> getImages() {
        if (this.f9365f == null) {
            this.f9365f = new ArrayList();
        }
        return this.f9365f;
    }

    public int getItemViewType(int i) {
        return (!this.f9362c || i != 0) ? 2 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new CameraViewHolder(LayoutInflater.from(this.f9361b).inflate(R.layout.im_picture_camera_item_view, viewGroup, false));
        }
        return new ImageViewHolder(LayoutInflater.from(this.f9361b).inflate(R.layout.im_picture_image_item_view, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = i;
        if (getItemViewType(i2) == 1) {
            ((CameraViewHolder) viewHolder).headerView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMMediaGridAdapter.this.f9363d != null) {
                        IMMediaGridAdapter.this.f9363d.onTakePhoto();
                    }
                }
            });
            return;
        }
        ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
        IMLocalMedia iMLocalMedia = this.f9365f.get(this.f9362c ? i2 - 1 : i2);
        iMLocalMedia.position = imageViewHolder.getAdapterPosition();
        String path = iMLocalMedia.getPath();
        String pictureType = iMLocalMedia.getPictureType();
        m6362a(imageViewHolder, iMLocalMedia);
        selectImage(imageViewHolder, isSelected(iMLocalMedia), false);
        int isPictureType = IMPictureMimeType.isPictureType(pictureType);
        boolean isGif = IMPictureMimeType.isGif(pictureType);
        boolean isLongImg = IMPictureMimeType.isLongImg(iMLocalMedia);
        if (isGif) {
            IMViewUtil.show((View) imageViewHolder.tvImageTag);
            imageViewHolder.tvImageTag.setText(this.f9361b.getResources().getString(R.string.im_picture_gif_tag));
        } else if (isLongImg) {
            IMViewUtil.show((View) imageViewHolder.tvImageTag);
            imageViewHolder.tvImageTag.setText(this.f9361b.getResources().getString(R.string.im_picture_long_chart));
        } else {
            IMViewUtil.hide((View) imageViewHolder.tvImageTag);
            imageViewHolder.tvImageTag.setText("");
        }
        IMImageRequestOptions placeholder = new IMImageRequestOptions().diskCacheStrategy(IMImageRequestOptions.DiskCacheStrategy.ALL).centerCrop().placeholder(R.drawable.im_bg_picture_image);
        if (this.f9372m > 0 || this.f9373n > 0) {
            placeholder.override(this.f9372m, this.f9373n);
        } else {
            placeholder.sizeMultiplier(this.f9374o);
        }
        BtsImageLoader.getInstance().loadInto(path, imageViewHolder.ivImage, (Animator) null, placeholder, (Callback) null);
        if (this.f9367h || this.f9369j || this.f9370k) {
            final String str = path;
            final int i3 = isPictureType;
            final ImageViewHolder imageViewHolder2 = imageViewHolder;
            final IMLocalMedia iMLocalMedia2 = iMLocalMedia;
            imageViewHolder.viewSelectMask.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!IMPictureFileUtils.isFileExists(IMMediaGridAdapter.this.f9361b, str)) {
                        SystemUtils.showToast(IMTipsToast.makeText(IMMediaGridAdapter.this.f9361b, (CharSequence) IMPictureMimeType.m6378s(IMMediaGridAdapter.this.f9361b, i3), 0));
                    } else {
                        IMMediaGridAdapter.this.m6367b(imageViewHolder2, iMLocalMedia2);
                    }
                }
            });
        }
        final String str2 = path;
        final int i4 = isPictureType;
        final int i5 = i;
        final IMLocalMedia iMLocalMedia3 = iMLocalMedia;
        final ImageViewHolder imageViewHolder3 = imageViewHolder;
        imageViewHolder.contentView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                if (!IMPictureFileUtils.isFileExists(IMMediaGridAdapter.this.f9361b, str2)) {
                    SystemUtils.showToast(IMTipsToast.makeText(IMMediaGridAdapter.this.f9361b, (CharSequence) IMPictureMimeType.m6378s(IMMediaGridAdapter.this.f9361b, i4), 0));
                    return;
                }
                int i = IMMediaGridAdapter.this.f9362c ? i5 - 1 : i5;
                if ((i4 == 1 && IMMediaGridAdapter.this.f9367h) || ((i4 == 2 && (IMMediaGridAdapter.this.f9369j || IMMediaGridAdapter.this.f9368i == 1)) || (i4 == 3 && (IMMediaGridAdapter.this.f9370k || IMMediaGridAdapter.this.f9368i == 1)))) {
                    z = true;
                }
                if (z) {
                    IMMediaGridAdapter.this.f9363d.onMediaPreviewClick(iMLocalMedia3, i);
                } else {
                    IMMediaGridAdapter.this.m6367b(imageViewHolder3, iMLocalMedia3);
                }
            }
        });
    }

    public int getItemCount() {
        return this.f9362c ? this.f9365f.size() + 1 : this.f9365f.size();
    }

    /* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter$CameraViewHolder */
    public class CameraViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public View headerView;
        private TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            this.headerView = view;
            TextView textView = (TextView) view.findViewById(R.id.picture_item_tv_camera);
            this.tvCamera = textView;
            textView.setText(IMMediaGridAdapter.this.f9361b.getString(R.string.im_picture_take_picture));
        }
    }

    /* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter$ImageViewHolder */
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public View contentView;
        /* access modifiers changed from: private */
        public ImageView ivImage;
        /* access modifiers changed from: private */
        public TextView tvImageTag;
        /* access modifiers changed from: private */
        public TextView tvSelect;
        /* access modifiers changed from: private */
        public View viewSelectMask;

        public ImageViewHolder(View view) {
            super(view);
            this.contentView = view;
            this.ivImage = (ImageView) view.findViewById(R.id.iv_image);
            this.viewSelectMask = view.findViewById(R.id.view_select_mask);
            this.tvSelect = (TextView) view.findViewById(R.id.tv_select);
            this.tvImageTag = (TextView) view.findViewById(R.id.tv_image_tag);
        }
    }

    public boolean isSelected(IMLocalMedia iMLocalMedia) {
        for (IMLocalMedia path : this.f9366g) {
            if (path.getPath().equals(iMLocalMedia.getPath())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m6362a(ImageViewHolder imageViewHolder, IMLocalMedia iMLocalMedia) {
        imageViewHolder.tvSelect.setText("");
        for (IMLocalMedia next : this.f9366g) {
            if (next.getPath().equals(iMLocalMedia.getPath())) {
                iMLocalMedia.setNum(next.getNum());
                next.setPosition(iMLocalMedia.getPosition());
                imageViewHolder.tvSelect.setText(String.valueOf(iMLocalMedia.getNum()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6367b(ImageViewHolder imageViewHolder, IMLocalMedia iMLocalMedia) {
        boolean isSelected = imageViewHolder.tvSelect.isSelected();
        int size = this.f9366g.size();
        int i = this.f9364e;
        if (size < i || isSelected) {
            if (isSelected) {
                Iterator<IMLocalMedia> it = this.f9366g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IMLocalMedia next = it.next();
                    if (next.getPath().equals(iMLocalMedia.getPath())) {
                        this.f9366g.remove(next);
                        m6365b();
                        m6366b(imageViewHolder.ivImage);
                        break;
                    }
                }
            } else {
                if (this.f9368i == 1) {
                    m6360a();
                }
                this.f9366g.add(iMLocalMedia);
                iMLocalMedia.setNum(this.f9366g.size());
                m6361a(imageViewHolder.ivImage);
            }
            notifyItemChanged(imageViewHolder.getAdapterPosition());
            selectImage(imageViewHolder, !isSelected, true);
            OnMediaSelectChangedListener onMediaSelectChangedListener = this.f9363d;
            if (onMediaSelectChangedListener != null) {
                onMediaSelectChangedListener.onMediaSelectChange(this.f9366g);
                return;
            }
            return;
        }
        Context context = this.f9361b;
        SystemUtils.showToast(IMTipsToast.makeText(context, (CharSequence) context.getString(R.string.im_picture_message_max_num, new Object[]{Integer.valueOf(i)}), 0));
    }

    /* renamed from: a */
    private void m6360a() {
        List<IMLocalMedia> list = this.f9366g;
        if (list != null && list.size() > 0) {
            this.f9379t = true;
            int i = 0;
            IMLocalMedia iMLocalMedia = this.f9366g.get(0);
            if (this.f9376q.showCameraInGallery || this.f9379t) {
                i = iMLocalMedia.position;
            } else if (iMLocalMedia.position > 0) {
                i = iMLocalMedia.position - 1;
            }
            notifyItemChanged(i);
            this.f9366g.clear();
        }
    }

    /* renamed from: b */
    private void m6365b() {
        int size = this.f9366g.size();
        int i = 0;
        while (i < size) {
            IMLocalMedia iMLocalMedia = this.f9366g.get(i);
            i++;
            iMLocalMedia.setNum(i);
            notifyItemChanged(iMLocalMedia.position);
        }
    }

    public void selectImage(ImageViewHolder imageViewHolder, boolean z, boolean z2) {
        imageViewHolder.tvSelect.setSelected(z);
        if (z2 && z && this.f9375p != null) {
            imageViewHolder.tvSelect.startAnimation(this.f9375p);
        }
        if (!this.f9371l) {
            return;
        }
        if (z) {
            imageViewHolder.ivImage.setColorFilter(ContextCompat.getColor(this.f9361b, R.color.im_picture_image_selected_overlay), PorterDuff.Mode.SRC_ATOP);
        } else {
            imageViewHolder.ivImage.clearColorFilter();
        }
    }

    public void setOnMediaSelectChangedListener(OnMediaSelectChangedListener onMediaSelectChangedListener) {
        this.f9363d = onMediaSelectChangedListener;
    }

    /* renamed from: a */
    private void m6361a(ImageView imageView) {
        if (this.f9378s) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new android.animation.Animator[]{ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 1.12f}), ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 1.12f})});
            animatorSet.setDuration(450);
            animatorSet.start();
        }
    }

    /* renamed from: b */
    private void m6366b(ImageView imageView) {
        if (this.f9378s) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new android.animation.Animator[]{ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.12f, 1.0f}), ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.12f, 1.0f})});
            animatorSet.setDuration(450);
            animatorSet.start();
        }
    }
}
