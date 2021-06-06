package com.deliveryservice.controller.dto;

import com.deliveryservice.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
public class UserDto {

    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    @NotBlank(message = "이메일은 필수 입력입니다.")
    private String email;

    @Setter
    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "이름은 필수 입력입니다.")
    @Size(min = 2, max = 5, message = "이름은 2자 이상 5자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "휴대폰 번호는 필수 입력입니다.")
    @Pattern(regexp = "010-[0-9]{3,4}-[0-9]{4}", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    @NotEmpty(message = "주소는 필수 입력입니다.")
    private String address;


    public User toUserEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .phone(this.phone)
                .address(this.address)
                .build();
    }

    @Builder
    public UserDto(String email, String password, String name, String phone, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

}
