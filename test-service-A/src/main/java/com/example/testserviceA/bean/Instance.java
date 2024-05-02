package com.example.testserviceA.bean;

public class Instance {
    private String host;
    private String port;

    public Instance(String host, String port){
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
