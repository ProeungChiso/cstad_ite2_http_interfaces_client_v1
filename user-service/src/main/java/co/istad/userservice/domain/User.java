package co.istad.userservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
}
