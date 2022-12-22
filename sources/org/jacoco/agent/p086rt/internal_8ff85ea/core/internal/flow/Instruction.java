package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.Instruction */
public class Instruction {
    private int branches = 0;
    private int coveredBranches = 0;
    private final int line;
    private Instruction predecessor;

    public Instruction(int i) {
        this.line = i;
    }

    public void addBranch() {
        this.branches++;
    }

    public void setPredecessor(Instruction instruction) {
        this.predecessor = instruction;
        instruction.addBranch();
    }

    public void setCovered() {
        Instruction instruction = this;
        while (instruction != null) {
            int i = instruction.coveredBranches;
            instruction.coveredBranches = i + 1;
            if (i == 0) {
                instruction = instruction.predecessor;
            } else {
                return;
            }
        }
    }

    public int getLine() {
        return this.line;
    }

    public int getBranches() {
        return this.branches;
    }

    public int getCoveredBranches() {
        return this.coveredBranches;
    }
}
