package indi.Lucius.dto;

import lombok.Data;

/**
 * @ClassName: NormalDto
 * @Description: 普通消息传输
 * @Author: Lucius Pan
 * @Date: 2023/5/28 21:19
 */

@Data
public class NormalDto {
    private  String code;
    private String mes;
    private String location;

    public NormalDto(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public NormalDto(String code, String mes, String location) {
        this.code = code;
        this.mes = mes;
        this.location = location;
    }
}
