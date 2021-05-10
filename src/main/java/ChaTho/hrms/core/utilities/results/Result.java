package ChaTho.hrms.core.utilities.results;

public interface Result<T> {
    T getData();
    String getMessage();
    boolean isSuccess();
}
