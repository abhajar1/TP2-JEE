package ma.emsi.tp2rolegrp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20,unique = true)
    private String roleName;
    private String description;
    @ManyToMany(fetch= FetchType.EAGER)
   // @JoinTable(name="USERS_ROLES")
    @ToString.Exclude
    private List<User> users=new ArrayList<>();
}
