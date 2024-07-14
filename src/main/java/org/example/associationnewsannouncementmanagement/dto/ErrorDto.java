package org.example.associationnewsannouncementmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private int resultCode;
    private String result;
    private String errorMessage;
    private Date time;
}
