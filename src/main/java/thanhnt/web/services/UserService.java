package thanhnt.web.services;

import thanhnt.web.entities.User;

public interface UserService {
	User findByUserName(String userName);
}
