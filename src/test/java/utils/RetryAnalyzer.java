package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int RETRY_LIMIT = 3;

    @Override
    public boolean retry(ITestResult result) {
        int retryCount = result.getMethod().getCurrentInvocationCount();

        if (retryCount < RETRY_LIMIT) {
            System.out.println("Retrying test: " + result.getMethod().getMethodName() +
                             " | Attempt: " + (retryCount + 1));
            return true;
        }
        return false;
    }


}
