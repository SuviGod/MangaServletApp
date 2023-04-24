package ua.sulima.mangaservletapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String password;

    private String email;

    private Byte[] image;

    private Timestamp updated;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new LinkedList<>();

    public void addRole(Role newRole) {
        roles.add( newRole );
        newRole.getUsersWithRole().add( this );
    }

    public void removeRole(Role roleToDelete) {
        roles.remove( roleToDelete );
        roleToDelete.getUsersWithRole().remove( this );
    }

}
