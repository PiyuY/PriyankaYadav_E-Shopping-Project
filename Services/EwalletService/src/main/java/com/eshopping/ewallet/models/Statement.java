package com.eshopping.ewallet.models;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Statement")
public class Statement {
	@Id
	private String statementId;
	private TransactionType transactionType;
	private double amount;
	private LocalDateTime dateTime;
	private String orderId;
	private String transactionRemark;
	private Ewallet eWallet;
	
	//Default Constructor
	public Statement() {}

	//Parameterized Constructor with Ewallet
	public Statement(String statementId, TransactionType transactionType, double amount, LocalDateTime dateTime,
			String orderId, String transactionRemark, Ewallet eWallet) {
		super();
		this.statementId = statementId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.orderId = orderId;
		this.transactionRemark = transactionRemark;
		this.eWallet = eWallet;
	}
	

	//Parameterized Constructor without statementId
	public Statement(TransactionType transactionType, double amount, LocalDateTime dateTime,
			String orderId, String transactionRemark, Ewallet eWallet) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.orderId = orderId;
		this.transactionRemark = transactionRemark;
		this.eWallet = eWallet;
	}

	//Parameterized Constructor without Ewallet
	public Statement(String statementId, TransactionType transactionType, double amount, LocalDateTime dateTime,
			String orderId, String transactionRemark) {
		super();
		this.statementId = statementId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.orderId = orderId;
		this.transactionRemark = transactionRemark;
	}

	//Parameterized Constructor without orderId, statementId
	public Statement(TransactionType transactionType, double amount, LocalDateTime dateTime, String transactionRemark,
			Ewallet eWallet) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.transactionRemark = transactionRemark;
		this.eWallet = eWallet;
	}

	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", dateTime=" + dateTime + ", orderId=" + orderId + ", transactionRemark=" + transactionRemark
				+ ", eWallet=" + eWallet + "]";
	}

	public String getStatementId() {
		return statementId;
	}

	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTransactionRemark() {
		return transactionRemark;
	}

	public void setTransactionRemark(String transactionRemark) {
		this.transactionRemark = transactionRemark;
	}

	public Ewallet geteWallet() {
		return eWallet;
	}

	public void seteWallet(Ewallet eWallet) {
		this.eWallet = eWallet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, dateTime, eWallet, orderId, statementId, transactionRemark, transactionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(dateTime, other.dateTime) && Objects.equals(eWallet, other.eWallet)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(statementId, other.statementId)
				&& Objects.equals(transactionRemark, other.transactionRemark)
				&& transactionType == other.transactionType;
	}
		
}
