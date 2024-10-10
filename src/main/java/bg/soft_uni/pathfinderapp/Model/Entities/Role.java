package bg.soft_uni.pathfinderapp.Model.Entities;

import bg.soft_uni.pathfinderapp.Model.Entities.Enums.RoleNames;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Column
    @Enumerated(EnumType.STRING)
    private RoleNames name;

    public Role(RoleNames name) {
        this.name = name;
    }

    public Role() {

    }

    public RoleNames getName() {
        return name;
    }

    public void setName(RoleNames name) {
        this.name = name;
    }
}
