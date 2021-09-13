package com.gulbalasalamov.springbackendemailverification.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service

public class EmailValidator implements Predicate<String> {

    //TODO: ideally REGEX to validate email. I assume everything valid.
    @Override
    public boolean test(String s) {
        return true;
    }
}
