package main;

public class StringAlgorithms {
  public static void main(String[] args) {
    StringAlgorithms.parseContents("parseContents");
  }

  public static boolean isUpperCase(String s) {
    for(int i=0; i < s.length(); i++) {
      int asciiValue = s.charAt(i);
      if (asciiValue < (int) "A".charAt(0) || asciiValue > (int) "Z".charAt(0)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isUpperCaseStream(String s) {
    return s.chars().allMatch(Character::isUpperCase);
  }

  public static boolean isLowerCase(String s) {
    return s.chars().noneMatch(Character::isUpperCase);
  }

  public static boolean isPasswordStrong(String s) {
    // One uppercase, one lowercase and one digit
    return s.chars().anyMatch(Character::isUpperCase) && s.chars().anyMatch(Character::isDigit) &&
        s.chars().anyMatch(Character::isLowerCase);
  }

  public static String normalize(String s) {
    return s.trim().toLowerCase().replace(",", "");
  }

  public static void parseContents(String s) {
    for(char c : s.toCharArray()) {
      System.out.println(c);
    }
  }

  public static boolean isAtEvenIndex(String s, char item) {
    if (s == null || s.isEmpty()) {
      System.out.println("S is: " + s);
      return false;
    }
    for(int i=0; i <= s.length() / 2 + 1; i=i+2) {
      if(item == s.charAt(i)) {
        return true;
      }
    }
    return false;
  }

  public static String reverse(String s) {
    // Since, String are immutable. StringBuilder dynamically expands in memory.
    StringBuilder reversed = new StringBuilder();

    /* ALWAYS check for a null String, to avoid a NPE on s.length() */
    if (s == null) {
      return null;
    }
    for(int i=s.length(); i>0; i--) {
      reversed.append(s.charAt(i-1));
    }
    return reversed.toString();
  }

  public static String reverse2(String s) {
    if (s == null) {
      return s;
    }
    StringBuilder string = new StringBuilder(s);
    return string.reverse().toString();
  }

  // Challenge 1
  public static String reverseEachWord(String s) {
    if (s == null) {
      return s;
    }
    StringBuilder sentence = new StringBuilder();
    StringBuilder word = new StringBuilder();
    for (int i=0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (!word.isEmpty()) {
          sentence.append(word.reverse());
          word.delete(0, word.length());
        }
        sentence.append(" ");
      } else {
        word.append(c);
      }
    }
    if (!word.isEmpty()) {
      sentence.append(word.reverse());
    }
    return sentence.toString();
  }
}
