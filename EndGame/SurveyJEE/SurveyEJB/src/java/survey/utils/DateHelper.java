/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.utils;

import java.util.Calendar;

/**
 *
 * @author vivek
 */
public class DateHelper {

    public static Calendar removeTimestamp(Calendar date) {
        
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        
        return date;
    }
    
    public static boolean checkDateRange(Calendar startDate, Calendar endDate) {
        
        if (startDate == null || endDate == null)
            return true;
        
        if (endDate.after(startDate))
            return true;
        
        return false;
    }
    
    public static boolean checkDateMandatory(Calendar date) {
        
        if (date == null)
            return false;
        
        return true;
    }
    
    public static boolean checkDateAfterToday(Calendar date) {
        
        Calendar today = removeTimestamp(Calendar.getInstance());
        
        if (today.after(date))
            return true;
        
        return false;
    }
    
    public static boolean checkDateBeforeToday(Calendar date) {
        
        if (date == null)
            return true;
        
        Calendar today = removeTimestamp(Calendar.getInstance());
        
        if (today.before(date))
            return true;
        
        return false;
    }
    
    public static boolean checkDateToday(Calendar date) {
        
        Calendar today = removeTimestamp(Calendar.getInstance());
        
        if (today.equals(date))
            return true;
        
        return false;
    }
}
