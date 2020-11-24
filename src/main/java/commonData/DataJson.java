package commonData;

import java.io.File;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataJson {

	public static DataJson get(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(filename), DataJson.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@JsonProperty("firstName")
	String firstName;
	
	@JsonProperty("lastName")
	String lastName;
	
	@JsonProperty("dateOfBirthDay")
	String dateOfBirthDay;
	
	@JsonProperty("dateOfBirthMonth")
	String dateOfBirthMonth;
	
	@JsonProperty("dateOfBirthYear")
	String dateOfBirthYear;
	
	@JsonProperty("company")
	String company;
	
	@JsonProperty("password")
	String password;
	
	@JsonProperty("comfirmPassword")
	String comfirmPassword;
	
	@JsonProperty("email")
	String email;
	
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirthDay() {
		return dateOfBirthDay;
	}

	public String getDateOfBirthMonth() {
		return dateOfBirthMonth;
	}

	public String getDateOfBirthYear() {
		return dateOfBirthYear;
	}

	public String getCompany() {
		return company;
	}

	public String getPassword() {
		return password;
	}

	public String getComfirmPassword() {
		return comfirmPassword;
	}

	public String getEmail() {
		return email;
	}

	
}
