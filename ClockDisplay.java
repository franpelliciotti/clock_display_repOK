
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
        assert repOK(): "The class invariant is not respected.";
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * Preconditions: @param hour must be greater than or equal 
     * to zero, and lower than or equal to twenty-four.
     * @param minute must be greater than or equal 
     * to zero, and lower than or equal to sixty.
     * Postconditions:
     */
    public ClockDisplay(int hour, int minute)
    {
        if(hour < 0)
            throw new IllegalArgumentException("hour must be greater than or equal to zero");
        if(hour > 24)
            throw new IllegalArgumentException("hour must be lower than or equal to twenty-four");
        if(minute < 0)
            throw new IllegalArgumentException("minute must be greater than or equal to zero");
        if(minute > 60)
            throw new IllegalArgumentException("minute must be lower than or equal to sixty");
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
        assert repOK(): "The class invariant is not respected.";
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
        assert repOK(): "The class invariant is not respected.";
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     * Preconditions: @param hour must be greater than or equal 
     * to zero, and lower than or equal to twenty-four.
     * @param minute must be greater than or equal 
     * to zero, and lower than or equal to sixty.
     * Postconditions:
     */
    public void setTime(int hour, int minute)
    {
        if(hour < 0)
            throw new IllegalArgumentException("hour must be greater than or equal to zero");
        if(hour > 24)
            throw new IllegalArgumentException("hour must be lower than or equal to twenty-four");
        if(minute < 0)
            throw new IllegalArgumentException("minute must be greater than or equal to zero");
        if(minute > 60)
            throw new IllegalArgumentException("minute must be lower than or equal to sixty");
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
        assert repOK(): "The class invariant is not respected.";
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
        assert repOK(): "The class invariant is not respected.";
    }
    
    /**
     * Return the value of the hour in the display
     */
    public int getHour(){
        return hours.getValue();
    }
    
    /**
     * Return the value of the minutes in the display
     */
    public int getMinutes(){
        return minutes.getValue();
    }
    
    /**
     * Class invariant: getMinutes() must be greater than or equal 
     * to zero, and lower than or equal to sixty; and getHour() must
     * be greater than or equal 
     * to zero, and lower than or equal to twenty-four.
     */
    public boolean repOK(){
        return ((getMinutes() >= 0 && getMinutes() <= 60) && (getHour() >= 0 && getHour() <= 24));
    }
}