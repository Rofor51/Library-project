package com.project.library.bookservice.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private String lastName;

    public AuthorDto(Long id, String name,String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
