package com.mkyong.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.mkyong.form.model.User;
import com.mkyong.form.service.UserService;

@Component
public class UserFormValidator implements Validator {

	@Autowired
	@Qualifier("neptunKodValidator")
	private NeptunKodValidator neptunKodValidator;

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "NotEmpty.userForm.age");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "neptunKod", "NotEmpty.userForm.neptunKod");

		if (!neptunKodValidator.valid(user.getNeptunKod())) {
			errors.rejectValue("neptunKod", "Pattern.userForm.neptunKod");
		}
		if (userService.existingNeptunKod(user.getNeptunKod()) != null)
			if (userService.existingNeptunKod(user.getNeptunKod()).getId() != user.getId()) {
				if (userService.existingNeptunKod(user.getNeptunKod()) != null) {
					errors.rejectValue("neptunKod", "Existing.userForm.neptunKod");
				}

			}

	}

}