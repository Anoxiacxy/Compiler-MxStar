package Util;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Position {
    private int row, col;

    public Position() {
        this.row = 0;
        this.col = 0;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(Token token) {
        this.row = token.getLine();
        this.col = token.getCharPositionInLine();
    }

    public Position(TerminalNode terminalNode) {
        this(terminalNode.getSymbol());
    }

    public Position(ParserRuleContext parserRuleContext) {
        this(parserRuleContext.getStart());
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "(row: " + row + ", col: " + col + ")";
    }
}