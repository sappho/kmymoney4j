package uk.org.sappho.kmymoney.rawdata.persistence.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import uk.org.sappho.kmymoney.rawdata.RawData;

public class FilenameRawDataPersistence extends AbstractRawDataPersistence {

    private final String filename;

    public FilenameRawDataPersistence(String filename) {

        super();
        this.filename = filename;
    }

    public RawData load() throws IOException {

        return load(new FileInputStream(filename));
    }

    public void save(RawData rawData) throws IOException {

        save(rawData, new FileOutputStream(filename));
    }

}
