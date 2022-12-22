package com.didi.component.expectation.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.common.model.bubble.CommonBubbleItemModel;
import com.didi.component.common.util.GLog;
import com.didi.component.common.widget.CircleProgressBar;
import com.didi.component.expectation.AbsExpectationPresenter;
import com.didi.component.expectation.IExpectationView;
import com.didi.component.expectation.impl.WaitView;
import com.didi.component.expectation.impl.WebpLocResEnum;
import com.didi.component.expectation.impl.WebpResEnum;
import com.didi.component.expectation.model.AnyCarRequesting;
import com.didi.component.expectation.model.FlexRaise;
import com.didi.component.expectation.model.ProgressState;
import com.didi.component.expectation.view.animation.ExpectationCardAnimation;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.OnlineImageCacheManager;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.datasource.BubbleSourceManager;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.didiglobal.travel.infra.content.ContextKt;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Ú\u00012\u00020\u0001:\u0002Ú\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010t\u001a\u00020]2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020w\u0018\u00010vH\u0016J\b\u0010x\u001a\u00020]H\u0016J\b\u0010y\u001a\u00020]H\u0016J\u0012\u0010z\u001a\u00020]2\b\u0010{\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010|\u001a\u00020]2\u0006\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020,H\u0016J\b\u0010\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020]H\u0016J\t\u0010\u0001\u001a\u00020]H\u0016J\t\u0010\u0001\u001a\u00020]H\u0016J\t\u0010\u0001\u001a\u00020]H\u0016J\t\u0010\u0001\u001a\u00020]H\u0016J\b\u0010V\u001a\u00020WH\u0016J\u0012\u0010\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020,H\u0016J1\u0010\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020W2\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0003J\t\u0010\u0001\u001a\u00020]H\u0016J\u001b\u0010\u0001\u001a\u00020]2\u0010\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010vH\u0016J\u0014\u0010\u0001\u001a\u00020]2\t\u0010\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0014\u0010\u0001\u001a\u00020]2\t\u0010\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0019\u0010\u0001\u001a\u00020]2\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020]2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020]2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001b\u0010\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020,H\u0016J\u0017\u0010¡\u0001\u001a\u00020]2\f\u0010^\u001a\b\u0012\u0002\b\u0003\u0018\u00010_H\u0016J\u0013\u0010¢\u0001\u001a\u00020]2\b\u0010£\u0001\u001a\u00030¤\u0001H\u0016J\u0015\u0010¥\u0001\u001a\u00020]2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u0012\u0010¨\u0001\u001a\u00020]2\u0007\u0010©\u0001\u001a\u00020,H\u0016J\u0015\u0010ª\u0001\u001a\u00020]2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\u0014\u0010­\u0001\u001a\u00020]2\t\u0010«\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0014\u0010®\u0001\u001a\u00020]2\t\u0010¯\u0001\u001a\u0004\u0018\u00010@H\u0016J\u001f\u0010°\u0001\u001a\u00020]2\t\u0010«\u0001\u001a\u0004\u0018\u00010@2\t\u0010±\u0001\u001a\u0004\u0018\u00010@H\u0016J+\u0010²\u0001\u001a\u00020]2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010@2\t\u0010¶\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0015\u0010·\u0001\u001a\u00020]2\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u0015\u0010º\u0001\u001a\u00020]2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\u0013\u0010»\u0001\u001a\u00020]2\b\u0010¼\u0001\u001a\u00030¤\u0001H\u0016J%\u0010½\u0001\u001a\u00020]2\b\u0010¾\u0001\u001a\u00030¤\u00012\u0007\u0010¿\u0001\u001a\u00020w2\u0007\u0010À\u0001\u001a\u00020,H\u0016J;\u0010Á\u0001\u001a\u00020]2\b\u0010Â\u0001\u001a\u00030¤\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010Ã\u0001\u001a\u00020,2\u0007\u0010À\u0001\u001a\u00020,2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J\u0015\u0010Æ\u0001\u001a\u00020]2\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0016J\u0015\u0010É\u0001\u001a\u00020]2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0016J^\u0010Ì\u0001\u001a\u00020]2\t\u0010Í\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010Î\u0001\u001a\u00020,2\b\u0010Ï\u0001\u001a\u00030¤\u00012\b\u0010Ð\u0001\u001a\u00030¤\u00012\u0007\u0010Ñ\u0001\u001a\u00020,2\u0007\u0010Ò\u0001\u001a\u00020W2\u0007\u0010À\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020,H\u0016J\t\u0010Ó\u0001\u001a\u00020]H\u0016J\u0015\u0010Ô\u0001\u001a\u00020]2\n\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001H\u0016J1\u0010×\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020W2\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0017\u0010Ø\u0001\u001a\u0004\u0018\u00010,*\u0004\u0018\u00010@H\u0002¢\u0006\u0003\u0010Ù\u0001R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0014\u0010&\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!R\u0014\u0010(\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0015R\u0014\u00101\u001a\u0002028BX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u000eR\u0014\u00107\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010!R\u0014\u00109\u001a\u00020:8BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0014\u0010F\u001a\u00020G8BX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010!R\u0014\u0010L\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010!R\u0014\u0010N\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010!R\u0014\u0010P\u001a\u00020Q8BX\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010!R\u000e\u0010V\u001a\u00020WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020WX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010[\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\b\u0012\u0002\b\u0003\u0018\u00010_X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020a8BX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0014\u0010d\u001a\u00020a8BX\u0004¢\u0006\u0006\u001a\u0004\be\u0010cR\u0014\u0010f\u001a\u00020g8BX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010!R\u0014\u0010l\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bm\u0010!R\u0014\u0010n\u001a\u00020G8BX\u0004¢\u0006\u0006\u001a\u0004\bo\u0010IR\u0014\u0010p\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\bq\u0010!R\u0014\u0010r\u001a\u00020g8BX\u0004¢\u0006\u0006\u001a\u0004\bs\u0010i¨\u0006Û\u0001"}, mo175978d2 = {"Lcom/didi/component/expectation/view/ExpectationView2;", "Lcom/didi/component/expectation/IExpectationView;", "context", "Landroid/content/Context;", "container", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "_cardAnimation", "Lcom/didi/component/expectation/view/animation/ExpectationCardAnimation;", "_view", "Landroid/view/View;", "anyCarWaitingGif", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAnyCarWaitingGif", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "anyCarWaitingLayout", "getAnyCarWaitingLayout", "()Landroid/view/ViewGroup;", "anyCarWaitingProcessBar", "Lcom/didi/component/common/widget/CircleProgressBar;", "getAnyCarWaitingProcessBar", "()Lcom/didi/component/common/widget/CircleProgressBar;", "anyCarWaitingRequestingList", "Landroidx/recyclerview/widget/RecyclerView;", "getAnyCarWaitingRequestingList", "()Landroidx/recyclerview/widget/RecyclerView;", "anyCarWaitingRequestingTip", "Lcom/didi/component/expectation/view/AnyCarBubbleTipLayout;", "getAnyCarWaitingRequestingTip", "()Lcom/didi/component/expectation/view/AnyCarBubbleTipLayout;", "anyCarWaitingTime", "Landroid/widget/TextView;", "getAnyCarWaitingTime", "()Landroid/widget/TextView;", "anyCarWaitingTimeDes", "getAnyCarWaitingTimeDes", "anyCarWaitingTitle", "getAnyCarWaitingTitle", "captionText", "getCaptionText", "cardAnimation", "getCardAnimation", "()Lcom/didi/component/expectation/view/animation/ExpectationCardAnimation;", "cardBigHeight", "", "circleImgAnimatable", "Landroid/graphics/drawable/Animatable;", "circleProgressBar", "getCircleProgressBar", "circleProgressGroup", "Landroidx/constraintlayout/widget/Group;", "getCircleProgressGroup", "()Landroidx/constraintlayout/widget/Group;", "circleProgressImage", "getCircleProgressImage", "compensationText", "getCompensationText", "compensationWaitView", "Lcom/didi/component/expectation/impl/WaitView;", "getCompensationWaitView", "()Lcom/didi/component/expectation/impl/WaitView;", "getContext", "()Landroid/content/Context;", "driverWebpUrl", "", "equityBackplane", "getEquityBackplane", "()Landroid/view/View;", "equityGroup", "getEquityGroup", "equityImage", "Landroid/widget/ImageView;", "getEquityImage", "()Landroid/widget/ImageView;", "equityText", "getEquityText", "flex_btn", "getFlex_btn", "flex_price", "getFlex_price", "flex_raise_fare_layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getFlex_raise_fare_layout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "flex_title", "getFlex_title", "isAnimation", "", "isAnyCar", "isCollapse", "isShowSubtitle", "pendingUpdateAction", "Lkotlin/Function0;", "", "presenter", "Lcom/didi/component/expectation/AbsExpectationPresenter;", "spaceView1", "Landroid/widget/Space;", "getSpaceView1", "()Landroid/widget/Space;", "spaceView2", "getSpaceView2", "subtitleSwitcher", "Landroid/widget/TextSwitcher;", "getSubtitleSwitcher", "()Landroid/widget/TextSwitcher;", "timeText", "getTimeText", "timeTitleText", "getTimeTitleText", "tipsImage", "getTipsImage", "tipsText", "getTipsText", "titleSwitcher", "getTitleSwitcher", "addProgressNode", "nodeData", "", "Lcom/didi/component/expectation/model/ProgressState;", "cancelAnim", "cancelCircleAnim", "closeAnyCarTipComplete", "id", "finishProgressBar", "sort", "dur", "getView", "hideCaptionText", "hideRichSubtitle", "hideSubTitleText", "hideTime", "hideTips", "log", "msg", "openBoxAndShowCoupon", "discount", "performUpdateViewByIndriverWithAnimated", "small", "refresh", "duration", "", "callback", "Lcom/didi/component/business/xpanelnew/IXpCompRefresh$IXpCompRefreshCb;", "resetViewStatus", "setAnyCarRequestingList", "carRequestingList", "Lcom/didi/component/expectation/model/AnyCarRequesting;", "setCaptionText", "caption", "setEquityText", "s", "setIsAnyCar", "(Ljava/lang/Boolean;)V", "setMainIcon", "type", "Lcom/didi/component/expectation/impl/WebpLocResEnum;", "Lcom/didi/component/expectation/impl/WebpResEnum;", "setObtainedCouponViewVisibility", "waitedTime", "totalTime", "setPresenter", "setProgressBar", "cent", "", "setRichSubtitle", "globalRichInfo", "Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "setSceneVisibility", "sceneType", "setSubTitleText", "text", "", "setTime", "setTimeDes", "des", "setTimes", "timePreFix", "setTips", "info", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "rightIcon", "click", "setTipsBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setTitleText", "setTranslationX", "translationX", "setWaitProgressBar", "currentPercent", "state", "index", "shakeGiftBox", "angle", "count", "listener", "Landroid/animation/Animator$AnimatorListener;", "showAnyCarRequestTip", "bubbleModel", "Lcom/didi/component/common/model/bubble/CommonBubbleItemModel;", "showEquityUI", "data", "Lcom/didi/component/expectation/model/UsePrivilege;", "showThumb", "urlOrLocalFileName", "progressIconType", "startProgress", "endProgress", "interval", "isAlreadyWait", "startCircleAnim", "updateFlex", "flexRaise", "Lcom/didi/component/expectation/model/FlexRaise;", "updateViewByIndriver", "colorOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "Companion", "comp-expectation_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationView2.kt */
public final class ExpectationView2 implements IExpectationView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: l */
    private static final String f13684l = "ExpectationViewV2";

    /* renamed from: m */
    private static final int f13685m = 2;

    /* renamed from: n */
    private static final int f13686n = 105;

    /* renamed from: a */
    private boolean f13687a;

    /* renamed from: b */
    private String f13688b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Animatable f13689c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsExpectationPresenter<?> f13690d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13691e;

    /* renamed from: f */
    private boolean f13692f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f13693g;

    /* renamed from: h */
    private int f13694h = 245;

    /* renamed from: i */
    private View f13695i;

    /* renamed from: j */
    private volatile ExpectationCardAnimation f13696j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Function0<Unit> f13697k;

    public ExpectationView2(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_expectation_card_v2_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…layout, container, false)");
        this.f13695i = inflate;
        m9439k().setFactory(new ViewSwitcher.ViewFactory(this) {
            final /* synthetic */ ExpectationView2 this$0;

            {
                this.this$0 = r1;
            }

            public final View makeView() {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.this$0.m9426a());
                appCompatTextView.setMaxLines(2);
                appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                appCompatTextView.setGravity(17);
                appCompatTextView.setTextColor(-16777216);
                appCompatTextView.setTextSize(1, 16.0f);
                appCompatTextView.getPaint().setFakeBoldText(true);
                return appCompatTextView;
            }
        });
        m9440l().setFactory(new ViewSwitcher.ViewFactory(this) {
            final /* synthetic */ ExpectationView2 this$0;

            {
                this.this$0 = r1;
            }

            public final View makeView() {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.this$0.m9426a());
                appCompatTextView.setMaxLines(2);
                appCompatTextView.setGravity(17);
                appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                appCompatTextView.setTextColor(-16777216);
                appCompatTextView.setTextSize(1, 12.0f);
                return appCompatTextView;
            }
        });
        CircleProgressBar n = m9442n();
        n.setGradientStatus(false);
        Context context2 = n.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "this.context");
        int colorOf = ContextKt.colorOf(context2, R.color.global_color_gradient_begin);
        Context context3 = n.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "this.context");
        n.setGradientColor(colorOf, ContextKt.colorOf(context3, R.color.global_color_gradient_end), 30);
        CircleProgressBar f = m9434f();
        f.setGradientStatus(false);
        Context context4 = f.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "this.context");
        int colorOf2 = ContextKt.colorOf(context4, R.color.global_color_gradient_begin);
        Context context5 = f.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "this.context");
        f.setGradientColor(colorOf2, ContextKt.colorOf(context5, R.color.global_color_gradient_end), 30);
        try {
            m9423D().setBackground(DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.global_overall_main_button_selector));
            m9423D().setTextColor(ContextCompat.getColorStateList(context, DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        m9420A().setVisibility(8);
        m9423D().setEnabled(true);
        m9423D().setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ExpectationView2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AbsExpectationPresenter access$getPresenter$p = this.this$0.f13690d;
                if (access$getPresenter$p != null) {
                    access$getPresenter$p.onFlexClick();
                }
            }
        });
        m9436h().setLayoutManager(new LinearLayoutManager(context, 1, false));
        m9436h().setNestedScrollingEnabled(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Context m9426a() {
        Context context = this.f13695i.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "_view.context");
        return context;
    }

    /* renamed from: b */
    private final ViewGroup m9429b() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.any_car_layout)");
        return (ViewGroup) findViewById;
    }

    /* renamed from: c */
    private final TextView m9431c() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.any_car_waiting_title)");
        return (TextView) findViewById;
    }

    /* renamed from: d */
    private final TextView m9432d() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_time_des);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.any_car_waiting_time_des)");
        return (TextView) findViewById;
    }

    /* renamed from: e */
    private final TextView m9433e() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_time);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.any_car_waiting_time)");
        return (TextView) findViewById;
    }

    /* renamed from: f */
    private final CircleProgressBar m9434f() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_progressBar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.…_car_waiting_progressBar)");
        return (CircleProgressBar) findViewById;
    }

    /* renamed from: g */
    private final SimpleDraweeView m9435g() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_gif);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.any_car_waiting_gif)");
        return (SimpleDraweeView) findViewById;
    }

    /* renamed from: h */
    private final RecyclerView m9436h() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_requesting_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.…_waiting_requesting_list)");
        return (RecyclerView) findViewById;
    }

    /* renamed from: i */
    private final AnyCarBubbleTipLayout m9437i() {
        View findViewById = this.f13695i.findViewById(R.id.any_car_waiting_requesting_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.…r_waiting_requesting_tip)");
        return (AnyCarBubbleTipLayout) findViewById;
    }

    /* renamed from: j */
    private final ExpectationCardAnimation m9438j() {
        ExpectationCardAnimation expectationCardAnimation;
        synchronized (this) {
            expectationCardAnimation = this.f13696j;
            if (expectationCardAnimation == null) {
                expectationCardAnimation = new ExpectationCardAnimation((ViewGroup) this.f13695i);
                this.f13696j = expectationCardAnimation;
            }
        }
        return expectationCardAnimation;
    }

    /* renamed from: k */
    private final TextSwitcher m9439k() {
        View findViewById = this.f13695i.findViewById(R.id.title_text_ts);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.title_text_ts)");
        return (TextSwitcher) findViewById;
    }

    /* renamed from: l */
    private final TextSwitcher m9440l() {
        View findViewById = this.f13695i.findViewById(R.id.content_text_ts);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.content_text_ts)");
        return (TextSwitcher) findViewById;
    }

    /* renamed from: m */
    private final TextView m9441m() {
        View findViewById = this.f13695i.findViewById(R.id.title_time_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.title_time_text)");
        return (TextView) findViewById;
    }

    /* renamed from: n */
    private final CircleProgressBar m9442n() {
        View findViewById = this.f13695i.findViewById(R.id.custom_progressBar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.custom_progressBar)");
        return (CircleProgressBar) findViewById;
    }

    /* renamed from: o */
    private final SimpleDraweeView m9443o() {
        View findViewById = this.f13695i.findViewById(R.id.webp_imageView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.webp_imageView)");
        return (SimpleDraweeView) findViewById;
    }

    /* renamed from: p */
    private final Group m9444p() {
        View findViewById = this.f13695i.findViewById(R.id.group_circle_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.group_circle_progress)");
        return (Group) findViewById;
    }

    /* renamed from: q */
    private final TextView m9445q() {
        View findViewById = this.f13695i.findViewById(R.id.subtitle_rich_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.subtitle_rich_text)");
        return (TextView) findViewById;
    }

    /* renamed from: r */
    private final WaitView m9446r() {
        View findViewById = this.f13695i.findViewById(R.id.wait_need_compensation);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.wait_need_compensation)");
        return (WaitView) findViewById;
    }

    /* renamed from: s */
    private final TextView m9447s() {
        View findViewById = this.f13695i.findViewById(R.id.time_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.time_text)");
        return (TextView) findViewById;
    }

    /* renamed from: t */
    private final TextView m9448t() {
        View findViewById = this.f13695i.findViewById(R.id.tip_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.tip_text)");
        return (TextView) findViewById;
    }

    /* renamed from: u */
    private final ImageView m9449u() {
        View findViewById = this.f13695i.findViewById(R.id.tips_icon_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.tips_icon_iv)");
        return (ImageView) findViewById;
    }

    /* renamed from: v */
    private final TextView m9450v() {
        View findViewById = this.f13695i.findViewById(R.id.caption_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.caption_text)");
        return (TextView) findViewById;
    }

    /* renamed from: w */
    private final TextView m9451w() {
        View findViewById = this.f13695i.findViewById(R.id.tv_equity);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.tv_equity)");
        return (TextView) findViewById;
    }

    /* renamed from: x */
    private final ImageView m9452x() {
        View findViewById = this.f13695i.findViewById(R.id.iv_equity);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.iv_equity)");
        return (ImageView) findViewById;
    }

    /* renamed from: y */
    private final View m9453y() {
        View findViewById = this.f13695i.findViewById(R.id.v_equity_backplane);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.v_equity_backplane)");
        return findViewById;
    }

    /* renamed from: z */
    private final View m9454z() {
        View findViewById = this.f13695i.findViewById(R.id.group_equity);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.group_equity)");
        return findViewById;
    }

    /* renamed from: A */
    private final ConstraintLayout m9420A() {
        View findViewById = this.f13695i.findViewById(R.id.flex_raise_fare_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.flex_raise_fare_layout)");
        return (ConstraintLayout) findViewById;
    }

    /* renamed from: B */
    private final TextView m9421B() {
        View findViewById = this.f13695i.findViewById(R.id.flex_title_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.flex_title_text)");
        return (TextView) findViewById;
    }

    /* renamed from: C */
    private final TextView m9422C() {
        View findViewById = this.f13695i.findViewById(R.id.flex_price_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.flex_price_text)");
        return (TextView) findViewById;
    }

    /* renamed from: D */
    private final TextView m9423D() {
        View findViewById = this.f13695i.findViewById(R.id.flex_raise_fare_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.flex_raise_fare_btn)");
        return (TextView) findViewById;
    }

    /* renamed from: E */
    private final Space m9424E() {
        View findViewById = this.f13695i.findViewById(R.id.space_progress_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.space_progress_bottom)");
        return (Space) findViewById;
    }

    /* renamed from: F */
    private final Space m9425F() {
        View findViewById = this.f13695i.findViewById(R.id.space_expectation_bot_gap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "_view.findViewById(R.id.space_expectation_bot_gap)");
        return (Space) findViewById;
    }

    public void updateFlex(FlexRaise flexRaise) {
        LEGORichInfo lEGORichInfo;
        LEGORichInfo lEGORichInfo2;
        m9420A().setVisibility(0);
        if (!(flexRaise == null || (lEGORichInfo2 = flexRaise.title) == null)) {
            lEGORichInfo2.bindTextView(m9421B());
        }
        if (!(flexRaise == null || (lEGORichInfo = flexRaise.price) == null)) {
            lEGORichInfo.bindTextView(m9422C());
        }
        m9423D().setText(flexRaise == null ? null : flexRaise.raise_btn_title);
    }

    public View getView() {
        return this.f13695i;
    }

    public void setPresenter(AbsExpectationPresenter<?> absExpectationPresenter) {
        this.f13690d = absExpectationPresenter;
    }

    public void setIsAnyCar(Boolean bool) {
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        this.f13687a = booleanValue;
        if (booleanValue) {
            m9429b().setVisibility(0);
            m9439k().setVisibility(8);
            m9442n().setVisibility(8);
            m9443o().setVisibility(8);
            m9444p().setVisibility(8);
            ViewGroup.LayoutParams layoutParams = m9424E().getLayoutParams();
            layoutParams.height = 0;
            m9424E().setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = m9425F().getLayoutParams();
            layoutParams2.height = 0;
            m9425F().setLayoutParams(layoutParams2);
            return;
        }
        m9429b().setVisibility(8);
        m9439k().setVisibility(0);
        m9442n().setVisibility(0);
        m9443o().setVisibility(0);
        m9444p().setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = m9424E().getLayoutParams();
        layoutParams3.height = UiUtils.dip2px(m9426a(), 14.0f);
        m9424E().setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = m9425F().getLayoutParams();
        layoutParams4.height = UiUtils.dip2px(m9426a(), 20.0f);
        m9425F().setLayoutParams(layoutParams4);
    }

    public void setAnyCarRequestingList(List<AnyCarRequesting> list) {
        if (list != null) {
            m9436h().setAdapter(new AnyCarRequestingAdapter(m9426a(), list));
        }
    }

    public void showAnyCarRequestTip(CommonBubbleItemModel commonBubbleItemModel) {
        String content;
        if (commonBubbleItemModel != null && new BubbleSourceManager(m9426a()).isShowBubble(commonBubbleItemModel.bubbleId, 1) && commonBubbleItemModel.bubbleText != null && (content = commonBubbleItemModel.bubbleText.getContent()) != null) {
            m9437i().setPadding(20, 20, 20, 20);
            m9437i().setBubbleBackgroundColor(ResourcesHelper.getColor(m9426a(), R.color.g_color_5C6166));
            m9437i().setTypeface(3);
            m9437i().setText(content);
            m9437i().setMaxLines(2);
            m9437i().setOnClickListener(new ExpectationView2$showAnyCarRequestTip$1$1$1(this, commonBubbleItemModel));
            m9437i().setVisibility(0);
        }
    }

    public void closeAnyCarTipComplete(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            m9437i().setVisibility(8);
            new BubbleSourceManager(m9426a()).saveBubbleShowCount(str);
        }
    }

    public void setTitleText(CharSequence charSequence) {
        m9431c().setText(charSequence == null ? "" : charSequence);
        TextSwitcher k = m9439k();
        if (charSequence == null) {
            charSequence = "";
        }
        k.setText(charSequence);
    }

    public void setSubTitleText(CharSequence charSequence) {
        if (!this.f13687a) {
            this.f13692f = true;
            m9438j().setShowSubtitle(true);
            if (this.f13693g) {
                m9440l().setVisibility(8);
            } else {
                m9440l().setVisibility(0);
            }
            m9445q().setVisibility(8);
            m9438j().setShowReimburseSubtitle(true);
            TextSwitcher l = m9440l();
            if (charSequence == null) {
            }
            l.setText(charSequence);
        }
    }

    public void hideSubTitleText() {
        this.f13692f = false;
        m9438j().setShowSubtitle(false);
        m9440l().setVisibility(8);
    }

    public void setProgressBar(float f) {
        m9442n().setPercent(Math.max(0.0f, f));
        m9434f().setPercent(Math.max(0.0f, f));
    }

    public void finishProgressBar(int i, int i2) {
        CircleProgressBar n = m9442n();
        if (i == 1) {
            n.setProgressWithAnimation(0.0f, i2);
        } else {
            n.setProgressWithAnimation(100.0f, i2);
        }
        CircleProgressBar f = m9434f();
        if (i == 1) {
            f.setProgressWithAnimation(0.0f, i2);
        } else {
            f.setProgressWithAnimation(100.0f, i2);
        }
    }

    public void setTime(String str) {
        if (str == null) {
            str = "";
        }
        m9433e().setText(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r2 != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTimes(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0004
            java.lang.String r5 = ""
        L_0x0004:
            boolean r0 = r4.f13687a
            if (r0 == 0) goto L_0x0012
            android.widget.TextView r6 = r4.m9433e()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6.setText(r5)
            goto L_0x006d
        L_0x0012:
            android.widget.TextView r0 = r4.m9447s()
            int r1 = r0.getVisibility()
            r2 = 0
            if (r1 == 0) goto L_0x0027
            boolean r1 = r4.f13693g
            if (r1 != 0) goto L_0x0027
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            r1.setVisibility(r2)
        L_0x0027:
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x003d
            int r3 = r6.length()
            if (r3 <= 0) goto L_0x003a
            r2 = 1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r6 = r1
        L_0x003e:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0043
            goto L_0x006d
        L_0x0043:
            android.widget.TextView r1 = r4.m9441m()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            java.lang.String r6 = " {"
            r2.append(r6)
            r2.append(r5)
            r5 = 125(0x7d, float:1.75E-43)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            android.text.SpannableStringBuilder r5 = com.didi.component.business.util.HighlightUtil.highlight((java.lang.CharSequence) r5, (int) r6, (boolean) r0)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.ExpectationView2.setTimes(java.lang.String, java.lang.String):void");
    }

    public void hideTime() {
        m9447s().setVisibility(8);
        m9441m().setVisibility(8);
    }

    public void setTimeDes(String str) {
        m9432d().setText(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if ((r6.length() > 0) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTips(com.didi.global.globaluikit.richinfo.LEGORichInfo r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0005
            r5 = r0
            goto L_0x000e
        L_0x0005:
            android.widget.TextView r1 = r4.m9448t()
            r5.bindTextView(r1)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x000e:
            if (r5 != 0) goto L_0x0011
            return
        L_0x0011:
            android.widget.ImageView r5 = r4.m9449u()
            android.view.View r5 = (android.view.View) r5
            r1 = 0
            r5.setVisibility(r1)
            android.widget.TextView r5 = r4.m9448t()
            android.view.View r5 = (android.view.View) r5
            r5.setVisibility(r1)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5 = 1
            if (r6 == 0) goto L_0x0035
            int r2 = r6.length()
            if (r2 <= 0) goto L_0x0031
            r2 = 1
            goto L_0x0032
        L_0x0031:
            r2 = 0
        L_0x0032:
            if (r2 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r6 = r0
        L_0x0036:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x003b
            goto L_0x0072
        L_0x003b:
            android.content.Context r2 = r4.m9426a()
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
            com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r6)
            android.widget.ImageView r3 = r4.m9449u()
            r2.into((android.widget.ImageView) r3)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x005c
            int r2 = r7.length()
            if (r2 <= 0) goto L_0x0059
            r1 = 1
        L_0x0059:
            if (r1 == 0) goto L_0x005c
            r0 = r7
        L_0x005c:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0061
            goto L_0x0071
        L_0x0061:
            android.widget.ImageView r5 = r4.m9449u()
            android.view.View r5 = (android.view.View) r5
            com.didi.component.expectation.view.ExpectationView2$setTips$lambda-15$lambda-14$$inlined$onClick$1 r7 = new com.didi.component.expectation.view.ExpectationView2$setTips$lambda-15$lambda-14$$inlined$onClick$1
            r7.<init>(r4, r0)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r5.setOnClickListener(r7)
        L_0x0071:
            r0 = r6
        L_0x0072:
            if (r0 != 0) goto L_0x007f
            android.widget.ImageView r5 = r4.m9449u()
            android.view.View r5 = (android.view.View) r5
            r6 = 8
            r5.setVisibility(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.ExpectationView2.setTips(com.didi.global.globaluikit.richinfo.LEGORichInfo, java.lang.String, java.lang.String):void");
    }

    public void hideTips() {
        m9449u().setVisibility(8);
        m9448t().setVisibility(8);
    }

    public void setMainIcon(WebpResEnum webpResEnum) {
        if (webpResEnum != null) {
            String str = this.f13688b;
            boolean z = false;
            if (str != null && str.equals(webpResEnum.getUrl())) {
                z = true;
            }
            if (!z) {
                this.f13688b = webpResEnum.getUrl();
                SimpleDraweeView o = m9443o();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String url = webpResEnum.getUrl();
                boolean hasCache = OnlineImageCacheManager.getInstance(m9426a()).hasCache(url, ICacheProvider.PROVIDER_KEY_FRESCO);
                LogUtil.m26314i(f13684l, "setMainIcon:url = " + url + ", hasCache = " + hasCache);
                OmegaUtil.loadUrlEvent(url, hasCache);
                GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) o.getHierarchy();
                if (genericDraweeHierarchy != null) {
                    genericDraweeHierarchy.setPlaceholderImage(webpResEnum.getPlaceHolderRes());
                }
                o.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(webpResEnum.getUrl()).setAutoPlayAnimations(true)).setControllerListener(new ExpectationView2$setMainIcon$1$1(url, hasCache, elapsedRealtime))).build());
                if (DRtlToolkit.rtl()) {
                    o.setScaleX(-1.0f);
                }
            }
        }
    }

    public void setMainIcon(WebpLocResEnum webpLocResEnum) {
        if (webpLocResEnum != null) {
            Uri parse = Uri.parse("res://" + m9426a().getPackageName() + IOUtils.DIR_SEPARATOR_UNIX + webpLocResEnum.getRes());
            SimpleDraweeView o = m9443o();
            o.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(parse).setAutoPlayAnimations(true)).setControllerListener(new ExpectationView2$setMainIcon$2$1(this))).build());
            if (DRtlToolkit.rtl()) {
                o.setScaleX(-1.0f);
            }
            SimpleDraweeView g = m9435g();
            g.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(parse).setAutoPlayAnimations(true)).build());
            if (DRtlToolkit.rtl()) {
                g.setScaleX(-1.0f);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if ((r4.length() > 0) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCaptionText(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = r3.f13687a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x0017
            int r2 = r4.length()
            if (r2 <= 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r2 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r4 = r1
        L_0x0018:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x001d
            goto L_0x002c
        L_0x001d:
            android.widget.TextView r1 = r3.m9450v()
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            r2.setVisibility(r0)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.ExpectationView2.setCaptionText(java.lang.String):void");
    }

    public void hideCaptionText() {
        m9450v().setVisibility(8);
    }

    public void updateViewByIndriver(boolean z, boolean z2, long j, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        m9427a("show " + this.f13693g + "/ " + z + "/ refresh=" + z2 + "/ isAnimation " + this.f13691e);
        if (z != this.f13693g) {
            if (this.f13691e || m9438j().isRunning()) {
                this.f13697k = new ExpectationView2$updateViewByIndriver$1(this, z, z2, j, iXpCompRefreshCb);
                return;
            }
            this.f13697k = null;
            this.f13695i.post(new ExpectationView2$updateViewByIndriver$2(this, z, z2, j, iXpCompRefreshCb));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m9428a(boolean z, boolean z2, long j, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        if (z != this.f13693g) {
            this.f13691e = true;
            this.f13693g = z;
            if (z) {
                if (!ViewCompat.isLaidOut(this.f13695i)) {
                    this.f13695i.measure(0, 0);
                }
                this.f13694h = this.f13695i.getMeasuredHeight();
                if (iXpCompRefreshCb != null) {
                    iXpCompRefreshCb.callback(272.0f, UiUtils.dip2px(m9426a(), 105.0f));
                }
                m9438j().collapse(iXpCompRefreshCb, j, new ExpectationView2$performUpdateViewByIndriverWithAnimated$1(this));
                return;
            }
            if (iXpCompRefreshCb != null) {
                iXpCompRefreshCb.callback(0.0f, this.f13694h);
            }
            m9438j().expand(iXpCompRefreshCb, this.f13694h, j, new ExpectationView2$performUpdateViewByIndriverWithAnimated$2(this));
        }
    }

    public boolean isAnimation() {
        return this.f13691e;
    }

    public void setSceneVisibility(int i) {
        if (!this.f13687a) {
            if (i == 2) {
                m9444p().setVisibility(8);
                m9438j().setShowProgress(false);
                m9446r().setVisibility(0);
                m9438j().setShowReimburse(true);
                hideTime();
                return;
            }
            m9444p().setVisibility(0);
            m9438j().setShowProgress(true);
            m9446r().setVisibility(8);
            m9438j().setShowReimburse(false);
        }
    }

    public void setObtainedCouponViewVisibility(int i, int i2) {
        if (i >= i2) {
            WaitView r = m9446r();
            r.setThumbLayoutVisibility(8);
            r.setProgressBarVisibility(8);
            r.setEndGiftBoxFlVisibility(8);
            r.setNodesVisibility(8);
            r.setDiscountLottieVisibility(0);
        }
    }

    public void setWaitProgressBar(float f, ProgressState progressState, int i) {
        Intrinsics.checkNotNullParameter(progressState, "state");
        m9446r().setProgress(Math.max(0.0f, f), progressState, i);
    }

    public void showThumb(String str, int i, float f, float f2, int i2, boolean z, int i3, int i4, int i5) {
        if (z) {
            m9446r().updateThumbMargin(f, f2, i3);
        }
        if (i4 >= i5) {
            m9446r().setThumbLayoutVisibility(8);
            return;
        }
        m9446r().setThumbLayoutVisibility(0);
        if (i == 0) {
            m9446r().setThumbLayoutVisibility(8);
        } else if (i == 1) {
            WaitView r = m9446r();
            r.setThumbImageVisibility(0);
            r.setThumbLottieVisibility(8);
            if (str == null) {
                str = "";
            }
            r.showRemoteThumbImage(str);
        } else if (i == 2) {
            WaitView r2 = m9446r();
            r2.setThumbLottieVisibility(0);
            r2.setThumbImageVisibility(8);
            if (str == null) {
                str = "";
            }
            r2.playLocalThumbLottie(str);
        }
        m9446r().translateThumb(f, f2, i2, i3);
    }

    public void setTranslationX(float f) {
        m9446r().setTranslationX(f);
    }

    public void cancelAnim() {
        WaitView r = m9446r();
        r.cancelThumbAnim();
        r.cancelShakeAnim();
        r.cancelThumbLottie();
        r.cancelGiftBoxLottie();
    }

    public void cancelCircleAnim() {
        Animatable animatable = this.f13689c;
        boolean z = false;
        if (animatable != null && animatable.isRunning()) {
            z = true;
        }
        if (z) {
            SystemUtils.log(5, f13684l, "cancelCircleAnim 1", (Throwable) null, "com.didi.component.expectation.view.ExpectationView2", 621);
            Animatable animatable2 = this.f13689c;
            if (animatable2 != null) {
                animatable2.stop();
            }
        }
    }

    public void startCircleAnim() {
        Animatable animatable = this.f13689c;
        boolean z = false;
        if (animatable != null && !animatable.isRunning()) {
            z = true;
        }
        if (z) {
            SystemUtils.log(5, f13684l, "startCircleAnim 1", (Throwable) null, "com.didi.component.expectation.view.ExpectationView2", 628);
            Animatable animatable2 = this.f13689c;
            if (animatable2 != null) {
                animatable2.start();
            }
        }
    }

    public void resetViewStatus() {
        WaitView r = m9446r();
        r.setDiscountLottieVisibility(8);
        r.setProgressBarVisibility(0);
        r.setThumbLayoutVisibility(0);
        r.setThumbLottieVisibility(8);
        r.setThumbImageVisibility(8);
        r.setEndGiftBoxFlVisibility(0);
        r.setGiftBoxLottieVisibility(8);
        r.setDiscountCouponVisibility(8);
        r.setDiscountNumberVisibility(8);
        r.setStartBgLottieVisibility(0);
    }

    public void shakeGiftBox(float f, long j, int i, int i2, Animator.AnimatorListener animatorListener) {
        m9446r().shakeGiftBox(f, j, i, i2, animatorListener);
    }

    public void setRichSubtitle(GlobalRichInfo globalRichInfo) {
        CharSequence charSequence;
        TextView q = m9445q();
        q.setVisibility(0);
        m9438j().setShowReimburseSubtitle(true);
        hideSubTitleText();
        if (globalRichInfo == null) {
            charSequence = null;
        } else {
            try {
                charSequence = globalRichInfo.parseRichInfo(q.getContext());
            } catch (Exception e) {
                e.printStackTrace();
                charSequence = globalRichInfo.getContent();
            }
        }
        q.setText(charSequence);
    }

    public void hideRichSubtitle() {
        m9445q().setVisibility(8);
        m9438j().setShowReimburseSubtitle(false);
    }

    public void openBoxAndShowCoupon(int i) {
        m9446r().openBoxAndShowCoupon((float) i);
    }

    public void setTipsBackground(Drawable drawable) {
        TextView t = m9448t();
        if (drawable != null) {
            t.setBackground(drawable);
        }
        t.setTextColor(-16724822);
    }

    public void addProgressNode(List<ProgressState> list) {
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                m9446r().addNodeView(list);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if ((r1.length() > 0) != false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (r2 != false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showEquityUI(com.didi.component.expectation.model.UsePrivilege r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0006
            r6 = r0
            goto L_0x009c
        L_0x0006:
            android.view.View r1 = r5.m9454z()
            r2 = 0
            r1.setVisibility(r2)
            java.lang.String r1 = r6.mColor
            java.lang.Integer r1 = r5.m9430b(r1)
            if (r1 != 0) goto L_0x0017
            goto L_0x0024
        L_0x0017:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            android.view.View r3 = r5.m9453y()
            r3.setBackgroundColor(r1)
        L_0x0024:
            java.lang.String r1 = r6.nIconUrl
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 1
            if (r1 == 0) goto L_0x0037
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            if (r4 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r0
        L_0x0038:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x003d
            goto L_0x0054
        L_0x003d:
            android.content.Context r4 = r5.m9426a()
            com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with((android.content.Context) r4)
            com.bumptech.glide.RequestBuilder r4 = r4.asBitmap()
            com.bumptech.glide.RequestBuilder r1 = r4.load((java.lang.String) r1)
            android.widget.ImageView r4 = r5.m9452x()
            r1.into((android.widget.ImageView) r4)
        L_0x0054:
            java.lang.String r1 = r6.mFontSize
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0064
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x0061
            r2 = 1
        L_0x0061:
            if (r2 == 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r1 = r0
        L_0x0065:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x006a
            goto L_0x0086
        L_0x006a:
            android.widget.TextView r2 = r5.m9451w()     // Catch:{ NumberFormatException -> 0x0078 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0078 }
            r2.setTextSize(r1)     // Catch:{ NumberFormatException -> 0x0078 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ NumberFormatException -> 0x0078 }
            goto L_0x0086
        L_0x0078:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.String r3 = "ExpectationViewV2"
            com.didi.component.common.util.GLog.m7969e(r3, r2, r1)
            kotlin.Unit r0 = (kotlin.Unit) r0
        L_0x0086:
            java.lang.String r0 = r6.mTextColor
            java.lang.Integer r0 = r5.m9430b(r0)
            if (r0 != 0) goto L_0x008f
            goto L_0x009c
        L_0x008f:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            android.widget.TextView r1 = r5.m9451w()
            r1.setTextColor(r0)
        L_0x009c:
            if (r6 != 0) goto L_0x00a7
            android.view.View r6 = r5.m9454z()
            r0 = 8
            r6.setVisibility(r0)
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.ExpectationView2.showEquityUI(com.didi.component.expectation.model.UsePrivilege):void");
    }

    public void setEquityText(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            m9451w().setText(charSequence);
        } else {
            GLog.m7968e(f13684l, "setEquityText>> EquityText is null");
        }
    }

    /* renamed from: a */
    private final void m9427a(String str) {
        SystemUtils.log(3, f13684l, str, (Throwable) null, "com.didi.component.expectation.view.ExpectationView2", 728);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if ((r4.length() > 0) != false) goto L_0x0012;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Integer m9430b(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0 = 0
            if (r4 == 0) goto L_0x0011
            int r1 = r4.length()
            if (r1 <= 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r4 = r0
        L_0x0012:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x0017
            goto L_0x002f
        L_0x0017:
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ IllegalArgumentException -> 0x0021 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalArgumentException -> 0x0021 }
            r0 = r4
            goto L_0x002f
        L_0x0021:
            r4 = move-exception
            java.lang.String r1 = r4.getMessage()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.String r2 = "ExpectationViewV2"
            com.didi.component.common.util.GLog.m7969e(r2, r1, r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.ExpectationView2.m9430b(java.lang.String):java.lang.Integer");
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/component/expectation/view/ExpectationView2$Companion;", "", "()V", "CARD_COLLAPSE_HEIGHT", "", "TAG", "", "WAIT_COMPENSATION_SCENE", "comp-expectation_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ExpectationView2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
