package uk.org.sappho.kmymoney.rawdata;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.Fraction;

public class Value {

    private String value;
    private Long id = null;
    private Long longValue = null;
    private Date date = null;
    private Fraction fraction = null;

    private final static Pattern idRegex = Pattern.compile("^([A-Z])0*([0-9]*?)$");
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Value(String value) {

        this.value = value;
    }

    @Override
    public String toString() {

        return value;
    }

    public long getId(String requiredPrefix) throws DataNodeException {

        return getId(requiredPrefix, new String[] {});
    }

    public long getId(String requiredPrefix, String[] reservedIds) throws DataNodeException {

        if (id == null) {
            boolean isReserved = false;
            for (String reservedId : reservedIds)
                if (value.equals(reservedId)) {
                    isReserved = true;
                    break;
                }
            if (isReserved)
                id = 0L;
            else {
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
        }
        return id;
    }

    public void setId(long id, String requiredPrefix, DecimalFormat format) {

        value = requiredPrefix + format.format(id);
        this.id = id;
    }

    public long getLong() throws DataNodeException {

        try {
            if (longValue == null)
                longValue = Long.parseLong(value);
            return longValue;
        } catch (Throwable t) {
            throw new DataNodeException("Value " + value + " is not a correctly formatted long integer");
        }
    }

    public void setLong(long value) {

        this.value = "" + value;
        longValue = value;
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

    public void setDate(Date date) {

        value = dateFormat.format(date);
        this.date = date;
    }

    public Fraction getFraction() throws DataNodeException {

        try {
            if (fraction == null)
                fraction = Fraction.getFraction(value);
            return fraction;
        } catch (Throwable t) {
            throw new DataNodeException("Value " + value + " is not a correctly formatted fractional value");
        }
    }
}
