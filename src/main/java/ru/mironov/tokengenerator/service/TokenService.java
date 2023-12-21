package ru.mironov.tokengenerator.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.mironov.tokengenerator.model.ApplicationName;
import ru.mironov.tokengenerator.repository.TokenRepository;
import ru.mironov.tokengenerator.repository.model.TokenModel;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    public Optional<TokenModel> getToken(ApplicationName applicationName, String login, String password) {
        Assert.notNull(applicationName, "application name must be a set");
        Assert.notNull(login, "login must be a set");
        Assert.notNull(password, "password must be a set");
        return tokenRepository.getToken(applicationName, login, password);
    }
}
