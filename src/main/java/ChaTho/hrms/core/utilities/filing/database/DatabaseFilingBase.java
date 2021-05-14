package ChaTho.hrms.core.utilities.filing.database;

import ChaTho.hrms.core.abstracts.File;
import ChaTho.hrms.core.utilities.filing.Filing;

public abstract class DatabaseFilingBase implements Filing {
    public abstract byte[] fileToBytes(File file);
}
