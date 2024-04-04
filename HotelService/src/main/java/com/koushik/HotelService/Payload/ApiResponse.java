package com.koushik.HotelService.Payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
}
