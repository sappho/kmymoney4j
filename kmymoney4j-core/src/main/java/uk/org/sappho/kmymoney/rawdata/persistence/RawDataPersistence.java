package uk.org.sappho.kmymoney.rawdata.persistence;

import java.io.IOException;

import uk.org.sappho.kmymoney.rawdata.RawData;

public interface RawDataPersistence {

    public RawData load() throws IOException;

    public void save(RawData rawData) throws IOException;
}
