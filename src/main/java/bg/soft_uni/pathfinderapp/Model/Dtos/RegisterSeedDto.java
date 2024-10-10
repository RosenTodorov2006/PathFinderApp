package bg.soft_uni.pathfinderapp.Model.Dtos;
import bg.soft_uni.pathfinderapp.Validation.annotation.UniqueEmail;
import bg.soft_uni.pathfinderapp.Validation.annotation.UniqueUsername;
import bg.soft_uni.pathfinderapp.Validation.annotation.ValidatePassword;
import jakarta.validation.constraints.*;
@ValidatePassword
public class RegisterSeedDto {
    @NotNull
    @NotEmpty(message = "Empty field")
    @Size(min = 5, message = "Minimal length is 5")
    @UniqueUsername
    private String username;
    @NotNull
    @NotEmpty(message = "Empty field")
    @Size(min = 5, message = "Minimal length is 5")
    private String fullName;
    @NotNull
    @NotEmpty(message = "Noy Empty!")
    @Email(message = "Invalid email")
    @UniqueEmail
    private String email;
    @NotNull
    @Positive(message = "Age is psitive")
    private int age;
    @NotNull
    @NotEmpty(message = "Invalid password")
    private String password;
    @NotNull
    @NotEmpty(message = "Invalid confirm password")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
