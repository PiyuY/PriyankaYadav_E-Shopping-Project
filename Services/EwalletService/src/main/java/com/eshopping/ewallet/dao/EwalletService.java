package com.eshopping.ewallet.dao;

import java.util.List;
import java.util.Optional;

import com.eshopping.ewallet.models.Ewallet;
import com.eshopping.ewallet.models.Statement;

public interface EwalletService {
	
	public List<Ewallet> getWallets();
//	public Ewallet addWallet(Ewallet addwallet);
	public Ewallet addWalletForProfile(String profileId);
	public void addMoney(Ewallet ewallet, double amount, String transactionRemarks);
	
	// To Update EWallet Details & Generate Statements
	public void doTransaction(Ewallet ewallet, double amount, String transactionRemarks, String orderId);	
	public Optional<Ewallet> getWalletById(String ewalletId);
	public Optional<Statement> getStatementById(String statementId);
	public List<Statement> getAllStatements();
	public String deleteWalletById(String ewalletid);
	
}
