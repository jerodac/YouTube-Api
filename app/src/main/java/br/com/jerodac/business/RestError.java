package br.com.jerodac.business;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class RestError {

    private Exception exception;
    private boolean connectionError;

    public RestError(Exception e) {
        exception = e;

    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean isConnectionError() {
        return connectionError;
    }

    public void setConnectionError(boolean connectionError) {
        this.connectionError = connectionError;
    }
}
