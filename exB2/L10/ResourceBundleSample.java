package exB2.L10;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ResourceBundle\u306e\u30c6\u30b9\u30c8
 */
public class ResourceBundleSample {

  public static void main(String[] args) {
    //Locale.setDefault(Locale.ENGLISH);

    ResourceBundle resource = ResourceBundle.getBundle("messages");
    System.out.println(resource.getString("greeting.message"));
  }
}