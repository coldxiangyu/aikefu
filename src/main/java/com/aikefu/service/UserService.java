package com.aikefu.service;

import com.aikefu.entity.domain.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface UserService extends IService<User> {

	boolean deleteAll();

	List<User> selectListBySQL();

	User findUser();

	User getUserByWrapper(Wrapper wrapper);

	/**
	 * 修改用户的状态为正常
	 *
	 * @return User
	 */
	User updateUserNormal();

	/**
	 * 增加登录错误次数
	 *
	 * @return 登录错误次数
	 */
	Integer updateUserLoginError();

	/**
	 * 修改最后登录时间
	 *
	 * @param lastDate 最后登录时间
	 * @return User
	 */
	User updateUserLoginLast(Date lastDate);

	/**
	 * 修改禁用状态
	 *
	 * @param enable enable
	 */
	void updateUserLoginEnable(String enable);
}