public class Main {
    public static void main(String[] args) {
      org.testng.TestNG testSuite = new org.testng.TestNG();
      Class[] testClasses = new Class[]{CustomApiTest.class};
      testSuite.setTestClasses(testClasses);
      testSuite.run();
    }
}
