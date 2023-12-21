package ru.mironov.tokengenerator.model;

public record TokenRequest(ApplicationName applicationName, String login, String password) {
}
