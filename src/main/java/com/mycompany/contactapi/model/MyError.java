package com.mycompany.contactapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyError {

        private String date;
        private String status;
        private int code;
        private String message;
}
