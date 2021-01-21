package Util.Error;

import Util.Position;

public class InternalError extends Error {
    public InternalError(String message, Position position) {
        super(message, position);
    }

    @Override
    public String toString() {
        return "InternalError{" +
                "position=" + position +
                ", msg='" + msg + '\'' +
                '}';
    }
}
