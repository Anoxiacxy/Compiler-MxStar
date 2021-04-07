package Util.Error;

import Util.Position;

public class ComplicationError extends Error {
    public ComplicationError(String message, Position position) {
        super(message, position);
    }

    @Override
    public String toString() {
        return "ComplicationError{" +
                "position=" + position +
                ", msg='" + msg + '\'' +
                '}';
    }
}
