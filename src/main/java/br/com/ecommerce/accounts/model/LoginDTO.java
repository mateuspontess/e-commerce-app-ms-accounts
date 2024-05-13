package br.com.ecommerce.accounts.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginDTO(
		
	    @NotBlank @Size(min = 3) 
	    String username,
	    
	    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
	            message = "The password must contain at least one letter, one special character and be at least 8 characters long")
	    String password
	) {}