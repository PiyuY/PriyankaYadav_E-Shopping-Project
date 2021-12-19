package com.eshopping.ewallet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.ewallet.dao.EwalletService;
import com.eshopping.ewallet.models.Ewallet;
import com.eshopping.ewallet.models.Statement;

@RestController
@RequestMapping("/ewallet")
public class EwalletResource {
	
	@Autowired
	EwalletService ewalletService;
	
	@GetMapping("/all")
	public List<Ewallet> getWallets(){
		return ewalletService.getWallets();
	}
	
//	@PostMapping("/add")
//	public Ewallet addWallet(@RequestBody Ewallet addwallet) {
//		return ewalletService.addWallet(addwallet);
//	}
//	
	@PostMapping("/addForProfile/{profileId}")
	public Ewallet addWalletForProfile(@PathVariable("profileId") String profileId) {
		return ewalletService.addWalletForProfile(profileId);
	}
	
	@PostMapping("/addmoney/{amount}/{remark}")
	public void addMoney(@RequestBody Ewallet ewallet, @PathVariable("amount") double amount, @PathVariable("remark") String transactionRemarks) {
		ewalletService.addMoney(ewallet, amount, transactionRemarks);
	}
	
	@PostMapping("/transaction/{amount}/{remark}/{orderId}")
	public void doTransaction(@RequestBody Ewallet ewallet, @PathVariable("amount") double amount, @PathVariable("remark") String transactionRemarks, @PathVariable("orderId") String orderId) {
		ewalletService.doTransaction(ewallet, amount, transactionRemarks, orderId);
	}
	
	@GetMapping("/byid/{ewalletId}")
	public Optional<Ewallet> getWalletById(@PathVariable("ewalletId") String ewalletId){
		return ewalletService.getWalletById(ewalletId);
	}
	
	@GetMapping("/statement/byid/{statementId}")
	public Optional<Statement> getStatementById(@PathVariable("statementId") String statementId){
		return ewalletService.getStatementById(statementId);
	}
	
	@GetMapping("/statement/all")
	public List<Statement> getAllStatements(){
		return ewalletService.getAllStatements();
	}
	
	@DeleteMapping("/delete/{ewalletId}")
	public String deleteWalletById(@PathVariable("ewalletId") String ewalletId) {
		return ewalletService.deleteWalletById(ewalletId);
	}
}
