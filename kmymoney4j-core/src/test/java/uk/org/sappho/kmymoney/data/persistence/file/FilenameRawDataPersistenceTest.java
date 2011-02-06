package uk.org.sappho.kmymoney.data.persistence.file;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.junit.Test;

import uk.org.sappho.kmymoney.data.KMyMoneyData;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.RawData;
import uk.org.sappho.kmymoney.rawdata.persistence.file.FilenameRawDataPersistence;

public class FilenameRawDataPersistenceTest {

    @Test
    public void shouldReadFile() throws IOException, IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        FilenameRawDataPersistence persistence = new FilenameRawDataPersistence(
                "../../money-data/Andrew-Money.xml");
        RawData rawdata = persistence.load();
        KMyMoneyData data = new KMyMoneyData(rawdata.getRootNode());
        data.getPayees().add("Colourfull Character");
        data.setLastUpdated(new Date());
        persistence.save(rawdata);
    }
}
