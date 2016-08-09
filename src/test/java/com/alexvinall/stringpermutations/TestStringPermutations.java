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
  public void testStringPermutationsSimple() {
    // Given
    String input = "a";
    String expected = "a";

    // When
    StringPermutations.parseLines(newArrayList(input));

    // Then
    verify(printStream).println(expected);
  }


  /**
   * Ensures that the correct output is presented.
   */
  @Test
  public void testStringPermutations() {
    // Given
    String input = "abc";
    String expected = "abc,acb,bac,bca,cab,cba";

    // When
    StringPermutations.parseLines(newArrayList(input));

    // Then
    verify(printStream).println(expected);
  }


  /**
   * Ensures that the correct output is presented in a complex case.
   */
  @Test
  public void testStringPermutationsComplex() {
    // Given
    String input = "zgbh";
    String expected = "bghz,bgzh,bhgz,bhzg,bzgh,bzhg,gbhz,gbzh,ghbz,ghzb,gzbh,gzhb,hbgz,hbzg,hgbz,hgzb,hzbg,hzgb,zbgh,zbhg,zgbh,zghb,zhbg,zhgb";

    // When
    StringPermutations.parseLines(newArrayList(input));

    // Then
    verify(printStream).println(expected);
  }


  /**
   * Ensures that the correct output is presented in a case containing numeric characters.
   */
  @Test
  public void testStringPermutationsNumeric() {
    // TODO implement
  }


  /**
   * Ensures that the correct output is presented in a case where multiple strings are presented.
   */
  @Test
  public void testStringPermutationsMultiple() {
    // TODO implement
  }


  /**
   * Ensures that the correct output is presented when a file is provided as input.
   */
  @Test
  public void testStringPermutationsWithInputFile() {
    // TODO implement
  }
}
