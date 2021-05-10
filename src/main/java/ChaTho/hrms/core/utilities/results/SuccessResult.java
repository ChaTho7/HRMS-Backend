package ChaTho.hrms.core.utilities.results;

public class SuccessResult<T> extends ResultBase<T>{

    public SuccessResult(String message) {
        super(message, true);
    }

    public SuccessResult(T data, String message) {
        super(data, message, true);
    }
}
