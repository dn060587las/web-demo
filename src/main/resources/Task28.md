
## Task28
- Create class which implements CalendarProvider
- Implement validation of input parameters
- Create unit tests to check all cases with CalendarProvider

```java

class Day {
    private int numInWeek;
    private int numInmonth;
    private String name;    
}

class Month {
    private String name;
    private int num;
    private int year;
    private List<Day> days;
}

class InvalidFiscalDateFormatException extends Exception {
    //override constructors
};


class InvalidDayInYearException extends Exception {
    //override constructors
};

interface CalendarInputValidator {
    //methods to validate input parameters
}

public interface CalendarProvider {
    
    List<Month> getMonthes(int fiscalDateFrom, int fiscalDateTo) throws InvalidFiscalDateFormatException;
    
    Month getDayInfo(int year, int dayInYear) throws InvalidDayInYearException;
        
    List<String> getMonthesFormatted(int fiscalDateFrom, int fiscalDateTo) throws InvalidFiscalDateFormatException;
}
```
