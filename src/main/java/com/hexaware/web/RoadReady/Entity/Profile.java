package com.hexaware.web.RoadReady.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false) 
    @JoinColumn(name = "userId", referencedColumnName = "userId", unique = true)
	private User user;
	
	@NotNull(message = "Contact information is required")
    @Size(max = 255, message = "Contact information should not exceed 255 characters")
	private String contactInfo;
	
	@NotNull(message = "Payment details are required")
    @Size(max = 255, message = "Payment details should not exceed 255 characters")
	private String paymentDetails;
	
	public Profile() {
		
	}

	public Profile(int profileId, User user,
			@NotNull(message = "Contact information is required") @Size(max = 255, message = "Contact information should not exceed 255 characters") String contactInfo,
			@NotNull(message = "Payment details are required") @Size(max = 255, message = "Payment details should not exceed 255 characters") String paymentDetails) {
		super();
		this.profileId = profileId;
		this.user = user;
		this.contactInfo = contactInfo;
		this.paymentDetails = paymentDetails;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", contactInfo=" + contactInfo + ", paymentDetails=" + paymentDetails
				+ "]";
	}
	
	
}
