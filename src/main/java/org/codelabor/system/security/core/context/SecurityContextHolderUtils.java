/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.security.core.context;

import java.util.Collection;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

/**
 * @author Shin Sang-Jae
 *
 */
public class SecurityContextHolderUtils {

	/**
	 * get username from Principal
	 *
	 * @return username
	 */
	public static String getUsername() {
		String username = null;
		Object principal = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			Authentication authentication = context.getAuthentication();
			if (authentication != null) {
				principal = authentication.getPrincipal();
				if (principal != null) {

					if (principal instanceof UserDetails) {
						username = ((UserDetails) principal).getUsername();
					} else if (principal != null) {
						username = principal.toString();
					}
					LoggerFactory.getLogger(SecurityContextHolderUtils.class).debug("username: {}", username);
				}
			}
		}
		return username;
	}

	/**
	 *
	 */
	public SecurityContextHolderUtils() {

	}

	/**
	 *
	 * check current user has specific role
	 *
	 * @param roleName
	 *            Role name
	 * @return
	 */
	public static boolean hasRole(String roleName) {
		Assert.notNull(roleName);
		boolean hasRole = false;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			Authentication authentication = context.getAuthentication();
			if (authentication != null) {
				Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
				for (GrantedAuthority authority : authorities) {
					if (roleName.equals(authority.getAuthority())) {
						hasRole = true;
						break;
					}
				}
			}
		}
		LoggerFactory.getLogger(SecurityContextHolderUtils.class).debug("hasRole: {}", hasRole);
		return hasRole;
	}

}
