/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.servicelocator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import survey.bpo.RoleFacadeRemote;
import survey.config.LookUpConfig;

/**
 *
 * @author a0005933L
 */
public class RoleServiceLocator {
    
    private InitialContext initCtx = null;
    private static RoleServiceLocator locator = null;
    
    static{
        locator = new RoleServiceLocator();
    }
    
    private RoleServiceLocator(){
        try{
            initCtx = new InitialContext();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static RoleServiceLocator getInstance(){
        return locator;
    }
    
    public RoleFacadeRemote loopupRoleFacade(){
        RoleFacadeRemote rFR = null;
        try{
            rFR = (RoleFacadeRemote)initCtx.lookup(LookUpConfig.RoleFacadeBeanLookUp);
        }catch(NamingException ne){
            ne.printStackTrace();                   
        }
        return rFR;
    }
}
