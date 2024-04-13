package com.esprit.microservices.eventsplanner;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partners {
    private String partnersName;
    private String link;
    private String email;

}
