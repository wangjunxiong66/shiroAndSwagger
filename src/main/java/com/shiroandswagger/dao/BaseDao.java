package com.shiroandswagger.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/8/11 上午10:25
 */
@NoRepositoryBean
public interface BaseDao<T, I extends Serializable>
        extends PagingAndSortingRepository<T, I>, JpaSpecificationExecutor<T> {

}
