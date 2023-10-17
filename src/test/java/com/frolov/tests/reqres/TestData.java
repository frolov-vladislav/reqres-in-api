package com.frolov.tests.reqres;

import com.github.javafaker.Faker;

public class TestData {

    public static final Faker faker = new Faker();
    public static final String firstName = faker.name().firstName();
    public static final String job = faker.job().title();
}