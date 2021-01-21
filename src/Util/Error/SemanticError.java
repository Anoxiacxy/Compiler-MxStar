package Util.Error;

import Util.Position;

public class SemanticError extends Error {
    public SemanticError(String message, Position position) {
        super(message, position);
    }

    @Override
    public String toString() {
        return "SemanticError{" +
                "position=" + position +
                ", msg='" + msg + '\'' +
                '}';
    }
}
