package org.example.entity;

import java.io.Serializable;

/**
 * @author walker.dou
 */
public class Result<T> implements Serializable {
    private String code;
    private Boolean success;
    private T data;
    private String msg;

    public Result(String code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Result() {
        this.code = "200";
        this.success = true;
        this.msg = "success";
    }


    public static <T> Result<T> success(T data) {
        Result<T> success = new Result();
        success.setData(data);
        return success;
    }

    public static <T> Result<T> success() {
        return new Result();
    }

    public static <T> Result<T> error() {
        return new Result("500", false, "fail");
    }

    public static <T> Result<T> error(String message) {
        return new Result("500", false, message);
    }

    public static <T> Result<T> error(String code, String message) {
        return new Result(code, false, message);
    }

    public void resetWithoutData(Result result) {
        this.success = result.getSuccess();
        this.code = result.getCode();
        this.msg = result.getMsg();
    }


    public String getCode() {
        return this.code;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$success = this.getSuccess();
                Object other$success = other.getSuccess();
                if (this$success == null) {
                    if (other$success != null) {
                        return false;
                    }
                } else if (!this$success.equals(other$success)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Result;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $code = this.getCode();
//        int result = result * 59 + ($code == null ? 43 : $code.hashCode());
//        Object $success = this.getSuccess();
//        result = result * 59 + ($success == null ? 43 : $success.hashCode());
//        Object $data = this.getData();
//        result = result * 59 + ($data == null ? 43 : $data.hashCode());
//        Object $msg = this.getMsg();
//        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
//        return result;
//    }

    public String toString() {
        return "Result(code=" + this.getCode() + ", success=" + this.getSuccess() + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }

    public Result(String code, Boolean success, T data, String msg) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

}