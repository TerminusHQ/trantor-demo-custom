package io.terminus.trantor.custom.action;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.custom.model.ClassesExt;
import io.terminus.trantor.custom.repo.ClassesExtRepository;
import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.autumn.Selectable;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户模型自定义 server action
 *
 * @author chengong
 * @date 2020/7/13
 */
@Slf4j
@Component
public class ClassesExtServerAction implements MultiDataAction<Classes> {

    @Autowired
    private ClassesExtRepository classesExtRepository;

    @Override
    public MultiDataResult load(MultiDataParams multiDataParams) {
        List<ClassesExt> studentList = classesExtRepository.find(Selectable::selectAll);
        return new MultiDataResult<>(studentList, (long) studentList.size());
    }

    /**
     * 二开action，对二开字段处理
     */
    @TAction(modelClass = Student.class)
    @DSTransaction
    public void save(ClassesExt classesExt) {
        if (StringUtils.isEmpty(classesExt.getHeadTeacherName())) {
            throw new RuntimeException("head teacher name is empty");
        }
        classesExtRepository.saveIgnoreRelationSkipNull(classesExt);
    }

}