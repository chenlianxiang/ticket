package com.heheda.ticket.web.vo.ticket;

import com.heheda.ticket.web.vo.balance.balanceVO;
import lombok.Data;

import java.sql.Date;
import java.util.List;

import com.heheda.ticket.web.vo.train.trainVO;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @program: ticket
 * @description: 车次对象
 * @author: clx
 * @create: 2019-09-07 12:51
 */
@Data
@Alias("ticketVO")
public class ticketVO {


    private int ticket_id;
    private int train_id;
//    @NotBlank(message = "出发点不能为空")
//    @Length(min = 2,message = "出发地简码至少2位数")
    private String from_code;
    private String from_name;
//    @NotBlank(message = "到达地不能为空")
    private String to_code;
    private String to_name;
    private String date;
    private Date time;


    private String  begin_date;

    private String end_date;

//    private trainVO trainVO;

    private int hard_seat;
    private int private_seat;
    private int second_seat;
    private int soft_seat;
    private int first_seat;


//    private List<balanceVO> list_balanceVO;
}
