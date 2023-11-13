package com.linkedin.jakarta.turing_award_service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@ApplicationScoped // Scope of instantiation = Application for Dependency Injection => is Singleton
public class TuringAwardMemoryService implements TuringAwardService{

    private Map<Integer, String> turingAwardWinners;

    @PostConstruct
    void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("turing.csv");
        InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(inputStream));
        BufferedReader bufferedReader = new BufferedReader(isr);
        turingAwardWinners = bufferedReader.lines()
                .map(s-> s.split(","))
                        .collect(Collectors.toMap(
                            s -> Integer.parseInt(s[0]),
                            s -> s[1],
                                (winner1, winner2) -> winner1 + ", " + winner2
                        ));
    }

    @Override
    public String fetchTuringAwardWinner(int year) {
        return turingAwardWinners.get(year);
    }
}
