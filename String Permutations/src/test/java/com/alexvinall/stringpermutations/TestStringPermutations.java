package com.alexvinall.stringpermutations;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


/**
 * Test class for {@link StringPermutations}.
 *
 * @author Alex Vinall 2016
 */
public class TestStringPermutations {

  @Mock
  PrintStream printStream;


  /**
   * Performs setup common across tests.
   */
  @Before
  public void before() {
    // Set up mock PrintStream to verify standard output
    MockitoAnnotations.initMocks(this);
    System.setOut(printStream);
  }


  /**
   * Ensures that the correct output is presented in a simple case.
   */
  @Test
  public void testStringPermutations() {
    // Given
    String input = "abc";
    String expected = "abc, acb, bac, bca, cab, cba";

    // When
    StringPermutations.parseLines(newArrayList(input));

    // Then
    verify(printStream).println(expected);
  }
}
