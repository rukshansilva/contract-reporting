package com.oracle.reporting;

import com.oracle.reporting.factory.ContractPortfolioServiceFactory;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Main Application class
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ContractReportingApplication {

		public static void main(String[] args) {

			System.out.println("Application task initiated !");

			if(args.length == 0) {
				System.err.println("Please provide the CSV String as an argument");
				return;
			}

			ContractPortfolioServiceFactory.getInstance(FactoryEnum.CONTRACT_PORTFOLIO_SERVICE).
					generateContractReport(args[0]);
			System.out.println("Application task completed !");
		}
}
