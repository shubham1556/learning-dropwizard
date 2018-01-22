package com.dwbook.phonebook.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.dwbook.phonebook.representations.Contact;

//mapper class
public class ContactMapper implements ResultSetMapper<Contact> {

    @Override
    public Contact map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        System.out.println("here");
        return new Contact(resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastName"), resultSet.getString("phone"));
    }
}
