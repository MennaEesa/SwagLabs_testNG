package listener;

import ScreenRecorder.screenRecorder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        try {
            screenRecorder.startRecording(context.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ITestContext context) {
        try {
           screenRecorder.stopRecording();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
