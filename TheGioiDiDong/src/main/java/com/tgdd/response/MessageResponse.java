package com.tgdd.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
	private String message;
	
//	public MessageResponse(String message) {
//		this.message=message;
//	}

	public MessageResponse(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
