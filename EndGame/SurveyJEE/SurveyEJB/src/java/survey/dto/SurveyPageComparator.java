/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.util.Comparator;

/**
 *
 * @author A0065956N
 */
public class SurveyPageComparator implements Comparator<SurveyPageDTO> {

    public int compare(SurveyPageDTO o1, SurveyPageDTO o2) {
        
        if (o1 == null || o2 == null || o1 == o2)
            return 0;
        
        Integer order1 = o1.getPageNo();
        Integer order2 = o2.getPageNo();
        
        return order1.compareTo(order2);
    }
}
