package com.aikefu.service.impl;

import com.aikefu.entity.domain.User;
import com.aikefu.entity.enums.TrueFalseEnum;
import com.aikefu.mapper.UserMapper;
import com.aikefu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	@Override
	public List<User> selectListBySQL() {
		return baseMapper.selectListBySQL();
	}

	@Override
	public User findUser() {
		List<User> users = baseMapper.selectListBySQL();
		if (users != null && users.size() > 0) {
			return users.get(0);
		} else {
			return new User();
		}
	}

	@Override
	public User getUserByWrapper(Wrapper wrapper) {
		return baseMapper.selectListByWrapper(wrapper);
	}

	@Override
	public User updateUserNormal() {
		User user = this.findUser();
		user.setLoginEnable(TrueFalseEnum.TRUE.getDesc());
		user.setLoginError(0);
		user.setLoginLast(new Date());
		baseMapper.update(user,null);
		return user;
	}

	@Override
	public Integer updateUserLoginError() {
		User user = this.findUser();
		user.setLoginError((user.getLoginError() == null ? 0 : user.getLoginError()) + 1);
		baseMapper.update(user,null);
		return user.getLoginError();
	}

	@Override
	public User updateUserLoginLast(Date lastDate) {
		User user = this.findUser();
		user.setLoginLast(lastDate);
		baseMapper.update(user,null);
		return user;
	}

	@Override
	public void updateUserLoginEnable(String enable) {
		User user = this.findUser();
		user.setLoginEnable(enable);
		baseMapper.update(user,null);
	}
}