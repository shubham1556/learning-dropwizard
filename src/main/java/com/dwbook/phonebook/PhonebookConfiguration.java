package com.dwbook.phonebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;


public class PhonebookConfiguration extends Configuration {

    //this class will have properties with name same as config and there corresponding getter methods
    @JsonProperty
    @NotEmpty
    private String message;

    @JsonProperty
    @Max(10)
    private int messageRepetitions;


    @JsonProperty
    private String additionalMessage = "Thos is an additional message";

    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageRepetitions() {
        return messageRepetitions;
    }

    public DataSourceFactory getDatabaseSourceFactory() {
        return database;
    }
}
