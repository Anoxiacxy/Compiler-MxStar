package Util.Error;

import Util.Position;

public class SyntaxError extends Error {

    public SyntaxError(String message, Position position) {
        super(message, position);
    }

    @Override
    public String toString() {
        return "SyntaxError{" +
                "position=" + position +
                ", msg='" + msg + '\'' +
                '}';
    }
}
