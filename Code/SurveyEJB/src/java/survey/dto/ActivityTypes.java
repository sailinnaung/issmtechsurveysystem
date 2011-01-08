/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

/**
 *
 * @author A0065956N
 */
public enum ActivityTypes {

    OPEN,   // Just created and never saved
    DRAFT,  // Saved but not submitted
    SUBMIT, // Submitted
    // Closed (could happen when a change is made to a submitted entity. 
    // Previous entity set to closed and new entity set to Submit on submit)
    CLOSE,
    INVALID // Deleted/Invalid
}
