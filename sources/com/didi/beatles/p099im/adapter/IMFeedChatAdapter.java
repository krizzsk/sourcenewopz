package com.didi.beatles.p099im.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.module.entity.IMFeedMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.views.feed.IMListChatHelperVHolder;
import com.didi.beatles.p099im.views.feed.IMListChatMsgVHolder;
import com.didi.beatles.p099im.views.feed.IMListChatVHolder;
import com.didi.beatles.p099im.views.feed.IMListFeedVHolder;
import com.didi.beatles.p099im.views.feed.IMListTopVHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.didi.beatles.im.adapter.IMFeedChatAdapter */
public class IMFeedChatAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private static final int f9059a = 1;

    /* renamed from: b */
    private static final int f9060b = 2;

    /* renamed from: c */
    private static final int f9061c = 3;

    /* renamed from: d */
    private static final int f9062d = 4;

    /* renamed from: e */
    private Activity f9063e;

    /* renamed from: f */
    private List<IMSession> f9064f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnViewCallback f9065g;

    /* renamed from: h */
    private boolean f9066h = false;

    /* renamed from: i */
    private boolean f9067i = false;

    /* renamed from: j */
    private boolean f9068j = false;

    /* renamed from: k */
    private int f9069k = 0;

    /* renamed from: l */
    private int f9070l = 0;

    /* renamed from: m */
    private int f9071m = -1;

    /* renamed from: n */
    private IMListFeedVHolder.FlagCallback<IMSession> f9072n = new IMListFeedVHolder.FlagCallback<IMSession>() {
        private Set<Long> set = new HashSet();

        public boolean isFlag(IMSession iMSession) {
            return this.set.contains(Long.valueOf(iMSession.getSessionId()));
        }

        public void addFlag(IMSession iMSession) {
            this.set.add(Long.valueOf(iMSession.getSessionId()));
        }

        public void removeFlag(IMSession iMSession) {
            this.set.remove(Long.valueOf(iMSession.getSessionId()));
        }

        public void clear() {
            this.set.clear();
        }
    };

    /* renamed from: o */
    private IMListFeedVHolder.FlagCallback<IMFeedMessage> f9073o = new IMListFeedVHolder.FlagCallback<IMFeedMessage>() {
        private Set<Long> set = new HashSet();

        public boolean isFlag(IMFeedMessage iMFeedMessage) {
            return this.set.contains(Long.valueOf(iMFeedMessage.mid));
        }

        public void addFlag(IMFeedMessage iMFeedMessage) {
            this.set.add(Long.valueOf(iMFeedMessage.mid));
        }

        public void removeFlag(IMFeedMessage iMFeedMessage) {
            this.set.remove(Long.valueOf(iMFeedMessage.mid));
        }

        public void clear() {
            this.set.clear();
        }
    };

    /* renamed from: com.didi.beatles.im.adapter.IMFeedChatAdapter$OnViewCallback */
    public static abstract class OnViewCallback {
        public void callAnimationFinish() {
        }

        public void callChangeList(boolean z) {
        }

        public void callChangeNotify(IMSession iMSession, boolean z) {
        }

        public void callClearUnRead() {
        }

        public void callClickMessage(IMFeedMessage iMFeedMessage, String str) {
        }

        public void callClickSession(IMSession iMSession) {
        }

        public void callDelSession(IMSession iMSession) {
        }
    }

    public IMFeedChatAdapter(Activity activity) {
        this.f9063e = activity;
    }

    public void setCallback(OnViewCallback onViewCallback) {
        this.f9065g = onViewCallback;
    }

    public void configShow(boolean z, boolean z2, boolean z3) {
        this.f9067i = z2;
        this.f9066h = z;
        this.f9068j = z3;
    }

    public void setUnReadCount(int i) {
        this.f9069k = i;
        if (this.f9067i) {
            notifyItemChanged(0);
        }
    }

    public void setData(List<IMSession> list) {
        this.f9072n.clear();
        this.f9073o.clear();
        this.f9070l = 0;
        this.f9071m = -1;
        if (list != null) {
            this.f9064f.clear();
            this.f9064f.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void updateData(IMSession iMSession) {
        int indexOf = this.f9064f.indexOf(iMSession);
        if (indexOf < 0) {
            this.f9064f.add(0, iMSession);
            notifyItemInserted(m6170b(0));
            return;
        }
        this.f9064f.remove(indexOf);
        this.f9064f.add(indexOf, iMSession);
        notifyItemChanged(m6170b(indexOf));
    }

    public void deleteData(IMSession iMSession) {
        int indexOf = this.f9064f.indexOf(iMSession);
        if (indexOf >= 0) {
            this.f9064f.remove(indexOf);
            notifyItemRemoved(m6170b(indexOf));
        }
    }

    public List<IMSession> getRecentShow() {
        int max = Math.max(m6168a(this.f9070l), 0);
        int a = m6168a(this.f9071m) + 1;
        if (max >= a) {
            return new ArrayList();
        }
        this.f9070l = this.f9071m + 1;
        return this.f9064f.subList(max, a);
    }

    public void doClearAnimation(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        C39621 r2 = new Interpolator() {
            private AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            private DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();

            public float getInterpolation(float f) {
                float f2;
                float f3;
                if (f <= 0.25f) {
                    f3 = 0.5f;
                    f2 = this.decelerateInterpolator.getInterpolation((0.25f - f) * 4.0f);
                } else {
                    f3 = 1.0f;
                    f2 = this.accelerateInterpolator.getInterpolation(((1.0f - f) * 4.0f) / 3.0f);
                }
                return f3 - (f2 / 2.0f);
            }
        };
        C39632 r3 = new IMListChatVHolder.AnimationCallback() {
            private boolean isCallback = false;

            public void finishAnimation() {
                if (!this.isCallback) {
                    this.isCallback = true;
                    if (IMFeedChatAdapter.this.f9065g != null) {
                        IMFeedChatAdapter.this.f9065g.callAnimationFinish();
                    }
                }
            }
        };
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
            if (findViewHolderForLayoutPosition instanceof IMListChatVHolder) {
                ((IMListChatVHolder) findViewHolderForLayoutPosition).clearAnimation(r2, r3);
            }
        }
    }

    public int getItemCount() {
        return this.f9064f.size() + ((this.f9067i || this.f9068j) ? 1 : 0);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new IMListChatHelperVHolder(this.f9063e, viewGroup);
        }
        if (i == 2) {
            return new IMListChatMsgVHolder(this.f9063e, viewGroup);
        }
        if (i == 3) {
            return new IMListFeedVHolder(this.f9063e, viewGroup, this.f9072n, this.f9073o);
        }
        if (i != 4) {
            return null;
        }
        return new IMListTopVHolder(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int a = m6168a(i);
        if (viewHolder instanceof IMListTopVHolder) {
            ((IMListTopVHolder) viewHolder).bindData(this.f9068j, this.f9066h, this.f9067i, this.f9069k, new IMListTopVHolder.ClearListener() {
                public void clearMsg(View view) {
                    if (IMFeedChatAdapter.this.f9065g != null) {
                        IMFeedChatAdapter.this.f9065g.callClearUnRead();
                    }
                }

                public void changeFeed(boolean z) {
                    if (IMFeedChatAdapter.this.f9065g != null) {
                        IMFeedChatAdapter.this.f9065g.callChangeList(z);
                    }
                }
            });
        } else if (viewHolder instanceof IMListFeedVHolder) {
            ((IMListFeedVHolder) viewHolder).bindData(this.f9064f.get(m6168a(i)), new IMListFeedVHolder.FeedListener() {
                public void clickSession(IMSession iMSession) {
                    if (IMFeedChatAdapter.this.f9065g != null) {
                        IMFeedChatAdapter.this.f9065g.callClickSession(iMSession);
                    }
                }

                public void clickMessage(IMFeedMessage iMFeedMessage, String str) {
                    if (IMFeedChatAdapter.this.f9065g != null) {
                        IMFeedChatAdapter.this.f9065g.callClickMessage(iMFeedMessage, str);
                    }
                }
            });
        } else {
            boolean z = false;
            if (viewHolder instanceof IMListChatHelperVHolder) {
                IMListChatHelperVHolder iMListChatHelperVHolder = (IMListChatHelperVHolder) viewHolder;
                IMSession iMSession = this.f9064f.get(m6168a(i));
                if (i == getItemCount() - 1) {
                    z = true;
                }
                iMListChatHelperVHolder.bindData(iMSession, a, z, (IMListChatHelperVHolder.ChatHelperListener) new IMListChatHelperVHolder.ChatHelperListener() {
                    public void deleteHelper(View view, IMSession iMSession) {
                        if (IMFeedChatAdapter.this.f9065g != null) {
                            IMFeedChatAdapter.this.f9065g.callDelSession(iMSession);
                        }
                    }

                    public void openNotify(View view, IMSession iMSession, boolean z) {
                        if (IMFeedChatAdapter.this.f9065g != null) {
                            IMFeedChatAdapter.this.f9065g.callChangeNotify(iMSession, z);
                        }
                    }

                    public void onClick(View view, IMSession iMSession) {
                        if (IMFeedChatAdapter.this.f9065g != null) {
                            IMFeedChatAdapter.this.f9065g.callClickSession(iMSession);
                        }
                    }
                });
            } else if (viewHolder instanceof IMListChatMsgVHolder) {
                IMListChatMsgVHolder iMListChatMsgVHolder = (IMListChatMsgVHolder) viewHolder;
                IMSession iMSession2 = this.f9064f.get(m6168a(i));
                if (i == getItemCount() - 1) {
                    z = true;
                }
                iMListChatMsgVHolder.bindData(iMSession2, a, z, (IMListChatMsgVHolder.ChatMsgListener) new IMListChatMsgVHolder.ChatMsgListener() {
                    public void deleteMsg(View view, IMSession iMSession) {
                        if (IMFeedChatAdapter.this.f9065g != null) {
                            IMFeedChatAdapter.this.f9065g.callDelSession(iMSession);
                        }
                    }

                    public void onClick(View view, IMSession iMSession) {
                        if (IMFeedChatAdapter.this.f9065g != null) {
                            IMFeedChatAdapter.this.f9065g.callClickSession(iMSession);
                        }
                    }
                });
            }
        }
    }

    public int getItemViewType(int i) {
        this.f9071m = Math.max(this.f9071m, i);
        if ((this.f9067i || this.f9068j) && i == 0) {
            return 4;
        }
        if (this.f9064f.get(m6168a(i)).getType() == 4) {
            return this.f9066h ? 3 : 1;
        }
        return 2;
    }

    /* renamed from: a */
    private int m6168a(int i) {
        return i - ((this.f9067i || this.f9068j) ? 1 : 0);
    }

    /* renamed from: b */
    private int m6170b(int i) {
        return i + ((this.f9067i || this.f9068j) ? 1 : 0);
    }
}
