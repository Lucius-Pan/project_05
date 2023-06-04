package indi.Lucius.control;

import indi.Lucius.dto.JsonDto;
import indi.Lucius.service.ICardService;
import indi.Lucius.vo.CardShowVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: CardControl
 * @Description: 关于卡管理的control
 * @Author: Lucius Pan
 * @Date: 2023/6/3 19:30
 */

@RestController
public class CardControl {
    @Resource
    ICardService cardService;

    @PostMapping("/selectAllCard")
    public JsonDto selectAllCard(String cardNum, String empName, String beginTime, String endTime, String bState, String page) {
        List<CardShowVo> list = cardService.selectAll(cardNum, empName, beginTime, endTime, bState, Integer.parseInt(page));
        Integer num = cardService.selectAllNum(cardNum, empName, beginTime, endTime, bState);
        System.out.println(list);
        if (list == null || list.size() == 0) {
            return new JsonDto("500", "table is null");
        } else {
            JsonDto jsonDto = new JsonDto("200", "success");
            jsonDto.getData().put("list", list);
            jsonDto.getData().put("num", num);
            return jsonDto;
        }
    }

    @PostMapping("/deleteCard")
    public JsonDto deleteCard(String cardNum) {
        System.out.println(cardNum);
        Integer num = cardService.deleteCard(cardNum);
        if (num == 0) {
            return new JsonDto("500", "delete fail");
        } else {
            return new JsonDto("200", "success");
        }
    }

    @PostMapping("/resetCard")
    public JsonDto resetCard(String cardNum) {
        System.out.println(cardNum);
        Integer num = cardService.resetCard(cardNum);
        if (num == 0) {
            return new JsonDto("500", "reset fail");
        } else {
            return new JsonDto("200", "success");
        }
    }

    @PostMapping("/allocateCard")
    public JsonDto allocateCard(String cardNum, String empId, String endTime) {
        System.out.println("cardNum:" + cardNum + "empNum:" + empId + "endTime:" + endTime);
        Integer num = cardService.allocateCard(cardNum, empId, endTime);
        if (num == 0) {
            return new JsonDto("500", "allocate fail");
        } else if (num == -1) {
            return new JsonDto("500", "empId is not exist");
        } else {
            return new JsonDto("200", "success");
        }
    }

    @PostMapping("/insertCard")
    public JsonDto insertCard(String cardNum) {
        System.out.println("cardNum:" + cardNum );
        Integer num = cardService.insertCard(cardNum);
        if (num == 0) {
            return new JsonDto("500", "insert fail");
        }  else {
            return new JsonDto("200", "success");
        }
    }

}
