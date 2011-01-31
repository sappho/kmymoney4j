package uk.org.sappho.kmymoney.data;

public class NameValuePair {

    private final String name;
    private final String value;

    public NameValuePair(String name, String value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
