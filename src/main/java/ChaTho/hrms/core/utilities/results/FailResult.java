package ChaTho.hrms.core.utilities.results;

public class FailResult<T> extends ResultBase<T>{

    public FailResult(String message) {
        super(message, false);
    }

    public FailResult(T data, String message) {
        super(data, message, false);
    }
}
