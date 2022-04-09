package ro.unibuc.fmi.dietapp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
    private Long id;

    private String name;

    //TODO:validare
    private String code;
}
