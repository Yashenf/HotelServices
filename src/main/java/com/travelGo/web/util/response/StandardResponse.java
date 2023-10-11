package com.travelGo.web.util.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    private int status;
    private String message;
    private Object data;
}
