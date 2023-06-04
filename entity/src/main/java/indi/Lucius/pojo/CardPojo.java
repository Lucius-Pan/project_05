package indi.Lucius.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: CardPojo
 * @Description:
 * @Author: Lucius Pan
 * @Date: 2023/6/3 23:25
 */

@Data
public class CardPojo {
    private int cardId;
    private String cardNum;
    private int empId;
    private Date beginTime;
    private Date endTime;

    public CardPojo() {
    }

    public CardPojo(int cardId, String cardNum, int empId, Date beginTime, Date endTime) {
        this.cardId = cardId;
        this.cardNum = cardNum;
        this.empId = empId;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
}
