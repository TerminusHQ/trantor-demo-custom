package io.terminus.trantor.custom.repo;


import io.terminus.trantor.custom.model.ClassesExt;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * 用户 dao, 须继承 TrantorDAO，默认已包含 CRUD 操作
 *
 * @author chengong
 * @date 2020/7/13
 */
@Repository
public class ClassesExtRepository extends TrantorDAO<ClassesExt, Long> {
}
