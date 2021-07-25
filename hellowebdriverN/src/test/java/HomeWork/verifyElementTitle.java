//package HomeWork;
//
//import sun.security.pkcs11.wrapper.Constants;
//
//import javax.swing.*;
//
//public class verifyElementTitleClass {
//    public String verifyElementTitle(String locator, String data) {
//        String expectedTxt = data;
//        String actualTxt = getElement(locator).getText();
//        if (actualTxt.equals(expectedTxt)) {
//            System.out.println("Title name present");
//            return Constants.PASS;
//        } else
//            System.out.println("Title mismach or not present");
//        return Constants.FAIL;
//    }
//
//    private AbstractButton getElement(String locator) {
//        return null;
//    }
//}
