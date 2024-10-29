package com.barosanu.model;

import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {
    private String address;
    private String password;
    private Properties properties;
    private Store store;
    private Session session;

    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }

    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        this.properties = new Properties();
        properties.put("incomingHost", "imap.poczta.onet.pl");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.port", "993");

        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.poczta.onet.pl");
        properties.put("mail.smtps.port", "465");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.poczta.onet.pl");
    }

    @Override
    public String toString() {
        return  address ;
    }
}
