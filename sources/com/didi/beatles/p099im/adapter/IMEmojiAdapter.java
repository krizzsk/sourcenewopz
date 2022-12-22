package com.didi.beatles.p099im.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.data.IMInnerData;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.beatles.p099im.views.imageView.IMNetworkImageView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.adapter.IMEmojiAdapter */
public class IMEmojiAdapter extends RecyclerView.Adapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<IMEmojiModule> f9055a;

    /* renamed from: b */
    private Context f9056b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMEmojiViewOnClickListener f9057c;

    /* renamed from: d */
    private int f9058d;

    /* renamed from: com.didi.beatles.im.adapter.IMEmojiAdapter$IMEmojiViewOnClickListener */
    public interface IMEmojiViewOnClickListener {
        void onClick(String str, String str2, String str3);
    }

    public IMEmojiAdapter(Context context, int i, List<IMEmojiModule> list, IMEmojiViewOnClickListener iMEmojiViewOnClickListener) {
        this.f9055a = list;
        this.f9056b = context;
        this.f9057c = iMEmojiViewOnClickListener;
        this.f9058d = i;
    }

    public void changeEmojiList(List<IMEmojiModule> list) {
        if (list != null) {
            this.f9055a = list;
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new EmojiViewHolder(LayoutInflater.from(this.f9056b).inflate(R.layout.im_emoji_item, (ViewGroup) null));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        List<IMEmojiModule> list;
        if (viewHolder != null && (list = this.f9055a) != null) {
            EmojiViewHolder emojiViewHolder = (EmojiViewHolder) viewHolder;
            String str = list.get(i).host;
            if (TextUtils.isEmpty(str)) {
                str = IMInnerData.getInstance().getEmojiPrefix();
            }
            IMNetworkImageView iMNetworkImageView = emojiViewHolder.imageView;
            iMNetworkImageView.loadImageUrl(str + this.f9055a.get(i).picName + IMPictureMimeType.PNG, R.drawable.bts_im_widget_progress_rotate);
            ViewGroup.LayoutParams layoutParams = emojiViewHolder.content.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.f9058d;
                emojiViewHolder.content.setLayoutParams(layoutParams);
            }
            emojiViewHolder.descTv.setText(this.f9055a.get(i).desc);
            emojiViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMEmojiAdapter.this.f9057c != null) {
                        IMEmojiAdapter.this.f9057c.onClick(((IMEmojiModule) IMEmojiAdapter.this.f9055a.get(i)).emojiId, ((IMEmojiModule) IMEmojiAdapter.this.f9055a.get(i)).picName, ((IMEmojiModule) IMEmojiAdapter.this.f9055a.get(i)).desc);
                    }
                }
            });
        }
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public int getItemCount() {
        List<IMEmojiModule> list = this.f9055a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: com.didi.beatles.im.adapter.IMEmojiAdapter$EmojiViewHolder */
    private class EmojiViewHolder extends RecyclerView.ViewHolder {
        LinearLayout content;
        TextView descTv;
        IMNetworkImageView imageView;

        EmojiViewHolder(View view) {
            super(view);
            this.imageView = (IMNetworkImageView) view.findViewById(R.id.im_emoji_item_iv);
            this.descTv = (TextView) view.findViewById(R.id.im_emoji_item_tv);
            this.content = (LinearLayout) view.findViewById(R.id.im_emoji_item_content);
        }
    }
}
