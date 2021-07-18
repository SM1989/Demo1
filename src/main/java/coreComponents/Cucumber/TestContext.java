package main.java.coreComponents.Cucumber;

import main.java.coreComponents.managers.CoreFunctionsManager;

public class TestContext {

	private CoreFunctionsManager coreFunctionsManager;


	public TestContext()  {

		coreFunctionsManager = new CoreFunctionsManager();
	}


	public CoreFunctionsManager getCoreFunctionsManager() {
		return coreFunctionsManager;
	}



}
