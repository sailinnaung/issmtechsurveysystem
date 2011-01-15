
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;




import com.opensymphony.xwork2.ActionSupport;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import survey.delegates.UserDelegate;
import survey.dto.UserDTO;
import survey.exception.DAOException;
import survey.exception.RecordExistsException;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahsa
 */

public class UserManagementAction extends ActionSupport {
 private List<UserDTO> users;
    private String username;

    private UserDTO user = new UserDTO();
    private UserDelegate delegate = new UserDelegate();
    public static final String Open_user_list = "UserList";
    public static final String Open_New_User_Form = "NewUserForm";
    public static final String Open_Update_Form = "UpdateForm";
    public static final String Update_user = "UpdateUser";
    public static final String Add_User = "AddUser";
    public static final String Delete_User = "DeleteUser";

    public String openUserList() {
        users = delegate.getUsersByRoleName("ADMIN"); // later check
        System.out.println("############## in open user list" + String.valueOf(users.size()));
        return Open_user_list;
    }
    public String openUpdateForm() {
        try{
            user = delegate.getUserByUserName(username);
        }catch(RemoteException e){
            e.printStackTrace();
            return "failure";
        }
        
        return Open_Update_Form;
    }
    public String openNewUserForm() {
        user=new UserDTO();
        System.out.println("############## in open new user form");

        return Open_New_User_Form;
    }
    public String update() {
          System.out.println("############## in update");
          System.out.println("$$$$$$$$$$$"+username);
       
        return Update_user;
    }
    public String delete() {
         System.out.println("############## in delete");
     return Delete_User;
    }
    public String addUser() {
        try {
            System.out.println("Before creating user");
            user = delegate.createUser(user);
            System.out.println("Create User successful");
            username = user.getUsername();
            System.out.println("############## in addUser");
        } catch (DAOException ex) {
            Logger.getLogger(UserManagementAction.class.getName()).log(Level.SEVERE, null, ex);
            return "failure";
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagementAction.class.getName()).log(Level.SEVERE, null, ex);
            return "failure";
        } catch (RecordExistsException ex) {
            Logger.getLogger(UserManagementAction.class.getName()).log(Level.SEVERE, null, ex);
            return "failure";
        }
        return Add_User;
    }

  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<UserDTO> getUsers() {
        System.out.println("@@@@@@@@@@@@ in g");
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}