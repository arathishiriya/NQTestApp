/*
 * @author       :NQAdmin
 * @purpose	 :This is a NQ Test application which is used to invoke an already installed NQ app on the device
 * @Prerequisites: Assumes, that a relevant NQApp is installed in the device that is being tested
 * @Testing      :HAs been tested on the latest version of NQApp(as of July 28th 2014 
 * 		 :HAs been tested on the device Nexus 5
 * 
 * 
*/ 

/*Import the uiautomator libraries
*/

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/* UI automation tests should extend this class. This class provides access to the following:
*  UiDevice instance
*  Bundle for command line parameters
*/

public class NQTest extends UiAutomatorTestCase  {

	public NQTest() {
		// TODO Auto-generated constructor stub
	}
	public void testDemo() throws UiObjectNotFoundException {   
		 
		 // Simulate a short press on the HOME button.
		// Just to make sure that the phone is in the HOME to start with.
		
		 getUiDevice().pressHome();
		 
		 // We’re now in the home screen. Next, we want to simulate 
		 // a user bringing up the All Apps screen.
		 // If you use the uiautomatorviewer tool to capture a snapshot 
		 // of the Home screen, notice that the All Apps button’s 
		 // content-description property has the value “Apps”.  We can 
		 // use this property to create a UiSelector to find the button.
		 
		 UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		 
		 // Simulate a click to bring up the All Apps screen.
		 allAppsButton.clickAndWaitForNewWindow();
		 
		 // In the All Apps screen, the NQApp is located in 
		 // the Apps tab. To simulate the user bringing up the Apps tab,
		 // we create a UiSelector to find a tab with the text description 
		 // “Apps”.
		 
		 
		 //The present nexus 5 device populates content description as Apps for Apps tab.
		 //so, invoking the same

		 UiObject appsTab = new UiObject(new UiSelector().descriptionContains("Apps"));
		 

		 // Simulate a click to enter the Apps tab.
		 appsTab.click();
		 
		 // Next, in the apps tabs, we can simulate a user swiping until
		 // they come to the NQApp app icon.  Since the container view 
		 // is scrollable, we can use a UiScrollable object.

		 UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		 
		 // Set the swiping mode to horizontal (the default is vertical)
		 
		 appViews.setAsHorizontalList();
		 
		 //Now to invoke the NQ app
		 
		 UiObject NQApp = appViews.getChildByText(new UiSelector()
		    .className(android.widget.TextView.class.getName()),"NQ Mobile Diagnostics");
		 NQApp.clickAndWaitForNewWindow();
		
		 			      
		
		}  
	
}
