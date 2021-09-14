package com.gulbalasalamov.springbackendemailverification.email;

public interface EmailSender {
    void send(String to, String email);
}
