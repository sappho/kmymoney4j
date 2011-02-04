package uk.org.sappho.kmymoney.rawdata;

public class NameValuePair {

    private final String name;
    private final Value value;

    public NameValuePair(String name, Value value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }
}
