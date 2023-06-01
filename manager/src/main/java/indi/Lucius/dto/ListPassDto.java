package indi.Lucius.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: ListPassDto
 * @Description: 传递List的Dto
 * @Author: Lucius Pan
 * @Date: 2023/5/29 21:19
 */
@Data
public class ListPassDto {
    private String code;
    private String mes;
    private List list;
    private Integer num;

    public ListPassDto(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public ListPassDto(String code, String mes, List list, Integer num) {
        this.code = code;
        this.mes = mes;
        this.list = list;
        this.num = num;
    }
}
