package io.terminus.trantor.custom.model;

import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.custom.api.annotation.ExtendTModel;
import io.terminus.trantor.demo.model.Classes;
import lombok.Data;

/**
 * @author chengong
 * 二开model定义信息
 */
@Data
@ExtendTModel(Classes.class)
public class ClassesExt extends Classes {
    private static final long serialVersionUID = 2L;

    @TModelField(name = "二开字段（班主任姓名）")
    String headTeacherName;
}
