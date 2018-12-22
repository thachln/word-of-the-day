Some exception testing has only 1 problem:
  1. The command @Test(expected=NumberFormatException.class) is not working on JUnit 5 so I replace it by the asserThrows.
  