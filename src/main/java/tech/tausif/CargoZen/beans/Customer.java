package tech.tausif.CargoZen.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String email;
    private String username;
    private String name;
    private String phone;
    private String password;
}
