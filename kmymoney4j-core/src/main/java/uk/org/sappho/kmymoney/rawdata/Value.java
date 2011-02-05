package uk.org.sappho.kmymoney.rawdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Value {

    private final String value;
    private Long id = null;
    private Long longValue = null;
    private Date date = null;

    private final static Pattern idRegex = Pattern.compile("^([A-Z])0*([0-9]*?)$");
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Value(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public Long getId(String requiredPrefix) throws DataNodeException {

        if (id == null) {
            Matcher matcher = idRegex.matcher(value);
            if (matcher.matches()) {
                String digits = matcher.group(2);
                if (matcher.group(1).equals(requiredPrefix) && digits.length() > 0)
                    id = Long.parseLong(digits);
            }
            if (id == null)
                throw new DataNodeException("ID value " + value + " is not actually an ID with prefix "
                        + requiredPrefix);
        }
        return id;
    }

    public Long getLong() throws DataNodeException {

        try {
            if (longValue == null)
                longValue = Long.parseLong(value);
            return longValue;
        } catch (Throwable t) {
            throw new DataNodeException("Value " + value + " is not a correctly formatted long integer");
        }
    }

    public Date getDate() throws DataNodeException {

        try {
            if (date == null)
                date = dateFormat.parse(value);
            return date;
        } catch (Throwable t) {
            throw new DataNodeException("Value " + value + " is not a correctly formatted date");
        }
    }
}
