package ChaTho.hrms.core.utilities.results;

import lombok.Data;

@Data
public class ResultBase<T> implements Result<T> {
    private T data;
    private String message;
    private boolean success;

    public ResultBase(String message, boolean success) {
        super();
        this.message = message;
        this.success = success;
    }

    public ResultBase(T data, String message, boolean success) {
        super();
        this.data = data;
        this.message = message;
        this.success = success;
    }

}
