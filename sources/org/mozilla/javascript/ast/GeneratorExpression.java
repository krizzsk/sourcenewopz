package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;

public class GeneratorExpression extends Scope {
    private AstNode filter;
    private int ifPosition = -1;
    private List<GeneratorExpressionLoop> loops = new ArrayList();

    /* renamed from: lp */
    private int f6636lp = -1;
    private AstNode result;

    /* renamed from: rp */
    private int f6637rp = -1;

    public GeneratorExpression() {
        this.type = 162;
    }

    public GeneratorExpression(int i) {
        super(i);
        this.type = 162;
    }

    public GeneratorExpression(int i, int i2) {
        super(i, i2);
        this.type = 162;
    }

    public AstNode getResult() {
        return this.result;
    }

    public void setResult(AstNode astNode) {
        assertNotNull(astNode);
        this.result = astNode;
        astNode.setParent(this);
    }

    public List<GeneratorExpressionLoop> getLoops() {
        return this.loops;
    }

    public void setLoops(List<GeneratorExpressionLoop> list) {
        assertNotNull(list);
        this.loops.clear();
        for (GeneratorExpressionLoop addLoop : list) {
            addLoop(addLoop);
        }
    }

    public void addLoop(GeneratorExpressionLoop generatorExpressionLoop) {
        assertNotNull(generatorExpressionLoop);
        this.loops.add(generatorExpressionLoop);
        generatorExpressionLoop.setParent(this);
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
        return this.f6636lp;
    }

    public void setFilterLp(int i) {
        this.f6636lp = i;
    }

    public int getFilterRp() {
        return this.f6637rp;
    }

    public void setFilterRp(int i) {
        this.f6637rp = i;
    }

    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(250);
        sb.append("(");
        sb.append(this.result.toSource(0));
        for (GeneratorExpressionLoop source : this.loops) {
            sb.append(source.toSource(0));
        }
        if (this.filter != null) {
            sb.append(" if (");
            sb.append(this.filter.toSource(0));
            sb.append(")");
        }
        sb.append(")");
        return sb.toString();
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.result.visit(nodeVisitor);
            for (GeneratorExpressionLoop visit : this.loops) {
                visit.visit(nodeVisitor);
            }
            AstNode astNode = this.filter;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
