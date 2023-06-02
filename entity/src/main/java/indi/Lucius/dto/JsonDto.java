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
    private String mes;
    private Map data = new HashMap();

    public JsonDto() {
    }

    public JsonDto(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public JsonDto(String code, String mes, Map data) {
        this.code = code;
        this.mes = mes;
        this.data = data;
    }
}
