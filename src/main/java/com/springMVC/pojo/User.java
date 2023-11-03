package com.springMVC.pojo;

import lombok.*;

import java.util.Date;

@Data
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private Integer age;
    private String[] hobbies;
    private Date birthday;
    private Address address;
}
