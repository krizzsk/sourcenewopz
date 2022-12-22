package com.didi.component.common.dialog;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.common.util.ImageFetcherUtil;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class ImageHintDialog implements IDialog {

    /* renamed from: a */
    private final int f11559a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f11560b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialogFragment f11561c;

    /* renamed from: d */
    private boolean f11562d;

    public boolean cancelable() {
        return false;
    }

    private ImageHintDialog(int i) {
        this.f11559a = i;
    }

    public int getId() {
        return this.f11559a;
    }

    public void show() {
        this.f11562d = true;
        this.f11560b.getNavigation().showDialog(this.f11561c);
    }

    public boolean isShowing() {
        return this.f11562d;
    }

    public void dismiss() {
        this.f11560b.getNavigation().dismissDialog(this.f11561c);
        this.f11562d = false;
    }

    public void update(DialogInfo dialogInfo) {
        m7839a((ImageHintDialogInfo) dialogInfo, this.f11561c.getView());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7839a(ImageHintDialogInfo imageHintDialogInfo, View view) {
        if (view != null) {
            final ImageView imageView = (ImageView) view.findViewById(R.id.dialog_top_image);
            if (imageHintDialogInfo.f11567e == 1) {
                imageView.setBackgroundResource(R.drawable.brazil_comp_image_holder_with_top_corners);
            } else if (imageHintDialogInfo.f11567e != -1) {
                imageView.setBackgroundResource(imageHintDialogInfo.f11567e);
            }
            ImageFetcherUtil.getInstance().fetchCallback(this.f11560b.getContext(), imageHintDialogInfo.f11563a, (ImageFetcherUtil.ImageLoadCallback) new ImageFetcherUtil.ImageLoadCallback() {
                public void onSuccess(Bitmap bitmap) {
                    if (bitmap != null) {
                        imageView.setBackgroundResource(0);
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
            ((TextView) view.findViewById(R.id.dialog_title)).setText(imageHintDialogInfo.f11564b);
            ((TextView) view.findViewById(R.id.dialog_subtitle)).setText(imageHintDialogInfo.f11565c);
        }
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private ImageHintDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(ImageHintDialogInfo imageHintDialogInfo) {
            this.mDialogInfo = imageHintDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public ImageHintDialog build() {
            ImageHintDialog imageHintDialog = new ImageHintDialog(this.mDialogInfo.dialogId);
            BusinessContext unused = imageHintDialog.f11560b = this.mBizCtx;
            View inflate = LayoutInflater.from(this.mBizCtx.getContext()).inflate(R.layout.comp_dialog_image_hint, (ViewGroup) null);
            AlertDialogFragment unused2 = imageHintDialog.f11561c = new AlertDialogFragment.Builder(this.mBizCtx.getContext()).setContentView(inflate).setPositiveButton((CharSequence) this.mDialogInfo.f11566d, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    DialogBuilder.this.mListener.onAction(4);
                }
            }).setPositiveButtonDefault().setCancelable(this.mDialogInfo.cancelable).create();
            imageHintDialog.m7839a(this.mDialogInfo, inflate);
            return imageHintDialog;
        }
    }
}
