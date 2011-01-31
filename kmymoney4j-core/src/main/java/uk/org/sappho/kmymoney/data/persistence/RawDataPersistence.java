package uk.org.sappho.kmymoney.data.persistence;

import java.io.IOException;

import uk.org.sappho.kmymoney.data.KMyMoneyRawData;

public interface RawDataPersistence {

    public KMyMoneyRawData load() throws IOException;

    public void save(KMyMoneyRawData rawData) throws IOException;
}
