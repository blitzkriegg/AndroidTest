package com.nerubia.cfw.entities;

/**
 * Created by meldy on 03/07/2015.
 */
public class CfwErrorResponse {
    public Error error;

    public static class Error {
        public Data data;

        public static class Data {
            public String message;
        }
    }
}
