package ma.emsi.tp2rolegrp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USERS")

public class User {
    @Id
    private  String userId;
    @Column(name="USER_NAME",unique = true,length = 20)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch= FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();// pour eviter exception ptr=0
}
