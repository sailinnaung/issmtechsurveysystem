/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.mockDataForTesting;

import java.util.ArrayList;
import java.util.Iterator;
import survey.dto.FunctionDTO;
import survey.dto.RoleDTO;
import survey.dto.UserDTO;
import survey.dto.UserDTO;

/**
 *
 * @author Sai Lin Naung
 */
public class MockDataInterface {

    ArrayList<UserDTO> usrList=new ArrayList<UserDTO>();
    ArrayList<RoleDTO> roleList=new ArrayList<RoleDTO>();
    ArrayList<FunctionDTO> funcList= new ArrayList<FunctionDTO>();;

    public MockDataInterface(){
        ArrayList<FunctionDTO> rshrFuncList = new ArrayList<FunctionDTO>();
        ArrayList<FunctionDTO> rspdFuncList = new ArrayList<FunctionDTO>();
        ArrayList<FunctionDTO> adminFuncList = new ArrayList<FunctionDTO>();

        FunctionDTO f1 = populateFunctionDTO("f1", 1, "View Survey", null, 1);
        funcList.add(f1);
        rshrFuncList.add(f1);
        rspdFuncList.add(f1);
        adminFuncList.add(f1);
        FunctionDTO f2 = populateFunctionDTO("f2", 2, "Create Questionnaire", null, 2);
        funcList.add(f2);
        rshrFuncList.add(f2);
        FunctionDTO f3 = populateFunctionDTO("f3", 3, "Search Questionnaire", null, 3);
        funcList.add(f3);
        rshrFuncList.add(f3);
        rspdFuncList.add(f3);
        adminFuncList.add(f3);
        FunctionDTO f4 = populateFunctionDTO("f4", 4, "View Survey Report", null, 4);
        funcList.add(f4);
        rshrFuncList.add(f4);
        rspdFuncList.add(f4);
        adminFuncList.add(f4);
        FunctionDTO f5 = populateFunctionDTO("f5", 5, "Create User", null, 5);
        funcList.add(f5);
        adminFuncList.add(f5);
        FunctionDTO f6 = populateFunctionDTO("f6", 6, "Edit User", null, 6);
        funcList.add(f6);
        adminFuncList.add(f6);
        FunctionDTO f7 = populateFunctionDTO("f7", 7, "Search User", null, 7);
        funcList.add(f7);
        adminFuncList.add(f7);
        FunctionDTO f8 = populateFunctionDTO("f8", 8, "Create Role", null, 8);
        funcList.add(f8);
        adminFuncList.add(f8);
        FunctionDTO f9 = populateFunctionDTO("f9", 9, "Edit Role", null, 9);
        funcList.add(f9);
        adminFuncList.add(f9);
        FunctionDTO f10 = populateFunctionDTO("f10", 10, "Create Function", null, 10);
        funcList.add(f10);
        adminFuncList.add(f10);
        FunctionDTO f11 = populateFunctionDTO("f11", 11, "Edit Function", null, 11);
        funcList.add(f11);
        adminFuncList.add(f11);
       

        ArrayList<RoleDTO> john_roleList = new ArrayList<RoleDTO>();
        ArrayList<RoleDTO> tom_roleList = new ArrayList<RoleDTO>();
        ArrayList<RoleDTO> harry_roleList = new ArrayList<RoleDTO>();

        RoleDTO r1 = populateRoleDTO(1, "Researcher", null, rshrFuncList);
        john_roleList.add(r1);
        roleList.add(r1);
        RoleDTO r2 = populateRoleDTO(2, "Respondant", null, rspdFuncList);
        roleList.add(r2);
        john_roleList.add(r2);
        tom_roleList.add(r2);
        harry_roleList.add(r2);
        RoleDTO r3 = populateRoleDTO(3, "Admin", null, adminFuncList);
        roleList.add(r3);
        harry_roleList.add(r3);

        UserDTO john = populateUserDTO("John", "john", "john@gmail.com", r1);
        UserDTO tom = populateUserDTO("Tom", "tom", "tom@gmail.com", r2);
        UserDTO harry = populateUserDTO("Harry", "harry", "harry@gmail.com", r3);

        usrList.add(john);
        usrList.add(tom);
        usrList.add(harry);

        System.out.println("John, Tom, Harry objects created");
    }

    private UserDTO populateUserDTO(String name,String password, String email,RoleDTO role){
        UserDTO usr = new UserDTO();
        usr.setDeleteFlg(false);
        usr.setEmail(email);
        usr.setPassword(password);
        usr.setUsername(name);
        usr.setRole(role);
        System.out.println("inside populateUserDTO");
        return usr;
    }

    private FunctionDTO populateFunctionDTO(String code, int id,String name,String desc,int order){
        FunctionDTO fDto = new FunctionDTO();
        fDto.setCode(code);
        fDto.setFunctionID(id);
        fDto.setName(name);
        fDto.setDescription(desc);
        fDto.setOrder(order);

        return fDto;
    }

    private RoleDTO populateRoleDTO(int id,String name,String desc,ArrayList<FunctionDTO> funcArr){
        RoleDTO rDto = new RoleDTO();
        rDto.setRoleID(id);
        rDto.setName(name);
        rDto.setDescription(desc);
        rDto.setFunctions(funcArr);

        return rDto;
    }

    public UserDTO getUserByUserName(String userName){
        UserDTO usr=null;
        Iterator<UserDTO> usrItr = usrList.iterator();
        while(usrItr.hasNext()){
            UserDTO myUsr = usrItr.next();
            System.out.println("myUsr.getUsername() :"+myUsr.getUsername());
            if(myUsr.getUsername().equals(userName)){
                usr = myUsr;
                break;
            }
        }
        return usr;
    }

}
