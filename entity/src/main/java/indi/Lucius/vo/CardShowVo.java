package indi.Lucius.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: CardShowVp
 * @Description: 前段展示卡片表格的VO
 * @Author: Lucius Pan
 * @Date: 2023/6/4 08:40
 */
@Data
public class CardShowVo {
//    SELECT card_info.card_num ,card_info.begin_time,card_info.end_time ,card_info.b_state, emp_info.emp_name
    private String cardNum;
    private String empName;
    private Date beginTime;
    private Date endTime;
    private int bState;

    public CardShowVo() {
    }

    public CardShowVo(String cardNum, String empName, Date beginTime, Date endTime, int bState) {
        this.cardNum = cardNum;
        this.empName = empName;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.bState = bState;
    }
}

