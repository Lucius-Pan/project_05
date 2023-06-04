package indi.Lucius.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: NormalDto
 * @Description: 普通消息传输
 * @Author: Lucius Pan
 * @Date: 2023/5/28 21:19
 */

@Data
public class JsonDto {
    private  String code;
    private String msg;
    private Map data = new HashMap();

    public JsonDto() {
    }

    public JsonDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonDto(String code, String msg, Map data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
