package ru.mironov.tokengenerator.model;

public record TokenResponse(String token) {
    public static TokenResponse empty() {
        return new TokenResponse("generation failed");
    }
}
