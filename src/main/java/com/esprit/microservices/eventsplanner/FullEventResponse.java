package com.esprit.microservices.eventsplanner;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullEventResponse {
    private String title;
    private String description;
    List<Partners> partner ;
}
