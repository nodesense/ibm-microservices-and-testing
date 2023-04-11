```java

package data.reqres;

import lombok.Data;
import java.util.Set;

@Data
public class SignupJWT {
    private String username;
    private String password;
    
    private String email;
    
    private Set<String> role;
    
    public SignupJWT(String username, String password, String email, Set<String> role) {
        this.username = username;
        this.password  = password;
        this.email = email;
        this.role = role;
    }
}

```
