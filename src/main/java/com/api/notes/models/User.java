package com.api.notes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description = "User object")
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @JsonProperty(value = "id", required = true, index = 10)
    @Schema(description = "Unique identifier of the User.", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private long id;

    @JsonProperty(value = "username", required = true, index = 20)
    @Schema(description = "Name of the User.", example = "Lucas", required = true)
    @NotBlank
    @Size(min = 0, max = 20)
    @Column(name = "username", nullable = false)
    private String username;

    @JsonProperty(value = "password", required = true, index = 30)
    @Schema(description = "Password of the User.", example = "asd123", required = true)
    @NotBlank
    @Size(min = 0, max = 15)
    @Column(name = "password", nullable = false)
    private String password;

}
