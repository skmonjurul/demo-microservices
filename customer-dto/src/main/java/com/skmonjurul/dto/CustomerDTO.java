package com.skmonjurul.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
