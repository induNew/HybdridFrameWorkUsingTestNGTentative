package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListner extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	Reporter.log("This application is employee time sheet tool and this suite has so many regression test cases !!",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("The test hase been executed successfully !",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("The "+result.getMethod().getMethodName()+" test has been failed and the ScreenShot is taken , Please check the screenshot in screenshot folder",true);
		String methodName = result.getMethod().getMethodName();
		failed(methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() +" this method got skipped !");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		int percent = result.SUCCESS;
		Reporter.log(""+percent ,true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("The test has been started !",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("the test execution is been done",true);
	}

}
