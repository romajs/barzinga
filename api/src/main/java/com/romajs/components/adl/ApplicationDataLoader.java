package com.romajs.components.adl;


public class ApplicationDataLoader {
	
	public void load(ApplicationDataLoad appDataLoad) {
		appDataLoad.seed();
		appDataLoad.importation();
		appDataLoad.perform();
	}

}
