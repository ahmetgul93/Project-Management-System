package model;

import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

@FacesValidator("login.emailValidator")
public class EmailValidator implements Validator, ClientValidator {

  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

  private final Pattern pattern;

  public EmailValidator() {
    this.pattern = Pattern.compile(EMAIL_PATTERN);
  }

  @Override
  public Map<String, Object> getMetadata() {
    return null;
  }

  @Override
  public String getValidatorId() {
    return "login.emailValidator";
  }

  @Override
  public void validate(FacesContext ctx, UIComponent component, Object value)
      throws ValidatorException {
    if (value == null) {
      return;
    }

    if (!this.pattern.matcher(value.toString()).matches()) {
      throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error",
          value + " is not a valid email."));
    }
  }
}
