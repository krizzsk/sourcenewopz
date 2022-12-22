package org.mozilla.javascript.ast;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.List;

public class ArrayComprehension extends Scope {
    private AstNode filter;
    private int ifPosition = -1;
    private List<ArrayComprehensionLoop> loops = new ArrayList();

    /* renamed from: lp */
    private int f6626lp = -1;
    private AstNode result;

    /* renamed from: rp */
    private int f6627rp = -1;

    public ArrayComprehension() {
        this.type = 157;
    }

    public ArrayComprehension(int i) {
        super(i);
        this.type = 157;
    }

    public ArrayComprehension(int i, int i2) {
        super(i, i2);
        this.type = 157;
    }

    public AstNode getResult() {
        return this.result;
    }

    public void setResult(AstNode astNode) {
        assertNotNull(astNode);
        this.result = astNode;
        astNode.setParent(this);
    }

    public List<ArrayComprehensionLoop> getLoops() {
        return this.loops;
    }

    public void setLoops(List<ArrayComprehensionLoop> list) {
        assertNotNull(list);
        this.loops.clear();
        for (ArrayComprehensionLoop addLoop : list) {
            addLoop(addLoop);
        }
    }

    public void addLoop(ArrayComprehensionLoop arrayComprehensionLoop) {
        assertNotNull(arrayComprehensionLoop);
        this.loops.add(arrayComprehensionLoop);
        arrayComprehensionLoop.setParent(this);
    }

    public AstNode getFilter() {
        return this.filter;
    }

    public void setFilter(AstNode astNode) {
        this.filter = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public int getIfPosition() {
        return this.ifPosition;
    }

    public void setIfPosition(int i) {
        this.ifPosition = i;
    }

    public int getFilterLp() {
        return this.f6626lp;
    }

    public void setFilterLp(int i) {
        this.f6626lp = i;
    }

    public int getFilterRp() {
        return this.f6627rp;
    }

    public void setFilterRp(int i) {
        this.f6627rp = i;
    }

    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(250);
        sb.append(Const.jaLeft);
        sb.append(this.result.toSource(0));
        for (ArrayComprehensionLoop source : this.loops) {
            sb.append(source.toSource(0));
        }
        if (this.filter != null) {
            sb.append(" if (");
            sb.append(this.filter.toSource(0));
            sb.append(")");
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.result.visit(nodeVisitor);
            for (ArrayComprehensionLoop visit : this.loops) {
                visit.visit(nodeVisitor);
            }
            AstNode astNode = this.filter;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
