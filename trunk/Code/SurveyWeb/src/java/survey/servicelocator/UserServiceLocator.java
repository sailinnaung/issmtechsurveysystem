/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.servicelocator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import survey.bpo.UserFacadeRemote;
import survey.config.LookUpConfig;

/**
 *
 * @author Sai Lin Naung
 */
public class UserServiceLocator {

    private InitialContext initCtx = null;
    private static UserServiceLocator locator = null;

    static{
        locator = new UserServiceLocator();
    }

    private UserServiceLocator(){
        try{
            initCtx = new InitialContext();
        }catch(Exception e){
            e.printStackTrace(); // later will use log4j for logging
        }
    }

    public static UserServiceLocator getInstance(){
        return locator;
    }

    public UserFacadeRemote lookupUserFacadeBean(){
        UserFacadeRemote usrFR = null;
        try{
            usrFR = (UserFacadeRemote) initCtx.lookup(LookUpConfig.UserFacadeBeanLookUp);
        }
        catch(NamingException ne){
            ne.printStackTrace();            
        }
        return usrFR;
    }
}
