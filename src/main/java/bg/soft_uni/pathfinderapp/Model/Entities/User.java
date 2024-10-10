package bg.soft_uni.pathfinderapp.Model.Entities;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.Level;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column
    private int age;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column
    private String email;
    @Column
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Role> roles;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
