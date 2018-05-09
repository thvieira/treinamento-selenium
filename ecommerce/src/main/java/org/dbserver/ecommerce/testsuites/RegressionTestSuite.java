package org.dbserver.ecommerce.testsuites;

import org.dbserver.ecommerce.framework.Report;
import org.dbserver.ecommerce.testcases.LoginTestCase;
import org.dbserver.ecommerce.testcases.RegistrationWrongPasswordTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTestCase.class,
	RegistrationWrongPasswordTestCase.class
})
public class RegressionTestSuite {
	
	@BeforeClass
	public static void initTest() {
		Report.create("Virtue Mart", "Suite de Regressao");
	}

	@AfterClass
	public static void endTest() {
		Report.close();
	}

}
