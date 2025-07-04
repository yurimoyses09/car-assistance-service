package com.moyses.api_system_car.infraestructure.web.dto.api;

public class Response<T> {

    private boolean success;
    private String message;
    private T data;

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T>Response<T> success(String message, T data){
        return new Response<>(true, message, data);
    }

    public static <T> Response <T> error (String message, T data){
        return new Response<>(false, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
