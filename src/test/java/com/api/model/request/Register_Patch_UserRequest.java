package com.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Register_Patch_UserRequest {

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int userStatus;

	public static class Builder {
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String phone;
		private int userStatus;

		public Register_Patch_UserRequest build() {

			Register_Patch_UserRequest patchReq = new Register_Patch_UserRequest(username, 
					firstName, lastName, email, password, phone,
					userStatus);
			return patchReq;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder userStatus(int userStatus) {
			this.userStatus = userStatus;
			return this;
		}

	}
}
