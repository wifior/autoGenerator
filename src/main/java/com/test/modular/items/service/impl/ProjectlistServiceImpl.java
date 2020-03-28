package com.test.modular.items.service.impl;

import com.test.modular.items.model.Projectlist;
import com.test.modular.items.dao.ProjectlistMapper;
import com.test.modular.items.service.IProjectlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目列表 服务实现类
 * </p>
 *
 * @author Think
 * @since 2020-03-28
 */
@Service
public class ProjectlistServiceImpl extends ServiceImpl<ProjectlistMapper, Projectlist> implements IProjectlistService {

}
