package com.example.Data.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClubUpdate {
    @NotNull
    @Size(min = 1, max = 3)
    private String id;

    @NotNull
    private String newId;

    @NotNull
    private String newSPI;

}
