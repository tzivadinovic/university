package rs.ac.metropolitan.eLearning.util;

import rs.ac.metropolitan.eLearning.entity.Role;

public class Util {
	public static boolean hasRole(Iterable<Role> roles, String roleName) {
		for (Role role : roles) {
			if (role.getRole().equals(roleName)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasRole(Iterable<Role> roles, Integer roleId) {
		for (Role role : roles) {
			if (role.getId().equals(roleId)) {
				return true;
			}
		}
		return false;
	}
}
