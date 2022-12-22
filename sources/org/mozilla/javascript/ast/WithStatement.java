package org.mozilla.javascript.ast;

public class WithStatement extends AstNode {
    private AstNode expression;

    /* renamed from: lp */
    private int f6646lp = -1;

    /* renamed from: rp */
    private int f6647rp = -1;
    private AstNode statement;

    public WithStatement() {
        this.type = 123;
    }

    public WithStatement(int i) {
        super(i);
        this.type = 123;
    }

    public WithStatement(int i, int i2) {
        super(i, i2);
        this.type = 123;
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public AstNode getStatement() {
        return this.statement;
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    public int getLp() {
        return this.f6646lp;
    }

    public void setLp(int i) {
        this.f6646lp = i;
    }

    public int getRp() {
        return this.f6647rp;
    }

    public void setRp(int i) {
        this.f6647rp = i;
    }

    public void setParens(int i, int i2) {
        this.f6646lp = i;
        this.f6647rp = i2;
    }

    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("with (");
        sb.append(this.expression.toSource(0));
        sb.append(") ");
        if (this.statement.getType() == 129) {
            sb.append(this.statement.toSource(i).trim());
            sb.append("\n");
        } else {
            sb.append("\n");
            sb.append(this.statement.toSource(i + 1));
        }
        return sb.toString();
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
            this.statement.visit(nodeVisitor);
        }
    }
}
