package com.frolov.tests.reqres;

import com.github.javafaker.Faker;

public class TestData {

    public static final Faker faker = new Faker();
    public static final String name = faker.name().firstName();
    public static final String job = faker.job().title();
    public static final String email = "eve.holt@reqres.in";
    public static final String password = "pistol";
    public static final String anotherJob = faker.job().title();
}