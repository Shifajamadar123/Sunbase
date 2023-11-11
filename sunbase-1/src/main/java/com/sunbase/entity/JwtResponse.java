package com.sunbase.entity;


public class JwtResponse {
	private String jwtToken;
	
	private String username;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
	}
	
	public static class builder {
		private String jwtToken;
		private String username;

        // Builder methods to set values
        public builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public builder username(String username) {
            this.username = username;
            return this;
        }

        // Build method to create the Person instance
        public JwtResponse build() {
            return new JwtResponse(jwtToken, username);
        }
    }
	
	public static builder builder() {
        return new builder();
    }

}
