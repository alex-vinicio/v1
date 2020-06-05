package net.osgg.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;


public class Person {

	  @Digits(integer = 2, fraction = 0, message = "Error: Only integer numbers are allowed")
	  @Min(value = 18, message = "Error: Age should be an integer number greater or equal than 18")
	  @Max(value = 65, message = "Error: Age should be an integer number less or equal than 65")
	  private String age;
	  
	  
	  @NotNull(message = "Name cannot be null")
	  @Size(min = 4, max = 15, message = "The name should be between 4-15 characters and doesn't contain a number")
	  private String name;
	  
	  public static boolean contieneSoloLetras(String name) {
		    for (int x = 0; x < name.length(); x++) {
		        char c = name.charAt(x);
		        // Si no está entre a y z, ni entre A y Z, ni es un espacio
		        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
		            return false;
		        }
		    }
		    return true;
		}
	  
	  public String getAge() {
	    return age;
	  }

	  public void setAge(String age) {
	    this.age = age;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
		if(contieneSoloLetras(name)== true) {
			this.name = name;
		}else {
			this.name = "";
		}
	  }
	  
	  public String toString() {
			return "Person(Name: " + this.name + ", Age: " + this.age + ")";
	  }
}