package com.didichuxing.omega.sdk.uicomponents.treeview.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.didichuxing.omega.sdk.uicomponents.treeview.holder.SimpleViewHolder;
import com.didichuxing.omega.sdk.uicomponents.treeview.model.TreeNode;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AndroidTreeView {
    private static final String NODES_PATH_SEPARATOR = ";";
    private boolean applyForRoot;
    private int containerStyle = 0;
    private Class<? extends TreeNode.BaseNodeViewHolder> defaultViewHolderClass = SimpleViewHolder.class;
    private Context mContext;
    private TreeNode mRoot;
    private boolean mSelectionModeEnabled;
    private boolean mUseDefaultAnimation = false;
    /* access modifiers changed from: private */
    public TreeNode.TreeNodeClickListener nodeClickListener;
    /* access modifiers changed from: private */
    public TreeNode.TreeNodeLongClickListener nodeLongClickListener;
    private boolean use2dScroll = false;

    public AndroidTreeView(Context context, TreeNode treeNode) {
        this.mRoot = treeNode;
        this.mContext = context;
    }

    public void setDefaultAnimation(boolean z) {
        this.mUseDefaultAnimation = z;
    }

    public void setDefaultContainerStyle(int i) {
        setDefaultContainerStyle(i, false);
    }

    public void setDefaultContainerStyle(int i, boolean z) {
        this.containerStyle = i;
        this.applyForRoot = z;
    }

    public void setUse2dScroll(boolean z) {
        this.use2dScroll = z;
    }

    public boolean is2dScrollEnabled() {
        return this.use2dScroll;
    }

    public void setDefaultViewHolder(Class<? extends TreeNode.BaseNodeViewHolder> cls) {
        this.defaultViewHolderClass = cls;
    }

    public void setDefaultNodeClickListener(TreeNode.TreeNodeClickListener treeNodeClickListener) {
        this.nodeClickListener = treeNodeClickListener;
    }

    public void setDefaultNodeLongClickListener(TreeNode.TreeNodeLongClickListener treeNodeLongClickListener) {
        this.nodeLongClickListener = treeNodeLongClickListener;
    }

    public void expandAll() {
        expandNode(this.mRoot, true);
    }

    public void collapseAll() {
        for (TreeNode collapseNode : this.mRoot.getChildren()) {
            collapseNode(collapseNode, true);
        }
    }

    public View getView(int i) {
        ViewGroup viewGroup;
        if (i > 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.mContext, i);
            viewGroup = this.use2dScroll ? new TwoDScrollView(contextThemeWrapper) : new ScrollView(contextThemeWrapper);
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            ScrollView scrollView = new ScrollView(this.mContext);
            scrollView.setLayoutParams(layoutParams);
            viewGroup = this.use2dScroll ? new TwoDScrollView(this.mContext) : scrollView;
        }
        Context context = this.mContext;
        if (this.containerStyle != 0 && this.applyForRoot) {
            context = new ContextThemeWrapper(this.mContext, this.containerStyle);
        }
        final LinearLayout linearLayout = new LinearLayout(context, (AttributeSet) null, this.containerStyle);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setId(R.id.omega_uic_tree_items);
        linearLayout.setOrientation(1);
        viewGroup.addView(linearLayout);
        this.mRoot.setViewHolder(new TreeNode.BaseNodeViewHolder(this.mContext) {
            public View createNodeView(TreeNode treeNode, Object obj) {
                return null;
            }

            public ViewGroup getNodeItemsView() {
                return linearLayout;
            }
        });
        expandNode(this.mRoot, false);
        return viewGroup;
    }

    public View getView() {
        return getView(-1);
    }

    public void expandLevel(int i) {
        for (TreeNode expandLevel : this.mRoot.getChildren()) {
            expandLevel(expandLevel, i);
        }
    }

    private void expandLevel(TreeNode treeNode, int i) {
        if (treeNode.getLevel() <= i) {
            expandNode(treeNode, false);
        }
        for (TreeNode expandLevel : treeNode.getChildren()) {
            expandLevel(expandLevel, i);
        }
    }

    public void expandNode(TreeNode treeNode) {
        expandNode(treeNode, false);
    }

    public void collapseNode(TreeNode treeNode) {
        collapseNode(treeNode, false);
    }

    public String getSaveState() {
        StringBuilder sb = new StringBuilder();
        getSaveState(this.mRoot, sb);
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public void restoreState(String str) {
        if (!TextUtils.isEmpty(str)) {
            collapseAll();
            restoreNodeState(this.mRoot, new HashSet(Arrays.asList(str.split(NODES_PATH_SEPARATOR))));
        }
    }

    private void restoreNodeState(TreeNode treeNode, Set<String> set) {
        for (TreeNode next : treeNode.getChildren()) {
            if (set.contains(next.getPath())) {
                expandNode(next);
                restoreNodeState(next, set);
            }
        }
    }

    private void getSaveState(TreeNode treeNode, StringBuilder sb) {
        for (TreeNode next : treeNode.getChildren()) {
            if (next.isExpanded()) {
                sb.append(next.getPath());
                sb.append(NODES_PATH_SEPARATOR);
                getSaveState(next, sb);
            }
        }
    }

    /* access modifiers changed from: private */
    public void toggleNode(TreeNode treeNode) {
        if (treeNode.isExpanded()) {
            collapseNode(treeNode, false);
        } else {
            expandNode(treeNode, false);
        }
    }

    private void collapseNode(TreeNode treeNode, boolean z) {
        treeNode.setExpanded(false);
        TreeNode.BaseNodeViewHolder viewHolderForNode = getViewHolderForNode(treeNode);
        if (this.mUseDefaultAnimation) {
            collapse(viewHolderForNode.getNodeItemsView());
        } else {
            viewHolderForNode.getNodeItemsView().setVisibility(8);
        }
        viewHolderForNode.toggle(false);
        if (z) {
            for (TreeNode collapseNode : treeNode.getChildren()) {
                collapseNode(collapseNode, z);
            }
        }
    }

    private void expandNode(TreeNode treeNode, boolean z) {
        treeNode.setExpanded(true);
        TreeNode.BaseNodeViewHolder viewHolderForNode = getViewHolderForNode(treeNode);
        viewHolderForNode.getNodeItemsView().removeAllViews();
        viewHolderForNode.toggle(true);
        for (TreeNode next : treeNode.getChildren()) {
            addNode(viewHolderForNode.getNodeItemsView(), next);
            if (next.isExpanded() || z) {
                expandNode(next, z);
            }
        }
        if (this.mUseDefaultAnimation) {
            expand(viewHolderForNode.getNodeItemsView());
        } else {
            viewHolderForNode.getNodeItemsView().setVisibility(0);
        }
    }

    private void addNode(ViewGroup viewGroup, final TreeNode treeNode) {
        TreeNode.BaseNodeViewHolder viewHolderForNode = getViewHolderForNode(treeNode);
        View view = viewHolderForNode.getView();
        viewGroup.addView(view);
        boolean z = this.mSelectionModeEnabled;
        if (z) {
            viewHolderForNode.toggleSelectionMode(z);
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (treeNode.getClickListener() != null) {
                    TreeNode.TreeNodeClickListener clickListener = treeNode.getClickListener();
                    TreeNode treeNode = treeNode;
                    clickListener.onClick(treeNode, treeNode.getValue());
                } else if (AndroidTreeView.this.nodeClickListener != null) {
                    TreeNode.TreeNodeClickListener access$000 = AndroidTreeView.this.nodeClickListener;
                    TreeNode treeNode2 = treeNode;
                    access$000.onClick(treeNode2, treeNode2.getValue());
                }
                AndroidTreeView.this.toggleNode(treeNode);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (treeNode.getLongClickListener() != null) {
                    TreeNode.TreeNodeLongClickListener longClickListener = treeNode.getLongClickListener();
                    TreeNode treeNode = treeNode;
                    return longClickListener.onLongClick(treeNode, treeNode.getValue());
                } else if (AndroidTreeView.this.nodeLongClickListener == null) {
                    return false;
                } else {
                    TreeNode.TreeNodeLongClickListener access$200 = AndroidTreeView.this.nodeLongClickListener;
                    TreeNode treeNode2 = treeNode;
                    return access$200.onLongClick(treeNode2, treeNode2.getValue());
                }
            }
        });
    }

    public void setSelectionModeEnabled(boolean z) {
        if (!z) {
            deselectAll();
        }
        this.mSelectionModeEnabled = z;
        for (TreeNode treeNode : this.mRoot.getChildren()) {
            toggleSelectionMode(treeNode, z);
        }
    }

    public <E> List<E> getSelectedValues(Class<E> cls) {
        ArrayList arrayList = new ArrayList();
        for (TreeNode value : getSelected()) {
            Object value2 = value.getValue();
            if (value2 != null && value2.getClass().equals(cls)) {
                arrayList.add(value2);
            }
        }
        return arrayList;
    }

    public boolean isSelectionModeEnabled() {
        return this.mSelectionModeEnabled;
    }

    private void toggleSelectionMode(TreeNode treeNode, boolean z) {
        toogleSelectionForNode(treeNode, z);
        if (treeNode.isExpanded()) {
            for (TreeNode treeNode2 : treeNode.getChildren()) {
                toggleSelectionMode(treeNode2, z);
            }
        }
    }

    public List<TreeNode> getSelected() {
        if (this.mSelectionModeEnabled) {
            return getSelected(this.mRoot);
        }
        return new ArrayList();
    }

    private List<TreeNode> getSelected(TreeNode treeNode) {
        ArrayList arrayList = new ArrayList();
        for (TreeNode next : treeNode.getChildren()) {
            if (next.isSelected()) {
                arrayList.add(next);
            }
            arrayList.addAll(getSelected(next));
        }
        return arrayList;
    }

    public void selectAll(boolean z) {
        makeAllSelection(true, z);
    }

    public void deselectAll() {
        makeAllSelection(false, false);
    }

    private void makeAllSelection(boolean z, boolean z2) {
        if (this.mSelectionModeEnabled) {
            for (TreeNode selectNode : this.mRoot.getChildren()) {
                selectNode(selectNode, z, z2);
            }
        }
    }

    public void selectNode(TreeNode treeNode, boolean z) {
        if (this.mSelectionModeEnabled) {
            treeNode.setSelected(z);
            toogleSelectionForNode(treeNode, true);
        }
    }

    private void selectNode(TreeNode treeNode, boolean z, boolean z2) {
        treeNode.setSelected(z);
        boolean z3 = true;
        toogleSelectionForNode(treeNode, true);
        if (z2) {
            z3 = treeNode.isExpanded();
        }
        if (z3) {
            for (TreeNode selectNode : treeNode.getChildren()) {
                selectNode(selectNode, z, z2);
            }
        }
    }

    private void toogleSelectionForNode(TreeNode treeNode, boolean z) {
        if (getViewHolderForNode(treeNode).isInitialized()) {
            getViewHolderForNode(treeNode).toggleSelectionMode(z);
        }
    }

    private TreeNode.BaseNodeViewHolder getViewHolderForNode(TreeNode treeNode) {
        TreeNode.BaseNodeViewHolder viewHolder = treeNode.getViewHolder();
        if (viewHolder == null) {
            try {
                viewHolder = (TreeNode.BaseNodeViewHolder) this.defaultViewHolderClass.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext});
                treeNode.setViewHolder(viewHolder);
            } catch (Exception unused) {
                throw new RuntimeException("Could not instantiate class " + this.defaultViewHolderClass);
            }
        }
        if (viewHolder.getContainerStyle() <= 0) {
            viewHolder.setContainerStyle(this.containerStyle);
        }
        if (viewHolder.getTreeView() == null) {
            viewHolder.setTreeViev(this);
        }
        return viewHolder;
    }

    private static void expand(final View view) {
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        C161634 r1 = new Animation() {
            public boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = f == 1.0f ? -2 : (int) (((float) measuredHeight) * f);
                view.requestLayout();
            }
        };
        r1.setDuration((long) ((int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density)));
        view.startAnimation(r1);
    }

    private static void collapse(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        C161645 r1 = new Animation() {
            public boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    view.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i = measuredHeight;
                layoutParams.height = i - ((int) (((float) i) * f));
                view.requestLayout();
            }
        };
        r1.setDuration((long) ((int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density)));
        view.startAnimation(r1);
    }

    public void addNode(TreeNode treeNode, TreeNode treeNode2) {
        treeNode.addChild(treeNode2);
        if (treeNode.isExpanded()) {
            addNode(getViewHolderForNode(treeNode).getNodeItemsView(), treeNode2);
        }
    }

    public void removeNode(TreeNode treeNode) {
        if (treeNode.getParent() != null) {
            TreeNode parent = treeNode.getParent();
            int deleteChild = parent.deleteChild(treeNode);
            if (parent.isExpanded() && deleteChild >= 0) {
                getViewHolderForNode(parent).getNodeItemsView().removeViewAt(deleteChild);
            }
        }
    }
}
