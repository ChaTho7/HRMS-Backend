package ChaTho.hrms.core.utilities.filing.local;

import ChaTho.hrms.core.abstracts.File;

public abstract class LocalFilingBase {
    public abstract String getPath();
    public abstract void filing(File file, String uuid);
}
