package Util.Error;

import Util.Position;

public abstract class Error extends RuntimeException {
    protected Position position;
    protected String msg;

    public Error(String message, Position position) {
        this.msg = message;
        this.position = position;
    }

    @Override
    public String toString() {
        return "BaseError{" +
                "position=" + position +
                ", msg='" + msg + '\'' +
                '}';
    }
}
