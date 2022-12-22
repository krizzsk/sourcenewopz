package android.view;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class View {
    public static final int ACCESSIBILITY_CURSOR_POSITION_UNDEFINED = -1;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    static final int ALL_RTL_PROPERTIES_RESOLVED = 1610678816;
    public static final String DEBUG_LAYOUT_PROPERTY = "debug.layout";
    public static final int DRAG_FLAG_GLOBAL = 256;
    public static final int DRAG_FLAG_GLOBAL_PERSISTABLE_URI_PERMISSION = 64;
    public static final int DRAG_FLAG_GLOBAL_PREFIX_URI_PERMISSION = 128;
    public static final int DRAG_FLAG_GLOBAL_URI_READ = 1;
    public static final int DRAG_FLAG_GLOBAL_URI_WRITE = 2;
    public static final int DRAG_FLAG_OPAQUE = 512;
    static final int DRAG_MASK = 3;
    protected static int[] EMPTY_STATE_SET = null;
    public static final int FIND_VIEWS_WITH_ACCESSIBILITY_NODE_PROVIDERS = 4;
    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
    public static final int FIND_VIEWS_WITH_TEXT = 1;
    public static final int GONE = 8;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int INVISIBLE = 4;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int NAVIGATION_BAR_TRANSIENT = 134217728;
    public static final int NAVIGATION_BAR_TRANSLUCENT = Integer.MIN_VALUE;
    public static final int NAVIGATION_BAR_TRANSPARENT = 32768;
    public static final int NAVIGATION_BAR_UNHIDE = 536870912;
    public static final int NO_ID = -1;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    static final int PFLAG2_ACCESSIBILITY_FOCUSED = 67108864;
    static final int PFLAG2_DRAG_CAN_ACCEPT = 1;
    static final int PFLAG2_DRAG_HOVERED = 2;
    static final int PFLAG2_DRAWABLE_RESOLVED = 1073741824;
    static final int PFLAG2_HAS_TRANSIENT_STATE = Integer.MIN_VALUE;
    static final int PFLAG2_LAYOUT_DIRECTION_MASK_SHIFT = 2;
    static final int PFLAG2_LAYOUT_DIRECTION_RESOLVED = 32;
    static final int PFLAG2_LAYOUT_DIRECTION_RESOLVED_MASK = 48;
    static final int PFLAG2_PADDING_RESOLVED = 536870912;
    static final int PFLAG2_SUBTREE_ACCESSIBILITY_STATE_CHANGED = 134217728;
    static final int PFLAG2_TEXT_ALIGNMENT_MASK_SHIFT = 13;
    static final int PFLAG2_TEXT_ALIGNMENT_RESOLVED = 65536;
    static final int PFLAG2_TEXT_DIRECTION_MASK_SHIFT = 6;
    static final int PFLAG2_TEXT_DIRECTION_RESOLVED = 512;
    static final int PFLAG2_VIEW_QUICK_REJECTED = 268435456;
    static final int PFLAG3_APPLYING_INSETS = 32;
    static final int PFLAG3_CALLED_SUPER = 16;
    static final int PFLAG3_FITTING_SYSTEM_WINDOWS = 64;
    static final int PFLAG3_IS_LAID_OUT = 4;
    static final int PFLAG3_MEASURE_NEEDED_BEFORE_LAYOUT = 8;
    static final int PFLAG3_NESTED_SCROLLING_ENABLED = 128;
    static final int PFLAG3_SCROLL_INDICATOR_BOTTOM = 512;
    static final int PFLAG3_SCROLL_INDICATOR_END = 8192;
    static final int PFLAG3_SCROLL_INDICATOR_LEFT = 1024;
    static final int PFLAG3_SCROLL_INDICATOR_RIGHT = 2048;
    static final int PFLAG3_SCROLL_INDICATOR_START = 4096;
    static final int PFLAG3_SCROLL_INDICATOR_TOP = 256;
    static final int PFLAG3_VIEW_IS_ANIMATING_ALPHA = 2;
    static final int PFLAG3_VIEW_IS_ANIMATING_TRANSFORM = 1;
    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 16375;
    public static final int RECENT_APPS_VISIBLE = 16384;
    public static final int SCREEN_STATE_OFF = 0;
    public static final int SCREEN_STATE_ON = 1;
    public static final int SCROLLBARS_INSIDE_INSET = 16777216;
    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    public static final int SCROLLBARS_OUTSIDE_INSET = 50331648;
    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 33554432;
    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    public static final int SCROLLBAR_POSITION_LEFT = 1;
    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    static final int SCROLL_INDICATORS_NONE = 0;
    static final int SCROLL_INDICATORS_PFLAG3_MASK = 16128;
    static final int SCROLL_INDICATORS_TO_PFLAGS3_LSHIFT = 8;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    protected static int[] SELECTED_STATE_SET = null;
    public static final int STATUS_BAR_DISABLE_BACK = 4194304;
    public static final int STATUS_BAR_DISABLE_CLOCK = 8388608;
    public static final int STATUS_BAR_DISABLE_EXPAND = 65536;
    public static final int STATUS_BAR_DISABLE_HOME = 2097152;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 262144;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 131072;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 524288;
    public static final int STATUS_BAR_DISABLE_RECENT = 16777216;
    public static final int STATUS_BAR_DISABLE_SEARCH = 33554432;
    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 1048576;
    public static final int STATUS_BAR_HIDDEN = 1;
    public static final int STATUS_BAR_TRANSIENT = 67108864;
    public static final int STATUS_BAR_TRANSLUCENT = 1073741824;
    public static final int STATUS_BAR_TRANSPARENT = 8;
    public static final int STATUS_BAR_UNHIDE = 268435456;
    public static final int STATUS_BAR_VISIBLE = 0;
    public static final int SYSTEM_UI_CLEARABLE_FLAGS = 7;
    public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4;
    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
    public static final int SYSTEM_UI_FLAG_IMMERSIVE = 2048;
    public static final int SYSTEM_UI_FLAG_IMMERSIVE_STICKY = 4096;
    public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;
    public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
    public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
    public static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192;
    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1;
    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    public static final int SYSTEM_UI_LAYOUT_FLAGS = 1536;
    public static final int SYSTEM_UI_TRANSPARENT = 32776;
    public static final int TEXT_ALIGNMENT_CENTER = 4;
    public static final int TEXT_ALIGNMENT_GRAVITY = 1;
    public static final int TEXT_ALIGNMENT_INHERIT = 0;
    public static final int TEXT_ALIGNMENT_TEXT_END = 3;
    public static final int TEXT_ALIGNMENT_TEXT_START = 2;
    public static final int TEXT_ALIGNMENT_VIEW_END = 6;
    public static final int TEXT_ALIGNMENT_VIEW_START = 5;
    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    public static final int TEXT_DIRECTION_FIRST_STRONG_LTR = 6;
    public static final int TEXT_DIRECTION_FIRST_STRONG_RTL = 7;
    public static final int TEXT_DIRECTION_INHERIT = 0;
    public static final int TEXT_DIRECTION_LOCALE = 5;
    public static final int TEXT_DIRECTION_LTR = 3;
    public static final int TEXT_DIRECTION_RTL = 4;
    public static final int TV_PICTURE_IN_PICTURE_VISIBLE = 65536;
    public static final int VISIBLE = 0;

    public static class AccessibilityDelegate {
        public void sendAccessibilityEvent(View view, int i) {
        }
    }

    public interface OnApplyWindowInsetsListener {
        WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets);
    }

    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    public interface OnClickListener {
        void onClick(View view);
    }

    public interface OnContextClickListener {
        boolean onContextClick(View view);
    }

    public interface OnCreateContextMenuListener {
        void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);
    }

    public interface OnDragListener {
        boolean onDrag(View view, DragEvent dragEvent);
    }

    public interface OnFocusChangeListener {
        void onFocusChange(View view, boolean z);
    }

    public interface OnGenericMotionListener {
        boolean onGenericMotion(View view, MotionEvent motionEvent);
    }

    public interface OnHoverListener {
        boolean onHover(View view, MotionEvent motionEvent);
    }

    public interface OnKeyListener {
        boolean onKey(View view, int i, KeyEvent keyEvent);
    }

    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    public interface OnLongClickListener {
        boolean onLongClick(View view);
    }

    public interface OnScrollChangeListener {
        void onScrollChange(View view, int i, int i2, int i3, int i4);
    }

    public interface OnSystemUiVisibilityChangeListener {
        void onSystemUiVisibilityChange(int i);
    }

    public interface OnTouchListener {
        boolean onTouch(View view, MotionEvent motionEvent);
    }

    public static int generateViewId() {
        return 0;
    }

    public static int getDefaultSize(int i, int i2) {
        return 0;
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return null;
    }

    protected static int[] mergeDrawableStates(int[] iArr, int[] iArr2) {
        return null;
    }

    public static int resolveSize(int i, int i2) {
        return 0;
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return 0;
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public void addFocusables(ArrayList<View> arrayList, int i) {
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
    }

    public void addKeyboardNavigationClusters() {
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
    }

    public void addOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
    }

    public void addTouchables(ArrayList<View> arrayList) {
    }

    public ViewPropertyAnimator animate() {
        return null;
    }

    public void announceForAccessibility(CharSequence charSequence) {
    }

    /* access modifiers changed from: protected */
    public boolean awakenScrollBars() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean awakenScrollBars(int i) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean awakenScrollBars(int i, boolean z) {
        return false;
    }

    public void bringToFront() {
    }

    public void buildDrawingCache() {
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildLayer() {
    }

    public boolean callOnClick() {
        return false;
    }

    public boolean canResolveLayoutDirection() {
        return false;
    }

    public boolean canResolveTextAlignment() {
        return false;
    }

    public boolean canResolveTextDirection() {
        return false;
    }

    public boolean canScrollHorizontally(int i) {
        return false;
    }

    public boolean canScrollVertically(int i) {
        return false;
    }

    public void cancelLongPress() {
    }

    public final void cancelPendingInputEvents() {
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    public void clearAnimation() {
    }

    public void clearFocus() {
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollExtent() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return 0;
    }

    public void computeScroll() {
    }

    public WindowInsets computeSystemWindowInsets(WindowInsets windowInsets, Rect rect) {
        return null;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollExtent() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        return 0;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return null;
    }

    public void createContextMenu(ContextMenu contextMenu) {
    }

    public void destroyDrawingCache() {
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return null;
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
    }

    public void dispatchDisplayHint(int i) {
    }

    public boolean dispatchDragEvent(DragEvent dragEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void dispatchDrawableHotspotChanged(float f, float f2) {
    }

    public void dispatchFinishTemporaryDetach() {
    }

    /* access modifiers changed from: protected */
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchGenericPointerEvent(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return false;
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return false;
    }

    public boolean dispatchNestedPrePerformAccessibilityAction(int i, Bundle bundle) {
        return false;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return false;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return false;
    }

    public final boolean dispatchPointerEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    /* access modifiers changed from: protected */
    public void dispatchSetActivated(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void dispatchSetSelected(boolean z) {
    }

    public void dispatchStartTemporaryDetach() {
    }

    public void dispatchSystemUiVisibilityChanged(int i) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void dispatchVisibilityChanged(View view, int i) {
    }

    public void dispatchWindowFocusChanged(boolean z) {
    }

    public void dispatchWindowSystemUiVisiblityChanged(int i) {
    }

    public void dispatchWindowVisibilityChanged(int i) {
    }

    public void draw(Canvas canvas) {
    }

    public void drawableHotspotChanged(float f, float f2) {
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
    }

    public View findFocus() {
        return null;
    }

    public final <T extends View> T findViewById(int i) {
        return null;
    }

    public final View findViewWithTag(Object obj) {
        return null;
    }

    public void findViewsWithText(ArrayList<View> arrayList, CharSequence charSequence, int i) {
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return false;
    }

    public View focusSearch(int i) {
        return null;
    }

    public void forceHasOverlappingRendering(boolean z) {
    }

    public void forceLayout() {
    }

    public CharSequence getAccessibilityClassName() {
        return null;
    }

    public AccessibilityDelegate getAccessibilityDelegate() {
        return null;
    }

    public int getAccessibilityLiveRegion() {
        return 0;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return null;
    }

    public int getAccessibilityTraversalAfter() {
        return 0;
    }

    public int getAccessibilityTraversalBefore() {
        return 0;
    }

    public float getAlpha() {
        return 0.0f;
    }

    public Animation getAnimation() {
        return null;
    }

    public IBinder getApplicationWindowToken() {
        return null;
    }

    public Drawable getBackground() {
        return null;
    }

    public ColorStateList getBackgroundTintList() {
        return null;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return null;
    }

    public int getBaseline() {
        return 0;
    }

    public final int getBottom() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int getBottomPaddingOffset() {
        return 0;
    }

    public float getCameraDistance() {
        return 0.0f;
    }

    public Rect getClipBounds() {
        return null;
    }

    public boolean getClipBounds(Rect rect) {
        return false;
    }

    public final boolean getClipToOutline() {
        return false;
    }

    public CharSequence getContentDescription() {
        return null;
    }

    public final Context getContext() {
        return null;
    }

    /* access modifiers changed from: protected */
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return null;
    }

    public Display getDisplay() {
        return null;
    }

    public final int[] getDrawableState() {
        return null;
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public int getDrawingCacheBackgroundColor() {
        return 0;
    }

    public int getDrawingCacheQuality() {
        return 0;
    }

    public void getDrawingRect(Rect rect) {
    }

    public long getDrawingTime() {
        return 0;
    }

    public float getElevation() {
        return 0.0f;
    }

    public boolean getFilterTouchesWhenObscured() {
        return false;
    }

    public boolean getFitsSystemWindows() {
        return false;
    }

    public ArrayList<View> getFocusables(int i) {
        return null;
    }

    public void getFocusedRect(Rect rect) {
    }

    public Drawable getForeground() {
        return null;
    }

    public int getForegroundGravity() {
        return 0;
    }

    public ColorStateList getForegroundTintList() {
        return null;
    }

    public PorterDuff.Mode getForegroundTintMode() {
        return null;
    }

    public final boolean getGlobalVisibleRect(Rect rect) {
        return false;
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        return false;
    }

    public Handler getHandler() {
        return null;
    }

    public final boolean getHasOverlappingRendering() {
        return false;
    }

    public final int getHeight() {
        return 0;
    }

    public void getHitRect(Rect rect) {
    }

    public int getHorizontalFadingEdgeLength() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getHorizontalScrollbarHeight() {
        return 0;
    }

    public int getId() {
        return 0;
    }

    public int getImportantForAccessibility() {
        return 0;
    }

    public final Matrix getInverseMatrix() {
        return null;
    }

    public boolean getKeepScreenOn() {
        return false;
    }

    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return null;
    }

    public int getLabelFor() {
        return 0;
    }

    public int getLayerType() {
        return 0;
    }

    public int getLayoutDirection() {
        return 0;
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return null;
    }

    public final int getLeft() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int getLeftPaddingOffset() {
        return 0;
    }

    public final boolean getLocalVisibleRect(Rect rect) {
        return false;
    }

    public void getLocationInWindow(int[] iArr) {
    }

    public void getLocationOnScreen(int[] iArr) {
    }

    public Matrix getMatrix() {
        return null;
    }

    public int getMeasuredHeight() {
        return 0;
    }

    public final int getMeasuredHeightAndState() {
        return 0;
    }

    public final int getMeasuredState() {
        return 0;
    }

    public int getMeasuredWidth() {
        return 0;
    }

    public final int getMeasuredWidthAndState() {
        return 0;
    }

    public int getMinimumHeight() {
        return 0;
    }

    public int getMinimumWidth() {
        return 0;
    }

    public int getNextFocusDownId() {
        return 0;
    }

    public int getNextFocusForwardId() {
        return 0;
    }

    public int getNextFocusLeftId() {
        return 0;
    }

    public int getNextFocusRightId() {
        return 0;
    }

    public int getNextFocusUpId() {
        return 0;
    }

    public OnFocusChangeListener getOnFocusChangeListener() {
        return null;
    }

    public ViewOutlineProvider getOutlineProvider() {
        return null;
    }

    public int getOverScrollMode() {
        return 0;
    }

    public ViewOverlay getOverlay() {
        return null;
    }

    public int getPaddingBottom() {
        return 0;
    }

    public int getPaddingEnd() {
        return 0;
    }

    public int getPaddingLeft() {
        return 0;
    }

    public int getPaddingRight() {
        return 0;
    }

    public int getPaddingStart() {
        return 0;
    }

    public int getPaddingTop() {
        return 0;
    }

    public final ViewParent getParent() {
        return null;
    }

    public ViewParent getParentForAccessibility() {
        return null;
    }

    public float getPivotX() {
        return 0.0f;
    }

    public float getPivotY() {
        return 0.0f;
    }

    public PointerIcon getPointerIcon() {
        return null;
    }

    public Resources getResources() {
        return null;
    }

    public final int getRight() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int getRightPaddingOffset() {
        return 0;
    }

    public View getRootView() {
        return null;
    }

    public WindowInsets getRootWindowInsets() {
        return null;
    }

    public float getRotation() {
        return 0.0f;
    }

    public float getRotationX() {
        return 0.0f;
    }

    public float getRotationY() {
        return 0.0f;
    }

    public float getScaleX() {
        return 0.0f;
    }

    public float getScaleY() {
        return 0.0f;
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return 0;
    }

    public int getScrollBarFadeDuration() {
        return 0;
    }

    public int getScrollBarSize() {
        return 0;
    }

    public int getScrollBarStyle() {
        return 0;
    }

    public int getScrollIndicators() {
        return 0;
    }

    public final int getScrollX() {
        return 0;
    }

    public final int getScrollY() {
        return 0;
    }

    public int getSolidColor() {
        return 0;
    }

    public StateListAnimator getStateListAnimator() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return 0;
    }

    public int getSystemUiVisibility() {
        return 0;
    }

    public Object getTag() {
        return null;
    }

    public int getTextAlignment() {
        return 0;
    }

    public int getTextDirection() {
        return 0;
    }

    public final int getTop() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int getTopPaddingOffset() {
        return 0;
    }

    public TouchDelegate getTouchDelegate() {
        return null;
    }

    public ArrayList<View> getTouchables() {
        return null;
    }

    public String getTransitionName() {
        return null;
    }

    public float getTranslationX() {
        return 0.0f;
    }

    public float getTranslationY() {
        return 0.0f;
    }

    public float getTranslationZ() {
        return 0.0f;
    }

    public int getVerticalFadingEdgeLength() {
        return 0;
    }

    public int getVerticalScrollbarPosition() {
        return 0;
    }

    public int getVerticalScrollbarWidth() {
        return 0;
    }

    public ViewTreeObserver getViewTreeObserver() {
        return null;
    }

    public int getVisibility() {
        return 0;
    }

    public final int getWidth() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getWindowAttachCount() {
        return 0;
    }

    public WindowId getWindowId() {
        return null;
    }

    public int getWindowSystemUiVisibility() {
        return 0;
    }

    public IBinder getWindowToken() {
        return null;
    }

    public int getWindowVisibility() {
        return 0;
    }

    public void getWindowVisibleDisplayFrame(Rect rect) {
    }

    public float getX() {
        return 0.0f;
    }

    public float getY() {
        return 0.0f;
    }

    public float getZ() {
        return 0.0f;
    }

    public boolean hasFocus() {
        return false;
    }

    public boolean hasFocusable() {
        return false;
    }

    public boolean hasNestedScrollingParent() {
        return false;
    }

    public boolean hasOnClickListeners() {
        return false;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public boolean hasTransientState() {
        return false;
    }

    public boolean hasWindowFocus() {
        return false;
    }

    public void invalidate() {
    }

    public void invalidate(int i, int i2, int i3, int i4) {
    }

    public void invalidate(Rect rect) {
    }

    public void invalidateDrawable(Drawable drawable) {
    }

    public void invalidateOutline() {
    }

    public boolean isAccessibilityFocused() {
        return false;
    }

    public boolean isActivated() {
        return false;
    }

    public boolean isAttachedToWindow() {
        return false;
    }

    public boolean isClickable() {
        return false;
    }

    public boolean isContextClickable() {
        return false;
    }

    public boolean isDirty() {
        return false;
    }

    public boolean isDrawingCacheEnabled() {
        return false;
    }

    public boolean isDuplicateParentStateEnabled() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public boolean isFocusable() {
        return false;
    }

    public final boolean isFocusableInTouchMode() {
        return false;
    }

    public boolean isFocused() {
        return false;
    }

    public boolean isHapticFeedbackEnabled() {
        return false;
    }

    public boolean isHardwareAccelerated() {
        return false;
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return false;
    }

    public boolean isHorizontalScrollBarEnabled() {
        return false;
    }

    public boolean isHovered() {
        return false;
    }

    public boolean isImportantForAccessibility() {
        return false;
    }

    public boolean isInEditMode() {
        return false;
    }

    public boolean isInLayout() {
        return false;
    }

    public boolean isInTouchMode() {
        return false;
    }

    public final boolean isKeyboardNavigationCluster() {
        return false;
    }

    public boolean isLaidOut() {
        return false;
    }

    public boolean isLayoutDirectionResolved() {
        return false;
    }

    public boolean isLayoutRequested() {
        return false;
    }

    public boolean isLongClickable() {
        return false;
    }

    public boolean isNestedScrollingEnabled() {
        return false;
    }

    public boolean isOpaque() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isPaddingOffsetRequired() {
        return false;
    }

    public boolean isPaddingRelative() {
        return false;
    }

    public boolean isPressed() {
        return false;
    }

    public boolean isSaveEnabled() {
        return false;
    }

    public boolean isSaveFromParentEnabled() {
        return false;
    }

    public boolean isScrollContainer() {
        return false;
    }

    public boolean isScrollbarFadingEnabled() {
        return false;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isShown() {
        return false;
    }

    public boolean isSoundEffectsEnabled() {
        return false;
    }

    public final boolean isTemporarilyDetached() {
        return false;
    }

    public boolean isTextAlignmentResolved() {
        return false;
    }

    public boolean isTextDirectionResolved() {
        return false;
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return false;
    }

    public boolean isVerticalScrollBarEnabled() {
        return false;
    }

    public void jumpDrawablesToCurrentState() {
    }

    public View keyboardNavigationClusterSearch(View view, int i) {
        return null;
    }

    public void layout(int i, int i2, int i3, int i4) {
    }

    public final void measure(int i, int i2) {
    }

    public void offsetLeftAndRight(int i) {
    }

    public void offsetTopAndBottom(int i) {
    }

    /* access modifiers changed from: protected */
    public void onAnimationEnd() {
    }

    /* access modifiers changed from: protected */
    public void onAnimationStart() {
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
    }

    public void onCancelPendingInputEvents() {
    }

    public boolean onCheckIsTextEditor() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* access modifiers changed from: protected */
    public void onCreateContextMenu(ContextMenu contextMenu) {
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
    }

    /* access modifiers changed from: protected */
    public void onDisplayHint(int i) {
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    public void onDrawForeground(Canvas canvas) {
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
    }

    public void onFinishTemporaryDetach() {
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    public void onProvideStructure(ViewStructure viewStructure) {
    }

    public void onProvideVirtualStructure(ViewStructure viewStructure) {
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public void onRtlPropertiesChanged(int i) {
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onScreenStateChanged(int i) {
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: protected */
    public boolean onSetAlpha(int i) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    public void onStartTemporaryDetach() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onVisibilityAggregated(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return false;
    }

    public boolean performClick() {
        return false;
    }

    public boolean performContextClick() {
        return false;
    }

    public boolean performContextClick(float f, float f2) {
        return false;
    }

    public boolean performHapticFeedback(int i) {
        return false;
    }

    public boolean performHapticFeedback(int i, int i2) {
        return false;
    }

    public boolean performLongClick() {
        return false;
    }

    public boolean performLongClick(float f, float f2) {
        return false;
    }

    public void playSoundEffect(int i) {
    }

    public boolean post(Runnable runnable) {
        return false;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return false;
    }

    public void postInvalidate() {
    }

    public void postInvalidate(int i, int i2, int i3, int i4) {
    }

    public void postInvalidateDelayed(long j) {
    }

    public void postInvalidateDelayed(long j, int i, int i2, int i3, int i4) {
    }

    public void postInvalidateOnAnimation() {
    }

    public void postInvalidateOnAnimation(int i, int i2, int i3, int i4) {
    }

    public void postOnAnimation(Runnable runnable) {
    }

    public void postOnAnimationDelayed(Runnable runnable, long j) {
    }

    public void refreshDrawableState() {
    }

    public boolean removeCallbacks(Runnable runnable) {
        return false;
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
    }

    public void removeOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
    }

    public void requestApplyInsets() {
    }

    public void requestFitSystemWindows() {
    }

    public final boolean requestFocus() {
        return false;
    }

    public final boolean requestFocus(int i) {
        return false;
    }

    public boolean requestFocus(int i, Rect rect) {
        return false;
    }

    public final boolean requestFocusFromTouch() {
        return false;
    }

    public void requestLayout() {
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        return false;
    }

    public boolean requestRectangleOnScreen(Rect rect, boolean z) {
        return false;
    }

    public final void requestUnbufferedDispatch(MotionEvent motionEvent) {
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void scrollBy(int i, int i2) {
    }

    public void scrollTo(int i, int i2) {
    }

    public void sendAccessibilityEvent(int i) {
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
    }

    public void setAccessibilityLiveRegion(int i) {
    }

    public void setAccessibilityTraversalAfter(int i) {
    }

    public void setAccessibilityTraversalBefore(int i) {
    }

    public void setActivated(boolean z) {
    }

    public void setAlpha(float f) {
    }

    public void setAnimation(Animation animation) {
    }

    public void setBackground(Drawable drawable) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public final void setBottom(int i) {
    }

    public void setCameraDistance(float f) {
    }

    public void setClickable(boolean z) {
    }

    public void setClipBounds(Rect rect) {
    }

    public void setClipToOutline(boolean z) {
    }

    public void setContentDescription(CharSequence charSequence) {
    }

    public void setContextClickable(boolean z) {
    }

    public void setDrawingCacheBackgroundColor(int i) {
    }

    public void setDrawingCacheEnabled(boolean z) {
    }

    public void setDrawingCacheQuality(int i) {
    }

    public void setDuplicateParentStateEnabled(boolean z) {
    }

    public void setElevation(float f) {
    }

    public void setEnabled(boolean z) {
    }

    public void setFadingEdgeLength(int i) {
    }

    public void setFilterTouchesWhenObscured(boolean z) {
    }

    public void setFitsSystemWindows(boolean z) {
    }

    public void setFocusable(boolean z) {
    }

    public void setFocusableInTouchMode(boolean z) {
    }

    public void setForeground(Drawable drawable) {
    }

    public void setForegroundGravity(int i) {
    }

    public void setForegroundTintList(ColorStateList colorStateList) {
    }

    public void setForegroundTintMode(PorterDuff.Mode mode) {
    }

    public void setHapticFeedbackEnabled(boolean z) {
    }

    public void setHasTransientState(boolean z) {
    }

    public void setHorizontalFadingEdgeEnabled(boolean z) {
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
    }

    public void setHovered(boolean z) {
    }

    public void setId(int i) {
    }

    public void setImportantForAccessibility(int i) {
    }

    public void setKeepScreenOn(boolean z) {
    }

    public void setKeyboardNavigationCluster(boolean z) {
    }

    public void setLabelFor(int i) {
    }

    public void setLayerPaint(Paint paint) {
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setLayoutDirection(int i) {
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
    }

    public final void setLeft(int i) {
    }

    public void setLongClickable(boolean z) {
    }

    public void setMeasuredDimension(int i, int i2) {
    }

    public void setMinimumHeight(int i) {
    }

    public void setMinimumWidth(int i) {
    }

    public void setNestedScrollingEnabled(boolean z) {
    }

    public void setNextFocusDownId(int i) {
    }

    public void setNextFocusForwardId(int i) {
    }

    public void setNextFocusLeftId(int i) {
    }

    public void setNextFocusRightId(int i) {
    }

    public void setNextFocusUpId(int i) {
    }

    public void setOnApplyWindowInsetsListener(OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnContextClickListener(OnContextClickListener onContextClickListener) {
    }

    public void setOnCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
    }

    public void setOnDragListener(OnDragListener onDragListener) {
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
    }

    public void setOnGenericMotionListener(OnGenericMotionListener onGenericMotionListener) {
    }

    public void setOnHoverListener(OnHoverListener onHoverListener) {
    }

    public void setOnKeyListener(OnKeyListener onKeyListener) {
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
    }

    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener onSystemUiVisibilityChangeListener) {
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
    }

    public void setOverScrollMode(int i) {
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPivotX(float f) {
    }

    public void setPivotY(float f) {
    }

    public void setPointerIcon(PointerIcon pointerIcon) {
    }

    public void setPressed(boolean z) {
    }

    public final void setRight(int i) {
    }

    public void setRotation(float f) {
    }

    public void setRotationX(float f) {
    }

    public void setRotationY(float f) {
    }

    public void setSaveEnabled(boolean z) {
    }

    public void setSaveFromParentEnabled(boolean z) {
    }

    public void setScaleX(float f) {
    }

    public void setScaleY(float f) {
    }

    public void setScrollBarDefaultDelayBeforeFade(int i) {
    }

    public void setScrollBarFadeDuration(int i) {
    }

    public void setScrollBarSize(int i) {
    }

    public void setScrollBarStyle(int i) {
    }

    public void setScrollContainer(boolean z) {
    }

    public void setScrollIndicators(int i) {
    }

    public void setScrollIndicators(int i, int i2) {
    }

    public void setScrollX(int i) {
    }

    public void setScrollY(int i) {
    }

    public void setScrollbarFadingEnabled(boolean z) {
    }

    public void setSelected(boolean z) {
    }

    public void setSoundEffectsEnabled(boolean z) {
    }

    public void setStateListAnimator(StateListAnimator stateListAnimator) {
    }

    public void setSystemUiVisibility(int i) {
    }

    public void setTag(int i, Object obj) {
    }

    public void setTag(Object obj) {
    }

    public void setTextAlignment(int i) {
    }

    public void setTextDirection(int i) {
    }

    public final void setTop(int i) {
    }

    public void setTouchDelegate(TouchDelegate touchDelegate) {
    }

    public final void setTransitionName(String str) {
    }

    public void setTranslationX(float f) {
    }

    public void setTranslationY(float f) {
    }

    public void setTranslationZ(float f) {
    }

    public void setVerticalFadingEdgeEnabled(boolean z) {
    }

    public void setVerticalScrollBarEnabled(boolean z) {
    }

    public void setVerticalScrollbarPosition(int i) {
    }

    public void setVisibility(int i) {
    }

    public void setWillNotCacheDrawing(boolean z) {
    }

    public void setWillNotDraw(boolean z) {
    }

    public void setX(float f) {
    }

    public void setY(float f) {
    }

    public void setZ(float f) {
    }

    public boolean showContextMenu() {
        return false;
    }

    public boolean showContextMenu(float f, float f2) {
        return false;
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return null;
    }

    public void startAnimation(Animation animation) {
    }

    public final boolean startMovingTask(float f, float f2) {
        return false;
    }

    public boolean startNestedScroll(int i) {
        return false;
    }

    public void stopNestedScroll() {
    }

    public void unscheduleDrawable(Drawable drawable) {
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public final void updateDragShadow(DragShadowBuilder dragShadowBuilder) {
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return false;
    }

    public boolean willNotCacheDrawing() {
        return false;
    }

    public boolean willNotDraw() {
        return false;
    }

    public View(Context context) {
    }

    public View(Context context, AttributeSet attributeSet) {
    }

    public View(Context context, AttributeSet attributeSet, int i) {
    }

    public View(Context context, AttributeSet attributeSet, int i, int i2) {
    }

    public Object getTag(int i) {
        return false;
    }

    public static class DragShadowBuilder {
        public final View getView() {
            return null;
        }

        public void onDrawShadow(Canvas canvas) {
        }

        public void onProvideShadowMetrics(Point point, Point point2) {
        }

        public DragShadowBuilder(View view) {
        }

        public DragShadowBuilder() {
        }
    }

    public static class MeasureSpec {
        public static final int AT_MOST = Integer.MIN_VALUE;
        public static final int EXACTLY = 1073741824;
        private static final int MODE_MASK = -1073741824;
        private static final int MODE_SHIFT = 30;
        public static final int UNSPECIFIED = 0;

        public @interface MeasureSpecMode {
        }

        static int adjust(int i, int i2) {
            return 0;
        }

        public static int getMode(int i) {
            return i & MODE_MASK;
        }

        public static int getSize(int i) {
            return i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }

        public static int makeMeasureSpec(int i, int i2) {
            return 0;
        }

        public static int makeSafeMeasureSpec(int i, int i2) {
            return 0;
        }

        public static String toString(int i) {
            int mode = getMode(i);
            int size = getSize(i);
            StringBuilder sb = new StringBuilder("MeasureSpec: ");
            if (mode == 0) {
                sb.append("UNSPECIFIED ");
            } else if (mode == 1073741824) {
                sb.append("EXACTLY ");
            } else if (mode == Integer.MIN_VALUE) {
                sb.append("AT_MOST ");
            } else {
                sb.append(mode);
                sb.append(" ");
            }
            sb.append(size);
            return sb.toString();
        }
    }
}
