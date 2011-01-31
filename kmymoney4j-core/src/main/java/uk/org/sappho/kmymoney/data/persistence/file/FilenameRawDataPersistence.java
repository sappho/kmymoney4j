package uk.org.sappho.kmymoney.data.persistence.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import uk.org.sappho.kmymoney.data.KMyMoneyRawData;

public class FilenameRawDataPersistence extends AbstractRawDataPersistence {

    private final String filename;

    public FilenameRawDataPersistence(String filename) {

        super();
        this.filename = filename;
    }

    public KMyMoneyRawData load() throws IOException {

        return load(new FileInputStream(filename));
    }

    public void save(KMyMoneyRawData rawData) throws IOException {

        save(rawData, new FileOutputStream(filename));
    }

}
