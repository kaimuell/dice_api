package com.linkedin.jakarta;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Timestamp;

/**
 * A Time Service, which can be used to set a time
 */

@ApplicationScoped
public class MockTimeService implements TimeService{

    private Timestamp timestamp;

    @PostConstruct
    public void init(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    @Override
    public Timestamp now() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
