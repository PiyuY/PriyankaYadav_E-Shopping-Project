package com.eshopping.ewallet.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.ewallet.models.Ewallet;
import com.eshopping.ewallet.models.Statement;
import com.eshopping.ewallet.models.TransactionType;
import com.eshopping.ewallet.repositories.EwalletRepository;
import com.eshopping.ewallet.repositories.StatementRepository;

@Service
public class EwalletServiceImpl implements EwalletService {
	
	@Autowired
	EwalletRepository ewalletRepo;
	
	@Autowired
	StatementRepository statementRepo;

	@Override
	public List<Ewallet> getWallets() {
		return ewalletRepo.findAll();
	}

//	@Override
//	public Ewallet addWallet(Ewallet addwallet) {
//		return ewalletRepo.save(addwallet);
//	}
	
	@Override
	public Ewallet addWalletForProfile(String profileId) {
		Ewallet newWallet = new Ewallet(profileId, 0, new ArrayList<String>());
		return ewalletRepo.save(newWallet);
	}


	@Override
	public void addMoney(Ewallet ewallet, double amount, String transactionRemarks) {
		// update balance
		double totalBal = amount + ewallet.getCurrentBalance();
		ewallet.setCurrentBalance(totalBal);	
		ewalletRepo.save(ewallet);
		// generate statement
		Statement stmt = new Statement(TransactionType.CREDIT, amount, LocalDateTime.of(LocalDate.now(), LocalTime.now()), transactionRemarks, ewallet);
		statementRepo.save(stmt);
	}

	@Override
	public void doTransaction(Ewallet ewallet, double amount, String transactionRemarks, String orderId) {
		// update balance
		double totalBal = amount - ewallet.getCurrentBalance();
		ewallet.setCurrentBalance(totalBal);		
		ewalletRepo.save(ewallet);
		// generate statement
		Statement stmt = new Statement(TransactionType.DEBIT, amount, LocalDateTime.of(LocalDate.now(), LocalTime.now()), orderId, transactionRemarks, ewallet);
		statementRepo.save(stmt);
	}

	@Override
	public Optional<Ewallet> getWalletById(String ewalletId) {
		return ewalletRepo.findById(ewalletId);
	}

	@Override
	public Optional<Statement> getStatementById(String statementId) {
		return statementRepo.findById(statementId);
	}

	@Override
	public List<Statement> getAllStatements() {
		return statementRepo.findAll();
	}

	@Override
	public String deleteWalletById(String ewalletid) {
		ewalletRepo.deleteById(ewalletid);
		return "Wallet deleted!";
	}

}
