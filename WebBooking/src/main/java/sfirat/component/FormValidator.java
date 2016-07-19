package sfirat.component;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sfirat.entity.User;

@Component
public class FormValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.empty");
        String email = user.getEmail();
        if( email.length() > 64)
            errors.rejectValue("email", "error.emailLength");
        if( !EmailValidator.getInstance().isValid(email))
            errors.rejectValue("email", "error.emailNotValid");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.empty");
        String password = user.getPassword();
        if(!password.matches("^[\\w]{6,16}$"))
            errors.rejectValue("password", "error.passwordLength");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.empty");
        String firstname = user.getFirstname();
        if( firstname.length() > 32 || firstname.length() < 3)
            errors.rejectValue("firstname", "error.firstNameLength");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.empty");
        String lastname = user.getLastname();
        if( lastname.length() > 32 || lastname.length() < 3)
            errors.rejectValue("lastname", "error.lastNameLength");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.empty");
        String phone = user.getPhone();
        if(!phone.matches("^((\\+)\\d{2}\\((\\d{3}\\))\\d{3}([\\-])\\d{2}([-])\\d{2}$)"))
            errors.rejectValue("phone", "error.phone");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "error.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressId.country", "error.empty");
        String country = user.getAddressId().getCountry();
        if( country.length() > 32)
            errors.rejectValue("addressId.country", "error.fieldLength");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressId.city", "error.empty");
        String city = user.getAddressId().getCity();
        if(city.length() > 32)
            errors.rejectValue("addressId.city", "error.fieldLength");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressId.street", "error.empty");
        String street = user.getAddressId().getStreet();
        if(street.length() > 32)
            errors.rejectValue("addressId.street", "error.fieldLength");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressId.house", "error.empty");
        String house = user.getAddressId().getHouse();
        if(!(house.matches("^\\d{1,4}(([А-Яа-я])?|/\\d{1,4}?)$")))
            errors.rejectValue("addressId.house", "error.houseValid");

        if (user.getAddressId().getApartment() != null){
            String apartment = user.getAddressId().getApartment().toString();
            if(!(apartment.matches("^\\d{1,8}$")))
                errors.rejectValue("addressId.apartment", "error.apartmentValid");
        }
    }
}