package uk.org.sappho.kmymoney.data.persistence.file;

import java.io.IOException;

import org.junit.Test;

import uk.org.sappho.kmymoney.data.KMyMoneyRawData;

public class FilenameRawDataPersistenceTest {

    @Test
    public void shouldReadFile() throws IOException {

        FilenameRawDataPersistence persistence = new FilenameRawDataPersistence(
                "test.xml");
        KMyMoneyRawData data = persistence.load();
        persistence.save(data);
    }
}
