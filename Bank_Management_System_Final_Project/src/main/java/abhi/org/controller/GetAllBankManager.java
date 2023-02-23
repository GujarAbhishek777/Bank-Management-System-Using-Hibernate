package abhi.org.controller;


import java.util.List;

import abhi.org.dto.BankManager;
import abhi.org.service.BankManagerService;


public class GetAllBankManager {
public static void main(String[] args) {
        
		BankManagerService bankManagerService = new BankManagerService();		
		
		List<BankManager> bankManager2 = bankManagerService.getAllBankManager();
		
}
}