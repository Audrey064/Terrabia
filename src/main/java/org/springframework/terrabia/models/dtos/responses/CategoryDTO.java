package org.springframework.terrabia.models.dtos.responses;

import lombok.*;

@Builder

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class CategoryDTO {

    private String name;

    private String description;

}
