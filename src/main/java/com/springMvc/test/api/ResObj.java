package com.springMvc.test.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/3/27.
 */
@Setter
@Getter
@ToString
public class ResObj implements Serializable{
    private static final long serialVersionUID = -2056159097004086585L;
    private String code;
    private String msg;
    private Object data;

    public ResObj(){}
    public ResObj(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResObj(String code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
