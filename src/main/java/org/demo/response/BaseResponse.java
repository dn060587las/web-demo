package org.demo.response;

public class BaseResponse <T> {

    protected boolean success = true;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
