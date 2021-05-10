package ChaTho.hrms.core.utilities.businessRules;

import ChaTho.hrms.core.utilities.results.Result;

import java.util.ArrayList;
import java.util.List;

public class BusinessRules {

    public static <T> List<Result<T>> ruleChecker(Result<T>... rules) {
        List<Result<T>> errors = new ArrayList<>();

        for (var rule : rules) {
            if (!rule.isSuccess()) {
                errors.add(rule);
            }
        }
        if (errors.size() == 0) {
            return null;
        }

        return errors;
    }
}
