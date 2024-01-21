package org.itcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.common.Entity;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO extends Entity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    //编码
    private String code;

    private String name;

    /** 渠道来源 */
//    @Excel(name = "渠道来源")
    private String channel;

    /** 活动简介 */
//    @Excel(name = "活动简介")
    private String info;

    /** 活动类型 */
//    @Excel(name = "活动类型")
    private String type;

    /** 课程折扣 */
//    @Excel(name = "课程折扣")
    private Float discount;

    /** 课程代金券 */
//    @Excel(name = "课程代金券")
    private Integer vouchers;

    /** 状态 */
//    @Excel(name = "状态")
    private String status;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    private Integer pageNum;
    private Integer pageSize;


//    @Override
//    public String toString() {
//        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
//                .append("id", getId())
//                .append("name", getName())
//                .append("channel", getChannel())
//                .append("info", getInfo())
//                .append("type", getType())
//                .append("discount", getDiscount())
//                .append("vouchers", getVouchers())
//                .append("status", getStatus())
//                .append("beginTime", getBeginTime())
//                .append("endTime", getEndTime())
//                .append("code",getCode())
//                .toString();
//    }
}
