package testClasses;

import org.testng.annotations.Test;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {


  @DataProvider(name="UnsucessfulLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.readStringData(6, 0), ExcelReadClass.readStringData(6, 1)},
      new Object[] { ExcelReadClass.readStringData(7, 0), ExcelReadClass.readStringData(7, 1)},
      new Object[] { ExcelReadClass.readStringData(8, 0), ExcelReadClass.readStringData(8, 1)},
    };
  }
}
