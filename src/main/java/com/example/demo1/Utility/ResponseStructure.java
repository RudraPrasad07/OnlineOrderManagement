package com.example.demo1.Utility;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

	private int Statuscode;
	private String message;
	private T Data;
	private LocalDateTime time;
}
