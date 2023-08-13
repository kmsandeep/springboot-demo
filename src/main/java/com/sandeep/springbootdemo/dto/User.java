package com.sandeep.springbootdemo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Objects;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "USER_TBL")
public class User implements Cloneable{
    @Id
    @GeneratedValue
    private Long userId;
    @NotBlank()
    @Column(unique = true)
    private String username;
    @Min(10)
    @Max(80)
    private int age;
    @NotBlank
    private String role;



    public static void main(String[] args) {
        User user = User.builder().username("sandeep")
                .age(45)
                .userId(123L)
                .role("OKKK")
                .build();

        so();
        System.out.println(so(8));
    }
    static void so(){
        System.out.println("SO");
    }
    static int so(int q){
        return q;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
