package uk.org.sappho.kmymoney.rawdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Value {

    private final String value;

    private final static Pattern idRegex = Pattern.compile("^([A-Z])0*([0-9]*?)$");

    public Value(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public Long getId(String requiredPrefix) throws DataNodeException {

        Long longValue = null;
        Matcher matcher = idRegex.matcher(value);
        if (matcher.matches()) {
            String digits = matcher.group(2);
            if (matcher.group(1).equals(requiredPrefix) && digits.length() > 0)
                longValue = Long.parseLong(digits);
        }
        if (longValue == null)
            throw new DataNodeException("ID value " + value + " is not actually an ID with prefix "
                    + requiredPrefix);
        return longValue;
    }

    public Long getLong() throws DataNodeException {

        try {
            return Long.parseLong(value);
        } catch (Throwable t) {
            throw new DataNodeException(" Value " + value + " is not a correctly formatted long integer");
        }
    }
}
