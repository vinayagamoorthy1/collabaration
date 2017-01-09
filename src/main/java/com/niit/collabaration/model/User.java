package com.niit.collabaration.model;


	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.springframework.stereotype.Component;
	
	@Entity
	@Table(name="user_detail")
	@Component
	public class User extends BaseDomain{
		@Id
		private String id;
		private String name;
		private String password;
		private String email;
		private String address;
		private String mobile;
		private String reason;
		private String role;
		private char is_online;
		private char status;
		public String getId() {
			return id;
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public char getIs_online() {
			return is_online;
		}
		public void setIs_online(char is_online) {
			this.is_online = is_online;
		}
		public char getStatus() {
			return status;
		}
		public void setStatus(char status) {
			this.status = status;
		}
		public void setId(String id) {
			this.id = id;
		}

}
