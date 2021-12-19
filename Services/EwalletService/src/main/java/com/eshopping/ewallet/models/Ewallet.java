package com.eshopping.ewallet.models;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Ewallet")
public class Ewallet {
	
	@Id
	private String walletId;
	private String profileId;
	private double currentBalance;
	private List<String> statements;
	
	public Ewallet() {
		super();
	}

	public Ewallet(String walletId, String profileId, double currentBalance, List<String> statements) {
		super();
		this.walletId = walletId;
		this.profileId = profileId;
		this.currentBalance = currentBalance;
		this.statements = statements;
	}
	
	public Ewallet(String walletId, double currentBalance) {
		super();
		this.walletId = walletId;
		this.currentBalance = currentBalance;
	}
	
	public Ewallet(String profileId, double currentBalance, List<String> statements) {
		super();
		this.profileId = profileId;
		this.currentBalance = currentBalance;
		this.statements = statements;
	}

	@Override
	public String toString() {
		return "Ewallet [walletId=" + walletId + ", profileId=" + profileId + ", currentBalance=" + currentBalance
				+ ", statements=" + statements + "]";
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<String> getStatements() {
		return statements;
	}

	public void setStatements(List<String> statements) {
		this.statements = statements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentBalance, profileId, statements, walletId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ewallet other = (Ewallet) obj;
		return Double.doubleToLongBits(currentBalance) == Double.doubleToLongBits(other.currentBalance)
				&& Objects.equals(profileId, other.profileId) && Objects.equals(statements, other.statements)
				&& Objects.equals(walletId, other.walletId);
	}
	
	
		
}
