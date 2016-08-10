package com.alexvinall.stringpermutations;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * Accepts a file containing a list of strings, one per line, and prints (to
 * standard output) a comma-separated, alphabetical list of all possible
 * rearrangements of each string, one set per line.
 * <p>
 * Challenge available here:
 * https://www.codeeval.com/public_sc/14/
 *
 * @author Alex Vinall 2016
 */
public class StringPermutations {

  /**
   * Accepts a file containing a list of strings, one per line, and prints (to
   * standard output) a comma-separated, alphabetical list of all possible
   * rearrangements of each string, one set per line.
   *
   * @param args the file to parse.
   */
  public static void main(String[] args) {
    // TODO read file and check it for errors, return a list of strings, throw exception if file invalid
    List<String> lines = Lists.newArrayList();
    parseLines(lines);
  }


  static void parseLines(List<String> strings) {
    for (String string : strings) {
      String output = "";
      for (String possible : parse(string)) {
        output += possible + ",";
      }
      System.out.println(StringUtils.left(output, output.length() - 1));
    }
  }


  private static List<String> parse(String str) {
    if (str.length() == 1) {
      return Lists.newArrayList(str);
    }

    List<String> permutations = Lists.newArrayList();

    for (int i = 0; i < str.length(); i++) {
      String left = String.valueOf(str.charAt(i));
      StringBuilder subStr = new StringBuilder(str);
      subStr.deleteCharAt(i);

      List<String> subPermutations = parse(subStr.toString());

      for (String perm : subPermutations) {
        permutations.add(left + perm);
      }
    }

    Collections.sort(permutations);
    return permutations;
  }
}
