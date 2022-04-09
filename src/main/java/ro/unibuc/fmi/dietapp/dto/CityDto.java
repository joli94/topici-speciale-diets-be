package ro.unibuc.fmi.dietapp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private Long id;

    private String name;

    private Long countryId;
}
