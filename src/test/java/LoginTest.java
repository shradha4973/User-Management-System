import com.mycompany.usermanagement.dao.LoginDao;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

public class LoginTest {
    
    //Test case for valid username and valid passeword
    @Test
    public void Login_FullData(){
        LoginDao a = new LoginDao();
        assertTrue(a.check("admin", "admin"));
    }
    
    //Test case for empty username and empty passeword
    @Test
    public void Login_EmptyData(){
        LoginDao a = new LoginDao();
        assertFalse(a.check(" ", " "));
    }
    
    //Test case for invalid username and invalid passeword
    @Test
    public void Login_WrongData(){
        LoginDao a = new LoginDao();
        assertFalse(a.check("admin123", "admin123"));
    }
    
    //Test case for invalid username and valid passeword
    @Test
    public void Login_WrongUsername(){
        LoginDao a = new LoginDao();
        assertFalse(a.check("admin123", "admin"));
    }
    
    //Test case for valid username and invalid passeword
    @Test
    public void Login_WrongPassword(){
        LoginDao a = new LoginDao();
        assertFalse(a.check("admin", "admin123"));
    }
    
}
