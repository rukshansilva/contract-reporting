package com.oracle.reporting;

import com.oracle.reporting.service.ContractPortfolioService;
import com.oracle.reporting.service.impl.ContractPortfolioServiceImpl;

/**
 * Main Application class
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ContractReportingApplication {

		public static void main(String[] args) {

			ContractPortfolioService contractPortfolioService = new ContractPortfolioServiceImpl();

			if(args.length == 0) {
				System.err.println("Please provide the CSV String as an argument");
				return;
			}

			contractPortfolioService.generateContractReport(args[0]);
			System.out.println("Application tsk completed !");
		}
}
