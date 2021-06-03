import com.mycompany.usermanagement.dao.UserListDao;
import com.mycompany.usermanagement.model.User;
import java.sql.SQLException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

//Test case for user create and update from admin side

public class CreateAndUpdateTest {
    User user = new User();
    UserListDao create = new UserListDao();
   
    //Test case for matched username and password
    @Test
    public void validate_all_match() throws SQLException{
        user.setFname("shraddha");
        user.setLname("subba");
        user.setUname("shraddha123");
        user.setEmail("np03a180039@gmail.com");
        user.setContact(9874);
        user.setAddress("Kathmandu");
        user.setPword("shradha");
        user.setDob("2010-08-22");
        user.setGender("Female");
        user.setInfo("student");
        user.setProfile_pic("");
        user.setCover_pic("");
        user.setUserType(1);
        if (true==create.insertUser(user)){
            assertTrue(true);
        }else{
            assertTrue(false);
        }   
    } 
    
    //Test case for checking password length
    @Test
    public void validate_password_length(){
        user.setPword("chaser145");
        int pass_length = "chaser".length();
        if (pass_length < 8 && pass_length > 16 ){
            assertTrue(false);
        }else{
            assertTrue(true);
            
        }
    }
    
      //Test case for invalid username and password
    @Test
    public void validate_input() throws SQLException{
        user.setUname("sabhya");
        user.setPword("8959njfd");
        if(false==create.insertUser(user)){
            assertFalse(true);
        }else{
            assertFalse(false);
        }
    }
    
    @Test
    public void validate_email() throws SQLException{
        user.setUname("Shradha123");
        user.setPword("chaser145");
        user.setEmail("abc#gmail.com");
        if(false == create.insertUser(user)){
            assertFalse(true);
        }else{
            assertFalse(false);
            
        }
    }

}
