package com.systemdesign.flightcheckin.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CheckInRequest {
    private Long userId;
    private Long seatId;
}
