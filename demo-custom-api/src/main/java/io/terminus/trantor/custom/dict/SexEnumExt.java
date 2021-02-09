package io.terminus.trantor.custom.dict;

import io.terminus.trantor.api.annotation.typemeta.Label;
import io.terminus.trantor.custom.api.annotation.ExtendTDict;
import io.terminus.trantor.demo.dict.SexEnum;

/**
 * @author chengong
 * @date 2021/1/19 2:04 下午
 */
@ExtendTDict
public class SexEnumExt extends SexEnum {

    @Label("保密")
    public static final Integer Secrecy = 2;

}