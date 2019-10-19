/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.customconstraints;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import me.arsentii.nativeanimals.common.entities.User;
import me.arsentii.nativeanimals.common.repository.UserRepository;

/**
 *
 * @author zakhar
 */
public class UniqueValidation implements ConstraintValidator<Unique, String> {

    @Inject
    UserRepository userRepository;
    User user;

    public UniqueValidation() {
    }
    
    @Override
    public void initialize(Unique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userRepository.isExistsWithName(value);
    }

}
